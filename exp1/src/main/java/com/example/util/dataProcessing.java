package com.example.util;

import com.example.entity.Student;

import java.util.ArrayList;

public class dataProcessing {
    public static double GetAverage(ArrayList<Double> grades) {
        double sum = 0;
        for (int i = 0; i < grades.size(); i++) {
            sum += grades.get(i);
        }
        return sum / grades.size();   //return average
    }

    public static double GetCovariance(ArrayList<Double> grades) {
        double avg = dataProcessing.GetAverage(grades);
        double sum = 0;
        for (int i = 0; i < grades.size(); i++) {
            sum += (grades.get(i) - avg) * (grades.get(i) - avg);
        }
        return sum / (grades.size() - 1);   //return cov
    }

    public static ArrayList<Double> GetZScore(ArrayList<Double> grades) {
        double avg = dataProcessing.GetAverage(grades);
        double s = Math.sqrt(dataProcessing.GetCovariance(grades));
        ArrayList<Double> zscore = new ArrayList<>();
        for (int i = 0; i < grades.size(); i++) {
            zscore.add((grades.get(i) - avg) / s);
        }
        return zscore;   //return zscore
    }

    public static Double GetCorrelation(ArrayList<Double> grades1, ArrayList<Double> grades2) {
        ArrayList<Double> A = dataProcessing.GetZScore(grades1);
        ArrayList<Double> B = dataProcessing.GetZScore(grades2);
        double sum = 0;
        for (int i = 0; i < grades1.size(); i++) {
            sum += A.get(i) * B.get(i);
        }
        return sum;    //return Corr
    }

    public static Double TransformConstitution(String constit){   //将体测成绩转换成百分制成绩
            switch (constit){
                case "excellent": return 100.0;
                case "good": return 80.0;
                case "general":return 60.0;
                case "bad":return 40.0;
                default:return 0.0;
            }
    }


}
