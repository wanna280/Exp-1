## Exp-1

### 关于分工:
1.组长，贾剑超，编写实验1、实验3Java代码的主要实现，实验4的Java代码实现/Python代码实现，以及其余部分Python代码的编写。 <br />
2.组员：彭承超，编写实验1和实验3的Python部分代码，编写实验2的Python项目中的主要代码。<br />

### 说明
整个项目都以Java语言为主，使用的项目模板为SpringBoot的Demo项目进行修改，使用IDEA编写。其余辅助部分，使用Python进行实现和完善。 <br />
实验1，主要采用Java语言编写，对数据进行清洗、以及数据的导入/导出等操作都进行了模块化。 <br />
实验2，由于主要涉及到的都是画图这类的，使用Python进行画图等会比较方便，因此主要采用Python语言 <br />
实验3，算法的实现部分使用Java实现，可视化散点图、类中心类半径是java导出数据并且使用Python进行绘制的。 <br />
实验4，逻辑回归和梯度下降使用Java和Python语言分别实现，并进行可视化和运行，并写了对应的notebook和.py文件和java项目 <br />
机器学习实验1存放路径为/Exp-1/exp1/ <br />
机器学习实验2存放路径为/Exp-1/exp1/python/ <br />
机器学习实验3存放路径为/Exp-1/exp3/ <br />
机器学习实验4存放路径为/Exp-1/exp4/ <br />

每个项目的运行结果(打印部分）等将会放在/Exp-1/Result文件夹内，产生的数据文件的部分会在具体的实验当中进行说明。通过Result/result.md可以查看整个项目各个步骤的运行结果截图，img文件夹下存放的是对应的图片，以便在result.md文件中引入和查看<br />


## 实验1
### 项目结构说明：
/Exp-1/exp1/dataf.csv存放实验1FillNa(0)后输出的文件，用于实验2的数据导入 <br />
/Exp-1/exp1/datafy.csv存放实验1DropNa后输出的文件，暂存下来，也许用不到  <br />
项目存放的根路径为/Exp-1/exp1/src/main/java/com/example/  <br />
#### Run目录：
在Run目录下存放的类为项目中每道题目的源代码，如题目1为Run1，在demo/DemoApplication下通过调用对应的静态方法就可以实现运行每道题目。 <br />
#### entity目录：
entity目录存放项目对应的实体类，如实验1中的学生实体。 <br />
#### util目录： 
util目录下存放项目对应的工具，如实验1中的计算均值、方差等的工具。<br />
#### Data目录： 
Data目录存放项目用到的数据文件，如实验1中的学生成绩表。 <br />

#### util/ReadFile.java
---实现对数据文件的读取，直接读出来并且用ArrayList接收并return <br />
#### util/dataProcessing.java
---实现GetAverage、GetCovariance、GetZScore、GetCorrelation等计算工具以及清洗/格式化数据的方法 <br />
#### util/ExportFile.java
---将清洗之后的数据存为csv文件，提供两个静态方法，一个是按照格式化之后保存(ExportByFormat)，一个是按照不格式化之后保存(Export)
#### Run/Run1.java
---实现实验1题目1的运行结果，通过DemoApplication中调用执行 <br />
#### Run/Run2.java
---实现实验1题目2的运行结果，通过DemoApplication中调用执行 <br />
#### Run/Run3.java
---实现实验1题目3的运行结果，通过DemoApplication中调用执行 <br />
#### Run/Run4.java
---实现实验1题目4的运行结果，通过DemoApplication中调用执行 <br />
#### Run/Runx.java
---杂项文件，无用，用作暂时的代码保存 <br />
#### entity/Student.java
---定义学生实体类，包含了学生的各个属性，并实现了对应的Getter和Setter <br />
#### DemoApplication
---项目的入口主程序，调用Runx.Runx()方法来运行(x=1,2,3,4) <br />
#### Data/*
---项目的数据文件 <br />


## 实验2： 
#### python/dataProcessing.py
---实现一些数据处理的方法，如GetAverage、GetCovariance、GetZScore、GetCorrelation等。  <br />
#### python/Run.py
---用来运行程序，根据注释掉对应的内容可以运行对应题目的程序。  <br />
#### python/data_id.txt
---用来保存实验2第五题的实验数据导出结果  <br />




## 实验3
项目存放的根路径为/Exp-1/exp3/src/main/java/com/example/
/Exp-1/exp3/data.csv文件存放实现中的二维数据
/Exp-1/exp3/dataf.csv文件存放需要用到的十一维数据（从实验1中导出）
### demo/utils -- 存放一些项目中用到的一些工具类
#### FileOpeate类主要实现将文件读取为数组
提供三个构造方法 <br />
1.ReadFileAsArrayn，用于读取小于20维的数据，通过传入一个txt/csv文件的路径和一个二维的Double数组x，以及dim（需要读取的数据的纬度），直接将最终结果存储到x数组当中。<br />
2.ExportFile，用于将得到的中心点相关的数据写入文件，传入ArrayList<Point []>对象和文件路径 <br />
3.ExportTagFile，用于导出带有类标签的文件，主要用于实验4 <br />

#### GetRandom类主要实现一个static方法，用于获取K个不同的随机整数，传入参数K就可以返回Integer类型的数组
#### TransForm类主要存放一些项目中需要进行计算的方法
1.GetAverage方法用于实现求平均值 <br />
2.GetCovariance方法用于实现求方法 <br />
3.GetZScore方法用于将一个一维的数组进行Zscore标准化，可以遍历的方式求出多维数组的Zscore化<br />
4.GetDistance方法用于实现求两个N纬度的点之间的欧式距离，点是指会在下面介绍的Point对象。 <br />
5.Exists方法用于判断一个元素x是否在一个数组array当中，传入的参数即是x和array <br />
6.GetMin方法用于去求一个数组当中的最小值，用于后面KMeans中判断距离的远近 <br />
6.GetMaxDistancePoints方法用于去求各个类的点到类中心的距离最大的点的点列表<br />

### demo/point 存放项目中用到的点和点向量的对象
#### Point类用于定义点
1.Point的属性有点的length（维度）和点的各个维度的值数组x（20维之内） <br />
2.实现方法GetLength，获取当前点的维度（20） <br />
3.实现方法GetX，获取当前点的各个维度坐标，返回的是一个Double型的数组 <br />
4.实现方法SetX，设置当前点的所有维度的坐标，直接传入一个Double类型的数组类型的参数即可 <br />
5.实现方法SexXi，设置当前点的某个维度的值，传入参数为i和x，设置第i维度的值为x <br />
6.实现方法GetXi，获取当前点的某个维度的值，传入参数为i，返回第i维的值 <br />
#### PointList用于定义点向量
单纯存放一个点向量，方便定义使用，用于存放每一类的点的对象。

### demo/kmeans
#### KMeans类主要实现KMean算法
实现方法KMeans传入K值、数据（dim*num）、dim（维度）、num（点的个数），将这些点(x1,x2,...xn)分成K类 <br />

### /Exp-1/exp3/data_center.csv、data_lastCenter.csv、data_maxDistance.csv、data_tag.csv
分别存放数据的类中心变化过程、最终类中心、距离类中心最远的点、打标签后的点集合的x，y值

### /Exp-1/exp3/python
main.py，主要用于可视化类中心，类半径等
主要调用pandas库和matplotlib库进行文件的读取和数据可视化


### demo/DemoApplication.java
项目的主程序--通过调用实现的方法读取文件，以及执行KMeans算法。 <br />

## 实验4
### 使用Python实现：
路径为/Exp-1/exp4/python/  <br />
#### 1.关于解答说明:
第一问画sigmoid图，代码文件在main.py中 <br />
第二、三问实现梯度下降和逻辑回归，并预测（2，6）的分类，运行结果已经放到Result当中 <br />
LR.ipynb文件是二三问的运行过程的notebook，LR.py是notebook对应的.py文件，可以直接运行 <br />
#### 2.关于项目说明：
相关函数说明： <br />
1.sigmoid(x)，用于来求得sigmoid函数，用来求预测函数model和代价函数cost <br />
2.model(X, theta)，给出X和theta，给出y的预测值 <br />
3.cost(X,theta,y)，给出X,theta,y，求出对应的cost <br />
4.gradient(X, theta, y)，用来求出梯度的算法 <br />
5.LR(data_x,data_y,theta,lr=0.1)，根据前面实现的函数，实现梯度下降、逻辑回归 <br />
调用的包： <br />
三件套numpy,pandas,matplotlib <br />

### 使用Java实现
项目路径为/Exp-1/exp4/src/main/java/com/example/
#### LR包
LR/LR.java： <br />
用途：实现梯度下降的方法，包括Sigmod函数、预测函数Model、损失函数Cost、梯度函数Gradient、LR实现梯度下降逻辑回归。<br />
#### util包
##### util/FileOpeate.java: 
用途：实现方法取读取文件，保存到二维数组中 <br />
##### util/Print.java： 
用途：实现函数方便打印一维数组，矩阵等 <br />
##### util/Transform.java 
用途：实现数据之间的转换<br />
下面是主要用到的方法：  <br />
GetColumn_i(Double[][] matrix, int column)方法获取二维数组的一个列，i传入列索引index <br />
VectorMultiply(Double[] vector1, Double[] vector2)方法实现向量积，对应位置相乘，返回也是向量 <br />
Multiply(Double[] vector1, Double[] vector2)方法实现向量的数量级 <br />
Dot(Double[][] matrix1, Double[][] matrix2)实现矩阵的乘法 <br />
T(Double[][] matrix) 方法实现矩阵的转置 <br />
Reshape(Double[][] matrix, int rows, int columns) 方法实现矩阵的重塑<br />
Sub(Double[] vector1, Double[] vector2)方法实现向量的相加 <br />
Add(Double[] vector1, Double[] vector2)实现向量的相加 <br />
Sub(Double[][] matrix1, Double[][] matrix2)方法实现矩阵的相加 <br />
log(Double[] vector)方法求log，返回向量 <br />
Sum(Double[][] matrix) 方法对矩阵的各个元素求和<br />
Double Sum(Double[] vector) 方法实现对向量（数组）的各个元素之和 <br />
TransformMatrixToVector(Double[][] matrix)方法实现将矩阵转换为向量 <br />
TransformVectorToMatrix(Double[] vector)方法实现将向量转换为矩阵 <br />
Double[][] Add_One_Column_AtFirst(Double[][] matrix, Double x)实现将一列数字加入矩阵的第一列 <br />
<br />
Demo/DemoApplication.java，项目的main方法 <br />
