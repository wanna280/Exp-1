package com.example.demo;

import com.example.demo.util.FileOperate;
import com.example.demo.util.Print;
import com.example.demo.util.Transform;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.crypto.Data;
import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        Double[][] dataset = new Double[3][20];  //读取数据
        FileOperate.ReadFileAsArrayn("data_tag.csv", dataset, 3);
        Double[][] ds = Transform.T(dataset);
        Double[][] DataSet = Transform.Add_One_Column_AtFirst(ds, 1.0);

        Double[] columns = Transform.GetColumn_i(DataSet, 3);
        Double[][] X0 = new Double[3][20];
        X0[0] = Transform.GetColumn_i(DataSet, 0);
        X0[1] = Transform.GetColumn_i(DataSet, 1);
        X0[2] = Transform.GetColumn_i(DataSet, 2);

        Double[][] X = Transform.T(X0);
        Double[][] Y = Transform.T(Transform.TransformVectorToMatrix(columns));  //得到数据Y
        Double[][] theta = new Double[][]{{0.0}, {0.0}, {0.0}};  //theta->(3*1)
        Double lr = 0.1;  //定义学习速率为0.1
        int epochs = 10000;  //次数为10000
        Double[] cost = new Double[epochs];   //代价值变化

        for (int i = 0; i < epochs; i++) {
            cost[i] = 1.0;
        }

        Double[][] _T = Transform.T(X);
        Double[][] _Y = new Double[1][20];

        ArrayList<Double[][]> list = Transform.LR(X,Y,theta,epochs,lr,cost);
        Print.PrintMatrix(list.get(0));
        Print.PrintVector(cost,60);


    }

}
