package com.example.demo;

import com.example.demo.kmeans.KMeans;
import com.example.demo.point.Point;
import com.example.demo.utils.FileOperate;
import com.example.demo.utils.TransForm;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashMap;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        final String filePath = "data.csv";
//        //SpringApplication.run(DemoApplication.class, args);

//        final int len = 20;  //数组长度
//        Double[] x = new Double[len];
//        Double[] y = new Double[len];
//
//        FileOperate.ReadFileAsArray(filePath, x, y);
//        x = TransForm.GetZScore(x);
//        y = TransForm.GetZScore(y);
//
//        KMeans.KMeans(2,x,y);

//        int dim = 11;
//        int num = 106;
//        Double[][] x1 = new Double[11][106];
//        FileOperate.ReadFileAsArray1("dataf.csv",x1,dim);
//        for (int i = 0; i < 11; i++) {
//            if(i!=9){
//                x1[i] = TransForm.GetZScore(x1[i]);
//            }
//        }
//
//        KMeans.KMeans1(4,x1,dim,num);

        int dim = 11;
        int num = 106;
        Double[][] x1 = new Double[dim][num];
        FileOperate.ReadFileAsArray1("dataf.csv",x1,dim);
        for (int i = 0; i < dim; i++) {
                x1[i] = TransForm.GetZScore(x1[i]);
        }
        KMeans.KMeans1(4,x1,dim,num);
    }

}
