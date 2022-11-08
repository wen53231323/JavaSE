## System类

（1）System类代表系统，位于java.lang包，系统级的很多属性和控制方法都放置在该类的内部。 

（2）由于该类的构造器是private的，所以无法创建该类的对象，也就是无法实例化该类。其内部的成员变量和成员方法都是static的，所以也可以很方便的进行调用

（3）System类内部包含in、out和err三个成员变量，分别代表标准输入流（键盘输入），标准输出流（显示器）和标准错误输出流（显示器）。

（4）成员方法

| 方法                    | 简介                                                         |
| ----------------------- | ------------------------------------------------------------ |
| currentTimeMillis()     | 返回当前的计算机时间                                         |
| exit(int status)        | 退出程序，其中status的值为0代表正常退出，非零代表异常退出。使用该方法可以在图形界面编程中实现程序的退出功能等。 |
| gc()                    | 请求系统进行垃圾回收                                         |
| getProperty(String key) | 获得系统中属性名为key的属性对应的值                          |

（5）示例代码

```java
// java运行时的环境版本
String javaVersion = System.getProperty("java.version");
System.out.println(javaVersion);
// java的安装目录
String javaHome = System.getProperty("java.home");
System.out.println(javaHome);
// 操作系统的名称
String osName = System.getProperty("os.name");
System.out.println(osName);
// 操作系统的版本
String osVersion = System.getProperty("os.version");
System.out.println(osVersion);
// 用户的账户名称
String userName = System.getProperty("user.name");
System.out.println(userName);
// 用户的主目录
String userHome = System.getProperty("user.home");
System.out.println(userHome);
// 用户的当前工作目录
String userDir = System.getProperty("user.dir");
System.out.println(userDir);
```

## Math类

（1）java.lang.Math提供了一系列静态方法用于科学计算，其方法的参数和返回 值类型一般为double型

| 方法                       | 简介                                  |
| -------------------------- | ------------------------------------- |
| abs                        | 绝对值                                |
| acos,asin,atan,cos,sin,tan | 三角函数                              |
| sqrt                       | 平方根                                |
| pow(double a,doble b)      | a的b次幂                              |
| log                        | 自然对数                              |
| exp                        | e为底指数                             |
| max(double a,double  b)    | 最大数                                |
| min(double a,double  b)    | 最小数                                |
| random()                   | 返回0.0到1.0的随机数                  |
| long round(double a)       | double型数据a转换为long型（四舍五入） |
| toDegrees(double  angrad)  | 弧度—>角度                            |
| toRadians(double  angdeg)  | 角度—>弧度                            |

（2）代码示例

```java
System.out.println(Math.max(10,2));//获得最大值
System.out.println(Math.min(10, 5));//获得最小值
System.out.println(Math.abs(-20));//获得绝对值
System.out.println(Math.random());//生成0-1的随机数
```

## Random类

（1）Random类是专门用来生成随机数的，Math.random()底层调用的就是Random的nextDouble0方法

（2）代码示例

```java
Random random = new Random();
System.out.println(random.nextInt(100));//获取100以内的随机整数
System.out.println(random.nextFloat());//获取浮点随机
```

## Object类

### Object类简介

（1）Object类是所有Java类的根父类，如果在类的声明中未使用extends关键字指明其父类，则默认父类为java.lang.Object类，也就是说子类可以使用 Object 的所有方法。

```java
public class Person { 
	... 
} 
// 等价于 
public class Person extends Object {
	 ... 
} 
```

（2）Object类的方法

| 方法                          | 简介                                                         |
| ----------------------------- | ------------------------------------------------------------ |
| `getClass()`                  | 获取对象的运行时 class 对象，class 对象就是描述对象所属类的对象，是一个final 方法  通常是和 Java 反射机制搭配使用的 |
| hashCode()                    | 获取对象的散列值。Object  中该方法默认返回的是对象的堆内存地址。 |
| `equals(Object obj)`          | 比较两个对象，如果这两个对象引用指向的是同一个对象，那么返回 true，否则返回 false。<br>一般 equals 和 == 是不一样的，但是在 Object  中两者是一样的，子类一般都要重写这个方法。 |
| `toString()`                  | 返回一个 String 对象，一般子类都有覆盖。  <br>默认返回格式如下：对象的 class 名称 + @ + hashCode 的十六进制字符串。 |
| clone()                       | 保护方法，实现对象的浅复制，默认的 clone 方法是浅拷贝。  <br>只有实现了 Cloneable 接口才可以调用该方法，否则抛出  CloneNotSupportedException 异常。<br>所谓浅拷贝，指的是对象内属性引用的对象只会拷贝引用地址，而不会将引用的对象重新分配内存。  <br>深拷贝则是会连引用的对象也重新创建。 |
| notify()                      | 主要用于唤醒在该对象上等待的某个线程，是一个final 方法       |
| notifyAll()                   | 主要用于唤醒在该对象上等待的所有线程，是一个final 方法       |
| wait(long timeout)            | wait 方法就是使当前线程等待该对象的锁，当前线程必须是该对象的拥有者，也就是具有该对象的锁。<br>wait() 方法一直等待，直到获得锁或者被中断。<br>wait(long timeout)  设定一个超时间隔，如果在规定时间内没有获得锁就返回。 |
| wait(long timeout, int nanos) | 该方法导致当前线程等待，直到其他线程调用此对象的  notify() 方法或notifyAll()方法，或在指定已经过去的时间。  此方法类似于 wait  方法的一个参数，但它允许更好地控制的时间等待一个通知放弃之前的量。  实时量，以毫微秒计算，计算公式如下：1000000 * timeout + nanos  在所有其他方面，这种方法与 wait(long  timeout) 做同样的事情。特别是 wait(0, 0) 表示和 wait(0) 相同。  <br>参数说明  timeout：最大等待时间（毫秒）  nanos：附加时间在毫秒范围（0-999999） |
| wait()                        | 可以看到 wait() 方法实际上调用的是 wait(long timeout) 方法，只不过  timeout 为 0，即不等待 |
| finalize()                    | 该方法是保护方法，Jdk9中废弃，主要用于在 GC 的时候再次被调用，  如果我们实现了这个方法，对象可能在这个方法中再次复活，从而避免被  GC 回收 |

### Object中的toString()方法

（1）当我们输出一个对象的引用时，实际上就是调用当前对象的tostring()

```java
// 创建一个Person对象
Person person=new Person();
// 输出Person对象的引用
System.out.println(person); // xxx.Student@4ee285c6
// 实际默认调用了toString()方法
System.out.println(person.toString()); // xxx.Student@4ee285c6
```

（2）Object中定义的toString方法

```java
// toString()方法在Object类中定义，其返回值是String类型，返回类名和它的引用地址
public String toString() {
	return getClass().getName() + "@" + Integer.toHexString(hashCode());
}
```

（3）像String、Data、file、包装类等都重写了Object类中的toString()方法，使得在调用对象的toString()时，返回“实体内容信息”

```java
// String类中的toString()方法
public String toString() {
	return this;
}
```

（4）在现实的开发过程中，Object中的toString方法是要被重写的，当调用此方法时，返回"实体内容"信息，如果没有重写，那么在打印一个引用数据类型的时候，会调用Object中的toString方法

```java
class Person{
    private String name;
    private int age;
    
    // 重写toString方法
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```

### Object中的equals()方法

（1）Object中equals()方法用来比较对象的引用地址是否相同，源码如下

```java
public boolean equals(Object obj) {
	return (this == obj);
}
```

（2）像String、Data、File、包装类等都重写了Object类中的equals()方法，调用时是比较的是内容是否一致而不是地址一致

```java
// String类中的equals()方法
public boolean equals(Object anObject) {
	// 判断是否为同一个值，如X=X
    if (this == anObject) {
		return true;
	}
    // 判断是否为String对象
	if (anObject instanceof String) {
		String anotherString = (String)anObject;
		// 此处value是String类中定义的当前调用此方法的String转换成的char数组 
        int n = value.length;
		// 判断调用String的char数组和比较String的char数组长度是否一致
        if (n == anotherString.value.length) {
			char v1[] = value;
			char v2[] = anotherString.value;
			int i = 0;
			// 循环判断每个字符是否一致
            while (n-- != 0) {
				if (v1[i] != v2[i])
					return false;
					i++;
			}
			return true;
		}
	}
	return false;
}
```

（3）Object中的equals方法使用的是==进行的比较，实际上是比较的两个对象的内存地址是否相同，在现实的开发过程中，如果希望比较两个对象中的属性值是否一致时，要重写equals()方法

```java
class Person{
    private String name;
    private int age;
    
    // 重写equals()方法
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }
}
```

（4）面试题：==和equals()的区别？

| 对比     | 简介                                                         |
| -------- | ------------------------------------------------------------ |
| ==       | 是一个运算符，用于对内存地址进行比较，比较的是变量(栈)内存中存放的对象的(堆)内存地址 |
| equals() | 是一个方法，如果没有重写Object中的equals方法，源码中是使用==进行的比较，比较的两个对象的内存地址<br>一般都会重写equals()方法，使equals方法比较两个对象中的属性值是否一致时 |

### Object中的getClass()方法

（1）Object中的getClass()方法用于获取对象的运行时对象的类，方法的返回值是Class类型

```java
public final native Class<?> getClass();
```

（2）万物皆对象，JVM会将字节码文件加载到其内部一个叫做方法区的地方，然后会在堆中创建这个字节码文件对应的对象，这个对象是java.lang.Class类型的，在JVM中每个字节码文件只有一个对应的Class对象，可以通过Object中提供的getClass方法来获取这个对象。

```java
Object obj = new Object();
Class<?> clazz = obj.getClass();
```

（3）`Class clazz = obj.getClass();`根据clazz可以获取该对象的所有成员方法、成员方法等

```java
/**
 * 打印类的信息，包括类的构造函数，成员函数，成员变量
 */
public class ClassUtil {

    /**
     * 获取对象的成员方法的信息
     */
    public static void printClassMethodMessage(Object obj) {
        // 要获取类的信息 首先要获取类的类类型,传递的是哪个子类的对象 c就是该子类的类类型
        Class clazz = obj.getClass();
        // 获取类的名称
        System.out.println("类的名称是:" + clazz.getName());
        // Method类，方法对象 一个成员方法就是一个Method对象
        // getDeclaredMethods()获取的是所有该类自己声明的方法，不包括访问权限
        Method[] declaredMethods = clazz.getDeclaredMethods();
        // getMethods()方法获取的是所有的public的函数，包括父类继承而来的
        Method[] ms = clazz.getMethods();
        for (int i = 0; i < ms.length; i++) {
            // 得到方法的返回值类型的类类型
            Class returnType = ms[i].getReturnType();
            System.out.print(returnType.getName() + " ");
            // 得到方法的名称
            System.out.print(ms[i].getName() + "(");
            // 获取参数类型--->得到的是参数列表的类型的类类型
            Class[] paramTypes = ms[i].getParameterTypes();
            for (Class class1 : paramTypes) {
                System.out.print(class1.getName() + ",");
            }
            System.out.println(")");
        }
    }

    /**
     * 获取对象的成员变量的信息
     */
    public static void printFieldMessage(Object obj) {
        Class clazz = obj.getClass();
        // 成员变量也是对象 java.lang.reflect.Field Field类封装了关于成员变量的操作
        // getFields()方法获取的是所有的public的成员变量的信息
        Field[] fields = clazz.getFields();
        // getDeclaredFields获取的是该类自己声明的成员变量的信息
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            // 得到成员变量的类型的类类型
            Class fieldType = field.getType();
            String typeName = fieldType.getName();
            // 得到成员变量的名称
            String fieldName = field.getName();
            System.out.println(typeName + " " + fieldName);
        }
    }

    /**
     * 打印对象的构造函数的信息
     */
    public static void printConMessage(Object obj) {
        Class clazz = obj.getClass();
        // 构造函数也是对象 java.lang.Constructor中封装了构造函数的信息
        Constructor[] constructors = clazz.getConstructors();
        // getConstructors获取所有的public的构造函数 getDeclaredConstructors得到所有的构造函数
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : declaredConstructors) {
            System.out.print(constructor.getName() + "(");
            // 获取构造函数的参数列表--->得到的是参数列表的类类型
            Class[] paramTypes = constructor.getParameterTypes();
            for (Class class1 : paramTypes) {
                System.out.print(class1.getName() + ",");
            }
            System.out.println(")");
        }
    }
}
```

## 字符串类

String类、StringBuilder类、StringBuffer类是三个字符串相关类。

String类的对象代表不可变的字符序列，StringBuilder类和StringBuffer类代表可变字符序列

（1）String与StringBuffer的区别？

```
String是不可变字符序列，存储在字符串常量池中，内容无法修改
StringBuffer的底层是字符数组，系统会对该数组进行扩容，内容可以修改
频繁修改字符串的情况考虑使用StingBuffer
```

（2）StringBuilder和StringBuffer的区别

```
StringBuffer在jdk1.0版本加入，采用同步处理，是线程安全的，效率低
StringBuffer在jdk5.0版本加入，采用异步处理，是线程不安全的，效率高
```

（3）对于String、StringBuffer、StringBuffer三者使用的总结

```java
1、如果要操作少量的数据用 String
2、单线程操作字符串缓冲区下操作大量数据 StringBuilder
3、多线程操作字符串缓冲区下操作大量数据 StringBuffer
```

### String类

（1）在操作String类之前，首先需要对String类进行初始化，可以通过常量直接赋值对String类进行初始化，或者使用String的构造方法来初始化字符串对象

| 构造方法               | 功能描述                     |
| ---------------------- | ---------------------------- |
| String（）             | 创建一个内容为空的字符串     |
| String（char[] value） | 根据指定的字符数组创建对象   |
| String（String value） | 根据指定的字符串内容创建对象 |

```java
// 1、使用字符串常量直接初始化一个String对象
String str1="abc";

// 2、使用String的构造方法初始化字符串对象
String str1=new String();// 创建一个空的字符串
String str2=new String ("小明");//创建字符串"小明"
char[] charArray=new char[]{'A','B','C'};
String str3=new String(charArray);//创建一个内容为字符数组的字符串
```

（2）String是引用数据类型，通过源码可以看到String类前面加了final修饰，因此String类是不能够被继承的。将其设置为不能被继承的原因是为了减少歧义

```java
public final class String implements java.io.Serializable, Comparable<String>, CharSequence {...}
```

（3）String创建好之后值是不可以被改变的，这里指的是在堆中的字符串的值是不可以被改变，不可变的主要原因是其底层使用了一个final修饰的char字符数组（Jdk8中）。在Jdk9之后版本中，String底层使用的是final修饰的byte字节数组

```java
public class StringTest {
    public static void main(String[] args) {
        String str = "小明";
        change(str); // 修改为:小刚
        System.out.println(str); // 小明
    }

    public static void change(String str) {
        str = "小刚";
        System.out.println("修改为:" + str);
    }
}
```

（3）String类常用方法

| 方法                                                         | 简介                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| int length()                                                 | 返回字符串的长度： return  value.length                      |
| char charAt(int  index)                                      | 返回某索引处的字符：return  value[index]                     |
| boolean isEmpty()                                            | 判断是否是空字符串：return  value.length == 0                |
| String toLowerCase()                                         | 使用默认语言环境，将 String  中的所有字符转换为小写          |
| String toUpperCase()                                         | 使用默认语言环境，将 String  中的所有字符转换为大写          |
| String trim()                                                | 返回字符串的副本，忽略前导空白和尾部空白                     |
| boolean equals(Object  obj)                                  | 比较字符串的内容是否相同                                     |
| boolean  equalsIgnoreCase(String anotherString)              | 与equals方法类似，忽略大 小写                                |
| String concat(String  str)                                   | 将指定字符串连接到此字符串的结尾，等价于用“+”                |
| int compareTo(String  anotherString)                         | 比较两个字符串的大小                                         |
| String substring(int  beginIndex)                            | 返回一个新的字符串，它是此字符串的从  beginIndex开始截取到最后的一个子字符串。 |
| String substring(int  beginIndex, int endIndex)              | 返回一个新字符串，它是此字符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。 |
| boolean  endsWith(String suffix)                             | 测试此字符串是否以指定的后缀结束                             |
| boolean  startsWith(String prefix)                           | 测试此字符串是否以指定的前缀开始                             |
| boolean  startsWith(String prefix, int toffset)              | 测试此字符串从指定索引开始的  子字符串是否以指定前缀开始     |
| boolean  contains(CharSequence s)                            | 当且仅当此字符串包含指定的 char  值序列 时，返回 true        |
| int indexOf(String  str)：                                   | 返回指定子字符串在此字符串中第一次出现处的索引               |
| int indexOf(String  str, int fromIndex)                      | 返回指定子字符串在此字符串中第一次出  现处的索引，从指定的索引开始 |
| int  lastIndexOf(String str)                                 | 返回指定子字符串在此字符串中最右边出现处的索引               |
| int  lastIndexOf(String str, int fromIndex)                  | 返回指定子字符串在此字符串中最后  一次出现处的索引，从指定的索引开始反向搜索（注：indexOf和lastIndexOf方法如果未找到都是返回-1） |
| String replace(char  oldChar, char newChar)                  | 返回一个新的字符串，它是 通过用  newChar 替换此字符串中出现的所有 oldChar 得到的。 |
| String  replace(CharSequence target, CharSequence replacement) | 使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。 |
| String  replaceAll(String regex, String replacement)         | 使用给定的 replacement  替换此字符串所有匹配给定的正则表达式的子字符串。 |
| String  replaceFirst(String regex, String replacement)       | 使用给定的 replacement  替换此字符串匹配给定的正则表达式的第一个子字符串。 |
| boolean  matches(String regex)                               | 告知此字符串是否匹配给定的正则表达式                         |
| String[] split(String  regex)                                | 根据给定正则表达式的匹配拆分此字符串。                       |
| String[] split(String  regex, int limit)                     | 根据匹配给定的正则表达式来拆分此  字符串，最多不超过limit个，如果超过了，剩下的全部都放到最后一个元素中。 |

### StringBuffer类

（1）由于字符串是常量，因此一旦创建，其内容和长度是不可改变的。如果需要对一个字符串进行修改，则只能创建新的字符串。为了便于对字符串的修改，JDK中提供了一个StringBuffer类(也称字符串缓冲区)，与String类最大的区别在于StringBuffer的内容和长度都是可以改变的。

（2）StringBuffer 类提供了 3 个构造方法来创建一个字符串

| 构造方法                 | 功能描述                                                     |
| ------------------------ | ------------------------------------------------------------ |
| StringBuffer()           | 构造一个空的字符串缓冲区，并且初始化为 16 个字符的容量       |
| StringBuffer(int length) | 创建一个空的字符串缓冲区，并且初始化为指定长度 length 的容量 |
| StringBuffer(String str) | 创建一个字符串缓冲区，并将其内容初始化为指定的字符串内容 str，字符串缓冲区的初始容量为 16 加上字符串 str 的长度 |

（3）StringBuffer工作原理

```java
StringBuffer的底层是char字符数组（Jdk8），Jdk9之后底层是byte字节数组。
如果没有明确设定，则系统会默认创建一个长度为16的char字符类型数组，
在添加字符时，如果数组容量不够了，则会通过数组的拷贝对数组进行扩容，并不会产生新的Stringuffer 对象，
使用StringBuffer时最好预测并手动初始化长度，这样能够减少数组的拷贝，从而提高效率。
```

（4）StringBuffer是线程安全的，在多线程程序中也可以很方便的进行使用，但是程序的执行效率相对来说就要稍微慢一些

（5）String与StringBuffer的区别？

```
String是不可变字符序列，存储在字符串常量池中，内容无法修改
StringBuffer的底层是字符数组，系统会对该数组进行扩容，内容可以修改
频繁修改字符串的情况考虑使用StingBuffer
```

（5）StringBuffer类的常用方法

| 常用方法                                | 简介                                                         |
| --------------------------------------- | ------------------------------------------------------------ |
| append(xxx)                             | 提供了很多的append()方法，用于进行字符串拼接（增）           |
| delete(int start,int end)               | 删除指定位置的内容（删）                                     |
| deleteCharAt(int index)                 | 移除序列中指定位置的字符（删）                               |
| replace(int start, int end, String str) | 把[start,end)位置替换为str  StringBuffer insert(int offset, xxx)：在指定位置插入xxx（改） |
| insert(int offset,  xxx)                | 在指定位置插入xxx（改）                                      |
| reverse()                               | 反转，把当前字符序列逆转                                     |
| charAt(int n )                          | 查                                                           |
| setCharAt(int n ,char ch)               | 替换字符，用于在字符串的指定索引位置替换一个字符（改）       |
| length()                                | 长度                                                         |

### StringBuilder类

（1）StringBuilder 和 StringBuffer 非常类似，均代表可变的字符序列，通过API可以看到提供相关功能的方法也一样 

（2）StringBuilder和StringBuffer的区别

```
StringBuffer在jdk1.0版本加入，采用同步处理，是线程安全的，效率低
StringBuffer在jdk5.0版本加入，采用异步处理，是线程不安全的，效率高
```

（3）对于String、StringBuffer、StringBuffer三者使用的总结

```java
1、如果要操作少量的数据用 String
2、单线程操作字符串缓冲区下操作大量数据 StringBuilder
3、多线程操作字符串缓冲区下操作大量数据 StringBuffer
```

## 包装类

### 包装类分类

Java是一个面向对象的编程语言，但是Java中的八种基本数据类型却是不面向对象的，于是Java提供了8种基本数据类型对应的包装类（封装类），使得基本数据类型的变量具有类的特征。有了类的特点，就可以调用类中的方法，Java才是真正的面向对象。除了Integer和Character类以外，其它六个类的类名和基本数据类型一致，只是类名的第一个字母大写即可

| 基本数据类型 | 包装类    |
| ------------ | --------- |
| byte         | Byte      |
| short        | Short     |
| char         | Character |
| int          | Integer   |
| long         | Long      |
| float        | Float     |
| double       | Double    |
| boolean      | Boolean   |

### 包装类的自动拆装箱机制

| 机制     | 简介                                                         |
| -------- | ------------------------------------------------------------ |
| 自动装箱 | 基本数据类型-->包装类<br>将 基本数据类型 封装为对象类型，来符合java的面向对象的思想。 |
| 自动拆箱 | 包装类-->基本数据类型<br>是指包装类对象赋给一个相对应基本数据类型的变量 |

（1）基本数据类型-->包装类（装箱）

```java
// 通过包装类的构造器实现
int num = 500; 
Integer newNum = new Integer(num);
// 通过Integer类提供的values静态方法
Integer num = Integer.values(0);
// 自动装箱
int a = 13;
Integer b = a;
boolean c = true;
Boolean d = c;
```

（2）包装类-->基本数据类型（拆箱）

```java
// 调用包装类的.xxxValue()方法
Integer a = new Integer(12);
int b = a.intValue();
// 自动拆箱
Integer a = 13;
int b = a;
```

（3）基本数据类型、包装类-->字符串（装箱）

```java
// 调用字符串重载的valueOf()方法
String str = String.valueOf(1.23f);
// 连接运算
String intStr = 5 + "";
```

（4）字符串-->基本数据类型（拆箱）

```java
// 通过包装类的构造器实现
int i = new Integer("123");
// 通过包装类的parseXxx(String s)静态方法
int num = Integer.parseInt("123");
```

### Java包装类型的缓存机制

（1）Java 包装类的缓存机制，是在Java 5中引入的一个有助于节省内存、提高性能的功能

（2）Java 基本类型除了Float 和 Double 外，其他包装数据类型都使用了缓存机制来提升性能

（3）缓存机制实现方式是在类初始化时，提前创建好会频繁使用的包装类对象，当需要使用某个包装类的对象时，如果该对象包装的值在缓存的范围内，就返回缓存的对象，否则就创建新的对象并返回。

（4）缓存机制只有在自动装箱时有效，使用构造函数创建对象不适用，因为每次new会创建新的对象

（5）自动装箱会从缓存池中取对象，两种浮点数类型的包装类`Float`,`Double`并没有实现常量池技术，在其他包装类中，包装类`Byte`,`Short`,`Integer`,`Long` 默认创建了区间为 [-128, 127] 的缓存池缓存数据，包装类`Character` 创建了区间在 **[0,127]** 范围的缓存池缓存数据，包装类`Boolean` 直接返回 `True` or `False`。缓存的基本数据类型值的范围如下

| 基本数据类型 | 包装类    | 缓存范围    |
| ------------ | --------- | ----------- |
| byte         | Byte      | [-128, 127] |
| short        | Short     | [-128, 127] |
| char         | Character | [0,127]     |
| int          | Integer   | [-128, 127] |
| long         | Long      | [-128, 127] |
| float        | Float     | 无          |
| double       | Double    | 无          |
| boolean      | Boolean   | True、False |

（6）包装类缓存原理：使用自动装箱将基本类型转为封装类对象这个过程其实底层实现是调用封装类的valueOf方法

```java
// Integer包装类中的valueOf(int i)方法
public static Integer valueOf(int i) {
    // 如果 IntegerCache.low <= i <= IntegerCache.high，就从IntegerCache中获取对象，否则创建一个新的Integer对象
	if (i >= IntegerCache.low && i <= IntegerCache.high)
		return IntegerCache.cache[i + (-IntegerCache.low)];
	return new Integer(i);
}
```

IntegerCache是Integer类中定义的一个`private static`的内部类

```java
private static class IntegerCache {
	static final int low = -128;
	static final int high;
	static final Integer cache[];

	static {
		// high value may be configured by property（高值可以通过属性配置）
		int h = 127;
		String integerCacheHighPropValue =
				sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
		if (integerCacheHighPropValue != null) {
			try {
				int i = parseInt(integerCacheHighPropValue);
				i = Math.max(i, 127);
				// Maximum array size is Integer.MAX_VALUE（最大数组大小为Integer.MAX_VALUE）
				h = Math.min(i, Integer.MAX_VALUE - (-low) -1);
			} catch( NumberFormatException nfe) {
				// If the property cannot be parsed into an int, ignore it.（若该属性不能被解析为int类型，则忽略）
			}
		}
		high = h;

		cache = new Integer[(high - low) + 1];
		int j = low;
		for(int k = 0; k < cache.length; k++)
			cache[k] = new Integer(j++);

		// range [-128, 127] must be interned (JLS7 5.1.7)
		assert Integer.IntegerCache.high >= 127;
	}

	private IntegerCache() {}
}
```

## BigInteger和BigDecimal类

### BigInteger类

（1）Integer包装类能存储的最大值是有限的。如果要表示再大的整数，不管是基本数据类型还是包装类都无能为力，更不用说运算了。 

（2）java.math包下的BigInteger可以表示不可变的任意精度的整数，可以对超过Integer范围内的数据进行运算。

（3）BigInteger 提供所有 Java 的基本整数操作符的对应物，并提供 java.lang.Math 的所有相关方法。 

（4）BigInteger 还提供以下运算：模算术、GCD 计算、质数测试、素数生成、 位操作以及一些其他操作。

（5）成员方法

| 方法                               | 简介                                                   |
| ---------------------------------- | ------------------------------------------------------ |
| add(BigInteger val)                | 加法                                                   |
| subtract(BigInteger val)           | 减法                                                   |
| multiply(BigInteger val)           | 乘法                                                   |
| divide(BigInteger val)             | 除法                                                   |
| divideAndRemainder(BigInteger val) | 带余除法，返回两个BigInteger，第一个是商，第二个是余数 |
| pow(int exponet)                   | 进行取参数的 exponet 次方操作                          |
| negate()                           | 取相反数                                               |
| shiftLegt(int n)                   | 将数字左移 n 位，如果 n 为负数，做右移操作             |
| shiftRight(int n)                  | 将数字右移 n 位，如果 n 为负数，做左移操作             |
| compareTo(BigInteger val)          | 做数字比较操作                                         |
| max(BigInteger val)                | 返回较大的数值                                         |

### BigDecimal类

（1）一般的float类型和double可以用来做科学计算或工程计算，但由于在运算的时候，float类型和double很容易丢失精度，在商业计算中， 要求数字精度比较高，为了能精确的表示、计算浮点数，Java提供了BigDecimal类

（2）BigDecimal表示不可变的、任意精度的有符号十进制数，可以解决浮点型数据运算数据丢失问题，在金融行业可能会使用到该类

（3）成员方法

| 方法                                                    | 简介                                                         |
| ------------------------------------------------------- | ------------------------------------------------------------ |
| add(BigDecimal value);                                  | 加法                                                         |
| subtract(BigDecimal value);                             | 减法                                                         |
| multiply(BigDecimal value);                             | 乘法                                                         |
| divide(BigDecimal value);                               | 除法                                                         |
| divide(BigDecimal divisor, int scale, int roundingMode) | 第一参数表示除数， 第二个参数表示小数点后保留位数，第三个参数表示舍入模式，只有在作除法运算或四舍五入时才用到舍入模式 |

（4）舍入模式介绍

| 模式              | 简介                                                         |
| ----------------- | ------------------------------------------------------------ |
| ROUND_UP          | 向远离零的方向舍入。舍弃非零部分，并将非零舍弃部分相邻的一位数字加一 |
| ROUND_DOWN        | 向接近零的方向舍入。舍弃非零部分，同时不会非零舍弃部分相邻的一位数字加一，采取截取行为 |
| ROUND_CEILING     | 向正无穷的方向舍入。如果为正数，舍入结果同ROUND_UP一致；如果为负数，舍入结果同ROUND_DOWN一致。注意：此模式不会减少数值大小 |
| ROUND_FLOOR       | 向负无穷的方向舍入。如果为正数，舍入结果同ROUND_DOWN一致；如果为负数，舍入结果同ROUND_UP一致。注意：此模式不会增加数值大小 |
| ROUND_HALF_UP     | 四舍五入                                                     |
| ROUND_HALF_DOWN   | 五舍六入                                                     |
| ROUND_HALF_EVEN   | 向“最接近”的数字舍入，如果与两个相邻数字的距离相等，则相邻的偶数舍入。如果舍弃部分左边的数字奇数，则舍入行为与ROUND_HALF_UP相同，如果为偶数，则舍入行为与ROUND_HALF_DOWN相同。注意：在重复进行一系列计算时，此舍入模式可以将累加错误减到最小。此舍入模式也称为“银行家舍入法”，主要在美国使用。四舍六入，五分两种情况，如果前一位为奇数，则入位，否则舍去 |
| ROUND_UNNECESSARY | 断言请求的操作具有精确的结果，因此不需要舍入。如果对获得精确结果的操作指定此舍入模式，则抛出ArithmeticException |

## JDK8前日期时间类

System类提供的public static long currentTimeMillis()用来返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差。

```java
long time=System.currentTimeMillis();
System.out.println(time);
```

### Date类

（1）java.util.Date类

| 构造器          | 简介                                           |
| --------------- | ---------------------------------------------- |
| Date()          | 使用无参构造器创建的对象可以获取本地当前时间。 |
| Date(long date) | 创建指定毫秒数的Date对象                       |

```java
@Test
public void test() {
	Date date1 = new Date(); // 使用空参构造创建java.util.Date类对象，打印当前的时间
	System.out.println(date1.toString());
	System.out.println(date1.getTime()); // 把日期对象转换成对应的时间毫秒值
	System.out.println(date1.toLocaleString());// 根据本地格式转换日期对象

	Date date2 = new Date(123456L);// 使用有参构造创建java.util.Date类对象，把毫秒值转成日期对象
	System.out.println(date2.toString());
}
```

（2）java.sql.Date是java.util.Date类的子类，对应着数据库中的日期类型的变量

```java
@Test
public void test() {
    java.sql.Date date = new java.sql.Date(123456L);
    System.out.println(date);
}
```

### DateFormat类

（1）java.text.DateFormat 是日期/时间格式化子类的抽象类，通过这个类可以完成日期和文本之间的转换，也就是可以在Date对象与String对象之间进行来回转换

| 转换                   | 简介                                         |
| ---------------------- | -------------------------------------------- |
| 格式化（日期 -> 文本） | 按照指定的格式，从Date对象转换为String对象。 |
| 解析（文本-> 日期）    | 按照指定的格式，从String对象转换为Date对象。 |

（2）DateFormat类是一个抽象类，无法直接创建对象使用，可以使用DateFormat类的子类SimpleDateFormat

```java
@Test
public void test() throws ParseException {
	// 使用无参构造实例化SimpleDateFormat
	SimpleDateFormat dateFormat1 = new SimpleDateFormat();
	// 格式化：日期—>字符串
	String format1 = dateFormat1.format(new Date());
	System.out.println(format1);
	// 解析：字符串—>日期
	Date parse1 = dateFormat1.parse("20-1-6 下午1:00");
	System.out.println(parse1);

	// 使用无参构造实例化SimpleDateFormat，按照指定的方式格式化和解析
	SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	// 格式化：日期—>字符串
	String format2 = dateFormat2.format(new Date());
	System.out.println(format2);
	// 解析：字符串—>日期
	Date parse2 = dateFormat2.parse("2020-01-06 01:34:09");
	System.out.println(parse2);
}
```

### Calendar

（1）java.util.Calendar是日历类，在Date后出现，替换掉了许多Date的方法。该类是一个抽象基类，将所有可能用到的时间信息封装为静态成员变量，方便获取，主用用于完成日期字段之间相互操作的功能。 

（2）常用方法

| 常用方法                                        | 简介                                                         |
| ----------------------------------------------- | ------------------------------------------------------------ |
| public int get(int field)                       | 返回给定日历字段的值。                                       |
| public void set(int field, int value)           | 将给定的日历字段设置为给定值。                               |
| public abstract void add(int field, int amount) | 根据日历的规则，为给定的日历字段添加或减去指定的时间量。     |
| public Date getTime()                           | 返回一个表示此Calendar时间值（从历元到现在的毫秒偏移量）的Date对象。 |

（3）Calendar类中提供很多成员常量，代表给定的日历字段

| 字段值       | 含义                                  |
| ------------ | ------------------------------------- |
| YEAR         | 年                                    |
| MONTH        | 月（从0开始，可以+1使用               |
| DAY_OF_MONTH | 月中的天（几号）                      |
| HOUR         | 时（12小时制）                        |
| HOUR_OF_DAY  | 时（24小时制）                        |
| MINUTE       | 分                                    |
| SECOND       | 秒                                    |
| DAY_OF_WEEK  | 周中的天（周几，周日为1，可以-1使用） |

## JDK8后日期时间类

针对JDK8以前的日期类设计不足，比如不支持时区、线程不安全等，JDK8引入了java.time包来作为新的日期处理类

| 属性              | 含义                                 |
| ----------------- | ------------------------------------ |
| Instant           | 代表的是时间相当于Date               |
| LocalDate         | 代表日期,比如2022-01-14              |
| LocalTime         | 代表时间,比如12:20:30                |
| LocalDateTime     | 代表具体时间,比如2022-01-14 12:20:30 |
| ZonedDateTime     | 代表一个包含时区的完整的日期时间     |
| Period            | 代表时间段                           |
| ZoneOffset        | 代表时区偏移量,比如+8:00             |
| Clock             | 代表时钟,比如获取美国纽约的时间      |
| DateTimeFormatter | 日期和字符串格式转换                 |

### LocalDate、LocalTime、LocalDateTime 类

（1）常用方法

| 常用方法   | 描述                                         |
| ---------- | -------------------------------------------- |
| now()      | 获取当前的日期、时间、日期+时间              |
| of()       | 设置指定的年、月、日、时、分、秒。没有偏移量 |
| getXxx()   | 获取相关的属性                               |
| withXxx()  | 设置相关的属性                               |
| plusXxx()  | 增加相关的属性                               |
| minusXxx() | 减少相关的属性                               |

（2）示例代码

```java
//now()：获取当前的日期、时间、日期+时间
LocalDate time1 = LocalDate.now();
LocalTime time2 = LocalTime.now();
LocalDateTime time3 = LocalDateTime.now();

System.out.println(time1);
System.out.println(time2);
System.out.println(time3);

//of()：设置指定的年、月、日、时、分、秒。没有偏移量
LocalDateTime of = LocalDateTime.of(2022, 1, 6, 10, 10, 10);
System.out.println(of);

//getXxx()：获取相关的属性
System.out.println(time3.getDayOfMonth());
System.out.println(time3.getDayOfWeek());
System.out.println(time3.getMonth());
System.out.println(time3.getMonthValue());
System.out.println(time3.getMinute());

//withXxx()：设置相关的属性
LocalDateTime time4 = time3.withHour(22);
System.out.println(time3);
System.out.println(time4);

//plusXxx()：增加相关的属性
LocalDateTime time5 = time3.plusHours(5);
System.out.println(time3);
System.out.println(time5);

//minusXxx()：减少相关的属性
LocalDateTime time6 = time3.minusHours(5);
System.out.println(time3);
System.out.println(time5);
```

### Instant类

（1）时间线上的一个瞬时点。 这可能被用来记录应用程序中的事件时间戳。

（2）时间戳是指格林威治时间1970年01月01日00时00分00秒(北京时间1970年01月01 日08时00分00秒)起至现在的总秒数。 

（3）常用方法

| 常用方法       | 描述                                           |
| -------------- | ---------------------------------------------- |
| now()          | 获取本初子午线对应的标准时间                   |
| atOffset()     | 添加时间的偏移量                               |
| toEpochMilli() | 获取自1970年1月1日0时0分0秒（UTC）开始的毫秒数 |
| ofEpochMilli() | 通过给定的毫秒数，获取Instant示例              |

（4）代码示例

```java
//now()：获取本初子午线对应的标准时间
Instant time1 = Instant.now();
System.out.println(time1);

//atOffset()：添加时间的偏移量
OffsetDateTime time2 = time1.atOffset(ZoneOffset.ofHours(8));
System.out.println(time2);

//toEpochMilli()：获取自1970年1月1日0时0分0秒（UTC）开始的毫秒数
long time3 = time1.toEpochMilli();
System.out.println(time3);

//ofEpochMilli()：通过给定的毫秒数，获取Instant示例
Instant time4 = time1.ofEpochMilli(1641470139866L);
System.out.println(time4);
```

### DateTimeFormatter类

（1）用来格式化与解析日期或时间，类似SimpleDateFormat，不仅可以将日期、时间对象格式化成字符串，还能将特定格式的字符串解析成日期、时间对象

（2）获得DateTimeFormatter对象的方式

| 方式             | 简介                                                         |
| ---------------- | ------------------------------------------------------------ |
| 预定义的标准格式 | 使用静态常量创建DateTimeFormatter格式器，在DateTimeFormatter类中包含大量的静态常量，如BASIC_ISO_DATE、ISO_LOCAL_DATE、ISO_LOCAL_TIME等，通过这些静态常量都可以获取DateTimeFormatter实例 |
| 本地化相关的格式 | 使用不同风格的枚举值来创建DateTimeFormatter格式器，在FormatStyle类中定义了FULL、LONG、MEDIUM和SHORT四个枚举值，它们表示日期和时间的不同风 |
| 自定义的格式     | 根据模式字符串创建DateTimeFormatter格式器                    |

（3）代码示例

```java
@Test
public void test() {
    LocalDateTime date = LocalDateTime.now();
    //（1）使用常量创建DateTimeFormatter
    DateTimeFormatter dtf1 = DateTimeFormatter.ISO_DATE_TIME;
    System.out.println(dtf1.format(date));// 格式化：日期—>字符串
    TemporalAccessor parse1 = dtf1.parse("2020-01-06T20:13:08.006");//解析：字符串—>日期
    System.out.println(parse1);

    //（2）使用MEDIUM类型风格的DateTimeFormatter
    DateTimeFormatter dtf2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
    System.out.println(dtf2.format(date));// 格式化：日期—>字符串
    TemporalAccessor parse2 = dtf2.parse("2020-01-06T20:13:08.006");//解析：字符串—>日期
    System.out.println(parse2);

    //（3）根据模式字符串来创建DateTimeFormatter格式器
    DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm:ss");
    System.out.println(dtf3.format(date));
    TemporalAccessor parse3 = dtf3.parse("2020-01-06T20:13:08.006");//解析：字符串—>日期
    System.out.println(parse3);
}
```

## 枚举类（enum）

### 枚举类简介

（1）若类的对象只有有限个，确定的，我们称此类为枚举类，枚举是一个被命名的整型常数的集合，用于声明一组带标识符的常数

（2）枚举的作用是为了做信息的标志和信息的分类，当需要定义一组常量时，强烈建议使用枚举类

（3）如果枚举类中只有一个对象，则可以作为单例模式的实现方式

（4）和普通 Java 类一样，枚举类可以实现一个或多个接口，若每个枚举值在调用实现的接口方法呈现相同的行为方式，则只要统一实现该方法即可，若需要每个枚举值在调用实现的接口方法呈现出不同的行为方式，则可以让每个枚举值分别来实现该方法

（5）定义枚举类的两种方式

| 方式         | 简介                                     |
| ------------ | ---------------------------------------- |
| 自定义枚举类 | jdk5.0之前，自定义枚举类                 |
| enum关键字   | jdk5.0之后，可以使用enum关键字定义枚举类 |

（6）什么情况下使用枚举类？

有的时候一个类的对象是有限且固定的，这种情况下我们使用枚举类就比较方便

（7）为什么不用静态常量来替代枚举类呢？

枚举类更加直观，类型安全，使用常量会有缺陷

| 缺陷         | 简介                                                         |
| ------------ | ------------------------------------------------------------ |
| 类型不安全   | 若一个方法中要求传入季节这个参数，用常量的话，形参就是int类型，开发者传入任意类型的int类型值就行，但是如果是枚举类型的话，就只能传入枚举类中包含的对象 |
| 没有命名空间 | 开发者要在命名的时候以SEASON_开头，这样另外一个开发者再看这段代码的时候，才知道这四个常量分别代表季节 |

### 自定义枚举类

```java
public class Demo {
    public static void main(String[] args) {
        //自定义枚举类
        Student s1 = Student.s1;
        Student s2 = Student.s2;
        Student s3 = Student.s3;
        System.out.println(s1);// Student{id=1001, name='小明'}
        System.out.println(s2);// Student{id=1002, name='小红'}
        System.out.println(s3);// Student{id=1003, name='小刚'}
    }
}

//自定义枚举类
class Student {
    // 声明Student对象属性，private final修饰
    private final int id;
    private final String name;

    // 私有化的构造器，并给对象属性初始化
    private Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // 提供当前枚举类的多个对象，public static final修饰
    public static final Student s1 = new Student(1001, "小明");
    public static final Student s2 = new Student(1002, "小明");
    public static final Student s3 = new Student(1003, "小刚");

    // 获取枚举类对象的属性
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
```

### 使用enum关键字定义枚举类

（1）枚举类默认继承 java.lang.Enum 类，而不是 Object 类，因此枚举类不能显示继承其他父类，但所有枚举实例都可以调用 Enum 类的方法

| 方法名称            | 说明                                                         |
| ------------------- | ------------------------------------------------------------ |
| values()            | 返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值。 |
| valueOf(String str) | 返回枚举类中对象名是str的对象，如果没有str的枚举类对象，则抛异常：IllegalArgumentException。 |
| toString()          | 返回当前枚举类对象常量的名称                                 |
| compareTo()         | 比较两个枚举成员在定义时的顺序                               |
| ordinal()           | 获取枚举成员的索引位置                                       |

（2）枚举类对象必须在第一行声明，多个枚举类对象之间用","隔开，用";"结束

（3）枚举类中的属性，系统会自动添加 public static final 修饰

（4）枚举类的构造器只能使用 private 权限修饰符，系统会自动添加 privatel 修饰

（5）代码示例

```java
public class Demo {
    public static void main(String[] args) {
        EnumTest e1 = EnumTest.e1;
        EnumTest e2 = EnumTest.e2;
        EnumTest e3 = EnumTest.e3;
        System.out.println(e1);// EnumTest{id=1001, name='小明'}
        System.out.println(e2);// EnumTest{id=1002, name='小红'}
        System.out.println(e3);// EnumTest{id=1003, name='小刚'}

        // values()方法：返回枚举类型的对象数组
        EnumTest[] values = EnumTest.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }

        // valueOf(String str)：返回指定枚举类对象,如果没有这个枚举类对象，则抛异常：IllegalArgumentException。
        EnumTest e = EnumTest.valueOf("e1");
        System.out.println(e);

        // ordinal()：获取枚举成员的索引位置
        int ordinal = EnumTest.e1.ordinal();
        System.out.println(ordinal);
    }
}

//使用enum关键字定义枚举类
enum EnumTest {
    // 提供当前枚举类的多个对象，多个对象之间用","隔开，用";"结束
    e1(1001, "小明"),
    e2(1002, "小红"),
    e3(1003, "小刚");
    // 声明对象的属性，private final修饰
    private final int id;
    private final String name;

    // 私有化的构造器，并给对象属性初始化
    EnumTest(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // 获取枚举类对象的属性
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "EnumTest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
```

