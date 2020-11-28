package com.example.Run;

import com.example.entity.Student;
import com.example.util.ReadFile;
import com.example.util.dataProcessing;

import java.util.ArrayList;
import java.util.HashMap;

public class Run2 {
    public static void Run2(){
        String filePath_csv = "src/main/java/com/example/Data/data.csv";
        String filePath_txt = "src/main/java/com/example/Data/data.txt";

        //传入文件路径，直接读取合并后的文件
        ArrayList<Student> list_students = dataProcessing.MergeCsvAndTxt(filePath_csv,filePath_txt);

        ArrayList<Student> arr = new ArrayList<Student>();  //存放符合条件的学生列表
        System.out.println(list_students.size());
        for (int i = 0; i < list_students.size(); i++) {
            //System.out.println(list_students.get(i).getName()+ "-" + list_students.get(i).getCity()+"-"+ list_students.get(i).getGender() + "-" + list_students.get(i).getC1()+ "-" +list_students.get(i).getC9());
            if (list_students.get(i).getCity().equals("Guangzhou")
                    &&list_students.get(i).getC1()>=80.0
                    &&list_students.get(i).getC9()>=9.0
                    &&(list_students.get(i).getGender().equals("boy")||list_students.get(i).getGender().equals("male"))
            ) {
                arr.add(list_students.get(i));  //如果符合条件，加入学生列表
            }
        }

        System.out.println(arr.size());    //打印数组的长度，即符合条件的人数
    }
}
