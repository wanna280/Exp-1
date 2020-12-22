package com.example.demo.utils;

import com.example.demo.point.Point;
import com.example.demo.point.PointList;

import java.io.*;
import java.util.ArrayList;

public class FileOperate {
    /**
     * 用于保存二维的点
     *
     * @param filePath 文件路径
     * @param x        要读入的第一列数据
     * @param y        要读入的第二列数据
     */
    public static void ReadFileAsArray(String filePath, Double[] x, Double[] y) {
        File file = new File(filePath);   //创建文件指针读文件
        try {
            FileReader reader = new FileReader(file);   //创建读文件指针
            BufferedReader bufferedReader = new BufferedReader(reader);  //创建读缓冲区指针
            String line;  //保存行的内容
            int i = 0;  //index
            while ((line = bufferedReader.readLine()) != null) {
                String[] lineArr = line.split(",");   //将每行切割成x,y
                x[i] = Double.parseDouble(lineArr[0]);  //加入数组
                y[i] = Double.parseDouble(lineArr[1]);
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * 用于保存n(20)维的点
     *
     * @param filePath 传入需要读入的文件路径
     * @param x        需要返回的数据
     * @param dim      需要读取的数据维度
     */
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

    public static void ExportFile(String filePath, ArrayList<Point[]> arr, int len) {  //导出中心点
        File file = new File(filePath);
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (int i = 0; i < arr.size(); i++) {
                for (int j = 0; j < arr.get(i).length; j++) {
                    for (int k = 0; k < len; k++) {
                        String content = String.valueOf(arr.get(i)[j].GetXi(k));
                        //System.out.println(content);
                        if (k == len - 1) {
                            bufferedWriter.write(content);
                        } else {
                            bufferedWriter.write(content + ",");
                        }

                    }
                    bufferedWriter.write("\n");  //换行
                }

            }

            bufferedWriter.close();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void ExportTagFile(String fileName, int K, int dim, PointList[] pointLists)  //导出打标签后的文件
    {
        File file = new File(fileName);   //创建一个文件指针对象
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);   //创建文件指针写的对象
            BufferedWriter bufferedWriter = new BufferedWriter(writer);   //创建写缓冲区指针的对象

            for (int i = 0; i < K; i++) {   //遍历得到标签列表的每一行
                for (int j = 0; j < pointLists[i].points.size(); j++) {
                    String tagFileLine = "";    //标签文件的一行，用于写文件
                    for (int k = 0; k < dim; k++) {
                        tagFileLine += String.valueOf(pointLists[i].points.get(j).GetXi(k)) + ",";
                        if (k == dim - 1) {   //在行的最后，加上标签
                            tagFileLine += String.valueOf(i) + "\n";
                        }
                    }
                    System.out.println(tagFileLine);  //终端打印
                    bufferedWriter.write(tagFileLine);   //写入缓冲区（文件）
                }
            }
            bufferedWriter.close();  //关闭缓冲区指针
            writer.close();  //关闭文件指针

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
