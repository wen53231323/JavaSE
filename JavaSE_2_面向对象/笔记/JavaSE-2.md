## 面向对象

### 面向过程和面向对象

（1）面向对象与面向过程简介

| 概念     | 简介                                                         |
| -------- | ------------------------------------------------------------ |
| 面向过程 | 面向过程是一种`功能行为`，以函数为最小单位，考虑怎么做。面向过程就是分析出解决问题所需要的步骤，然后用函数把这些步骤一一实现，使用的时候依次调用就可以了。面向多次性能比面向对象高，因为面向对象中类调用时需要实例化，开销比较大，比较消耗资源;  比如单片机、嵌入式开发、  Linux/Unix等一般采用面向过程开发，性能是最重要的因素。 |
| 面向对象 | 面向对象强调了`具备功能的对象`，以类/对象为最小单位，考虑谁来做。面向对象是把构成问题的事务按照一定规则划分为多个独立的对象，然后各个对象之间进行交互，通过调用对象的方法来解决问题 |

（2）面向对象与面向过程对比

| 对比     | 面向对象程序设计             | 面向过程程序设计（也叫结构化编程）             |
| -------- | ---------------------------- | ---------------------------------------------- |
| 设计语言 | Java、C++、C#、Python等      | C、Fortran                                     |
| 特点     | 封装、继承、多态             | 算法+数据结构                                  |
| 优势     | 适用于大型复杂系统，方便复用 | 适用于简单系统，容易理解                       |
| 劣势     | 比较抽象、性能比面向过程低   | 难以应对复杂系统，难以复用，不易维护、不易扩展 |

### 面向对象概括

（1）Java是一门面向对象设计的语言，对 Java语言来说，一切皆是对象。把现实世界中的对象抽象地体现在编程世界中，一个对象代表了某个具体的操作。一个个对象最终组成了完整的程序设计，这些对象可以是独立存在的，也可以是从别的对象继承过来的。对象之间通过相互作用传递信息，实现程序开发

（2）所谓`对象`，就是真实世界中的`实体`，对象与实体是一一对应的，也就是说现实世界中每一个实体都是一个对象，是一种具体的概念

（3）面向对象就是把`构成问题的事物`分解成一个个对象，建立对象不是为了实现一个步骤，而是为了描述某个事物在解决问题中的行为

### 面向对象的三大特征

| 特征                  | 简介                                                         |
| --------------------- | ------------------------------------------------------------ |
| 封装（Encapsulation） | 封装是面向对象的核心思想，将对象的**属性和行为封装起来，不需要让外界知道具体实现细节** |
| 继承（Inheritance）   | 继承主要描述的就是**类与类之间的关系**，通过继承，可以在无需重新编写原有类的情况下，**对原有类的功能进行扩展** |
| 多态（Polymorphism）  | 多态指的是在一个类中定义的属性和功能被其他类继承后，  当**把子类对象直接赋值给父类引用变量**时，相同引用类型的**变量调用同一个方法所呈现出的多种不同行为特性** |

### 面向对象的例子

在学校里，会有学生和老师等实体

学生有学号、姓名、所在班级等属性（成员变量）

学生有学习、提问、吃饭和走路等行为（方法）

学生只是对某个人抽象的描述，这个抽象的描述称为“类”

在学校里活动的学生小明、小刚等等，这些具体的个体称为“对象”，“对象”也称为“实例”

可以理解为：类 = 抽象概念的人；对象 = 实实在在的某个人 

### 面向对象分析问题的思路

（1）根据问题需要，选择问题所针对的现实世界中的实体。 

（2）从实体中寻找解决问题相关的属性和功能，这些属性和功能就形成了概念世界中的类。 

（3）把抽象的实体用计算机语言进行描述，形成计算机世界中类的定义。即借助某种程序语言，把类构造成计算机能够识别和处理的数据结构。

（4）将类实例化成计算机世界中的对象，对象是计算机世界中解决问题的最终工具。

（5）程序员从面向过程的执行者转化成了面向对象的指挥者

### 类和对象

（1）类与对象的概念

| 类和对象 | 概括                                                         |
| -------- | ------------------------------------------------------------ |
| 类       | 类是对一类事物的描述，是**抽象**的、概念上的定义。描述了一组有相同特性（属性）和相同行为（方法）的一组对象的集合，类是构造面向对象程序的基本单位 |
| 对象     | 对象是实际存在的该类事物的每个个体，具体的，实例。对象执行的操作称为类的方法 |

（2）类和对象的示例

| 类   | 对象                                       |
| ---- | ------------------------------------------ |
| 人   | 正在清洁的环卫工人小刘、教室里的学生张丽   |
| 汽车 | 一辆黄色的宝马跑车、一辆白色的林肯轿车     |
| 动物 | 一只叫“猫咪”的小花猫、一只叫“欢欢”的贵宾犬 |

## 类及类的成员

### 类的创建（class）

创建一个类，需要使用 class 关键字，语法格式如下（中括号`[]`中的部分可省略）

```java
[访问修饰符] class 类名 [extends 父类名] [implements 接口名]{ 
	类的成员（属性、方法、构造器、代码块、内部类）
}
```

| 字段       | 概括                                                         |
| ---------- | ------------------------------------------------------------ |
| 访问修饰符 | 对访问权限进行限定的  class的权限修饰只可以用public公共和default缺省 |
| 类名       | 首字母大写且符合标识符                                       |
| extends    | 用于类的继承                                                 |
| implements | 用于类实现接口                                               |
| 类的成员   | 属性、方法、构造器、代码块、内部类                           |

### 类的成员-属性（field）

#### 类中属性的定义

```java
[访问修饰符] 数据类型 属性名 = 初始化值; 
```

| 字段       | 概括                                                         |
| ---------- | ------------------------------------------------------------ |
| 访问修饰符 | 对访问权限进行限定，常用的权限修饰符有：private、缺省、protected、public   其他修饰符：static、final |
| 数据类型   | 任何基本数据类型(如int、boolean)  或 任何引用数据类型        |
| 属性名     | 属于标识符，符合命名规则和规范即可                           |

#### 成员变量和局部变量

（1）根据类位置的不同可以将属性划分为`成员变量`和`局部变量`

| 属性     | 简介                         |
| -------- | ---------------------------- |
| 成员变量 | 在方法体外，类体内声明的变量 |
| 局部变量 | 在方法体内部声明的变量       |

（2）成员变量和局部变量的区别

| 区别         | 成员变量                         | 局部变量                                 |
| ------------ | -------------------------------- | ---------------------------------------- |
| 声明的位置   | 直接声明在类中                   | 方法形参或内部、代码块内、构造器内等     |
| 访问修饰符   | private、public、static、final等 | `不能用权限修饰符修饰`，可以用final修饰  |
| 初始化值     | 有默认初始化值                   | 没有默认初始化值，必须显式赋值，方可使用 |
| 内存加载位置 | 堆空间 或 静态域内               | 栈空间                                   |

### 类的成员-方法（method）

#### 类中方法的定义

```java
[访问修饰符] 返回值类型 方法名(参数类型 形参1, 参数类型 形参2, …) {
	方法体
　　return 返回值;
}
```

| 字段           | 概括                                                         |
| -------------- | ------------------------------------------------------------ |
| 修饰符         | 对访问权限进行限定，常用的权限修饰符有：private、缺省、protected、public |
| 返回值类型     | 用于限定方法返回值的数据类型，与方法体中 return  返回值 搭配使用，若没有返回值使用void |
| 方法名         | 属于标识符，命名时遵循标识符命名规则和规范                   |
| 参数类型       | 限定调用方法时传入参数的数据类型                             |
| 形参           | 是一个变量，用于接收调用方法时传入的数据                     |
| return  返回值 | 方法在执行完毕后返还给调用它的程序的数据。当方法的返回值类型为void时，return及其返回值可以省略 |

#### 方法的重载（overload）

 在同一个类中，允许存在一个以上的同名方法，只要它们的参数个数或者参数类型不同即可

```java
public class Demo{
    // 方法A
    public void A(){
        
    }
    // 方法A的重载
    public void A(String name){
        
    }
}
```



### 类的成员-构造器（构造方法）

（1）类中构造器的定义（无返回值类型的声明、不能使用return语句返回一个值）

```java
// 有参构造器
[访问修饰符] 类名(参数类型 形参1, 参数类型 形参2, …)  { 
	初始化语句;
} 
```

| 字段       | 概括                                                         |
| ---------- | ------------------------------------------------------------ |
| 访问修饰符 | 修饰符只有权限修饰符private、默认、protected、public<br>不能被static、final、synchronized、abstract、native修饰 |
| 类名       | 构造器名称与类名一致                                         |
| 初始化语句 | 用于初始化类的信息 ，不能有 return 语句返回值                |

（2）系统默认提供一个空参的构造器，其权限与类的相同；一旦显式的定义了构造器，系统就不再提供空参构造器

```java
// 无参构造器
public 类名()  { 

} 
```

### 类的成员-代码块（初始化块）

（1）使用{}括起来的代码被称为代码块，常用来初始化类、对象

```java
[访问修饰符] {
    初始化语句;
} 
```

| 字段       | 概括**                                                       |
| ---------- | ------------------------------------------------------------ |
| 访问修饰符 | 修饰符可选但只能使用static，使用static关键字修饰的称为静态代码块，其余的称为非静态代码块 |
| 初始化语句 | 代码块中可以写任何语句（输入，输出，方法调用，循环，判断等等） |

（2）静态代码块与非静态代码块的区别

| 区别     | 静态代码块                                     | 非静态代码块                                                 |
| -------- | ---------------------------------------------- | ------------------------------------------------------------ |
| 执行时机 | 随着类的加载而执行，而且只执行一次             | 随着对象的创建而执行，每创建一个对象，就执行一次非静态代码块 |
| 作用     | 初始化类的信息                                 | 可以在创建对象时，对对象的属性等进行初始化                   |
| 调用     | 只能调用静态的属性、方法，不能调用非静态的结构 | 可以调用静态的属性、静态的方法，非静态的属性、非静态的方法   |

### 类的成员-内部类（inner class）

（1）在类中声明的类称为内部类

```java
// 类A为类B的外部类（outer class）
[访问修饰符] class 类A{
    // 类B为类A的内部类（inner class）
    [访问修饰符] class 类B{
        
    }
}
// 类C是类A的外部其他类（other class）
class 类C{
    
}
```

（2）内部的分类

| 内部类     | 简介                                                     |
| ---------- | -------------------------------------------------------- |
| 成员内部类 | 定义在类内部的非静态类叫做成员内部类（不使用static修饰） |
| 静态内部类 | 定义在类内部的静态类称为静态内部类（使用static修饰）     |
| 局部内部类 | 在方法中定义的内部类，有类名                             |
| 匿名内部类 | 在方法中定义的内部类，无类名                             |

```java
public class A {
    // 成员内部类
    public class B {

    }

    // 静态内部类
    public static class C {

    }

    public void m() {
        // 局部内部类
        class C {

        }
    }

    public static void main(String[] args) {
        // 匿名内部类
        new Test() {

        };
    }
}

class Test {

}
```

## 对象

对象是对类的实例化。对象具有状态和行为，变量用来表明对象的状态，方法表明对象所具有的行为。

Java中每个对象都是相互独立的，在内存中占有独立的内存地址，并且每个对象都具有自己的生命周期

Java对象的生命周期包括创建、使用和清除，当对象的生命周期结束时，对象就变成了垃圾，由 Java 虚拟机自带的垃圾回收机制处理

### 对象的创建

（1）使用 new 关键字创建对象

```java
类名 对象名 = new 类名();
```

（2）使用反射方法newInstance()创建对象

```java
// 调用 java.lang.Class 类中的 forName() 方法指定实例化的类的全称
java.lang.Class 类对象名称 = java.lang.Class.forName("要实例化的类全称");
// 调用 java.lang.Class 类对象的 newInstance() 方法创建对象
类名 对象名 = (类名) 类对象名称.newInstance();
```

（3）调用对象的 clone() 方法创建对象的拷贝

```java
类名 对象名A = new 类名();
类名 对象名B = (类名)对象名A.clone();
```

（4）运用序列化手段，调用java.io.ObjectInputStream 对象的 readObject()方法

（4）创建对象案例

先创建一个学生类Student

```java
public class Student implements Cloneable {
    // 因为实现了Cloneable接口，所以需要重写clone()方法
    protected Student clone() throws CloneNotSupportedException {
        Student stu = (Student) super.clone();
        return stu;
    }
}
```

创建学生类的实例对象

```java
public class Demo {

    /**
     * 方式一：使用 new 关键字创建对象
     */
    @Test
    public void test1() {
        // 使用 new 关键字创建对象
        Student stu = new Student();
        // 打印对象地址
        System.out.println(stu);
    }

    /**
     * 方式二：调用 java.lang.Class 的 newInstance() 方法创建对象
     */
    @Test
    public void test2() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 调用 java.lang.Class 类中的 forName() 方法指定实例化的类的全称
        java.lang.Class cls = java.lang.Class.forName("com.wen.Student");
        // 调用 java.lang.Class 类对象的 newInstance() 方法创建对象
        Student student = (Student) cls.newInstance();
        // 打印对象地址
        System.out.println(student);
    }

    /**
     * 方式三：调用对象的 clone() 方法创建并返回一个对象的拷贝，
     * 要实例化的类必须继承 java.lang.Cloneable 接口并重写clone()
     */
    @Test
    public void test3() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Student stuA = new Student();
        System.out.println(stuA);
        // 调用对象的 clone() 方法创建对象
        // clone() 方法：创建与该对象的类相同的新对象；
        try {
            //注意：因为有异常抛出，所以要捕获异常
            Student stuB = stuA.clone();
            System.out.println(stuB);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}
```

### 对象的使用

（1）访问对象成员（包括属性和方法）

```java
// 创建对象
类名 对象名 = new 类名();
// 使用对象名访问对象成员（包括属性和方法）
对象名.对象成员
```

（2）匿名对象：不定义对象的句柄，直接调用对象成员

```
new 类名().对象成员
```

（3）对象使用案例

先创建一个Person类

```java
public class Person {

    // 属性
    String name;
    // 属性
    int age;

    //方法
    public void eat() {
        System.out.println("人可以吃饭");
    }

    //方法
    public void sleep() {
        System.out.println("人可以睡觉");
    }

}
```

创建学生类的实例对象，并调用对象成员

```java
public class Demo {
    public static void main(String[] args) {
        Person person = new Person();
        person.age=1;
        person.name="小明";
        person.eat();
        person.sleep();
    }
}
```

### 对象内存分配

（1）在JVM内存里面主要有栈（stack）和堆（heap）两个区域

| 区域                  | 简介                                             |
| --------------------- | ------------------------------------------------ |
| java虚拟机栈（stack） | 被调用的方法会压栈，这里还会存放方法中的局部变量 |
| java堆（heap）        | 创建出来的对象会存放在堆中，成员变量也存储在这里 |

（2）当创建一个对象时，程序执行步骤如下

```java
1、程序中的main方法压栈，开始执行里面的代码
2、当执行Student stu = new Student()后，会在堆里面开辟一块空间来存储创建的Student对象，假设内存地址是0x0101，那么stu就会指向这个内存地址，stu存储在栈内存中，这样通过栈内存中的stu就可以找到堆内存中的对象了。
3、通过str.的方式访问堆中的对象，并为其成员变量进行赋值
4、方法弹栈
5、程序执行结束
```





## 面向对象的三大特征

### 封装（Encapsulation）

#### 封装简介

封装将类的某些信息隐藏在类内部，不允许外部程序直接访问，只能通过该类提供的方法来实现对隐藏信息的操作和访问。

也就是说用户无需知道对象内部的细节，但可以通过该对象对外提供的接口来访问该对象

#### 权限修饰符概括

（1）Java权限修饰符**public、protected、default(缺省)、private**置于类的成员定义前， 用来限定对象对该类成员的访问权限。 

| 修饰符          | 概括                                                         |
| --------------- | ------------------------------------------------------------ |
| private         | `当前类访问级别`，如果类的成员被private访问控制符来修饰，  则这个成员只能被该类的其他成员访问，其他类无法直接访问  类的良好封装就是通过private关键字来实现的 |
| default（缺省） | `包访问级别`，如果一个类或者类的成员不使用任何访问控制符修饰，  则称它为默认访问控制级别，这个类或者类的成员只能被本包中的其他类访问 |
| protected       | `子类访问级别`，如果一个类的成员被protected访问控制符修饰，  那么这个成员既能被同一包下的其他类访问，也能被不同包下该类的子类访问 |
| public          | `公共访问级别`，这是一个最宽松的访问控制级别，如果一个类或者类的成员被public访问控制符修饰，  那么这个类或者类的成员能被所有的类访问，不管访问类与被访问类是否在同一个包中 |

#### 权限修饰符访问级别

| 修饰符          | 类内部 | 同一个包 | 不同包的子类 | 同一个工程 |
| --------------- | ------ | -------- | ------------ | ---------- |
| private         | Yes    |          |              |            |
| default（缺省） | Yes    | Yes      |              |            |
| protected       | Yes    | Yes      | Yes          |            |
| public          | Yes    | Yes      | Yes          | Yes        |

### 继承（extends）

#### 简介

（1）继承是基于已有的类创造新的类。继承降低了代码编写的冗余度，便于功能的扩展，提高编程的效率，是多态性的使用的前提

（2）在 Java 中通过 extends 关键字可以申明一个类是从另外一个类继承而来的

```java
// 父类A
[访问修饰符] class 父类A{
	类的成员（属性、方法、构造器、代码块、内部类）
}
// 子类B继承父类A
[访问修饰符] class 子类B extends 父类A{
	类的成员（属性、方法、构造器、代码块、内部类）
}
```

#### 相关概念

（1）一旦子类A继承父类B以后，子类A中就获取了父类B中声明的所有的属性和方法，也可以创建自己的属性和方法

（2）Java 仅支持单继承，一个子类只能有一个父类，一个父类可以有多个子类

（3）一个子类的父类的父类称为间接父类，子类继承父类以后，就获取了直接父类以及所有间接父类中声明的属性和方法

（4）若子类重写了父类方法，就意味着子类里定义的方法彻底覆盖了父类里的同名方法，系统将不可能把父类里的方法转移到子类中

（5）如果我们没有显式的声明一个类的父类的话，则此类继承于java.lang.Object类
（6）所有的java类(除java.lang.Object类之外)都直接或间接的继承于java.lang.Object类，这就意味着所有的java类具有java.lang.Object类声明的功能

#### 重写父类方法

（1）子类继承父类以后，可以对父类中同名同参数的方法，进行覆盖操作

```java
public class Demo {
    public static void main(String[] args) {
        Animal animal = new Cat();
        animal.hello();
    }
}

// 父类Animal
class Animal {
    // 父类中的方法
    public void hello() {
        System.out.println("hello");
    }
}

// 子类Cat
class Cat extends Animal {
    // @Override注解用来帮助检查方法的正确性
	@Override
    public void hello() {
        System.out.println("重写了父类方法");
    }
}
```

上面的例子中，`animal`对象被定义为父类`Animal`类型。

在编译期，编译器会检查父类`Animal`类中是否有可访问的`hello()`方法，只要其中包含`hello()`方法，那么就可以编译通过。

在运行期，子类`Cat`对象被`new`出来，并赋值给`animal`变量，这时，JVM是明确的知道`animal`变量指向的其实是子类`Cat`对象的引用。所以，当`animal`对象调用`hello()`方法的时候，就会调用子类`Cat`类中定义的`hello()`方法。这就是所谓的动态多态性

（2）重写的条件

```
不能重写被标示为final的方法
参数列表必须完全与被重写方法的相同
返回类型必须完全与被重写方法的返回类型相同
如果不能继承一个方法，则不能重写这个方法
访问级别的限制性一定不能比被重写方法的强
访问级别的限制性可以比被重写方法的弱
重写方法一定不能抛出新的检查异常或比被重写的方法声明的检查异常更广泛的检查异常
重写的方法能够抛出更少或更有限的异常（也就是说，被重写的方法声明了异常，但重写的方法可以什么也不声明）
```



#### this关键字

（1）this表示对当前对象的引用，this 可以调用类的属性、方法和构造器 

```java
// 调用当前对象的构造器,需要在构造器中使用,必须放在构造器的首行
this(形参列表);
// 调用当前对象的属性
this.属性;
// 调用当前对象的方法
this.方法;
```

（2）当类中成员变量与构造方法形参重名时，可以使用this区分同名变量

```java
public class Demo {
    public String name;
    public int age;

    // 空参构造
    public Demo() {
        // 构造器中调用构造器,必须放在构造器的首行
        this("小白", 18);
        // 调用当前对象的方法
        this.hello();
    }

    // 全参构造
    public Demo(String name, int age) {
        // 构造器中调用属性
        this.name = name;
        this.age = age;
    }

    public void hello() {
        System.out.println("hello");
    }
}
```

（3）当需要返回当前对象的引用时，就常常在方法写return this

```java
public class Demo{
	public Demo test(){
        // 返回类的当前对象
        return this;
    }
}
```

#### super关键字

（1）super理解为父类的，如果子类中存在与父类同名的方法成员，则通过关键字super在子类方法中访问父类方法成员

```java
// 调用父类对象的构造器,需要在构造器中使用,必须放在构造器的首行
super(参数列表)
// 调用父类的属性
super.属性
// 调用父类的方法
super.方法
```

（2）super关键字可用于访问父类中定义的属性、方法，在子类构造器中调用父类的构造器

```java
// 父类Animal
class Animal {

    public String name;

    // 构造函数
    public Animal(String name) {
        // 构造器中调用属性
        this.name = name;
    }
	// 父类中的方法
    public void hello() {
        System.out.println("hello");
    }
}

// 子类Cat类
class Cat extends Animal {
    //构造函数
    public Cat() {
        // 调用父类对象的构造器,需要在构造器中使用,必须放在构造器的首行
        super("喵喵");
        // 调用父类的属性
        super.name = "绵绵";
        // 调用父类的hello()方法
        super.hello();
    }
}
```

（3）this和super的区别

| 区别点     | this                                                     | super                                    |
| ---------- | -------------------------------------------------------- | ---------------------------------------- |
| 访问属性   | 访问本类中的属性，如果本类没  有此属性则从父类中继续查找 | 直接访问父类中的属性                     |
| 调用方法   | 访问本类中的方法，如果本类没  有此方法则从父类中继续查找 | 直接访问父类中的方法                     |
| 调用构造器 | 调用本类构造器，必须放在构造器的首行                     | 调用父类构造器，必须放在子类构造器的首行 |

### 多态（polymorphism）

#### 多态简介

（1）多态可以理解为可以理解为一个事物的多种形态，在父类中定义的属性和方法被子类继承之后，可以具有不同的数据类型或表现出不同的行为

（2）多态例子：打印机可以有黑白打印机与彩色打印机，他们都是打印机，但是打印的效果不同

（3）多态的好处：可以使程序有良好的扩展，并可以对所有类的对象进行通用处理

（4）多态性是运行时的行为，只适用于方法，不适用于属性

（5）对面向对象来说，多态分为编译时多态和运行时多态。

| 多态       | 简介                                                         |
| ---------- | ------------------------------------------------------------ |
| 编译时多态 | 静态的，主要是指方法的重载，是根据参数列表的不同来区分不同的方法。通过编译之后会变成两个不同的方法，在运行时谈不上多态 |
| 运行时多态 | 动态的，是通过动态绑定来实现的，也就是大家通常所说的多态性   |

#### 实现多态的条件

| 条件     | 简介                                                         |
| -------- | ------------------------------------------------------------ |
| 继承     | 必须要有子类继承父类的继承关系                               |
| 重写     | 子类对父类中的一些方法进行重写，然后调用方法时就会调用子类重写的方法，而不是原本父类的方法 |
| 向上转型 | 父类引用指向子类对象（`Animal animal = new Cat();`）。在多态中需要将子类的引用赋给父类对象，只有这样该引用才能做到，既能调用父类的方法，又能调用子类的方法 |



#### 代码示例

```java
public class Demo {
    public static void main(String[] args) {
        // 对象的多态性：父类的引用指向子类的对象
        Animal animal1 = new Cat();
        Animal animal2 = new Dog();

        // 多态的使用：当调用父类同名同参数的方法时，实际执行的是子类重写父类的方法（虚拟方法调用）
        animal1.eat();// 子类1吃饭
        animal2.eat();// 子类2吃饭

        // 对象的多态性只适用于方法，不适用于属性(静态绑定)
        System.out.println(animal1.id); //1001
        System.out.println(animal2.id); //1001
    }

}

// 父类
class Animal {
    int id = 1001;
    String name;

    // 父类方法
    public void eat() {

    }
}

// 子类1
class Cat extends Animal {
    int id = 1002;

    // 重写父类方法
    @Override
    public void eat() {
        System.out.println("子类1吃饭");
    }
}

// 子类2
class Dog extends Animal {
    int id = 1003;

    // 重写父类方法
    @Override
    public void eat() {
        System.out.println("子类2吃饭");
    }
}
```

#### 静态绑定和动态绑定

（1）上面例子中等号左边的内容表示父类的引用，该引用在栈内存中，指向了一块堆中的地址，而这个地址中存放的是其子类的对象。

（2）animal是Animal类型的一个引用，指向的是其子类Cat的对象，这个就叫做`父类引用指向子类对象`。

（3）程序在编译（javac）的时候animal被看做Animal类型，所以animal.eat()绑定的是Animal类中的eat()方法，这叫做`静态绑定`

（4）程序运行时，会在堆中开辟空间创建出对象，此时animal指向的是堆中的Cat对象，而在Cat中对eat()方法进行了重写，所以在运行阶段绑定的是Cat中的eat()方法，这叫做`动态绑定`

（5）有了对象的多态性以后，在编译期，只能**调用父类中声明的方法**，但在运行期间，**实际执行的是子类重写父类的方法**，提高了代码的通用性，常称作接口重用（编译，看左边，运行，看右边）

（6）代码示例

```java
public class Demo {
    public static void main(String[] args) {
        A b = new B();
        // 编译时，只能调用父类中声明的属性和方法, 子类特有的属性和方法不能调用
        // b.name;     //静态绑定
        // b.test();   //静态绑定
        b.eat();       //动态绑定，会打印子类重写父类方法

        //如何调用子类特有的属性和方法?
        //向下转型，使用强制类型转换符(可能出现ClassCastException的异常)
        B b1 = (B) b;
        b1.test(); // 会打印子类特有的方法
    }
}

// 父类A
class A {
    String name = "父类属性";

    public void eat() {
        System.out.println("父类方法");
    }
}

// 子类B
class B extends A {
    String name = "子类属性";

    @Override
    public void eat() {
        System.out.println("子类重写父类方法");
    }

    public void test() {
        System.out.println("子类特有的方法");
    }
}
```

#### 类型转换

| 类型转换     | 简介                                                         |
| ------------ | ------------------------------------------------------------ |
| 自动类型转换 | 小的数据类型可以自动转换成大的数据类型                       |
| 强制类型转换 | 可以把大的数据类型强制转换成小的数据类型，使用强制转换时，可能出现类型转换异常（ClassCastException） |

```java
public class Demo {
    public static void main(String[] args) {
        /**
         * 有了对象的多态性以后，内存中实际上是加载了子类特有的属性和方法的，
         * 但是由于变量声明为父类类型，导致编译时，只能调用父类中声明的属性和方法,子类特有的属性和方法不能调用
         * */

        Animal cat = new Cat();
        // cat.sleep(); // 不能调用子类中特有的方法、属性,编译时，cat是父类Animal类型
       
        // 调用子类特有的属性和方法需要向下转型，使用强制类型转换符()
        Cat cat1 = (Cat) cat;
        cat1.sleep(); // 子类睡觉
    }
}

// 父类
class Animal {
    int id = 1001;
    String name;

    // 父类方法
    public void eat() {

    }
}

// 子类
class Cat extends Animal {
    int id = 1002;

    // 重写父类方法
    @Override
    public void eat() {
        System.out.println("子类吃饭");
    }

    public void sleep() {
        System.out.println("子类睡觉");
    }
}
```



#### instanceof关键字

会判断引用指向的对象是否是该类型的，如果是则计算结果是true，否则结果是false

```java
/**
*  instanceof关键字的使用方式：a instanceof A
*  判断对象a是否是类A的实例，如果是，返回true：如果不是，返回false
*  使用情境：为了避免在向下转型时出现ClassCastException的异常,在向下转型之前，先进行instanceof的判断，
*  如果返回true就进行向下转型，如果返回false，不进行向下转型
*/
public class Demo {
    public static void main(String[] args) {
        Animal cat = new Cat();
        Animal dog = new Dog();

        // 如果cat是Cat类的实例，就执行强制类型转换
        if (cat instanceof Cat) {
            Cat c = (Cat) cat; // 强制类型转换
            c.sleep(); // 调用子类特有方法
        }
        // 如果cat是Dog类的实例，就执行强制类型转换
        if (cat instanceof Dog) {
            Cat c = (Cat) cat; // 强制类型转换
            c.sleep(); // 调用子类特有方法
        }
    }
}

// 父类
class Animal {
    int id = 1001;
    String name;

    // 父类方法
    public void eat() {

    }
}

// 子类1
class Cat extends Animal {
    int id = 1002;

    // 重写父类方法
    @Override
    public void eat() {
        System.out.println("子类1吃饭");
    }

    // 子类1特有方法
    public void sleep() {
        System.out.println("子类1睡觉");
    }
}

// 子类2
class Dog extends Animal {
    int id = 1003;

    // 重写父类方法
    @Override
    public void eat() {
        System.out.println("子类2吃饭");
    }

    // 子类2特有方法
    public void sleep() {
        System.out.println("子类2睡觉");
    }
}
```

## 关键字

### package关键字

#### 概念相关

（1）为了更好地对类进行统一的管理和划分，Java提供了包机制。使用package关键字来声明类或接口所属的包，声明在源文件的首行

（2）包的作用：解决类命名冲突的问题、控制访问权限、划分项目层次，便于管理

（3）语法格式

```java
// 声明在源文件的首行
package pkg1[．pkg2[．pkg3…]];
```

（4）Java 包的命名规则

```java
1、包名全部由小写字母（多个单词也全部小写）
2、如果包名包含多个层次，每个层次用“.”分割
3、包名一般由倒置的域名开头，比如 com.baidu，不要有 www
4、自定义包不能 java 开头
```

（5）如果在源文件中没有定义包，那么类、接口、枚举和注释类型文件将会被放进一个无名的包中，也称为默认包。在实际企业开发中，通常不会把类定义在默认包下

#### 包导入（import）

（1）如果使用不同包中的其它类，需要使用该类的全名（包名+类名）

```java
// com.wen为包名，Test为包下的类
com.wen.Test() test = new com.wen.Test();
```

（2）为了简化编程，Java 引入了 `import` 关键字，用于导入指定包层次下的某个类或全部类，语法如下

```java
// 导入某个包下的某个类
import 包名.类名;
// 导入某个包下的所有类
import 包名.*;
```

注意：使用星号（*）可能会增加编译时间，特别是引入多个大包时，所以明确的导入你想要用到的类是一个好方法，需要注意的是使用星号对运行时间和类的大小没有影响

（3）import 语句位于 package 语句之后，类定义之前。一个 Java 源文件只能包含一个 package 语句，但可以包含多个 import 语句

（4）Java 默认为所有源文件导入 java.lang 包下的所有类，因此前面在 Java 程序中使用 String、System 类时都无须使用 import 语句来导入这些类

#### 系统包

Java SE 提供了一些系统包，其中包含了 Java 开发中常用的基础类

| 包        | 简介                                                         |
| --------- | ------------------------------------------------------------ |
| java.lang | 包含一些Java语言的核心类，如String、Math、Integer、  System和 Thread，提供常用功能 |
| java.net  | 包含执行与网络相关的操作的类和接口                           |
| java.io   | 包含能提供多种输入/输出功能的类                              |
| java.util | 包含一些实用工具类，如定义系统特性、接口的集合框架类、使用与日期日历相关的函数 |
| java.text | 包含了一些java格式化相关的类                                 |
| java.sql  | 包含了Java进行JDBC数据库编程的相关类/接口                    |
| java.awt  | 包含了构成抽象窗口工具集的多个类，这些类被用来构建和管理应用程序的图形用户界面（GUI） |

#### Jar包

（1）Java中的jar包就是java类在编译生成class文件后，进行打包的压缩包，jar包里面就是.class文件

（2）因为jar包主要是对class文件进行打包，而java编译生成的class文件是平台无关的，这就意味着`jar包是跨平台的`，所以不必关心涉及具体平台的问题

（3）将一个类打为 jar 包的语法

```java
// （1）编译
javac -d . 类名.java
// （2）打jar包，生成名叫myjar.jar的文件，参数c参数创建，参数v参数显示创建过程文件的详细信息
jar -cvf myjar.jar cn
```

（4）查看 jar 文件内容列表

```java
// 参数t表示显示列表，参数v表示显示文件的详细信息
jar -tvf myjar.jar
```

（5）解压 jar 文件

```java
jar xvf myjar.jar
```

（6）运行jar文件

```java
java -jar myjar.jar
```

（7）jar是一种基于ZIP压缩格式的文件，除了扩展名和zip不一样之外，可以认为一个jar文件和一个zip文件是完全一样的，因此二者仅仅是后缀名称的区别而已，也就是说将文件压缩为`zip`格式，通过`java -jar`也可以运行



### static关键字（静态）

（1）static关键字可以用来修饰属性、方法、代码块、内部类。被static关键字修饰的成员变量、方法可以被类直接访问，而不需要预先构造类的实例化对象

（2）静态方法`不能被重写`，虽然写出重写的代码是可以看到重写的效果，但是加入@Override注解会报错，因此静态方法不能被重写

（3）静态方法中，`不能使用this关键字、super关键字`

（4）静态方法中`不能直接访问实例方法和实例变量`，后面两者是跟对象有关的。

（5）静态变量或静态方法随着类的加载而加载，调用方式如下

```java
// 调用静态变量
类名.静态变量
// 调用静态方法
类名.静态方法
```

（6）开发时如何选择

| 位置 | 简介                                 |
| ---- | ------------------------------------ |
| 属性 | 类中的常量也常常声明为static         |
| 方法 | 工具类中的方法，习惯上声明为static的 |

```java
public class XxxUtil {
    // 常量也常常声明为static
    private static final String XXX_ID = "XXX_ID";
    
    // 工具类中的方法，习惯上声明为static的
    public static String get() {
        returb null;
    }
 	
    // 工具类中的方法，习惯上声明为static的
    public static void set(String value) {
        
    }
}
```

### final关键字（最终）

final可以用来修饰的结构：类、方法、变量

| 修饰位置 | 简介                                                         |
| -------- | ------------------------------------------------------------ |
| 修饰类   | 此类不能被其他类继承，例如String类、System类、StringBuffer   |
| 修饰方法 | 表明此方法不可以被重写，例如Object类中getClass方法           |
| 修饰变量 | final修饰的局部变量，一旦赋值，不可再改变，使用较少<br>final修饰的成员变量必须初始化值，在定义那些不常改变或者永恒不变数据的时候使用 |



### abstract关键字（抽象）

abstract关键字可以用来修饰的类、方法，修饰类称为抽象类，修饰方法称为抽象方法，抽象类和抽象方法不能被final关键字修饰

abstract关键字不能用来修饰属性、私有方法、静态方法、final的方法、final的类、构造器

#### 抽象类

（1）使用abstract关键字修饰的类称为抽象类，抽象类不能实例化（不能造对象）

```java
abstract class Test{…}
```

（2）抽象类中一定有构造器，便于子类对象实例化时调用，开发中，都会提供抽象类的子类，让子类对象实例化，完成相关的操作

（3）抽象类中的子类可以是抽象类，如果不是抽象类的话必须对抽象类中的抽象方法进行重写

#### 抽象方法

（1）使用abstract关键字修饰的方法称为抽象方法，抽象方法只有方法的声明，没有方法体

```java
public abstract void name();
```

（2）包含抽象方法的类，一定是一个抽象类，反之，抽象类中可以没有抽象方法的

（3）若子类重写了父类中的所有的抽象方法后，此子类可实例化

（4）若子类没有重写父类中的所有的抽象方法，此子类也是一个抽象类，需要用abstract修饰

 

### interface关键字（接口）

（1）在java语言里面使用`interface`来声明一个接口，接口其实是一个特殊的抽象类

（2）接口中的变量前面会被默认加上public static final的，即接口中没有变量，都是常量

（3）Java类可以实现多个接口，接口与接口之间可以继承，而且可以多继承

（4）接口案例

```java
public class Demo {
	public static void main(String[] args) {
		//创建电脑的对象
		Computer computer =new Computer();
		//创建U盘对象
		Flash flash=new Flash();
		//用电脑的对象调用方法（传输数据）
		computer.transferDate(flash);
	}
}
//电脑
class Computer{
	//传输数据
	public void transferDate(USB usb) {
		//开启usb接口
		usb.start();
		//具体细节（略）
		System.out.println("具体传输数据的细节");
		//关闭usb接口
		usb.stop();
	}
}
//接口,usb
interface USB{
	//定义常量(略)：定义了长、宽、最大最小的传输速度等
	//定义方法：开启
	void start();
	//定义方法：关闭
	void stop();
}
//实现接口，U盘
class Flash implements USB{
	@Override
	public void start() {
		System.out.println("U盘开启工作");
	}
	@Override
	public void stop() {
		System.out.println("U盘结束工作");
	}
}
//实现接口，打印机
class Printer implements USB{
	@Override
	public void start() {
		System.out.println("打印机开启工作");
	}
	@Override
	public void stop() {
		System.out.println("打印机结束工作");
	}
}
```

（5）接口应用：代理模式

```java
public class Demo {
	public static void main(String[] args) {
		Server server=new Server();
		ProxyServer proxyServer=new ProxyServer(server);
		proxyServer.browse();
	}
}
//接口
interface NetWork{
	public void browse();
}
//实现(被代理类)
class Server implements NetWork{
	@Override
	public void browse() {
		System.out.println("真实的服务器访问网络");
	}
}
//实现(代理类)
class ProxyServer implements NetWork{
	private NetWork work;
	//构造器
	public ProxyServer(NetWork work) {
		this.work=work;
	}
	//方法
	public void check() {
		System.out.println("联网之前的检查工作");
	}
	@Override
	public void browse() {
		check();
		
		work.browse();
	}
}
```

### native关键字

Java源码中有的方法是native修饰的，表示该方法是调用其他语言编写的实现。

native关键字的出现主要是由于某些层次使用Java语言不易编写或效率不高，此时可以使用其他语言实现，然后再通过Java来进行调用。

