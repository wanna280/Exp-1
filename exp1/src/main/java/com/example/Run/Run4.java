package com.example.Run;

import com.example.entity.Student;
import com.example.util.ReadFile;
import com.example.util.dataProcessing;

import java.util.ArrayList;

public class Run4 {

    public static void Run4() {
        ArrayList<Student> list = ReadFile.ReadCsv();   //读取Csv的内容
        list.addAll(ReadFile.ReadTxt());  //添加Txt的内容
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

        for (int i = 0; i < list.size(); i++) {
            arr1.add(list.get(i).getC1());
            arr2.add(list.get(i).getC2());
            arr3.add(list.get(i).getC3());
            arr4.add(list.get(i).getC4());
            arr5.add(list.get(i).getC5());
            arr6.add(list.get(i).getC6());
            arr7.add(list.get(i).getC7());
            arr8.add(list.get(i).getC8());
            arr9.add(list.get(i).getC9());
            arr10.add(list.get(i).getC10());
            arr11.add(dataProcessing.TransformConstitution(list.get(i).getConstitution()));
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
