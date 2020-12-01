# Exp-1

### 说明
机器学习实验1存放路径为/Exp-1/exp1 <br />
机器学习实验2存放路径为/Exp-1/exp1/python/ <br />
机器学习实验3存放路径为/Exp-1/exp3 <br />
机器学习实验4存放路径为/Exp-1/exp4 <br />
机器学习实验5存放路径为/Exp-1/exp5 <br />

/Exp-1/dataf.csv存放实验1FillNa(0)后输出的文件，用于实验2的数据导入
/Exp-1/datafy.csv存放实验1DropNa后输出的文件，暂存



## 项目结构说明：
### Run目录：
在Run目录下存放的类为项目中每道题目的源代码，如题目1为Run1，在demo/DemoApplication下通过调用对应的静态方法就可以实现运行每道题目。 <br />
### entity目录：
entity目录存放项目对应的实体类，如实验1中的学生实体。 <br />
### util目录： 
util目录下存放项目对应的工具，如实验1中的计算均值、方差等的工具。<br />
### Data目录： 
Data目录存放项目用到的数据文件，如实验1中的学生成绩表。 <br />


## 实验1： 
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
#### demo/DemoApplication
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
