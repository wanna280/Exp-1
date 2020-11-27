# Exp-1
机器学习实验1存放路径为/Exp-1/exp1 <br />
机器学习实验2存放路径为/Exp-1/exp2 <br />
机器学习实验3存放路径为/Exp-1/exp3 <br />
机器学习实验4存放路径为/Exp-1/exp4 <br />
机器学习实验5存放路径为/Exp-1/exp5 <br />


每个项目的具体路径为 <br />
/Exp-1/expx/src/main/java/com/example/路径下(expx代表exp1,exp2,exp3,exp4,exp5) <br />


项目结构说明：<br />
Run目录：<br />
在Run目录下存放的类为项目中每道题目的源代码，如题目1为Run1，在demo/DemoApplication下通过调用对应的静态方法就可以实现运行每道题目。 <br />
entity目录： <br />
entity目录存放项目对应的实体类，如实验1中的学生实体。 <br />
util目录： <br />
util目录下存放项目对应的工具，如实验1中的计算均值、方差等的工具。<br />
Data目录： <br />
Data目录存放项目用到的数据文件，如实验1中的学生成绩表。 <br />


实验1： <br />
util/ReadFile.java---实现对数据文件的读取，直接读出来并且用ArrayList接收并return <br />
util/dataPeocessing.java---实现GetAverage、GetCovariance、GetZScore、GetCorrelation等计算工具 <br />
Run/Run1.java---实现实验1题目1的运行结果 <br />
Run/Run2.java---实现实验1题目2的运行结果 <br />
Run/Run3.java---实现实验1题目3的运行结果 <br />
Run/Run4.java---实现实验1题目4的运行结果 <br />
Run/Runx.java---杂项文件 <br />
entity/Student.java---定义学生实体类 <br />
demo/DemoApplication---项目的入口主程序，调用Runx.Runx()方法来运行(x=1,2,3,4,5) <br />
Data/*---项目的数据文件 <br />
