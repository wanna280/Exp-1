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
        ArrayList<Student> list_students = dataProcessing.MergeCsvAndTxt(filePath_csv,filePath_txt);

        ArrayList<Student> arr = new ArrayList<Student>();
        HashMap<String, Double> map = new HashMap<>();
        for (int i = 0; i < list_students.size(); i++) {   //将地址为北京的放入列表arr
            if (list_students.get(i).getCity().equals("Beijing")) {
                arr.add(list_students.get(i));
            }
        }
        for (int j = 0; j < arr.size(); j++) {  //遍历arr，将Average、ZScore等放入map
            Student t = list_students.get(j);
            ArrayList<Double> arr_grades = new ArrayList<>();
            arr_grades.add(t.getC1());
            arr_grades.add(t.getC2());
            arr_grades.add(t.getC3());
            arr_grades.add(t.getC4());
            arr_grades.add(t.getC5());
            arr_grades.add(t.getC6()*10);
            arr_grades.add(t.getC7()*10);
            arr_grades.add(t.getC8()*10);
            arr_grades.add(t.getC9()*10);
            arr_grades.add(t.getC10()*10);
            arr_grades.add(dataProcessing.TransformConstitution(t.getConstitution()));
            //System.out.println(dataProcessing.TransformConstitution(t.getConstitution()));

            double avg = dataProcessing.GetAverage(arr_grades);
            map.put(t.getName(), avg);
        }


        System.out.println(map.size());
        for (String key :       //遍历key，打印average信息
                map.keySet()) {
            System.out.println("average" + "-" + key + "-" + map.get(key));
        }
    }
}
