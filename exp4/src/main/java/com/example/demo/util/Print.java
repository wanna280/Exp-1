package com.example.demo.util;

public class Print {
    public static void PrintMatrix(Double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void PrintVector(Double[] vector) {
        System.out.println("内容为：");
        for (int i = 0; i < vector.length; i++) {
            if ((i - 1) % 5 == 0) {
                System.out.println();
            }
            System.out.print(vector[i] + " ");
        }
        System.out.println();
    }

    public static void PrintVector(Double[] vector, int length) {
        System.out.println("内容为：");
        for (int i = 0; i < length; i++) {
            if (i % 5 == 0 && i != 0) {
                System.out.println();
            }
            System.out.print(vector[i] + " ");
        }
        System.out.println();
    }

    public static void PrintMatrixSize(Double[][] matrix) {
        System.out.println("形状为" + matrix.length + "*" + matrix[0].length);
    }
}
