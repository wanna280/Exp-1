import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

data = pd.read_csv("./data_tag.csv",header=None)   #读取表格，并设置header=None
data.columns = ["X1","X2","label"]  #设置列名
#print(data.shape)   #形状

data_1 = np.ones([20,1])
#print(data_1.shape)
data = np.column_stack([data_1,data])   #横向堆叠
#print(data.shape)

data_x = data[:,0:3]  #切片，取出前三列数据
#print(data_x.shape)

data_y = data[:,3]   #切片，取出最后一列数据（标签）
data_y = data_y.reshape([20,1])

#print(data_y.shape)

theta = np.zeros((3,1))  #初始化为3*1的数据
#print(theta.shape)

#sigmoid函数
def sigmoid(x):  #sigmoid函数，y=1 / (e^(-x) + 1)
    return 1 / ( np.exp( (-1) *x ) + 1)

#预测
def model(X, theta):
    return sigmoid(np.dot(X, theta))  #X是20*3，theta得是3*1才能得到20*1，所以不用转置

# 损失函数
def cost(X, theta, y):
    #损失函数的最大似然函数
    loss = -y * np.log(model(X, theta)) - (1 - y) * np.log(1 - model(X, theta))
    return np.sum(loss) / (len(X))  # 求平均损失
#梯度下降
def gradient(X, theta, y):
    leny = len(y)  #leny保存y的数据的行数
    y_pred = sigmoid(np.dot(X,theta))
    #print(y_pred.shape)  #(20,1)
    grad = (1 / leny) * (np.dot(X.T,y_pred - y))
    return grad

#梯度下降
def gradient(X, theta, y):
    leny = len(y)  #leny保存y的数据的行数
    y_pred = sigmoid(np.dot(X,theta))
    #print(y_pred.shape)  #(20,1)
    grad = (1 / leny) * (np.dot(X.T,y_pred - y))
    return grad

grad = gradient(data_x,theta,data_y)   #梯度下降，得到梯度
#print(grad.shape)

_cost = list()
def LR(data_x,data_y,theta,lr=0.1):   #逻辑回归
    for i in range(10000):
        theta -= lr * gradient(data_x,theta,data_y)
        _cost.append(cost(data_x,theta,data_y))

LR(data_x,data_y,theta=theta,lr=0.1)
#print(theta)

#print(len(_cost))

predt = model(data_x,theta)  #预测
predt_1 = [i for i in predt if i>0.5]  #＞0.5的在1类
predt_0 = [i for i in predt if i<=0.5] #<0.5的在0类
print("1类中的点的个数为{0}".format(len(predt_1)))   #打印1类的点的个数
print("0类中的点的个数为{0}".format(len(predt_0)))   #打印0类的点的个数

dt_x = np.array([1,2,6])  #预测(2，6)这个点的np数组
#print(dt_x)

prediction = model(dt_x,theta)   #预测
print("点(2,6)的模型预测值为：{0}".format(prediction[0]))    #prediction >0.5在1类，<0.5在0类
if prediction>0.5:
    print("点(2,6)的模型在类别1中")
else:
    print("点(2,6)的模型在类别0中")

plt.plot(_cost)  #画图
plt.xlabel("epochs")
plt.ylabel("cost")
plt.show()
    