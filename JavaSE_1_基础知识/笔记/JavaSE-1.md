## Java语言简介

### 计算机编程语言

（1）语言与计算机语言简介

| 语言与计算机语言 | 简介                                                         |
| ---------------- | ------------------------------------------------------------ |
| 语言             | 人与人之间用于沟通的一种方式，例如中国人与中国人用普通话沟通，而中国人要和外国人交流，要学习英语 |
| 计算机语言       | 人与计算机交流的方式，如果人要与计算机交流，那么就要学习计算机语言  计算机语言有很多种，例如C、C++、Python、Java、Scala等 |

 （2）语言的迭代

| 迭代       | 简介                                    |
| ---------- | --------------------------------------- |
| 第一代语言 | 机器语言，指令以二进制代码形式存在      |
| 第二代语言 | 汇编语言，使用助记符表示一条机器指令    |
| 第三代语言 | 高级语言，C、C++、Python、Java、Scala等 |



### Java体系平台

| 版本                              | 简介                                                         |
| --------------------------------- | ------------------------------------------------------------ |
| JavaSE（Java Standard Edition）   | Java标准版，支持面向桌面级应用（如Windows下的应用程序）的Java平台，  提供了完整的Java核心API，以前叫做J2SE，5.0版本后改名叫做JavaSE |
| JavaEE（Java Enterprise Edition） | Java企业版，是为开发企业环境下的应用程序提供的一套解决方案。  主要针对于Web应用程序开发，也是Java开发相关人员主要的工作方向。  在2018年3月初，Oracle公司将JavaEE移交给开源组织Eclipse基金会管理，因此JavaEE被改名为JakartaEE |
| JavaME（Java Micro Edition）      | Java小型版，对JavaAPI有所精简，加入了针对移动终端的支持，  支持Java程序运行在移动终端（手机、PDA）上的平台，是为开发电子消费产品和嵌入式设备提供的解决方案  以前叫做J2ME，后来更名为JavaME |
| JavaCard                          | 支持一些Java小程序（Applets）运行在小内存设备（如智能卡）上的平台 |

### Java语言特点

| 特点     | 简介                                                         |
| -------- | ------------------------------------------------------------ |
| 面向对象 | 两个基本概念：类、对象   三大特性：封装、继承、多态          |
| 健壮性   | 吸收了C/C++语言的优点，但去掉了其影响程序健壮性的部分（如指针、内存的申请与  释放等）  提供了一个相对安全的内存管理和访问机制 |
| 跨平台性 | 跨平台性：通过Java语言编写的应用程序在不同的系统平台上都可以运行。原理：只要在需要运行 java  应用程序的操作系统上，先安装一个Java虚拟机 (JVM Java Virtual Machine) 即可。  由JVM来负责Java程序在该系统中的运行。 |

### JVM、JRE、JDK简介

| JVM、JDK、JRE                    | 简介                                                         |
| -------------------------------- | ------------------------------------------------------------ |
| JVM（Java Virtual Machine）      | Java虚拟机，是一个虚拟的计算机，具有指令集并使用不同的存储区域。  负责执行指令，管理数据、内存、寄存器，编写的程序是会由这个虚拟机来执行 |
| JRE（Java Runtime  Environment） | Java运行环境，主要负责运行Java程序，包括Java虚拟机JVM和Java程序所需的核心类库等，    如果想要运行一个开发好的Java程序，计算机中只需要安装JRE即可。 |
| JDK（Java Development  Kit）     | Java开发工具包，主要用来开发Java程序，是提供给Java开发人员使用的  其中包含了Java的开发工具，也包括了 JRE，所以安装了JDK，就不用在单独安装JRE了  其中的开发工具：编译工具(javac.exe)  打包工具(jar.exe)等 |

### JVM、JRE、JDK的关系

对于那些只希望运行Java程序的人来说，只需要安装JRE即可，JDK包含了JRE，JRE包含了JVM，安装JDK之后，就不用再特意安装JRE了

```xml
JRE = JVM + JavaSE标准类库
JDK = JRE + 开发工具集
```

### Java的两种核心机制

| 核心机制                            | 简介                                                         |
| ----------------------------------- | ------------------------------------------------------------ |
| Java虚拟机（Java Virtal  Machine）  | JVM是一个虚拟的计算机，具有指令集并使用不同的存储区域。负责执行指令，管理数据、内存、寄存器。    对于不同的平台，有不同的虚拟机，只有某平台提供了对应的Java虚拟机，Java程序才可在此平台运行    Java虚拟机机制屏蔽了底层运行平台的差别，实现了“一次编译，到处运行” |
| 垃圾收集机制（Garbage  Collection） | 在C/C++等语言中，由程序员负责回收无用内存，Java  语言消除了程序员回收无用内存空间的责任  Java  语言提供一种系统级线程跟踪存储空间的分配情况，并在JVM空闲时，检查并释放那些可被释放的存储空间。   垃圾回收在Java程序运行过程中自动进行，程序员无法精确控制和干预。    Java程序还会出现内存泄漏和内存溢出问题吗？Yes! |

## Java基本语法

### 基本规则

（2）注释：是对代码的简要说明，是给程序员看的

```java
// 单行注释：使用双斜杠

/*
多行注释：使用斜杠星斜杠
*/

/**
*文档注释：使用斜杠星星星斜杠
*/
```

扩展说明：文档注释中的内容可以使用javadoc生成单独的帮助文档，这样可以方便一些开发者查阅，在命令提示符中输入下面命令

```java
javadoc –d 目标目录 java文件文件名
```

（3）程序的入口main()方法（格式固定）

```java
public static void main(String[] args) {
    
}
```

（4）输出语句

```java
// 先输出数据，然后换行
System.out.println("Hello World!");
// 只输出数据，不换行
System.out.print("Hello World!");
```

（5）执行语句：每个执行语句都以“;”结束



### HelloWorld入门案例

```java
//public 代表，全局的含义
//采用 class 来定义类的名称
//HelloWorld 是类的名称，注意类的名称区分大小写
public class HelloWorld {
    // static, 表示是静态的
    // void, 表示没有返回值
    // main, 入口方法，方法的参数也不能改变
    public static void main(String[] args) {
         //在控制台里面打印一行信息，信息内容是Hello World!
		System.out.println("Hello World!");
	}
}
```

### 编写注意

（1）在一个源文件中，可以声明多个类class，但是最多声明一个类名为public的类，而且要求声明为public的类的类名必须与源文件名相同

（2）字符集在26个英文字母、0到9的阿拉伯数字和下划线之中。Java中类、字段、方法、变量、常量尽量用字母表达，没有特别的理由不能用任何的其他字符

（3）命名需要有一定的意义，推荐采用问题域中的术语命名，使命名在一定程度上是自描述的

## 其他知识

### 关键字与保留字

（1）关键字与保留字简介

| 关键字和保留字 | 简介                                                         |
| -------------- | ------------------------------------------------------------ |
| 关键字         | 被Java语言赋予了特殊含义，用做专门用途的字符串（单词）  ，关键字中所有字母都为小写 |
| 保留字         | 现有Java版本尚未使用，但以后版本可能会作为关键字使  用。自己命名标识符时要避免使用这些保留字 |

（2）常见关键字

```java
abstract assert boolean break byte case catch char class continue default do double 
else enum extends final finally float for if implements import instanceof int interface 
long native new package private protected public return short static strictfp super 
switch synchronized this throw throws transient try void volatile while
```

（3）保留字

```java
gogo const
```

### 标识符

程序员写代码时自己定义的一些名字，通常情况下会使用英文来进行标识符的命名

### 字面量与常量

（1）字面量

```
字面量是用于表达一个固定值的表示法，通常可以分为字符串字面量、整数字面量、浮点数字面量、布尔字面量、字符字面量和空字面量
例如："a" 'b' 1 2.3 true false null等等
字面量的使用导致了诸如a = b * 10这样的语句出现，其中 a 和 b 是假定的变量，而10是一个字面量。
使用字面量不是一个好的编程习惯，因为字面量会掩盖包含字面的语句的真实意义。
当面对这样的语句时，我们并不清楚10是什么，字面量的使用会使修改程序的工作变得复杂
```

（2）常量

```java
为了解决字面量带来的问题，Java语言允许为不会改变的值，分配一个描述性的名字，这种名字称为常量。
声明常量的语法如下
final 数据类型 常量名称;
```

### 开发工具

| 开发工具                | 举例                                                      |
| ----------------------- | --------------------------------------------------------- |
| 记事本                  | UltraEdit、EditPlus、TextPad、NotePad                     |
| Java集成开发环境（IDE） | JBuilder 、NetBeans 、Eclipse 、MyEclipse、IntelliJ  IDEA |



## Java程序的运行原理

### Java程序的加载与执行

（1）对于Java程序员来说，主要做的事情就是编写以.java结尾的文件，我们称之为源文件（source file），把在源文件里面所编写的代码叫做源代码(source code)。但是这个.java结尾的文件是不能直接运行的，该文件主要是给程序员看的，java虚拟机看不懂，此时需要使用javac命令将其编译，生成以.class结尾的文件

```jav
javac HelloWorld.java
```

（2）通过javac命令编译成功之后，就会生成HelloWorld.class文件，这个class文件叫做字节码文件，这些字节码文件是给jvm看的，要想运行这个字节码文件的话，需要使用java命令

```java
java HelloWorld
```

（3）这个java命令后面的HelloWorld是要跟HelloWorld.class文件一致，然后java虚拟机中的类装载器会从类路径（默认是当前目录）下的电脑硬盘中寻找这个class文件，然后将其加载到java虚拟机的内存中开始运行，java虚拟机再将class文件中的指令进行翻译后发送给操作系统，操作系统再操作硬件，这样就可以在命令提示符中看到打印效果了

### Java程序的编译（编译期）

使用javac命令编译源代码的时期叫做编译期，这个阶段Java的编译器编译对应的java源文件，然后去检查源码里面的语法，如果出现了语法错误会进行提示，这个阶段提示的错误我们称之为编译期错误。如果遇到了编译期错误，是不会生成.class文件的，此时需要我们根据错误提示的信息去分析和解决。

### Java程序的运行（运行期）

使用java命令运行的时期叫做运行期，这个阶段由类装载器寻找class文件并装载到jvm里面开始运行，这个时期如果出现了错误，我们称之为运行期错误，运行期错误也会出现一些提示信息，我们需要根据这些提示信息去定位并解决问题。

### Java程序的执行过程

（1）经过javac命令将java源文件编译生成相应的class文件

（2）使用java命令之后会由jvm中的类装载器将class文件装载到内存中

（3）jvm中的执行引擎负责读取class文件中的指令

（4）执行引擎将指令发送给OS（operating system，操作系统）

（5）操作系统再去调用相应的device（设备，例如打印机）

## Java变量

### 变量简介

（1）变量是内存中的一个存储区域，该区域的数据可以在同一类型范围内不断变化

（2）变量是程序中最基本的存储单元，包含变量类型、变量名和存储的值

（3）变量的作用域是定义所在的一对{ }内，只有在其作用域内才有效，同一个作用域内，不能定义重名的变量

### 变量的声明和赋值

（1）Java中每个变量必须先声明，后使用

| 变量的使用 | 简介                  | 例子         |
| ---------- | --------------------- | ------------ |
| 声明       | 数据类型 变量名称;    | int num;     |
| 赋值       | 变量名称=值;          | num=10;      |
| 声明和赋值 | 数据类型 变量名称=值; | int  num=10; |

（2）使用案例

```java
public class Demo {
    public static void main(String[] args) {
        byte a = 1;
        short b = 2;
        int c = 3;
        long d = 4;
        float e = 5.5f;
        double f = 6.5;
        char g1 = '\t';//换行符
        char g2 = '\u0043';//制表符
        boolean h1 = true;
        boolean h2 = false;
    }
}
```

（4）成员变量和局部变量

| 分类     | 简介                                       |
| -------- | ------------------------------------------ |
| 成员变量 | 在方法体外，类体内声明的变量称为成员变量。 |
| 局部变量 | 在方法体内部声明的变量称为局部变量。       |

## Java数据类型

### 基本数据类型

注意：String类型不属于基本数据类型，它是jdk中封装好的一个类，数据转换时需要调用String类中相应的方法

| 数据类型 | 简介                   |
| -------- | ---------------------- |
| 整型     | byte、short、int、long |
| 浮点型   | float、double          |
| 字符型   | char                   |
| 布尔型   | boolean                |

#### 整型

| 类型            | 占用存储空间（字节） | 范围            | 默认值 | 封装器类 | 概括                                                         |
| --------------- | -------------------- | --------------- | ------ | -------- | ------------------------------------------------------------ |
| byte（字节）    | 1                    | -2^7 ~ 2^7-1    | 0      | Byte     | 计算机中基本存储单元。                                       |
| short（短整型） | 2                    | -2^15 ~2^15 -1  | 0      | Shore    | 短整型数据类型                                               |
| int（整型）     | 4                    | -2^31 ~ 2^31 -1 | 0      | Integer  | 整型常量默认为 int  型，变量通常声明为int型                  |
| long（长整型）  | 8                    | -2^63 ~ 2^63 -1 | 0.0l   | Long     | 声明long型常量须后加‘l’或‘L’  除非不足以表示较大的数，才使用long |

#### 浮点型

| 类 型                  | 占用存储空间（字节） | 范围                    | 默认值 | 概括                                                         |
| ---------------------- | -------------------- | ----------------------- | ------ | ------------------------------------------------------------ |
| float（单精度浮点型）  | 4                    | -3.403E38 ~ 3.403E38    | 0.0f   | 单精度，尾数可以精确到7位有效数字。  很多情况下，精度很难满足需求。 |
| double（双精度浮点型） | 8                    | -1.798E308 ~  1.798E308 | 0      | 双精度，精度是float的两倍。  浮点型常量默认为double型，  声明float型常量，须后加‘f’或‘F’ |

#### 字符类型

| 类 型          | 占用存储空间（字节）                     | 默认值 | 概括                                                         |
| -------------- | ---------------------------------------- | ------ | ------------------------------------------------------------ |
| char（字符型） | gbk / gb2312 是两个字节，utf-8 是3个字节 | \u0000 | Java中的所有字符都使用Unicode编码，  故一个字符可以存储一个字母，一个汉字，  或其他书面语的一个字符 ，char类型是可以进行运算的，因为它都对应有Unicode码 |

#### 布尔类型

| 类 型             | 概括                                                         |
| ----------------- | ------------------------------------------------------------ |
| boolean（布尔型） | boolean  类型用来判断逻辑条件，一般用于程序流程控制  boolean类型数据只允许取值true和false，无null |

### 基本数据类型转换

在Java中，boolean 类型与其他七种类型的数据都不能进行转换，其他数据类型之间可以进行转换，只是可能会存在精度损失或其他一些变化

#### 自动转换（隐式）

（1）数据范围小的数值赋值给另一个数据范围大的变量，这种转换方式是自动的，不会造成信息丢失， 也可以叫作隐式转换

（2）自动转换按从低到高的顺序转换。不同类型数据间的优先关系如下

```java
byte -> int -> long -> float -> double
shart -> int -> long -> float -> double
char -> int -> long -> float -> double
```

（3）对于需要转换的数据类型，必须是转换前的数据类型兼容转换后的数据类型。

（4）对于转换后的数据类型的范围，必须比转换前的数据类型范围大。

（5）自动转换案例

```java
public class Demo {
    public static void main(String[] args){
        byte A = 2;
        int B = 129;
        // byte C = A + B; // 编译不通过
        int C = A + B;
        System.out.println(C); // 131
    }
}
```

（6）自动转换面试题案例

```java
// 隐式类型转换 Java 面试题，求控制台打印
// 能够输出的结果：11111、22222、44444
// 实际结果：11111
public class Test {
    public static void main(String[] args) {
        byte b = 10;
        test(b); // 11111
    }

    private static void test(byte b) {
        System.out.println("11111");
    }

    private static void test(short b) {
        System.out.println("22222");
    }

    private static void test(char b) {
        System.out.println("33333");
    }

    private static void test(int b) {
        System.out.println("44444");
    }
}
```

#### 强制转换（显式）

（1）数据范围大的数值赋值给另一个数据范围小的变量，需要自己转换，可能会造成数据丢失或精度损失。

（2）强制转换规则如下

```java
数值型数据的转换：byte -> shart -> int -> long -> float -> double
字符型转换为整型：char -> int
```

（3）强制转换的格式是在需要转型的数据前加上`( )`然后在括号内加入需要转化的数据类型。有的数据经过转型运算后，精度会丢失，而有的会更加精确

```java
public class Demo {
    public static void main(String[] args){
        int x = (int) 12.34 + (int) 56.7;  // 丢失精度
        double y = (double) 10 + (double) 10;  // 提高精度
        System.out.println("x=" + x); // x=68
        System.out.println("y=" + y); // y=20.0
    }
}
```

### 引用数据类型

简单来说，所有的非基本数据类型都是引用数据类型

例如类、接口、数组、枚举、注解、字符串等

## Java运算符

运算符是一种特殊的符号，用以表示数据的运算、赋值和比较等

### 算数运算符

| 运算符 | 简介                                           |
| ------ | ---------------------------------------------- |
| +      | 加、正号、字符串连接                           |
| -      | 减、负号                                       |
| *      | 乘                                             |
| /      | 除                                             |
| %      | 取模（取余）                                   |
| ++     | 自增前，先运算，后取值  自增后，先取值，后运算 |
| --     | 自减前，先运算，后取值  自减后，先取值，后运算 |

### 赋值运算符

| 运算符 | 简介                                                         |
| ------ | ------------------------------------------------------------ |
| =      | 赋值运算符(支持连续赋值)  当“=”两侧数据类型不一致时，可以使用自动类型转换或使用强制类型转换原则进行处理。    扩展：+=, -=, *=, /=, %= |

 

### 比较运算符（关系运算符）

比较运算符的结果都是boolean型，也就是要么是true，要么是false

| 运算符         | 简介               |
| -------------- | ------------------ |
| ==             | 相等于             |
| !=             | 不等于             |
| >              | 大于               |
| <              | 小于               |
| >=             | 大于等于           |
| <=             | 小于等于           |
| **Instanceof** | 检查是否为类的对象 |

  

### 逻辑运算符

| 运算符 | 简介     |
| ------ | -------- |
| &      | 逻辑与   |
| &&     | 短路与   |
| \|     | 逻辑或   |
| \|\|   | 短路或   |
| !      | 逻辑非   |
| ^      | 逻辑异或 |

 

### 位运算符

位运算符是直接对整数的二进制的运算

| 运算符 | 简介       |
| ------ | ---------- |
| <<     | 左移       |
| >>     | 右移       |
| >>>    | 无符号右移 |
| &      | 与运算     |
| \|     | 或运算     |
| ^      | 异或运算   |
| ~      | 取反算值   |

 

### 三元运算符

（1）三元运算符也叫三目运算符 ，即由三部分组成，格式如下

```java
// 条件表达式的结果为boolean类型，表达式1和表达式2为同种类型
(条件表达式) ? 表达式 1 : 表达式 2;
```

（2）三元运算符执行流程

先执行关系表达式，看其结果是true还是false，如果是true，则执行表达式1，如果是false，则执行表达式2

（3）三元运算符与if-else的区别与联系

三元运算符要求必须返回一个结果，而if后的代码块可有多个语句，凡是可以使用三元运算符的地方，都可以改写为if-else，反之不成立

## Java中的包

### 包（package）

（1）在Java语言里面，开发者难免会编写出同名的类，为了便于区分，就这类前加前缀加以区分，这个前缀就是包

（2）为了使包名唯一，通常会使用公司域名来命名包名，因为域名是唯一的，平时自己开发的时候可以随意

```java
package com.wen.xxx
```

（3）包（package）类似一个文件夹，作用如下

区分相同名字的类、当类很多时，可以很好的管理类、控制访问范围

### 导入包（import）

（1）为了能够使用某一个包的成员，我们需要在 Java 程序中明确导入该包

```java
// 按需导入
import org.junit.Test;
// 全部导入
import java.io.*;
```

## 流程控制

### 关键字（break、continue、return）

| 关键字   | 简介                                                         |
| -------- | ------------------------------------------------------------ |
| break    | 只能用于switch语句和循环语句中，用于终止某个语句块的执行，`结束当前循环` |
| continue | 只能使用在循环结构中，`结束当次循环`，continue语句用于跳过其所在循环语句块的一次执行，继续下一次循环    continue语句出现在多层嵌套的循环语句体中时，可以通过标签指明要跳过的是哪一层循环 |
| return   | 并非专门用于结束循环的，用于`结束一个方法`。当一个方法执行到一个return语句时，这个方法将被结束。与break和continue不同的是，return直接结束整个方法，不管这个return处于多少层循环之内 |



### 流程控制简介

（1）流程控制语句是用来控制程序中各语句执行顺序的语句，可以把语句组合成能完成一定功能的小逻辑模块

（2）流程控制方式采用结构化程序设计中规定的三种基本流程结构

| 流程结构     | 简介                                                         |
| ------------ | ------------------------------------------------------------ |
| **顺序结构** | 程序从上到下逐行地执行，中间没有任何判断和跳转               |
| **分支结构** | 根据条件，选择性地执行某段代码。   有if…else和switch-case两种分支语句。 |
| **循环结构** | 根据循环条件，重复性的执行某段代码。   有for、while、do…while三种循环语句。 |

### 顺序结构

```java
// Java中定义成员变量时采用合法的前向引用
// 执行顺序：执行语句1 -> 执行语句2 -> 执行语句3 -> 执行语句n
public class Demo {
    public static void main(String[] args){
	int num1 = 12;// 执行语句1
	int num2 = num1 + 2;// 执行语句2
    System.out.println(num2); // 执行语句3
    ...
    // 执行语句n
    }
} 
```

### 分支结构

#### if-else

（1）单分支

```java
if(条件表达式){ 
	执行代码块；
}
```

（2）双分支

```java
if(条件表达式){ 
	执行代码块1; 
} else{ 
	执行代码块2;
}
```

（3）多分支

```
if(条件表达式1){ 
	执行代码块1; 
} else if (条件表达式2){ 
	执行代码块2; 
} else if (条件表达式n) {
	执行代码块n; 
}else{ 
	执行代码块n; 
}
```

#### switch-case

（1）语法

```java
switch (表达式/变量) {
    case 常量1:执行语句1;  //情况1
    case 常量2:执行语句2;  //情况2
    case 常量3:执行语句3;  //情况3
    case 常量n:执行语句n;  //情况n
	... ... ...
	default: 以上情况都不满足时执行语句;
}
```

（2）使用案例

```java
Scanner scan=new Scanner(System.in);
System.out.println("请输入数字10或20");
String next = scan.next();
int i = Integer.parseInt(next);
switch (i) {
   case 10:
      System.out.println("输入了10");
      break;
   case 20:
      System.out.println("输入了20");
      break;
   default:
      System.out.println("输入错误");
      break;
}
```

### 循环结构

#### for

```java
// 执行过程：①-②-③-④-②-③-④-②-③-④-.....-②
for (①初始化部分;②循环条件部分;④迭代部分)｛ 
	③循环体部分; 
｝
```

执行过程： ①-②-③-④-②-③-④-②-③-④-...-② 

#### while

```java
// 执行过程： ①-②-③-④-②-③-④-②-③-④-...-②
①初始化部分 
while(②循环条件部分)｛ 
	③循环体部分; 
	④迭代部分;
} 
```

#### do-while

```java
// 执行过程： ①-③-④-②-③-④-②-③-④-...②
①初始化部分;
do{ 
	③循环体部分 
	④迭代部分 
}while(②循环条件部分);
```

#### foreach

（1）JDK1.5提供了foreach循环，方便的遍历集合、数组元素

（2）语法结构

```java
for(集合或数组的类型 局部变量:集合或数组对象){
    
}
```

（3）代码示例

```java
// JDK1.5提供了foreach循环，方便的遍历集合、数组元素
public class Demo {
	public static void main(String[] args) {
		String[] arrs = {"A", "B", "C"};
		for (String arr : arrs) {
			System.out.println(arr);
		}
		List<String> asList = Arrays.asList("AA", "BB", "CC");
		for (Object obj : asList) {
			System.out.println(obj);
		}
	}
}
```

#### 嵌套循环（多重循环）

```java
// 嵌套循环：九九乘法表
public class Demo {
    public static void main(String[] args) {
        //九九乘法表
        //嵌套循环
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.print(i + "*" + j + "=" + i * j);
                System.out.print("    ");
            }
            System.out.println();
        }
    }
}
```

## 数组

### 数组概括

（1）数组是相同类型数据的有序集合

（2）数组描述的是相同类型的若干个数据，按照一定的先后次序排列组合而成

（3）数组中每一个数据称作一个数组元素，每个数组元素可以通过一个下标来访问它们

### 一维数组

（1）创建一维数组语法

```java
// 方式一
数据类型[] 数组名 = new 数据类型[]{元素1,元素2,元素3,元素n};
// 方式二
数据类型[] 数组名 = new 数据类型[数组长度];
// 方式三
数据类型[] 数组名 = {元素1,元素2,元素3,元素n};
```

（2）创建一维数组例子

```java
// 总结：数组一旦初始化完成，其长度就确定了
// 数组下标：从0开始，到数组长度-1为止
public class Demo {
	public static void main(String[] args) {
		int[] array1 = new int[]{1, 2, 3};//静态初始化：数组的初始化和数组元素的赋值同时进行
        int[] array2 = {1, 2, 3};//静态初始化：数组的初始化和数组元素的赋值同时进行
		String[] array3 = new String[3];//动态初始化:数组的初始化和数组元素的赋值操作分开进行   
		array3[0]="A";// 通过下标添加元素
        array3[1]="B";// 通过下标添加元素
        array3[2]="C";// 通过下标添加元素
    }
}
```

（3）一维数组的访问

```java
// 总结：数组一旦初始化完成，其长度就确定了
// 数组下标：从0开始，到数组长度-1为止
public class Demo {
	public static void main(String[] args) {
		int[] array = {1, 2, 3};//静态初始化：数组的初始化和数组元素的赋值同时进行
		System.out.println(array.length);// 查看数组长度
        System.out.println(array[0]);// 通过数组下标访问数组元素
        System.out.println(array[1]);// 通过数组下标访问数组元素
        System.out.println(array[2]);// 通过数组下标访问数组元素
    }
}
```

（4）一维数组的遍历

```java
// 总结：数组一旦初始化完成，其长度就确定了
// 数组下标：从0开始，到数组长度-1为止
public class Demo {
	public static void main(String[] args) {
        int[] array = {1, 2, 3};//静态初始化：数组的初始化和数组元素的赋值同时进行
		for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
	}
}
```

（5）生成随机长度为10的两位数数组

```java
// 总结：数组一旦初始化完成，其长度就确定了
// 数组下标：从0开始，到数组长度-1为止
public class Demo {
    @Test
    public int[] randomArray() {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * (99 - 10 + 1) + 10);
        }
        //遍历数组
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        return array;
    }
}
```



### 二维数组（多维数组）

多维数组可以看成是数组的数组，比如二维数组就是一个特殊的一维数组，其每一个元素都是一个一维数组

（1）创建二维数组语法

```java
// 方式一
数据类型[][] 数组名称 = new 数据类型 [行数][列数] { {元素1,元素2,元素n},{元素1,元素2,元素n} };
// 方式二
数据类型[][] 数组名称 = new 数据类型 [行数][列数];
// 方式三
数据类型[][] 数组名称 = { {元素1,元素2,元素n},{元素1,元素2,元素n} }
```

（2）创建二维数组例子

```java
// 总结：数组一旦初始化完成，其长度就确定了
// 数组下标：从0开始，到数组长度-1为止
public class Demo {
	public static void main(String[] args) {
		int[][] array1 = new int[][]{{1, 2, 3}, {4, 5, 6}};// 静态初始化
        int[][] array3 = {{1, 2, 3}, {4, 5, 6}};// 静态初始化
        int[][] array2 = new int[3][2];//动态初始化
        array2[0] = new int[]{1, 2, 3};
        array2[1] = new int[]{4, 5, 6};
    }
}
```

（3）二维数组的访问

```java
// 总结：数组一旦初始化完成，其长度就确定了
// 数组下标：从0开始，到数组长度-1为止
public class Demo {
	public static void main(String[] args) {       
        int[][] array = {{1, 2, 3}, {4, 5, 6}};// 静态初始化
        System.out.println(array[0][0]);// 数组的访问
		System.out.println(array[0][1]);// 数组的访问
		System.out.println(array[0][2]);// 数组的访问
		System.out.println(array[1][0]);// 数组的访问
		System.out.println(array[1][1]);// 数组的访问
		System.out.println(array[1][2]);// 数组的访问
	}
}
```

（4）二维数组的遍历

```java
// 总结：数组一旦初始化完成，其长度就确定了
// 数组下标：从0开始，到数组长度-1为止
public class Demo {
	public static void main(String[] args) {       
        int[][] array = {{1, 2, 3}, {4, 5, 6}};// 静态初始化
		for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
	}
}
```



## 数组涉及的常见算法

| 常见算法               | 简介                                                         |
| ---------------------- | ------------------------------------------------------------ |
| 数组元素的赋值         | 杨辉三角、回形数等                                           |
| 数组的各种求值         | 最大值、最小值、平均数、总和等                               |
| 数组的复制、反转、查找 | 线性查找、二分法查找                                         |
| 数组元素的排序算法     | 选择排序（直接选择排序、堆排序）、交换排序（冒泡排序、快速排序）、  插入排序（直接插入排序、折半插入排序、Shell排序）、  归并排序 、桶式排序、基数排序 |

### 赋值

#### 杨辉三角

```java
public class Demo {
    /**
     * 使用二维数组打印一个10行杨辉三角
     * 1：第一行有一个元素，第n行有n个元素
     * 2：每一行的第一个元素和最后一个元素都是1
     * 3：从第三行开始，对于非第一个元素和最后一个元素的元素，即array[i][j]=array[i-1][j-1]+array[i-1][j];
     */
    @Test
    public void test5() {
        //（1）声明一个二维数组
        int array[][] = new int[10][];//10行

        //（2）给数组的元素赋值
        for (int i = 0; i < array.length; i++) {
            array[i] = new int[i + 1];//每行有多少元素
            array[i][0] = array[i][i] = 1;//给首末元素赋值1
            //给首末元素赋值
            if (i > 1) {
                for (int j = 1; j < array[i].length - 1; j++) {
                    array[i][j] = array[i - 1][j - 1] + array[i - 1][j];

                }
            }

        }

        //（3）遍历二维数组
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```

#### 回形数

```java
public class Demo {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入回型数大小数值：");
            int n = scanner.nextInt();
            int[][] arr = new int[n][n];

            int count = 0;//要显示的数量
            int maxX = n - 1;  //x轴的最大下标
            int maxY = n - 1; //y轴的最大下标
            int minX = 0; //x轴的最小下标
            int minY = 0; //y轴的最小下表

            while (minX <= maxX) {
                for (int x = minX; x <= maxX; x++) {
                    arr[minY][x] = ++count;
                }
                minY++;
                for (int y = minY; y <= maxY; y++) {
                    arr[y][maxX] = ++count;
                }
                maxX--;
                for (int x = maxX; x >= minX; x--) {
                    arr[maxY][x] = ++count;
                }
                maxY--;
                for (int y = maxY; y >= minY; y--) {
                    arr[y][minX] = ++count;
                }
                minX++;
                System.out.println(count);
            }
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            return;
        }
    }
}
```

### 求值

#### 求和

```java
public class Demo {
    @Test
    public void test() {
        int[][] are = new int[][]{{1, 2}, {3, 4}, {5, 6}};
        int sum = 0;
        for (int i = 0; i < are.length; i++) {
            for (int j = 0; j < are[i].length; j++) {
                sum += are[i][j];
            }
        }
        System.out.println("总和为：" + sum);
    }
}
```

#### 最大值

```java
public class Demo {
    @Test
    public void max(){
        int[] array = {1, 2, 3};
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        System.out.println("最大数：" + max);
    }
}
```

#### 最小值

```java
public class Demo {
    @Test
    public void min() {
        int[] array = {1, 2, 3};
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        System.out.println("最小数：" + min);
    }
}
```

#### 求和

```java
public class 求和 {
    @Test
    public void sum() {
        int[] array = {1, 2, 3};
        int sumNum = 0;
        for (int i = 0; i < array.length; i++) {
            sumNum += array[i];
        }
        System.out.println(sumNum);
    }
}
```

#### 平均值

```java
public class 平均值 {
    @Test
    public void avg(){
        int[] array = {1, 2, 3};
        //求数组元素总和
        int sumNum = 0;
        for (int i = 0; i < array.length; i++) {
            sumNum += array[i];
        }
        int avg = sumNum / array.length;
        System.out.println("平均值：" + avg);
    }
}
```

### 复制、反转、查找

#### 复制

```java
public class Demo {
    @Test
    public void copy() {
        int[] arr1,arr2;
        //arr1,arr2关系：地址值相同，都指向了堆空间的唯一的一个数组实体
        arr1=new int[] {1,2,3,4,5};
        //遍历arr1
        System.out.println("arr1中元素：");
        for(int i=0;i<arr1.length;i++) {
            System.out.print(arr1[i]+" ");
        }
        System.out.println();
        //数组的复制：(区别于数组变量的赋值，arr1=arr2)
        //重新创建了一个数组实体，并将arr1复制给arr2
        arr2=new int[arr1.length];
        for(int i=0;i<arr2.length;i++) {
            arr2[i]=arr1[i];
        }
        //遍历arr2
        System.out.println("arr2中元素：");
        for(int i=0;i<arr2.length;i++) {
            System.out.print(arr2[i]+" ");
        }
        System.out.println();
    }
}
```

#### 反转

```java
public class Demo {
    @Test
    public void reverse1() {
        int[] array = new int[]{1, 2, 3, 4, 5};

        // 数组反转方式一
        for (int i = 0; i < array.length / 2; i++) {
            int reverse = array[i];//将定义的变量值等于数组第一个值
            array[i] = array[array.length - i - 1];//将第一个值替换为最后一个值
            array[array.length - i - 1] = reverse;//将最后一个替换为定义的值
        }
        // 打印反转后的数组
        System.out.println("反转后：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }

    @Test
    public void reverse2(){
        int[] array = new int[]{1, 2, 3, 4, 5};
        // 数组反转方式二
        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            int reverse = array[i];
            array[i] = array[j];
            array[j] = reverse;
        }
        // 打印反转后的数组
        System.out.println("反转后：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
```

#### 线性查找

```java
public class Demo {
    // 数组的查找(线性)：
    // 线性查找：通过遍历的方式，一个一个的数据进行比较，查找。
    @Test
    public void chazhao() {
        System.out.println("数组的查找(线性)");
        String[] array = new String[]{"a", "b", "c", "d", "e"};
        String chazhao = "b";
        boolean isFlag = true;
        for (int i = 0; i < array.length; i++) {
            //	String 中 == 比较引用地址是否相同，
            //  equals() 比较字符串的内容是否相同
            if (chazhao.equals(array[i])) {
                System.out.println("找到了指定元素，位置为：" + i);
                isFlag = false;
                break;
            }
        }
        if (isFlag) {
            System.out.println("没找到");
        }
    }
}
```

#### 二分法查找

```java
//数组的查找(二分法)：
//二分法查找(熟悉)：每次比较中间值，折半的方式检索
//前提：所要查找到数组必须是有序的
public class 二分法查找 {
   
    static int count; // 查找次数

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println(searchRecursive(array, 0, array.length - 1, 9));
        System.out.println(count);
        count = 0;
        System.out.println(searchLoop(array, 9));
        System.out.println(count);
    }

    /**
     * 执行递归二分查找，返回第一次出现该值的位置
     *
     * @param array     已排序的数组
     * @param start     开始位置
     * @param end       结束位置
     * @param findValue 需要找的值
     * @return 值在数组中的位置，从0开始。找不到返回-1
     */
    public static int searchRecursive(int[] array, int start, int end,
                                      int findValue) {
        // 如果数组为空，直接返回-1，即查找失败
        if (array == null) {
            return -1;
        }
        count++;
        if (start <= end) {
            // 中间位置
            int middle = (start + end) / 1;
            // 中值
            int middleValue = array[middle];

            if (findValue == middleValue) {
                // 等于中值直接返回
                return middle;
            } else if (findValue < middleValue) {
                // 小于中值时在中值前面找
                return searchRecursive(array, start, middle - 1, findValue);
            } else {
                // 大于中值在中值后面找
                return searchRecursive(array, middle + 1, end, findValue);
            }
        } else {
            // 返回-1，即查找失败
            return -1;
        }
    }

    /**
     * 循环二分查找，返回第一次出现该值的位置
     *
     * @param array     已排序的数组
     * @param findValue 需要找的值
     * @return 值在数组中的位置，从0开始。找不到返回-1
     */
    public static int searchLoop(int[] array, int findValue) {
        // 如果数组为空，直接返回-1，即查找失败
        if (array == null) {
            return -1;
        }

        // 起始位置
        int start = 0;
        // 结束位置
        int end = array.length - 1;

        while (start <= end) {
            count++;
            // 中间位置
            int middle = (start + end) / 2;
            // 中值
            int middleValue = array[middle];

            if (findValue == middleValue) {
                // 等于中值直接返回
                return middle;
            } else if (findValue < middleValue) {
                // 小于中值时在中值前面找
                end = middle - 1;
            } else {
                // 大于中值在中值后面找
                start = middle + 1;
            }
        }
        // 返回-1，即查找失败
        return -1;
    }
}
```

### 排序

#### 冒泡排序

```java
public class Demo {
    @Test
    public void maopao() {
        // 无序数组
        int[] arr = new int[]{20, 30, -40, 80, 60, -50, 10};

        // 冒泡排序
        for (int i = 0; i < arr.length; i++) {//记录数组中有多少元素
            for (int j = 0; j < arr.length - 1 - i; j++) {//循环的次数
                if (arr[j] > arr[j + 1]) {
                    int zhuan = arr[j];//第一个数据与第二个数据转换，大后小前
                    arr[j] = arr[j + 1];
                    arr[j + 1] = zhuan;
                }
            }
        }
        // 排序后遍历
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
```

#### 快速排序

```java
public class Demo {
 
    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private static void subSort(int[] data, int start, int end) {
        if (start < end) {
            int base = data[start];
            int low = start;
            int high = end + 1;
            while (true) {
                while (low < end && data[++low] - base <= 0) ;
                while (high > start && data[--high] - base >= 0) ;
                if (low < high) {
                    swap(data, low, high);
                } else {
                    break;
                }
            }
            swap(data, start, high);
            subSort(data, start, high - 1);//递归调用
            subSort(data, high + 1, end);
        }
    }

    public static void quickSort(int[] data) {
        subSort(data, 0, data.length - 1);
    }

    public static void main(String[] args) {
        int[] data = {9, -16, 30, 0, 23, -30, -49, 25, 21, 30};
        System.out.println("排序之前：" + java.util.Arrays.toString(data));
        quickSort(data);
        System.out.println("排序之后：" + java.util.Arrays.toString(data));
    }
}
```

### 自定义数组工具类

```java
/**
 * 自定义数组工具类
 */
public class MyArraysUtils {
    /**
     * 求数组最大值
     */
    public int getmax(int[] arr) {
        int fmax = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (fmax < arr[i]) {
                fmax = arr[i];
            }
        }
        return fmax;
    }

    /**
     * 求数组最小值
     */
    public int getmin(int[] arr) {
        int fmin = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (fmin > arr[i]) {
                fmin = arr[i];
            }
        }
        return fmin;
    }

    /**
     * 数组求和
     */
    public int gethe(int[] arr) {
        int he = 0;
        for (int i = 0; i < arr.length; i++) {
            he += arr[i];
        }
        return he;
    }

    /**
     * 数组平均值
     */
    public int getjun(int[] arr) {

        return gethe(arr) / arr.length;
    }

    /**
     * 数组反转
     */
    public void getfan(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int zhuan = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = zhuan;
        }
    }

    /**
     * 数组的复制
     */
    public int[] getfuzhi(int[] arr) {

        int[] srr = new int[arr.length];
        for (int i = 0; i < srr.length; i++) {
            srr[i] = arr[i];
        }
        return srr;

    }

    /**
     * 数组的排序
     */
    public void getpai(int[] arr) {
        //冒泡排序
        for (int i = 0; i < arr.length; i++) {//记录数组中有多少元素
            for (int j = 0; j < arr.length - 1 - i; j++) {//循环的次数
                if (arr[j] > arr[j + 1]) {
                    int zhuan = arr[j];//第一个数据与第二个数据转换，大后小前
                    arr[j] = arr[j + 1];
                    arr[j + 1] = zhuan;
                }
            }

        }
        //遍历排序后的数组
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * 数组遍历
     */
    public void bianli(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
```

### Arrays工具类

java.util.Arrays是JDK提供的操作数组的工具类，提供许多操作数组的方法，而且这些方法都是静态的，所以在使用时不用创建对象，程序员直接调用就行

| 方法                              | 介绍                                 |
| --------------------------------- | ------------------------------------ |
| boolean equals(int[] a,int[] b)   | 判断两个数组是否相等                 |
| String toString(int[] a)          | 输出数组信息                         |
| void fill(int[] a,int val)        | 将指定值填充到数组之中               |
| void sort(int[] a)                | 对数组进行排序                       |
| Int binarySearch(int[] a,int key) | 对排序后的数组进行二分法检索指定的值 |

```java
import org.junit.Test;
import java.util.Arrays;
// Arrays工具类使用
public class testArrays {
    /**
     * 判断两个数组是否相等
     * boolean equals(int[] a,int[],b)
     */
    @Test
    public void testEquals() {
        int[] arr1 = new int[]{1, 2, 3};
        int[] arr2 = new int[]{3, 2, 1};
        boolean isEquals = Arrays.equals(arr1, arr2);
        System.out.println(isEquals);
    }

    /**
     * 输出数据信息
     * String toString(int[] a)
     */
    @Test
    public void testToString() {
        int[] arr = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 将指定的值填充到数组中
     * void fill(int[] a,int val)
     */
    @Test
    public void testFill() {
        int[] arr = new int[]{1, 2, 3};
        Arrays.fill(arr, 10);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 对数组进行排序
     * void sort(int[] a)
     */
    @Test
    public void testSort() {
        int[] arr = new int[]{3, 1, 2};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 对排序后的数组进行二分法检索指定的值
     * int (int[] a,int key)
     */
    @Test
    public void testBinarySearch() {
        int[] arr = new int[]{3, 2, 1, 4, 5};
        int index = Arrays.binarySearch(arr, 5);
        if (index >= 0) {
            System.out.println(index);
        } else {
            System.out.println("未找到");
        }
    }

}
```

