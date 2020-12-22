import matplotlib.pyplot as plt 
import numpy as np
import MyUtil as ut


x = np.linspace(-10,10,1000)   #从-10到10生成1000个随机数  
y = ut.sigmod(x)


plt.plot(x,y)  #画图
plt.show()  #显示