package com.example.demo.utils;

import java.util.Random;

public class GetRandom {
    public static Integer[] GetRandom(int K){   //获取K个不同的随机数
        Integer[] random = new Integer[K];//初始化数组
        for (int i = 0; i < K; i++) {
            random[i] = 0;
        }
        Random random1 = new Random();
        int count = 0;//记录有效的随机数个数
        while(count < random.length){
            boolean flag = true;//用来标志的变量
            int r = random1.nextInt(10);
            for(int i=0;i<random.length;i++){
                if(r == random[i]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                random[count] = r;
                //System.out.println(r);
                count++;
            }
        }
        return random;
    }
}
