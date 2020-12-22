import numpy as np

# Sigmod函数
def sigmod(x):  #sigmod函数，y=1 / (e^(-x) + 1)
    return 1/(np.exp((-1)*x)+1)

# 预测函数h；np.dot(X, theta.T)两个矩阵相乘
def model(X, theta):
    return sigmoid(np.dot(X, theta.T))

# 损失函数
def cost(X, y, theta):
    left = np.multiply(-y, np.log(model(X, theta)))
    right = np.multiply(1 - y, np.log(1 - model(X, theta)))
    return np.sum(left - right) / (len(X))  # 求平均损失

# 计算梯度，求偏导
def gradient(X, y, theta):
    grad = np.zeros(theta.shape)
    error = (model(X, theta)- y).ravel()
    for j in range(len(theta.ravel())): #for each parmeter
        term = np.multiply(error, X[:,j])
        grad[0, j] = np.sum(term) / len(X)
    return grad

