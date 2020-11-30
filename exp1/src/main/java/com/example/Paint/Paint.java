package com.example.Paint;

import com.example.entity.Student;
import com.example.util.dataProcessing;

import java.awt.*;
import java.util.ArrayList;

public class Paint extends Panel {
    public void paint(Graphics graphics){
        int width = 400;
        int height = 400;
        graphics.setColor(Color.BLUE);
        //graphics.fillRect(0,0,width,height);
        graphics.setColor(Color.RED);
        graphics.drawRect(0,0,width,height);
        graphics.setColor(Color.black);

        String filePath_csv = "src/main/java/com/example/Data/data.csv";
        String filePath_txt = "src/main/java/com/example/Data/data.txt";

        //传入文件路径，直接读取合并后的文件
        ArrayList<Student> list_students = dataProcessing.MergeCsvAndTxt(filePath_csv,filePath_txt);

        for(int i = 0;i<list_students.size();i++){
            int x = (int) list_students.get(i).getC1();
            int y = new Double(dataProcessing.TransformConstitution(list_students.get(i).getConstitution())).intValue();
            x *= 4;
            y *= 4;
            graphics.drawOval(x,y,1,1);
        }
    }
}
