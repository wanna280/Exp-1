package com.example.Run;

import com.example.entity.Student;
import com.example.util.ReadFile;
import com.example.util.dataProcessing;

import java.util.ArrayList;
import java.util.HashMap;

public class Run1 {
    public static void Run1(){
        String filePath_csv = "src/main/java/com/example/Data/data.csv";
        String filePath_txt = "src/main/java/com/example/Data/data.txt";
        ArrayList<Student> list = dataProcessing.MergeCsvAndTxt(filePath_csv,filePath_txt);

        ArrayList<Student> arr = new ArrayList<Student>();
        HashMap<String, Double> map = new HashMap<>();
        HashMap<String, ArrayList<Double>> map1 = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {   //将地址为北京的放入列表arr
            if (list.get(i).getCity().equals("Beijing")) {
                arr.add(list.get(i));
            }
        }
        for (int j = 0; j < arr.size(); j++) {  //遍历arr，将Average、ZScore等放入map
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

            double avg = dataProcessing.GetAverage(arr1);
            map.put(t.getName(), avg);
        }


        System.out.println(map.size());
        for (String key :       //遍历key，打印average
                map.keySet()) {
            System.out.println("average" + "-" + key + "-" + map.get(key));
        }
    }
}
