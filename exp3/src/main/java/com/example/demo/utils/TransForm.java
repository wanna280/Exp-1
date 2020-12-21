package com.example.demo.utils;

import com.example.demo.point.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class TransForm {
    public static double GetAverage(Double[] grades) {   //传入一个grades的ArrayList求均值
        double sum = 0;   //sum，用于保存列表所有元素的和，初始化为0
        for (int i = 0; i < grades.length; i++) {  //对列表中的所有元素进行求和
            sum += grades[i];
        }
        return sum / grades.length;   //return average
    }

    public static double GetCovariance(Double[] grades) {  //传入一个grades的ArrayList求方差
        double avg = TransForm.GetAverage(grades);     //调用实现的方法求平均值
        double sum = 0;  //sum
        for (int i = 0; i < grades.length; i++) {
            sum += (grades[i] - avg) * (grades[i] - avg);   //sum = (Xi-avg)^2
        }
        return sum / (grades.length - 1);   //return cov
    }

    public static Double[] GetZScore(Double[] grades) {  //传入一个grades的ArrayList，进行Zscore化
        double avg = TransForm.GetAverage(grades);   //调用平均值函数求均值
        double s = Math.sqrt(TransForm.GetCovariance(grades));  //求出方法
        Double[] zscore = new Double[grades.length];
        if (s != 0) {
            for (int i = 0; i < grades.length; i++) {
                zscore[i] = (grades[i] - avg) / s;
            }
        }
        else {
            return grades;
        }

        return zscore;   //return zscore
    }

    public static double GetDistance(Point p1, Point p2) {  //求出任意维度的点的欧式距离
        double sum = 0;
        for (int i = 0; i < p1.GetLength(); i++) {
            sum += (p1.GetX()[i] - p2.GetX()[i]) * (p1.GetX()[i] - p2.GetX()[i]);
        }
        return Math.sqrt(sum);
    }


    public static boolean Exists(int x, Integer[] array) {  //x是否存在于array当中
        HashSet<Integer> set = new HashSet<>();
        set.addAll(Arrays.asList(array));   //将数组转换成为集合
        if (set.contains(x)) {
            return true;
        }
        return false;
    }

    public static double GetMin(double[] arr) {  //求出数组的最小值
        double min = arr[0];  //初始化min = arr[0]
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {  //如果遇到比自己还小的，将自己的值修改为更小的值
                min = arr[i];
            }
        }
        return min;
    }


}
