package com.example.Run;

import com.example.entity.Student;
import com.example.util.ReadFile;
import com.example.util.dataProcessing;

import java.util.ArrayList;

public class Run3 {
    public static void Run3(){
        ArrayList<Student> list = ReadFile.ReadCsv();   //读取Csv的内容
        list.addAll(ReadFile.ReadTxt());  //添加Txt的内容
        ArrayList<Student> arr = new ArrayList<Student>();
        ArrayList<Student> arr1 = new ArrayList<Student>();
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCity().equals("Guangzhou")) {
                arr.add(list.get(i));
            }
            if (list.get(i).getCity().equals("Shanghai")) {
                arr1.add(list.get(i));
            }
        }
        System.out.println(arr.size());
        System.out.println(arr1.size());

        ArrayList<Double> arr2 = new ArrayList<>();
        ArrayList<Double> arr3 = new ArrayList<>();

        for (int i=0;i<arr.size();i++){
            arr2.add(dataProcessing.TransformConstitution(arr.get(i).getConstitution()));
        }
        for (int i=0;i<arr1.size();i++){
            arr3.add(dataProcessing.TransformConstitution(arr.get(i).getConstitution()));
        }

        Double avg1 = dataProcessing.GetAverage(arr2);
        Double avg2 = dataProcessing.GetAverage(arr3);
        System.out.println("avg1-"+avg1+"/avg2-"+avg2);
    }
}
