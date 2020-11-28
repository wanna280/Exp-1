package com.example.Run;

import com.example.entity.Student;
import com.example.util.ReadFile;
import com.example.util.dataProcessing;

import java.util.ArrayList;

public class Run3 {
    public static void Run3(){
        String filePath_csv = "src/main/java/com/example/Data/data.csv";
        String filePath_txt = "src/main/java/com/example/Data/data.txt";

        //传入文件路径，直接读取合并后的文件
        ArrayList<Student> list_students = dataProcessing.MergeCsvAndTxt(filePath_csv,filePath_txt);

        //存放居住在广州的学生列表
        ArrayList<Student> arr_guangzhou = new ArrayList<Student>();
        //存放居住在上海的学生列表
        ArrayList<Student> arr_shanghai = new ArrayList<Student>();

        System.out.println(list_students.size());
        for (int i = 0; i < list_students.size(); i++) {
            if (list_students.get(i).getCity().equals("Guangzhou")) {   //查询广州的，加入广州学生列表
                arr_guangzhou.add(list_students.get(i));
            }
            if (list_students.get(i).getCity().equals("Shanghai")) {   //查询伤害的，加入上海学生列表
                arr_shanghai.add(list_students.get(i));
            }
        }
        System.out.println(arr_guangzhou.size());  //打印广州列表的尺寸
        System.out.println(arr_shanghai.size());   //打印上海列表的尺寸

        ArrayList<Double> arr2 = new ArrayList<>();
        ArrayList<Double> arr3 = new ArrayList<>();

        //体测转换成百分制成绩
        for (int i=0;i<arr_guangzhou.size();i++){
            arr2.add(dataProcessing.TransformConstitution(arr_guangzhou.get(i).getConstitution()));
        }
        //体测转换成百分制成绩
        for (int i=0;i<arr_shanghai.size();i++){
            arr3.add(dataProcessing.TransformConstitution(arr_shanghai.get(i).getConstitution()));
        }

        Double avg1 = dataProcessing.GetAverage(arr2);   //求平均值
        Double avg2 = dataProcessing.GetAverage(arr3);   //求平均值
        System.out.println("avg1-"+avg1+"/avg2-"+avg2);
    }
}
