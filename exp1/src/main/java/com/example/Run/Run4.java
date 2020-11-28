package com.example.Run;

import com.example.entity.Student;
import com.example.util.ReadFile;
import com.example.util.dataProcessing;

import java.util.ArrayList;

public class Run4 {

    public static void Run4() {
        String filePath_csv = "src/main/java/com/example/Data/data.csv";
        String filePath_txt = "src/main/java/com/example/Data/data.txt";
        ArrayList<Student> list_students = dataProcessing.MergeCsvAndTxt(filePath_csv,filePath_txt);

        ArrayList<Double> arr1 = new ArrayList<>();
        ArrayList<Double> arr2 = new ArrayList<>();
        ArrayList<Double> arr3 = new ArrayList<>();
        ArrayList<Double> arr4 = new ArrayList<>();
        ArrayList<Double> arr5 = new ArrayList<>();
        ArrayList<Double> arr6 = new ArrayList<>();
        ArrayList<Double> arr7 = new ArrayList<>();
        ArrayList<Double> arr8 = new ArrayList<>();
        ArrayList<Double> arr9 = new ArrayList<>();
        ArrayList<Double> arr10 = new ArrayList<>();
        ArrayList<Double> arr11 = new ArrayList<>();

        for (int i = 0; i < list_students.size(); i++) {
            arr1.add(list_students.get(i).getC1());
            arr2.add(list_students.get(i).getC2());
            arr3.add(list_students.get(i).getC3());
            arr4.add(list_students.get(i).getC4());
            arr5.add(list_students.get(i).getC5());
            arr6.add(list_students.get(i).getC6());
            arr7.add(list_students.get(i).getC7());
            arr8.add(list_students.get(i).getC8());
            arr9.add(list_students.get(i).getC9());
            arr10.add(list_students.get(i).getC10());
            arr11.add(dataProcessing.TransformConstitution(list_students.get(i).getConstitution()));
        }

        System.out.println(dataProcessing.GetCorrelation(arr1, arr11));
        System.out.println(dataProcessing.GetCorrelation(arr2, arr11));
        System.out.println(dataProcessing.GetCorrelation(arr3, arr11));
        System.out.println(dataProcessing.GetCorrelation(arr4, arr11));
        System.out.println(dataProcessing.GetCorrelation(arr5, arr11));
        System.out.println(dataProcessing.GetCorrelation(arr6, arr11));
        System.out.println(dataProcessing.GetCorrelation(arr7, arr11));
        System.out.println(dataProcessing.GetCorrelation(arr8, arr11));
        System.out.println(dataProcessing.GetCorrelation(arr9, arr11));
        //System.out.println(dataProcessing.GetCorrelation(arr10,arr11));
    }
}
