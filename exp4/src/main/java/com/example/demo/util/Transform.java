package com.example.demo.util;

import java.util.ArrayList;

public class Transform {
    public static Double[] GetColumn_i(Double[][] matrix, int column) {  //求矩阵的某一列
        int length = matrix.length;
        Double[] column_list = new Double[length];   //申请数组空间，保存列的值
        if (matrix != null) {   //如果不为空
            for (int i = 0; i < length; i++) {   //遍历矩阵的每一行，获取column对应的值
                column_list[i] = matrix[i][column];
            }
        }
        return column_list;
    }

    public static Double[] VectorMultiply(Double[] vector1, Double[] vector2) {
        Double[] vector_multi = new Double[vector1.length];  //申请空间
        if (vector1.length == vector2.length) {   //长度相等，乘积
            for (int i = 0; i < vector1.length; i++) {
                vector_multi[i] = vector1[i] * vector2[i];
            }
            return vector_multi;   //返回向量的乘积
        } else {  //不想等打印错误信息，返回null
            System.out.println("两个向量的长度不一致");
        }
        return null;
    }

    //向量的数量积
    public static Double Multiply(Double[] vector1, Double[] vector2) {
        Double sum = 0.0;  //初始化为0.0
        if (vector1.length == vector2.length)   //长度相等才能相乘，否则打印错误信息
        {
            for (int i = 0; i < vector1.length; i++) {
                    sum += vector1[i] * vector2[i];
            }
        } else {
            System.out.println("两向量的长度不一致");
        }

        return sum;
    }


    //矩阵乘法
    public static Double[][] Dot(Double[][] matrix1, Double[][] matrix2) {
        int m = matrix1.length;
        int n = matrix1[0].length;
        int n1 = matrix2.length;
        int p = matrix2[0].length;
        Double[][] matrix3 = new Double[m][p];   //申请一个m*p的空间
        //Print.PrintMatrixSize(matrix3);
        if (n != n1) {   //如果矩阵1的列数和矩阵2的行数不等
            System.out.println("矩阵1的列数和矩阵2的行数不等");
        } else {  //如果矩阵1的列数和矩阵2的行数相等
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < p; j++) {
                    Double[] row_m1 = matrix1[i];  //取出矩阵1的第i行
                    Double[] col_m2 = Transform.GetColumn_i(matrix2, j);
                    //Print.PrintVector(col_m2);
                    Double sum = Transform.Multiply(row_m1, col_m2);  //两个向量的乘积
                    //System.out.print(sum + " ");
                    matrix3[i][j] = sum;  //赋给矩阵的对应元素
                }

            }
        }
        return matrix3;  //返回矩阵的乘积矩阵
    }

    //矩阵的转置
    public static Double[][] T(Double[][] matrix) {   //转置
        int m = matrix.length;
        int n = matrix[0].length;
        Double[][] matrix_T = new Double[n][m];    //转置矩阵
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix_T[i][j] = matrix[j][i];
            }
        }
        return matrix_T;
    }

    //重塑
    public static Double[][] Reshape(Double[][] matrix, int rows, int columns) {
        int m = matrix.length;
        int n = matrix[0].length;

        if (rows * columns != m * n) {   //如果不符合重塑的需求
            System.out.println("矩阵尺寸和重塑的尺寸不符合要求");
            return null;
        }

        Double[][] matrix_reshape = new Double[rows][columns];   //重塑之后的矩阵
        Double[] list = new Double[rows * columns];  //申请m*n个空间，暂时存放矩阵的元素，再进行重新分配
        int index = 0;//索引，遍历list
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                list[index] = matrix[i][j];  //装进一个数组，后面进行分配
                index++;
            }
        }
        index = 0;   //重设为0，继续用
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix_reshape[i][j] = list[index];   //获取index的值
                index++; //设置一个元素之后index++
            }
        }
        return matrix_reshape;  //返回重塑之后的矩阵
    }

    public static Double[] Sub(Double[] vector1, Double[] vector2) {
        Double[] vector_sub = new Double[vector1.length];
        if (vector1.length == vector2.length) {  //长度相等执行减法
            for (int i = 0; i < vector1.length; i++) {
                vector_sub[i] = vector1[i] - vector2[i];  //求减法
            }
            return vector_sub;  //返回做减法之后的数据
        } else {
            System.out.println("两个向量的长度不一致");
        }
        return null;
    }

    public static Double[] Add(Double[] vector1, Double[] vector2) {
        Double[] vector_add = new Double[vector1.length];
        if (vector1.length == vector2.length) {  //长度相等执行加法
            for (int i = 0; i < vector1.length; i++) {
                vector_add[i] = vector1[i] + vector2[i];  //求加法
            }
            return vector_add;  //返回做减法之后的数据
        } else {
            System.out.println("两个向量的长度不一致");
        }
        return null;
    }

    public static Double[][] Sub(Double[][] matrix1, Double[][] matrix2) {
        Double[][] matrix_sub = new Double[matrix1.length][matrix1[0].length];  //先创建空间
        //如果尺寸相同再执行减法
        if (matrix1.length == matrix2.length && matrix1[0].length == matrix2[0].length) {
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[0].length; j++) {
                    matrix_sub[i][j] = matrix1[i][j] - matrix2[i][j];  //对应元素相减
                }
            }
            return matrix_sub;   //return减法矩阵
        } else {   //尺寸不相等，打印相关信息
            System.out.println("两个矩阵的尺寸不相同");
        }
        return null;
    }

    public static Double[] log(Double[] vector) {
        int len = vector.length;   //取得长度
        Double[] vector_log = new Double[len];   //申请空间
        for (int i = 0; i < len; i++) {
            vector_log[i] = Math.log(vector[i]);
        }
        return vector_log;   //返回向量
    }

    public static Double[][] log(Double[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Double[][] matrix_log = new Double[m][n];   //申请m*n个空间
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix_log[i][j] = Math.log(matrix[i][j]);
            }
        }
        return matrix_log;   //返回log矩阵
    }

    //求和矩阵
    public static Double Sum(Double[][] matrix) {
        Double sum = 0.0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sum += matrix[i][j];   //求和
            }
        }
        return sum;  //返回求和的值
    }

    //求和向量
    public static Double Sum(Double[] vector) {
        Double sum = 0.0;
        for (int i = 0; i < vector.length; i++) {
            sum += vector[i];   //求和
        }
        return sum;   //返回求和的值
    }

    public static Double[] TransformMatrixToVector(Double[][] matrix) {
        int index = 0;   //索引遍历元素
        Double[] vector = new Double[matrix.length * matrix[0].length];  //申请空间
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                vector[index] = matrix[i][j];
                index++;
            }
        }
        return vector;
    }

    public static Double[][] TransformVectorToMatrix(Double[] vector) {
        Double[][] matrix = new Double[1][vector.length];  //一维的矩阵
        for (int i = 0; i < vector.length; i++) {
            matrix[0][i] = vector[i];
        }
        return matrix;
    }

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
            return Transform.Sigmoid(dot);  //return 预测矩阵
        }
        return null;   //如果执行失败返回null（尺寸不对应）
    }


    //代价函数，可以使用
    public static Double Cost(Double[][] X, Double[][] theta, Double[][] Y) {
        int y_length = TransformMatrixToVector(Y).length;
        Double[] y = Transform.TransformMatrixToVector(Y);  //转换成y向量
        Double[] y_predict = Transform.TransformMatrixToVector(Transform.Model(X, theta));
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
        int len_y = TransformMatrixToVector(Y).length;   //先算出Y的行数len

        Double[][] Y_pred = Model(X, theta);
        Double[][] Y_sub_Y_pred = Transform.Sub(Y_pred, Y);   //Y_pred - Y
        Double[][] Gradient_Vector = Transform.Dot(Transform.T(X), Y_sub_Y_pred);  //梯度向量
        for (int i = 0; i < Gradient_Vector.length; i++) {   //除去长度，求Avg
            for (int j = 0; j < Gradient_Vector[0].length; j++) {
                Gradient_Vector[i][j] /= len_y;
            }
        }
        return Gradient_Vector;
    }

    public static ArrayList<Double[][]> LR(Double[][] X, Double[][] Y, Double[][] theta, int epochs, Double lr, Double[] cost) {
        ArrayList<Double[][]> list = new ArrayList<>();
        int index = 0;   //遍历cost
        for (int i = 0; i < epochs; i++) {
            Double[][] grad_mat = new Double[theta.length][theta[0].length];  //乘以学习速率之后的grad
            Double[][] grad = Transform.Gradient(X, theta, Y);   //获取梯度
            for (int j = 0; j < theta.length; j++) {
                for (int k = 0; k < theta[0].length; k++) {
                    grad_mat[j][k] = grad[j][k] * lr;
                }
            }
            theta = Transform.Sub(theta, grad_mat);   //theta -= grad_mat
            if(i == epochs -1){
                list.add(theta);
            }
            cost[index] = Transform.Cost(X, theta, Y);  //向cost列表中添加cost
            index++;
        }
        return list;
    }

    public static Double[][] Add_One_Column_AtFirst(Double[][] matrix, Double x) {
        Double[][] new_matrix = new Double[matrix.length][matrix[0].length + 1];  //多申请一列的空间
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <= matrix[0].length; j++) {
                if (j == 0) {
                    new_matrix[i][j] = x;
                } else {
                    new_matrix[i][j] = matrix[i][j - 1];
                }

            }
        }
        return new_matrix;
    }

}
