## Exp-1

### 关于分工:
1.组长：贾剑超，编写实验1的主要部分的代码，编写实验3的主要代码，编写实验2的部分代码<br />
2.组员：彭承超，编写实验1和实验3的部分代码，编写实验2的主要代码 <br />


### 说明
实验1和实验3都是主要采用Java语言编写，使用一个Demo的SpringBoot项目进行编写。 <br />
实验2，由于主要涉及到的都是画图这类的，使用python进行画图等会比较方便，因此主要采用python语言 <br />
机器学习实验1存放路径为/Exp-1/exp1 <br />
机器学习实验2存放路径为/Exp-1/exp1/python/ <br />
机器学习实验3存放路径为/Exp-1/exp3 <br />
机器学习实验4存放路径为/Exp-1/exp4 <br />
机器学习实验5存放路径为/Exp-1/exp5 <br />
项目的运行结果(打印部分）等将会放在文件夹Result内，文件的部分会在具体的实验当中进行说明。<br />


## 实验1
### 项目结构说明：
/Exp-1/exp1/dataf.csv存放实验1FillNa(0)后输出的文件，用于实验2的数据导入
/Exp-1/exp1/datafy.csv存放实验1DropNa后输出的文件，暂存
项目存放的根路径为/Exp-1/exp1/src/main/java/com/example/
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
---实现实验1题目1的运行结果 <br />
#### Run/Run2.java
---实现实验1题目2的运行结果 <br />
#### Run/Run3.java
---实现实验1题目3的运行结果 <br />
#### Run/Run4.java
---实现实验1题目4的运行结果 <br />
#### Run/Runx.java
---杂项文件 <br />
#### entity/Student.java
---定义学生实体类 <br />
#### DemoApplication
---项目的入口主程序，调用Runx.Runx()方法来运行(x=1,2,3,4) <br />
#### Data/*
---项目的数据文件 <br />


## 实验2： 
#### python/dataProcessing.py
---实现一些数据处理的方法，如GetAverage、GetCovariance、GetZScore、GetCorrelation等。  <br />
#### python/Run.py
---用来运行程序，根据注释可以运行对应题目的程序。  <br />
#### python/data_id.txt
---用来保存实验2第五题的实验数据导出结果




## 实验3
项目存放的根路径为/Exp-1/exp3/src/main/java/com/example/
/Exp-1/exp3/data.csv文件存放实现中的二维数据
/Exp-1/exp3/dataf.csv文件存放需要用到的十一位数据（从1题中导出）
### demo/utils -- 存放一些项目中用到的一些工具类
#### FileOpeate类主要实现将文件读取为数组
提供两个构造方法 <br />
1.ReadFileAsArray，用于读取2维的数据，通过传入一个txt/csv文件路径，和两个Double类型的数组x,y，将读取到的txt文件的内容直接放到x，y数组当中。<br />
2.ReadFileAsArray1，用于读取小于20维的数据，通过传入一个txt文件的路径和一个二维的Double数组x，以及dim（需要读取的数据的纬度），直接将最终结果存储到x数组当中。<br />

#### GetRandom类主要实现一个static方法，用于获取K个不同的随机整数，传入参数K就可以返回Integer类型的数组
#### TransForm类主要存放一些项目中需要进行计算的方法
1.GetAverage方法用于实现求平均值 <br />
2.GetCovariance方法用于实现求方法 <br />
3.GetZScore方法用于将一个一维的数组进行Zscore标准化，可以遍历的方式求出多维数组的Zscore化<br />
4.GetDistance方法用于实现求两个N纬度的点之间的欧式距离，点是指会在下面介绍的Point对象。 <br />
5.Exists方法用于判断一个元素x是否在一个数组array当中，传入的参数即是x和array <br />
6.GetMin方法用于去求一个数组当中的最小值，用于后面KMeans中判断距离的远近 <br />

### demo/point 存放项目中用到的点和点向量
#### Point类用于定义点
1.Point的属性有点的length（维度）和点的各个维度的值数组x（20维之内） <br />
2.实现方法GetLength，获取当前点的维度（20） <br />
3.实现方法GetX，获取当前点的各个维度坐标，返回的是一个Double型的数组 <br />
4.实现方法SetX，设置当前点的所有维度的坐标，直接传入一个Double类型的数组类型的参数即可 <br />
5.实现方法SexXi，设置当前点的某个维度的值，传入参数为i和x，设置第i维度的值为x <br />
6.实现方法GetXi，获取当前点的某个维度的值，传入参数为i，返回第i维的值 <br />
#### PointList用于定义点向量
单纯存放一个点向量，方便定义使用，用于存放每一类的点的对象/聚类的中心点的点对象。

### demo/kmeans
#### KMeans类主要实现KMean算法
1.实现方法KMeans传入K值，以及两个维度的数据x和y，将点(x,y)分成K类 <br />
2.实现方法KMeans1传入K值、数据（dim*num）、dim（维度）、num（点的个数），将这些点(x1,x2,...xn)分成K类 <br />


### demo/DemoApplication
项目的主程序--通过调用实现的方法读取文件，以及执行KMeans算法。 <br />
