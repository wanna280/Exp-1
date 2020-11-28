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
        ArrayList<Student> list = dataProcessing.MergeCsvAndTxt(filePath_csv,filePath_txt);
        ArrayList<Student> arr = new ArrayList<Student>();
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            //System.out.println(list.get(i).getName()+ "-" + list.get(i).getCity()+"-"+ list.get(i).getGender() + "-" + list.get(i).getC1()+ "-" +list.get(i).getC9());
            if (list.get(i).getCity().equals("Guangzhou")
                    &&list.get(i).getC1()>=80.0
                    &&list.get(i).getC9()>=9.0
                    &&(list.get(i).getGender().equals("boy")||list.get(i).getGender().equals("male"))
            ) {
                arr.add(list.get(i));
            }
        }

        System.out.println(arr.size());
    }
}
