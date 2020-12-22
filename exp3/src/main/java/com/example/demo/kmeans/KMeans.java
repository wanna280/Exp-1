package com.example.demo.kmeans;

import com.example.demo.point.Point;
import com.example.demo.point.PointList;
import com.example.demo.utils.FileOperate;
import com.example.demo.utils.GetRandom;
import com.example.demo.utils.TransForm;
import java.util.ArrayList;

public class KMeans {

    public static void KMeans(int K, Double[][] x, int dim, int num) {
        PointList[] points_k_list = new PointList[K];  //存放聚类后的结果,分成K类
        Point[] points_k_init = new Point[K];  //第一次使用随机点聚类的中心点
        Integer[] random = GetRandom.GetRandom(K);   //生成K个不同的随机数
        Double[][] distance_matrix_random_init = new Double[K][num];   //存放首次使用随机数生成的距离矩阵

        for (int i = 0; i < K; i++) {  //生成聚类的中心点
            points_k_list[i] = new PointList();   //初始化聚类的各个类别为空
            points_k_init[i] = new Point();  //创建空点，并向其中加入值
            for (int j = 0; j < dim; j++) {    //中心点的各个维度坐标
                points_k_init[i].SetXi(j, x[j][random[i]]);  //设置初始中心点的各维度坐标
            }
            points_k_list[i].points.add(points_k_init[i]);   //向聚类的类列表中添加中心点
        }

        for (int j = 0; j < K; j++) {
            for (int i = 0; i < num; i++) {
                Point point = new Point();
                for (int k = 0; k < dim; k++) {   //将多个维度的值的转换为Point
                    point.SetXi(k, x[k][i]);
                }
                double dis = TransForm.GetDistance(points_k_init[j], point);  //求距离，并更新距离矩阵
                distance_matrix_random_init[j][i] = dis;
            }
        }

        for (int i = 0; i < distance_matrix_random_init[0].length; i++) {
            if (!TransForm.Exists(i, random)) {   //如果不是聚类的中心点
                double[] arr = new double[K];  //得到每一行的数据
                for (int j = 0; j < K; j++) {
                    arr[j] = distance_matrix_random_init[j][i];
                }
                for (int j = 0; j < K; j++) {   //如果是最小值，将其index对应的点放入聚类结果列表
                    if (arr[j] == TransForm.GetMin(arr)) {
                        Point point = new Point();
                        for (int k = 0; k < dim; k++) {
                            point.SetXi(k, x[k][i]);
                        }
                        points_k_list[j].points.add(point);
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < K; i++) {
            System.out.print(points_k_list[i].points.size() + " ");
        }
        System.out.println();

        ArrayList<Point[]> center = new ArrayList<>();   //存放每次执行的聚类中心
        center.add(points_k_init);  //加入随机生成的中心

        int t = 0;
        while (t < 20) {    //循环20次进行聚类
            Point[] points_k_center = new Point[K];    //存放聚类的中心点
            for (int i = 0; i < K; i++) {
                points_k_center[i] = new Point();    //重新生成聚类的质心
                double[] sum = new double[dim];  //求和，用来后面求质心
                for (int k = 0; k < dim; k++) {  //求每个维度坐标之和，并将其补充到质心点当中去
                    for (int j = 0; j < points_k_list[i].points.size(); j++) {
                        sum[k] += points_k_list[i].points.get(j).GetXi(k);
                    }
                    points_k_center[i].SetXi(k, sum[k] / points_k_list[i].points.size());  //设置质心的值
                }
                //System.out.println(points_k_center[i].GetXi(0));
            }

            Double[][] distance_matrix = new Double[K][num];  //新的距离矩阵
            for (int i = 0; i < K; i++) {
                for (int j = 0; j < num; j++) {
                    distance_matrix[i][j] = 0.0;
                }

            }
            for (int j = 0; j < K; j++) {
                for (int i = 0; i < num; i++) {
                    Point point = new Point();
                    for (int k = 0; k < dim; k++) {   //将多个纬度的值的转换为Point
                        point.SetXi(k, x[k][i]);
                    }
                    double dis = TransForm.GetDistance(points_k_center[j], point);  //求距离，并更新距离矩阵
                    distance_matrix[j][i] = dis;
                }
            }
            center.add(points_k_center);

            for (int i = 0; i < K; i++) {   //清空上一次循环生成的列表，并重新初始化为空
                points_k_list[i] = null;
                points_k_list[i] = new PointList();
            }

            for (int i = 0; i < distance_matrix_random_init[0].length; i++) {
                double[] arr = new double[K];  //保存每一行的数据，用于后面对行内求最小值
                for (int j = 0; j < K; j++) {   //得到每一行的数据
                    arr[j] = distance_matrix[j][i];
                }
                for (int j = 0; j < K; j++) {   //如果是最小值，将其index对应的点放入聚类结果列表
                    if (arr[j] == TransForm.GetMin(arr)) {  //判断对应的距离是否为最小值，如果是最小值，将其放入对应的类别的列表当中
                        Point point = new Point();
                        for (int k = 0; k < dim; k++) {
                            point.SetXi(k, x[k][i]);
                        }

                        points_k_list[j].points.add(point);
                        break;
                    }
                }
            }
            for (int i = 0; i < K; i++) {   //遍历每一个类别，打印类别的size
                System.out.print(points_k_list[i].points.size() + " ");
            }
            System.out.println();
            t += 1;
        }

        //得到到各个类的最远的点到类中心的距离，用于后面导出
        Point[] points_max_to_center = TransForm.GetMaxDistancePoints(K,points_k_list,center);
        ArrayList<Point[]> lastCenter = new ArrayList<>();
        lastCenter.add(center.get(20));   //将最后的中心点添加入列表，用于后面导出
        ArrayList<Point[]> maxDistance = new ArrayList<>();
        maxDistance.add(points_max_to_center);   //将距离最远的点放入列表，用于后面导出

        FileOperate.ExportFile("data_center.csv", center, dim);  //导出类中心的变化过程（每7行为1次）
        FileOperate.ExportFile("data_lastCenter.csv", lastCenter, dim);  //导出最后聚类出来的中心
        FileOperate.ExportFile("data_maxDistance.csv", maxDistance, dim);  //导出距离类中心最远的点
        FileOperate.ExportTagFile("data_tag.csv",K,dim,points_k_list);   //导出打标签后的文件，用于实验4


    }
}
