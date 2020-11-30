import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import dataProcessing as dp     #导入自己实现的数据处理模块

data = pd.read_csv("../dataf.csv")
data_C1 = data.loc[:,["C1"]].values
data_C1 = data_C1.reshape(len(data_C1))

data_C2 = data.loc[:,["C2"]].values
data_C2 = data_C2.reshape(len(data_C2))

data_C3 = data.loc[:,["C3"]].values
data_C3 = data_C3.reshape(len(data_C3))

data_C4 = data.loc[:,["C4"]].values
data_C4 = data_C4.reshape(len(data_C4))

data_C5 = data.loc[:,["C5"]].values
data_C5 = data_C5.reshape(len(data_C5))

data_C6 = data.loc[:,["C6"]].values
data_C6 = data_C6.reshape(len(data_C6))

data_C7 = data.loc[:,["C7"]].values
data_C7 = data_C7.reshape(len(data_C7))

data_C8 = data.loc[:,["C8"]].values
data_C8 = data_C8.reshape(len(data_C8))

data_C9 = data.loc[:,["C9"]].values
data_C9 = data_C9.reshape(len(data_C9))

data_C10 = data.loc[:,["C10"]].values
data_C10 = data_C10.reshape(len(data_C10))

data_Constitution = data.loc[:,["Constitution"]].values
data_Constitution = data_Constitution.reshape(len(data_Constitution))

Data_Arr = [data_C1,data_C2,data_C3,data_C4,data_C5,data_C6,
    data_C7,data_C8,data_C9,data_C10,data_Constitution]

# 1.以C1为横坐标，Constitution为纵坐标画散点图
# plt.scatter(data_C1,data_Constitution)
# plt.xlabel("C1")
# plt.ylabel("Constitution")
# plt.show()

# 2.以5分为间隔，画出课程1的成绩直方图
# plt.title("C1直方图")
# plt.hist(data_C1,20)
# plt.xlabel("C1")
# plt.ylabel("Nums")
# plt.xticks([0,5,15,20,25,30,35,40,45,50,55,60,65,70,75,80,85,90,95,100])
# plt.show()


# 3.对每门成绩进行z-score归一化，得到归一化的数据矩阵

Arr = dp.GetZscoreArray(Data_Arr)
print(Arr)
    
