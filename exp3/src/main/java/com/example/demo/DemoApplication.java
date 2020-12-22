package com.example.demo;

import com.example.demo.kmeans.KMeans;
import com.example.demo.point.Point;
import com.example.demo.utils.FileOperate;
import com.example.demo.utils.TransForm;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        int dim = 2;
        int num = 20;
        Double[][] x1 = new Double[dim][num];
        FileOperate.ReadFileAsArrayn("data.csv",x1,dim);
//        for (int i = 0; i < dim; i++) {
//                x1[i] = TransForm.GetZScore(x1[i]);
//        }
        KMeans.KMeans(2,x1,dim,num);

    }

}
