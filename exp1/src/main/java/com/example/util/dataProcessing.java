package com.example.util;

import com.example.entity.Student;

import java.util.ArrayList;
import java.util.HashMap;

public class dataProcessing {
    public static double GetAverage(ArrayList<Double> grades) {   //传入一个grades的ArrayList求均值
        double sum = 0;   //sum，用于保存列表所有元素的和，初始化为0
        for (int i = 0; i < grades.size(); i++) {  //对列表中的所有元素进行求和
            sum += grades.get(i);
        }
        return sum / grades.size();   //return average
    }

    public static double GetCovariance(ArrayList<Double> grades) {  //传入一个grades的ArrayList求方差
        double avg = dataProcessing.GetAverage(grades);     //调用实现的方法求平均值
        double sum = 0;  //sum
        for (int i = 0; i < grades.size(); i++) {
            sum += (grades.get(i) - avg) * (grades.get(i) - avg);   //sum = (Xi-avg)^2
        }
        return sum / (grades.size() - 1);   //return cov
    }

    public static ArrayList<Double> GetZScore(ArrayList<Double> grades) {  //传入一个grades的ArrayList，进行Zscore化
        double avg = dataProcessing.GetAverage(grades);   //调用平均值函数求均值
        double s = Math.sqrt(dataProcessing.GetCovariance(grades));  //求出方法
        ArrayList<Double> zscore = new ArrayList<>();
        for (int i = 0; i < grades.size(); i++) {
            zscore.add((grades.get(i) - avg) / s);
        }
        return zscore;   //return zscore
    }

    public static Double GetCorrelation(ArrayList<Double> grades1, ArrayList<Double> grades2) { //求grades1和grades2的相关系数
        ArrayList<Double> A = dataProcessing.GetZScore(grades1);
        ArrayList<Double> B = dataProcessing.GetZScore(grades2);
        double sum = 0;
        for (int i = 0; i < grades1.size(); i++) {
            sum += A.get(i) * B.get(i);
        }
        return sum;    //return Corr
    }

    public static Double TransformConstitution(String constitute){   //将体测成绩转换成百分制成绩
            switch (constitute){
                case "excellent": return 100.0;   //excellent -->100
                case "good": return 80.0;   //good --> 80
                case "general":return 60.0;  //general --> 60
                case "bad":return 40.0;  //bad --> 40
                default:return 0.0;  //default 0
            }
    }


    public static void TransformMtoCm(Student student){
        if(student.getHeight()<10){
            student.setHeight(student.getHeight()*100);
        }
    }
    public static void TransformCmtoM(Student student){
        if(student.getHeight()>10){
            student.setHeight(student.getHeight()/100);
        }
    }


    public static void TransformStudentID(Student stu){   //格式化学号
        if(stu.getStudentId().length()==3){
            stu.setStudentId("202"+stu.getStudentId());
        }
        if(stu.getStudentId().length()==2){
            stu.setStudentId("2020"+stu.getStudentId());
        }
        if(stu.getStudentId().length()==1){
            stu.setStudentId("20200"+stu.getStudentId());
        }
    }

    public static ArrayList<Student> MergeCsvAndTxt(String filePath_csv,String filePath_txt){  //合并Csv和Txt文件
        ArrayList<Student> list = ReadFile.ReadCsv(filePath_csv);   //读取Csv的内容
        ArrayList<Student> list_txt = ReadFile.ReadCsv(filePath_txt);  //读取txt
        list.addAll(list_txt);  //添加Txt的内容
        return list;    //返回学生列表
    }

    public static ArrayList<Student> DuplicateRemoval(ArrayList<Student> students){  //传入一个Student的ArrayList，根据Name去重
        HashMap<String,Student> hashMap = new HashMap<>();   //创建hashMap用于去重名字
        ArrayList<Student> stuList = new ArrayList<>();
        for (int i =0;i<students.size();i++){
            Student stu = students.get(i);      //Get Student of index i

            dataProcessing.TransformMtoCm(stu);  //转换M to cm
            dataProcessing.TransformStudentID(stu);   //格式化ID为统一格式

            String key = students.get(i).getStudentId();   //key
            Student value = students.get(i);          //value
            if(stu.getC1()==0 || stu.getC2()==0 || stu.getC3() ==0 || stu.getC4()==0 || stu.getC5() == 0
                    || stu.getC6()==0 || stu.getC7() ==0 ||stu.getC8()==0 || stu.getC9()==0 || dataProcessing.TransformConstitution(stu.getConstitution()) == 0.0) {

            }else if(hashMap.containsKey(key)){    ///去掉残缺的数据
//            if(hashMap.containsKey(key)){   //不去掉残缺的数据

            }else {
                hashMap.put(key,value);  //放置到hashMap当中
            }
        }

        for (String stuName:
             hashMap.keySet()) {
            stuList.add(hashMap.get(stuName));     //遍历key，将Value放进stuList
        }
        return stuList;
    }

   //合并并去重并格式化
    public static ArrayList<Student> MergeDuplicateRemoval_CsvAndTxt(String filePath_csv,String filePath_txt){
        ArrayList<Student> students = dataProcessing.MergeCsvAndTxt(filePath_csv,filePath_txt);
        return dataProcessing.DuplicateRemoval(students);
    }


}
