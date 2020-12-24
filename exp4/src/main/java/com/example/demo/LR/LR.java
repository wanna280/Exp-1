package com.example.demo.LR;

import com.example.demo.util.Transform;

import java.util.ArrayList;

public class LR {
    public static Double[][] Sigmoid(Double[][] matrix) {   //sigmoid函数
        Double[][] matrix_sigmoid = new Double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix_sigmoid[i][j] = 1 / (1 + Math.exp(-matrix[i][j]));   //sigmoid矩阵
            }
        }
        return matrix_sigmoid;   //return sigmoid矩阵
    }


    //预测函数
    public static Double[][] Model(Double[][] X, Double[][] theta) {  //没有问题
        int m = X.length;
        int n = X[0].length;
        int n1 = theta.length;
        int p = theta[0].length;
        if (n != n1) {   //如果矩阵1的列数和矩阵2的行数不相等，打印错误信息
            System.out.println("矩阵1的列数和矩阵2的行数不相等");
        } else {  //相等的话，就进行矩阵的乘法，并用sigmoid函数进行预测
            Double[][] dot = Transform.Dot(X, theta);  //先求矩阵的乘积
            return LR.Sigmoid(dot);  //return 预测矩阵
        }
        return null;   //如果执行失败返回null（尺寸不对应）
    }


    //代价函数，可以使用
    public static Double Cost(Double[][] X, Double[][] theta, Double[][] Y) {
        int y_length = Transform.TransformMatrixToVector(Y).length;
        Double[] y = Transform.TransformMatrixToVector(Y);  //转换成y向量
        Double[] y_predict = Transform.TransformMatrixToVector(LR.Model(X, theta));
        Double[] ones_vector = new Double[y_length];   //申请和y一样长的1
        for (int i = 0; i < ones_vector.length; i++) {  //置为1
            ones_vector[i] = 1.0;
        }
        //left = y*log(y_pred)
        Double[] left = Transform.VectorMultiply(y, Transform.log(y_predict));  //y*y_pred
        Double[] one_sub_y = Transform.Sub(ones_vector, y);  //1-y

        Double[] one_sub_y_predict = Transform.Sub(ones_vector, y_predict); //1-y_pred

        //right = (1-y)*log(1-y_pred)
        Double[] right = Transform.VectorMultiply(one_sub_y, Transform.log(one_sub_y_predict));
        Double[] func = Transform.Add(left, right);  //最大似然函数（求和的时候得取负数）
        return -Transform.Sum(func) / y_length;   //return sum(loss)/len
    }

    //求梯度
    public static Double[][] Gradient(Double[][] X, Double[][] theta, Double[][] Y) {
        int len_y = Transform.TransformMatrixToVector(Y).length;   //先算出Y的行数len

        Double[][] Y_pred = Model(X, theta);
        Double[][] Y_sub_Y_pred = Transform.Sub(Y_pred, Y);   //Y_pred - Y
        Double[][] Gradient_Vector = Transform.Dot(Transform.T(X), Y_sub_Y_pred);  //梯度向量
        for (int i = 0; i < Gradient_Vector.length; i++) {   //除去长度，求Avg
            for (int j = 0; j < Gradient_Vector[0].length; j++) {
                Gradient_Vector[i][j] /= len_y;
            }
        }
        return Gradient_Vector;  //返回梯度向量e
    }

    public static ArrayList<Double[][]> LR(Double[][] X, Double[][] Y, Double[][] theta, int epochs, Double lr, Double[] cost) {
        ArrayList<Double[][]> list = new ArrayList<>();
        int index = 0;   //遍历cost
        for (int i = 0; i < epochs; i++) {
            Double[][] grad_mat = new Double[theta.length][theta[0].length];  //乘以学习速率之后的grad
            Double[][] grad = LR.Gradient(X, theta, Y);   //获取梯度
            for (int j = 0; j < theta.length; j++) {
                for (int k = 0; k < theta[0].length; k++) {
                    grad_mat[j][k] = grad[j][k] * lr;
                }
            }
            theta = Transform.Sub(theta, grad_mat);   //theta -= grad_mat
            if(i == epochs -1){
                list.add(theta);
            }
            cost[index] = LR.Cost(X, theta, Y);  //向cost列表中添加cost
            index++;
        }
        return list;  //返回最后一个beta
    }
}
