import matplotlib.pyplot as plt 
import numpy as np
import pandas as pd 

data = pd.read_csv("../data.csv",names=["x","y"])  #Read File

print(data)

plt.scatter(data["x"],data["y"])
plt.show()