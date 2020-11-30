package com.example.demo;

import com.example.Paint.Paint;
import com.example.Run.Run1;
import com.example.Run.Run2;
import com.example.Run.Run3;
import com.example.Run.Run4;
import com.example.entity.Student;
import com.example.util.ExportFile;
import com.example.util.dataProcessing;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class DemoApplication {

    public static void main(String[] args) {
        //Run1.Run1();
        //Run2.Run2();
        //Run3.Run3();
        //Run4.Run4();
        //Panel panel = new Paint();
        //Frame frame = new Frame("aaa");
        //frame.setLocation(200,200);
        //frame.add(panel);
        //frame.setResizable(false);
        //frame.setVisible(true);

        String filePath_csv = "src/main/java/com/example/Data/data.csv";
        String filePath_txt = "src/main/java/com/example/Data/data.txt";
        ArrayList<Student> students = dataProcessing.MergeDuplicateRemoval_CsvAndTxt(filePath_csv,filePath_txt);

        ExportFile.ExportByFormat(students);
        System.out.println(students.size());

        //SpringApplication.run(DemoApplication.class, args);
//        while (true){
//
//        }
    }

}
