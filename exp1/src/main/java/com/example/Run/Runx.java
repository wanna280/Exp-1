package com.example.Run;

import com.example.entity.Student;
import com.example.util.ReadFile;
import com.example.util.dataProcessing;

import java.util.ArrayList;
import java.util.HashMap;

public class Runx {
    public void Runx(){
        ArrayList<Student> list = ReadFile.ReadCsv();
        ArrayList<Student> arr = new ArrayList<Student>();
        HashMap<String, Double> map = new HashMap<>();
        HashMap<String, ArrayList<Double>> map1 = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {   //将地址为北京的放入列表arr
            //System.out.println(list.get(i).getId());
            if (list.get(i).getCity().equals("Beijing")) {
                arr.add(list.get(i));
            }
        }


        for (int j = 0; j < arr.size(); j++) {  //遍历arr，将Average、ZScore等放入map1
            Student t = list.get(j);
            ArrayList<Double> arr1 = new ArrayList<>();
            arr1.add(t.getC1());
            arr1.add(t.getC2());
            arr1.add(t.getC3());
            arr1.add(t.getC4());
            arr1.add(t.getC5());
            arr1.add(t.getC6()*10);
            arr1.add(t.getC7()*10);
            arr1.add(t.getC8()*10);
            arr1.add(t.getC9()*10);
            arr1.add(t.getC10()*10);
            arr1.add(dataProcessing.TransformConstitution(t.getConstitution()));
            //System.out.println(dataProcessing.TransformConstitution(t.getConstitution()));

            ArrayList<Double> a1 = dataProcessing.GetZScore(arr1);
            map1.put(t.getName(), a1);

            double avg = dataProcessing.GetAverage(arr1);
            map.put(t.getName(), avg);
        }
        for (String key :       //遍历key，打印average
                map.keySet()) {
            System.out.println("average" + "-" + key + "-" + map.get(key));
        }
        for (String key :       //遍历key，打印zscore
                map1.keySet()) {
            //System.out.println("zscore" + "-" + key + "-" + map1.get(key).toString());
        }
    }
}
