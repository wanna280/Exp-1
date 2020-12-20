package com.example.demo.kmeans;

import com.example.demo.point.Point;
import com.example.demo.point.PointList;
import com.example.demo.utils.GetRandom;
import com.example.demo.utils.TransForm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class KMeans {
    /**
     * @param K
     * @param x
     * @param y
     */
    public static void KMeans(int K, Double[] x, Double[] y) {
        PointList[] pointLists = new PointList[K];  //存放聚类后的结果,分成K类
        Point[] points = new Point[K];  //聚类的中心点
        Integer[] random = GetRandom.GetRandom(K);   //生成K个不同的随机数

        for (int i = 0; i < K; i++) {  //初始化聚类结果列表为空
            pointLists[i] = new PointList();
            //System.out.println(random[i]);
        }

        for (int i = 0; i < K; i++) {  //生成聚类的中心点
            //System.out.println(random[i].intValue());
            points[i] = new Point();  //创建空点，并向其中加入值
            points[i].SetXi(0, x[random[i]]);
            points[i].SetXi(1, y[random[i]]);
            pointLists[i].points.add(points[i]);   //向列表中添加中心点
        }

        Double[][] disList = new Double[K][x.length];   //求出距离列表
        for (int j = 0; j < K; j++) {
            for (int i = 0; i < x.length; i++) {
                Point point = new Point(x[i], y[i]);
                double dis = TransForm.GetDistance(points[j], point);  //求距离数组
                disList[j][i] = dis;
                //System.out.println(disList[j][i]);
            }
        }

        for (int i = 0; i < disList[0].length; i++) {
            if (!TransForm.Exists(i, random)) {   //如果不是聚类的中心点
                double[] arr = new double[K];  //得到每一行的数据
                for (int j = 0; j < K; j++) {
                    arr[j] = disList[j][i];
                }
                for (int j = 0; j < K; j++) {   //如果是最小值，将其index对应的点放入聚类结果列表
                    if (arr[j] == TransForm.GetMin(arr)) {
                        pointLists[j].points.add(new Point(x[i], y[i]));
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < K; i++) {
            System.out.println(pointLists[i].points.size());
        }


    }

    public static void KMeans1(int K, Double[][] x, int dim, int num) {
        PointList[] pointLists = new PointList[K];  //存放聚类后的结果,分成K类
        Point[] points = new Point[K];  //聚类的中心点
        Integer[] random = GetRandom.GetRandom(K);   //生成K个不同的随机数
        Double[][] disList = new Double[K][num];   //存放距离矩阵

        for (int i = 0; i < K; i++) {  //生成聚类的中心点
            pointLists[i] = new PointList();   //初始化聚类的各个类别为空
            points[i] = new Point();  //创建空点，并向其中加入值
            for (int j = 0; j < dim; j++) {    //中心点的各个维度坐标
                points[i].SetXi(j, x[j][random[i]]);  //设置初始中心点的各纬度坐标
            }
            pointLists[i].points.add(points[i]);   //向聚类的类列表中添加中心点
        }

        for (int j = 0; j < K; j++) {
            for (int i = 0; i < num; i++) {
                Point point = new Point();
                for (int k = 0; k < dim; k++) {   //将多个纬度的值的转换为Point
                    point.SetXi(k, x[k][i]);
                }
                double dis = TransForm.GetDistance(points[j], point);  //求距离，并更新距离矩阵
                disList[j][i] = dis;
            }
        }

        for (int i = 0; i < disList[0].length; i++) {
            if (!TransForm.Exists(i, random)) {   //如果不是聚类的中心点
                double[] arr = new double[K];  //得到每一行的数据
                for (int j = 0; j < K; j++) {
                    arr[j] = disList[j][i];
                }
                for (int j = 0; j < K; j++) {   //如果是最小值，将其index对应的点放入聚类结果列表
                    if (arr[j] == TransForm.GetMin(arr)) {
                        Point point = new Point();
                        for(int k =0;k<dim;k++){
                            point.SetXi(k,x[k][i]);
                        }
                        pointLists[j].points.add(point);
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < K; i++) {
            System.out.print(pointLists[i].points.size() + " ");
        }
        System.out.println();

//        for (int i = 0; i < K; i++) {
//            System.out.println(pointLists[i].points.size());
//        }

        ArrayList<Point[]> center = new ArrayList<>();   //存放每次执行的聚类中心
        center.add(points);  //加入随机生成的中心
        int t = 0;
        while (t<20) {
            Point[] points1 = new Point[K];    //存放聚类的中心点
            for (int i = 0; i < K; i++) {
                points1[i] = new Point();    //重新生成聚类的质心
                double[] sum = new double[dim];  //求和，用来后面求质心
                for (int k = 0; k < dim; k++) {  //求每个维度坐标之和，并将其补充到质心点当中去
                    for (int j = 0; j < pointLists[i].points.size(); j++) {
                        sum[k] += pointLists[i].points.get(j).GetXi(k);
                    }
                    points1[i].SetXi(k, sum[k] / pointLists[i].points.size());  //设置质心的值
                }
                //System.out.println(points1[i].GetXi(0));
            }

            Double[][] disList1 = new Double[K][num];  //新的距离矩阵
            for (int i = 0; i < K; i++) {
                for (int j = 0; j < num; j++) {
                    disList1[i][j] = 0.0;
                }

            }
            for (int j = 0; j < K; j++) {
                for (int i = 0; i < num; i++) {
                    Point point = new Point();
                    for (int k = 0; k < dim; k++) {   //将多个纬度的值的转换为Point
                        point.SetXi(k, x[k][i]);
                    }
                    double dis = TransForm.GetDistance(points1[j], point);  //求距离，并更新距离矩阵
                    disList1[j][i] = dis;
                }
            }
            center.add(points1);

            for (int i = 0; i < K; i++) {   //清空上一次循环生成的列表，并重新初始化为空
                pointLists[i] = null;
                pointLists[i] = new PointList();
            }

            for (int i = 0; i < disList[0].length; i++) {
                double[] arr = new double[K];  //保存每一行的数据，用于后面对行内求最小值
                for (int j = 0; j < K; j++) {   //得到每一行的数据
                    arr[j] = disList1[j][i];
                }
                for (int j = 0; j < K; j++) {   //如果是最小值，将其index对应的点放入聚类结果列表
                    if (arr[j] == TransForm.GetMin(arr)) {  //判断对应的距离是否为最小值，如果是最小值，将其放入对应的类别的列表当中
                        pointLists[j].points.add(new Point(x[0][i], x[1][i]));
                        break;
                    }
                }
            }
            for (int i = 0; i < K; i++) {   //遍历每一个类别，打印类别的size
                System.out.print(pointLists[i].points.size() + " ");
            }
            System.out.println();
            t += 1;
        }
        System.out.println();
    }
}
