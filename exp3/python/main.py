import matplotlib.pyplot as plt 
import numpy as np
import pandas as pd 

data = pd.read_csv("../data.csv",names=["x","y"])  #Read File
data_center = pd.read_csv("../data_lastCenter.csv",names=["x","y"])  #Read Center File
data_maxDistance = pd.read_csv("../data_maxDistance.csv",names=["x","y"]) #Read MaxDis File

K = len(list(data_center["x"]))  #通过文件读取的内容判断出K类

#print(data)

x1 = []
x1.append(data_center["x"])
x1.append(data_maxDistance["x"])

y1 = []
y1.append(data_center["y"])
y1.append(data_maxDistance["y"])

#可视化出出类半径
plt.plot(x1,y1)

plt.scatter(data["x"],data["y"],c="yellow")
plt.scatter(data_center["x"],data_center["y"],marker="x",c="red")
plt.scatter(data_maxDistance["x"],data_maxDistance["y"],marker="+",c="black")
plt.savefig("./img1/{0}.png".format(K))
plt.show()


