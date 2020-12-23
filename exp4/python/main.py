import matplotlib.pyplot as plt 
import numpy as np

def sigmoid(x):
    return 1 / (1 + np.exp( - x ))

x = np.linspace(-10,10,1000)   #从-10到10生成1000个随机数  
y = sigmoid(x)


plt.plot(x,y)  #画图
plt.show()  #显示