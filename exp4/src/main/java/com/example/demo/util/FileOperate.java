package com.example.demo.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileOperate {
    public static void ReadFileAsArrayn(String filePath, Double[][] x, int dim) {
        File file = new File(filePath);   //创建文件指针读文件
        try {
            FileReader reader = new FileReader(file);   //创建读文件指针
            BufferedReader bufferedReader = new BufferedReader(reader);  //创建读缓冲区指针
            String line;  //保存行的内容
            int i = 0;  //index
            while ((line = bufferedReader.readLine()) != null) {
                String[] lineArr = line.split(",");   //将每行切割成x,y
                //System.out.println(lineArr[0]+" "+lineArr[1]);
                for (int j = 0; j < dim; j++) {
                    x[j][i] = Double.parseDouble(lineArr[j]);  //加入数组
                    //System.out.println(x[j][i]);
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
