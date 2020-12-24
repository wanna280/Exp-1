package com.example.demo;

import com.example.demo.LR.LR;
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

        ArrayList<Double[][]> list = LR.LR(X, Y, theta, epochs, lr, cost);
        Print.PrintMatrix(list.get(0));
        Print.PrintVector(cost, 40);  //从10000个数据中打印前40个

        ArrayList<Double> class_1 = new ArrayList<Double>();
        ArrayList<Double> class_0 = new ArrayList<Double>();
        Double[][] predict = LR.Model(X, list.get(0));
        for (int i = 0; i < predict.length; i++) {
            for (int j = 0; j < predict[0].length; j++) {
                if (predict[i][j] > 0.5) {
                    class_1.add(predict[i][j]);
                } else {
                    class_0.add(predict[i][j]);
                }
            }
        }
        //Print.PrintMatrix(predict);
        System.out.println("1类中的数量有：" + class_1.size());
        System.out.println("0类中的数量有：" + class_0.size());


        Double[][] X1 = new Double[][]{{1.0, 2.0, 6.0}};
        Double[][] pred = LR.Model(X1, list.get(0));
        int class_flag = pred[0][0] > 0.5 ? 1 : 0;
        System.out.println("预测点(2,6)所在分类为" + class_flag);

    }

}
