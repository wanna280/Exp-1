import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import dataProcessing as dp     

data = pd.read_csv("../dataf.csv",usecols=['C1','C2','C3','C4','C5','C6','C7','C8','C9','C10','Constitution'])
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
# plt.scatter(data_C1,data_Constitution)   #画散点图
# plt.xlabel("C1")   #给x标标签C1
# plt.ylabel("Constitution")  #给y贴标签Constitution
# plt.show()   #显示

# 2.以5分为间隔，画出课程1的成绩直方图
# plt.title("C1")  #标题为C1
# plt.hist(data_C1,20)   #画直方图，并且刻度为5
# plt.xlabel("C1")      #给x贴标签C1
# plt.ylabel("Nums")    #给y贴标签Nums
# plt.xticks([0,5,15,20,25,30,35,40,45,50,55,60,65,70,75,80,85,90,95,100])
# plt.show()   #显示


# 3.对每门成绩进行z-score归一化，得到归一化的数据矩阵
# Arr_Zscore = dp.GetZscoreArray(Data_Arr)   #Zscore化，得到的是数组，每一个元素代表一列数据，Arr_Zscore[0]代表第一列Zscore化后的数据
# matrix = np.matrix(Arr_Zscore).T   #np.matrix得到横向的矩阵，matrix.T得到转置
# print(matrix)         #打印矩阵
# print(Arr_Zscore)


# # 4.求出相关矩阵
_data=pd.read_csv("../dataf.csv",usecols=['C1','C2','C3','C4','C5','C6','C7','C8','C9','C10','Constitution'])
data_rowArray=np.array(_data)   #得到每一行的数据，data[0]为第一行的数据，data[1]为第二行的数据，以此类推
corr_Mat=[]   #初始化一个一个数组存放矩阵
for i in data_rowArray:    # 遍历每一行数据
    res = []
    for j in data_rowArray:
        res.append(dp.GetCorrelation(i,j))  #求出第i行与第j行的相关系数
    corr_Mat.append(res)  #附加
Corr_Matrix = np.matrix(corr_Mat)   #根据corr_Mat转换成矩阵
print(Corr_Matrix)   #打印出来矩阵

# # 5.根据相关矩阵，找到距离每个样本最近的三个样本，得到100x3的矩阵
data_rowArray=np.array(_data)  #
f=open('data_id1.txt','w')     #创建文件data_id.txt的文件指针
for row in corr_Mat:          #遍历corr_Mat相关矩阵的每一行
    print(dp.GetNumberOfMax(4,row))      #打印最大的四个数的列表
    max_list=map(row.index,dp.GetNumberOfMax(4,row))   #用自己实现的函数，求出最大的4个数
    max_list=list(max_list)   #转换为列表
    res = []   #存放需要写入文件的内容
    for i in max_list[1:]:   #遍历最大数的列表（排除掉它本身）
        res.append(data_rowArray[int(i)][0])   #向res中附加data_rowArray[i][0]的内容
    res=[str(i) for i in res]     #列表推导式，将内容转换为字符串并存放在数组当中
    f.write(res[0]+'\t'+res[1]+'\t'+res[2]+'\n')     #将结果写到data_id.txt中
f.close()    #关闭文件指针

