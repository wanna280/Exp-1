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
        final String filePath = "dataf.csv";
        int dim = 11;
        int num = 106;
        Double[][] x1 = new Double[dim][num];
        FileOperate.ReadFileAsArray1("dataf.csv",x1,dim);
        for (int i = 0; i < dim; i++) {
                x1[i] = TransForm.GetZScore(x1[i]);
        }
        KMeans.KMeans1(3,x1,dim,num);

    }

}
