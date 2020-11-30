import numpy as np

def GetAverage(x):         #求均值
    sum = 0
    for i in x:
        sum += i
    return sum/len(x)

def GetCovariance(x):      #求方差
    x1 = GetAverage(x)
    sum = 0
    for i in x:
        sum += (i-x1)**2
    return sum/(len(x) - 1)

def GetZScore(x):         #ZScore化
    avg = GetAverage(x)
    s = np.sqrt(GetCovariance(x))
    y = []
    for i in range(len(x)):
        if s != 0:
            x[i] = (x[i]-avg)/s
    return x

def GetCorrelation(x,y):    #求相关系数
    A = GetZScore(x)
    B = GetZScore(y)
    sum = 0
    for i in range(len(x)):     # x,y长度一样
        sum += A[i] * B[i]
    return sum

def GetZscoreArray(x):
    Matrix = []
    for i in x:
        Matrix.append(GetZScore(i))
    return Matrix