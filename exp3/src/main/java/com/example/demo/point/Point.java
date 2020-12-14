package com.example.demo.point;

public class Point {   //存放20纬的数据的点
    private int length;
    private double[] x = new double[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

    public Point() {
    }

    public Point(double x,double y){
        this.x[0] = x;
        this.x[1] = y;
    }
    public double[] GetX(){
        return this.x;
    }
    public Integer GetLength(){
        return this.x.length;
    }
    public void SetX (double[] array){
        this.x = array;
    }

    public void SetXi(int i,double x){
        this.x[i] = x;
    }

    public double GetXi(int i){
        return this.x[i];
    }
}
