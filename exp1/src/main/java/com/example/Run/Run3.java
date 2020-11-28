package com.example.Run;

import com.example.entity.Student;
import com.example.util.ReadFile;
import com.example.util.dataProcessing;

import java.util.ArrayList;

public class Run3 {
    public static void Run3(){
        String filePath_csv = "src/main/java/com/example/Data/data.csv";
        String filePath_txt = "src/main/java/com/example/Data/data.txt";
        ArrayList<Student> list_students = dataProcessing.MergeCsvAndTxt(filePath_csv,filePath_txt);
        ArrayList<Student> arr_guangzhou = new ArrayList<Student>();
        ArrayList<Student> arr_shanghai = new ArrayList<Student>();
        System.out.println(list_students.size());
        for (int i = 0; i < list_students.size(); i++) {
            if (list_students.get(i).getCity().equals("Guangzhou")) {
                arr_guangzhou.add(list_students.get(i));
            }
            if (list_students.get(i).getCity().equals("Shanghai")) {
                arr_shanghai.add(list_students.get(i));
            }
        }
        System.out.println(arr_guangzhou.size());
        System.out.println(arr_shanghai.size());

        ArrayList<Double> arr2 = new ArrayList<>();
        ArrayList<Double> arr3 = new ArrayList<>();

        for (int i=0;i<arr_guangzhou.size();i++){
            arr2.add(dataProcessing.TransformConstitution(arr_guangzhou.get(i).getConstitution()));
        }
        for (int i=0;i<arr_shanghai.size();i++){
            arr3.add(dataProcessing.TransformConstitution(arr_shanghai.get(i).getConstitution()));
        }

        Double avg1 = dataProcessing.GetAverage(arr2);
        Double avg2 = dataProcessing.GetAverage(arr3);
        System.out.println("avg1-"+avg1+"/avg2-"+avg2);
    }
}
