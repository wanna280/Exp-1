import numpy as np

def GetAverage(x):         #求均值
    sum = 0
    for i in x:   #对数组中的元素进行求和
        sum += i
    return sum/len(x)  #return 和除以长度（均值）

def GetCovariance(x):      #求方差
    x1 = GetAverage(x)  #求出平均值，保存到x中
    sum = 0
    for i in x:
        sum += (i-x1)**2  #sum =(x-x1)*(x-x1)
    return sum/(len(x) - 1)   #return cov

def GetZScore(x):         #ZScore化
    avg = GetAverage(x)  #cov
    s = np.sqrt(GetCovariance(x))   #s
    y = []
    for i in range(len(x)):
        if s != 0:
            x[i] = (x[i]-avg)/s
    return x   #return x by format

def GetCorrelation(x,y):    #求相关系数
    A = GetZScore(x)   #get x format by zscore  
    B = GetZScore(y)   #get x format by zscore  
    sum = 0
    for i in range(len(x)):     # x,y长度一样
        sum += A[i] * B[i]
    return sum   #return corr

def GetZscoreArray(x):   #求Zscore数组
    Matrix = []
    for i in x:
        Matrix.append(GetZScore(i))
    return Matrix

def GetMax(x):        #获取列表中最大的数
    max = x[0]
    for i in range(len(x)):   #遍历x列表，求出最大值max
        if max < x[i]:   #如果数组中找到比它更大的数，用数组中对应的元素赋值给max
            max = x[i]
    return max  #return max

def GetNumberOfMax(num,x):   #获取列表最大的几个数
    max_of_number =[]    #初始化最大数组为空列表
    for i in range(num):   #根据给定的num进行循环
        max = GetMax(x)   #获取列表的最大值
        max_of_number.append(max)  #向max_of_number中添加当前列表中最大的值
        x.remove(max)   #列表中移除掉最大值
    return max_of_number   #return max of number