

## 反射概括

### 反射概念

Java反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意方法和属性。这种动态获取信息以及动态调用对象方法的功能称为Java语言的反射机制，通俗解释：反向获取class中各种对象的信息、例如成员变量、方法、构造方法、包等等信息

### 反射作用

（1）反射可以实现简单的反编译，获取类中的属性和方法等基本信息，通过反射机制获取类的属性、方法等，例如IDEA/Eclipse时，当输入一个对象或者类并调用它的属性和方法时，按下点号后，编译器就会自动列出相关属性或方法，这里就会用到反射

（2）反射最重要的用途就是开发各种通用框架，例如Spring 通过 XML 配置模式装载 Bean

### 反射功能

（1）运行时判断任意一个对象所属的类

（2）运行时构造任意一个类的对象 

（3）运行时判断任意一个类所具有的成员变量和方法 

（4）运行时获取泛型信息 

（5）运行时调用任意一个对象的成员变量和方法 

（6）运行时处理注解 

（7）生成动态代理

### 反射优点

| 优点 | 简介                                                         |
| ---- | ------------------------------------------------------------ |
| 灵活 | 使用反射机制后，程序在创建对象的时候不用使用new关键字写死在程序中了，而是可以从配置文件中进行读取，这样可以提高程序的灵活性和扩展性 |

### 反射缺点

| 缺点     | 简介                                                         |
| -------- | ------------------------------------------------------------ |
| 性能问题 | 使用反射基本上是一种解释操作，JVM无法对这些代码进行优化，需要动态的将读取类，因此反射操作的效率要比那些非反射操作性能低得多，反射机制主要应用在对灵活性和扩展性要求很高的系统框架上，对性能要求高的程序中不建议使用 |
| 安全限制 | 使用反射技术要求程序必须在一个没有安全限制的环境中运行       |
| 内部暴露 | 由于反射允许代码执行一些在正常情况下不被允许的操作（比如访问私有的属性和方法），所以使用反射可能会导致意料之外的副作用——代码有功能上的错误，降低可移植性。反射代码破坏了抽象性，因此当平台发生改变的时候，代码的行为就有可能也随着变化。 |

## 反射入门案例

需求：已知Cat类和类中的方法catName()，实现调用Cat类中的catName()方法和name属性

### 准备工作

（1）声明一个类Cat

```java
public class Cat {
    // 私有属性
    private Integer id;
    // 非私有属性
    public String name = "小喵";

    // 私有方法
    private void getCatId() {
        System.out.println("私有方法被调用");
        System.out.println("小猫的ID：" + id);
    }
    // 非私有方法
    public void getCatName() {
        System.out.println("非私有方法被调用");
        System.out.println("小猫的名字：" + name);
    }

    // 空参构造
    public Cat() {
    }

    // 全参构造
    public Cat(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
```

（2）创建类的配置信息文件Cat.properties

```properties
# 类的全路径
ClassPath=com.wen.common.Cat
# 类中的私有方法
privateMethod=getCatId
# 类中的非私有方法
publicMethod=getCatName
# 类中的私有属性
privateId=id
# 类中的非私有属性
publicName=name
```

### 调用类中的属性

（1）使用普通方法，对象.成员变量;

```java
@Test
public void test1() {
	Cat cat = new Cat();
	System.out.println(cat.name);
}
```

（2）利用反射，成员变量.get(对象);

```java
@Test
public void test2() throws Exception {
	// （1）加载类
	Class clazz = Class.forName("com.wen.common.Cat");
	// （2）加载的类的对象实例
	Object obj = clazz.newInstance();
	// （3）返回类中 public 修饰的属性
	Field name = clazz.getField("name");
	// （4）获取属性值
	// 传统：对象.成员变量
	// 反射：成员变量.get(对象)
	System.out.println(name.get(obj));
}
```

（3）反射方式优化：将配置信息放入配置文件

```java
@Test
public void test3() throws Exception {
	// 使用Properties类，读写配置文件
	Properties properties = new Properties();
	// 利用文件流，读取配置文件
	FileInputStream fileInputStream = new FileInputStream("target/classes/Cat.properties");
	// load()：逐行读取properties配置文件，分隔成两个字符串key和value，将他们放进Properties对象中
	properties.load(fileInputStream);
	// 获取配置信息中的字段
	String ClassPath = properties.get("ClassPath").toString();
	String getCatName = properties.get("publicMethod").toString();
	String name = properties.get("publicName").toString();
	System.out.println(ClassPath);
	System.out.println(getCatName);
	System.out.println(name);

	// （1）加载类
	Class clazz = Class.forName("com.wen.common.Cat");
	// （2）加载的类的对象实例
	Object obj = clazz.newInstance();
	// （3）返回类中 public 修饰的属性
	Field field = clazz.getField(name);
	// （4）获取属性值
	// 传统：对象.成员变量
	// 反射：成员变量.get(对象)
	System.out.println(field.get(obj));
}
```

### 调用类中的方法

（1）使用普通方法，对象.方法();

```java
@Test
public void test1() {
	Cat cat = new Cat();
	cat.getCatName();
}
```

（2）利用反射，方法对象.invoke(对象);

```java
@Test
public void test2() throws Exception {
	// （1）加载类
	Class clazz = Class.forName("com.wen.common.Cat");
	// （2）加载的类的对象实例
	Object o = clazz.newInstance();
	// （3）根据方法名 获取 方法的对象
	Method method = clazz.getMethod("getCatName");
	// （4）通过 方法的对象 调用 方法
	// 传统方式：对象.方法();
	// 反射方式：方法.invoke(对象);
	method.invoke(o);
}
```

（3）将配置信息放入配置文件，动态读取配置文件，好处是修改配置即可调用不同的方法，避免了直接修改源码

```java
@Test
public void test3() throws Exception {
	// 使用Properties类，读写配置文件
	Properties properties = new Properties();
	// 利用文件流，读取配置文件
	FileInputStream fileInputStream = new FileInputStream("target/classes/Cat.properties");
	// load()：逐行读取properties配置文件，分隔成两个字符串key和value，将他们放进Properties对象中
	properties.load(fileInputStream);
	// 获取配置信息中的字段
	String ClassPath = properties.get("ClassPath").toString();
	String getCatName = properties.get("publicMethod").toString();
	String name = properties.get("publicName").toString();
	System.out.println(ClassPath);
	System.out.println(getCatName);
	System.out.println(name);

	// （1）加载类
	Class clazz = Class.forName(ClassPath);
	// （2）加载的类的对象实例
	Object obj = clazz.newInstance();
	// （3）根据方法名 获取 方法对象
	Method method_new = clazz.getMethod(getCatName);
	// （4）通过方法对象调用方法
	// 传统方式：对象.方法();
	// 反射方式：方法.invoke(对象);
	method_new.invoke(obj);
}
```

### 反射前后差别

（1）使用反射前，在类的外部，不可以通过类的对象调用其内部的私有private结构

```java
@Test
public void test1() {
	// 创建Person类的对象（实例化）
	Cat cat = new Cat(1001, "小咪");
	// 通过对象调用内部的属性、方法
	// System.out.println(cat.id);// 不能调用私有属性
	System.out.println(cat.name);
	cat.getCatName();
	// cat.getCatId();// 不能调用私有方法
}
```

（2）使用反射之后，可以使用 setAccessible(boolean flag)方法临时改变访问权限，就可以获取可以调用私有的结构，比如：私有的构造器、方法、属性

```java
@Test
public void test2() throws Exception {
	// 加载类
	Class<Cat> clazz = Cat.class;
	// 加载的类的对象实例
	// getConstructors()：获取当前运行时类中声明为public的构造器
	Constructor<Cat> constructor = clazz.getConstructor(int.class, String.class);
	// 保证当前构造器可以访问
	constructor.setAccessible(true);
	// newInstance()：创建对象
	Object obj = constructor.newInstance(1001, "小明");
	Cat cat = (Cat) obj;
	System.out.println(cat.toString());

	// 通过反射调用指定的属性、方法
	// 调用属性
	// getDeclaredField(String name)：根据属性名name获取指定的属性
	Field id = clazz.getDeclaredField("id");
	Field name = clazz.getDeclaredField("name");
	// 保证当前属性可以访问
	name.setAccessible(true);
	System.out.println("id:" + id + "name:" + name);
	// 调用方法
	// getDeclaredMethod(String name, Class<?>… parameterTypes)：根据指定的方法名称和参数，匹配类中的方法，返回Method对象
	Method getCatId = clazz.getDeclaredMethod("getCatId");
	Method getCatName = clazz.getDeclaredMethod("getCatName");
	// 保证当前方法可以访问
	getCatId.setAccessible(true);
	getCatId.invoke(cat);
	getCatName.invoke(cat);
}
```



## 反射相关类

注：必须先获得Class才能获取Method、Constructor、Field

| API                           | 简介                                                         |
| ----------------------------- | ------------------------------------------------------------ |
| java.lang.Class               | 代表一个类型，代表整个类。代表整个字节码。                   |
| java.lang.reflect.Method      | 代表类中的方法。代表字节码中的方法字节码。                   |
| java.lang.reflect.Field       | 代表类的成员变量（静态变量+实例变量）代表字节码中的属性字节码 |
| java.lang.reflect.Constructor | 代表类的构造方法（构造器）。代表字节码中的构造方法字节码     |

### Class类

| 方法                                                      | 简介                                                         |
| --------------------------------------------------------- | ------------------------------------------------------------ |
| newInstance()                                             | 创建对象                                                     |
| getName()                                                 | 返回完整类名带包名                                           |
| getSimpleName()                                           | 返回类名                                                     |
| getFields()                                               | 返回类中public修饰的属性，返回Field数组                      |
| getDeclaredFields()                                       | 返回类中所有的属性，返回Field数组                            |
| getField(String name)                                     | 根据属性名获取指定的public修饰的属性                         |
| getDeclaredField(String name)                             | 根据属性名获取指定的属性                                     |
| getModifiers()                                            | 获取属性的修饰符列表,返回的修饰符是一个数字，每个数字是修饰符的代号  一般配合Modifier类的toString(int  x)方法使用 |
| getDeclaredMethods()                                      | 返回类中（类自身）所有的实例方法，包含public、protected和private方法。 |
| getDeclaredMethod(String name,  Class<?>… parameterTypes) | java.lang.Class.getDeclaredMethod()  返回值：根据指定的方法名称和参数，匹配类中的方法，返回Method对象  name参数表示方法的名称（字符串），parameterTypes参数表示参数数组 |
| getDeclaredConstructors()                                 | 返回类中所有的构造方法                                       |
| getDeclaredConstructor(Class<?>… parameterTypes)          | 根据方法形参获取指定的构造方法                               |
| getSuperclass()                                           | 根据方法形参获取指定的构造方法                               |
| getInterfaces()                                           | 返回调用类实现的接口集合                                     |

### Method类

| 方法                              | 简介                                                         |
| --------------------------------- | ------------------------------------------------------------ |
| getName()                         | 返回方法名                                                   |
| getModifiers()                    | 获取方法的修饰符列表,返回的修饰符是一个数字，每个数字是修饰符的代号  一般配合Modifier类的toString(int  x)方法使用 |
| getReturnType()                   | 以Class类型，返回方法类型  一般配合Class类的getSimpleName()方法使用 |
| getParameterTypes()               | 返回方法的修饰符列表（一个方法的参数可能会有多个。）  结果集一般配合Class类的getSimpleName()方法使用 |
| invoke(Object obj, Object…  args) | 调用方法                                                     |

### Field类

| 方法                          | 简介                                                         |
| ----------------------------- | ------------------------------------------------------------ |
| getName()                     | 返回属性名                                                   |
| getModifiers()                | 获取属性的修饰符列表,返回的修饰符是一个数字，每个数字是修饰符的代号  一般配合Modifier类的toString(int  x)方法使用 |
| getType()                     | 以Class类型，返回属性类型  一般配合Class类的getSimpleName()方法使用 |
| set(Object obj, Object value) | 设置属性值                                                   |
| get(Object obj)               | 读取属性值                                                   |

### Constructor类

| 方法                                    | 简介                                                         |
| --------------------------------------- | ------------------------------------------------------------ |
| public String  getName()                | 返回构造方法名                                               |
| public int  getModifiers()              | 获取构造方法的修饰符列表,返回的修饰符是一个数字，每个数字是修饰符的代号  一般配合Modifier类的toString(int  x)方法使用 |
| public  Class<?>[] getParameterTypes()  | 返回构造方法的修饰符列表（一个方法的参数可能会有多个）  结果集一般配合Class类的getSimpleName()方法使用 |
| public T newInstance(Object … initargs) | 创建对象，参数为创建对象的数据                               |

## 类的加载

### 类的加载过程

```
程序经过java.exe命令以后，会生成一个或多个字节码文件(以.class结尾)
接着我们使用java.exe命令对某个字节码文件进行解释运行，相当于将某个字节码文件加载到内存中（此过程就称为类的加载）
加载到内存中的类，我们就称为运行时类，此运行时类，就作为Class的一个示例，换句话说，Class的实例就对应着一个运行时类
加载到内存中的运行时类，会缓存一定的时间，在此时间之内，我们可以通过不同的方式来获取此运行时类
```

### 类的加载步骤

当程序主动使用某个类时，如果该类还未被加载到内存中，则系统会通过如下三个步骤来对该类进行初始化

| 加载过程 | 简介                                                         |
| -------- | ------------------------------------------------------------ |
| 加载     | 将class文件字节码内容加载到内存中，并将这些静态数据转换成方法区的运行时数据结构，然后生成一个代表这个类的java.lang.Class对象，作为方法区中类数据的访问入口（即引用地址）。所有需要访问和使用类数据只能通过这个Class对象。这个加载的过程需要类加载器参与。 |
| 链接     | 将Java类的二进制代码合并到JVM的运行状态之中的过程。<br>验证：确保加载的类信息符合JVM规范，例如：以cafe开头，没有安全方面的问题<br>准备：正式为类变量（static）分配内存并设置类变量默认初始值的阶段，这些内存都将在方法区中进行分配<br>解析：虚拟机常量池内的符号引用（常量名）替换为直接引用（地址）的过程。 |
| 初始化   | 执行类构造器`<clinit>()`方法的过程，类构造器()方法是由编译期自动收集类中所有类变量的赋值动作和静态代码块中的语句合并产生的。（类构造器是构造类信息的，不是构造该类对象的构造器），当初始化一个类的时候，如果发现其父类还没有进行初始化，则需要先触发其父类 的初始化，虚拟机会保证一个类的()方法在多线程环境中被正确加锁和同步 |

### ClassLoader类加载器

类加载器作用是用来把类(class)装载进内存的

```java
public class Demo {
    @Test
    public void test() {
        // 对于自定义类，使用系统类加载器进行加载
        ClassLoader classloader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classloader);// sun.misc.Launcher$AppClassLoader@18b4aac2

        // 调用系统类加载器的父类加载器getParent()：即获取扩展类加载器
        ClassLoader parent = classloader.getParent();
        System.out.println(parent);// sun.misc.Launcher$ExtClassLoader@54bedef2

        // 调用扩展类加载器的父类加载器getParent()：无法获取引导类加载器
        // 引导类加载器主要负责加载java的核心类库，无法加载自定义类的
        ClassLoader classLoader3 = parent.getParent();
        System.out.println(classLoader3);// null
    }
}

class ClassLoaderTest {
}
```

## 反射的动态性

### 动态语言和静态语言

| 概念     | 简介                                                         | 举例                    |
| -------- | ------------------------------------------------------------ | ----------------------- |
| 动态语言 | 指在编译时变量的数据类型即可确定的语言，在运行期是可变的，这意味着对象的多态性是与生俱来的，多数静态类型语言要求在使用变量之前必须声明数据类型，优点是编写的代码数量少，看起来更简洁，可以把精力更多地放在业务逻辑上 | JavaScript、PHP、Python |
| 静态语言 | 在运行时确定数据类型的语言，变量使用之前不需要类型声明，编译时会进行类型匹配检查，所以不能给变量赋予不同类型的值（除非用向上转型的技术来取得多态的效果） | Java、C、 C++           |

### 体会反射的动态性

Java 不是动态语言，但 Java 可以称之为 “准动态语言” 。即 Java 有一定的动态性，可以利用反射机制、字节码操作获得类似动态语言的特性，Java 的动态性让编程的时候更加灵活

```java
public class dynamic {
    /**
     * 体会反射的动态性
     * 通过随机数，动态创建类的对象
     */
    @Test
    public void test() {
        // 返回0、1、2之中的随机数
        int num = new Random().nextInt(3);
        System.out.println(num);
        String classPath = "";
        switch (num) {
            case 0:
                classPath = "java.util.Random";
                break;
            case 1:
                classPath = "java.util.Date";
                break;
            case 2:
                classPath = "java.lang.Object";
                break;
        }
        try {
            Object obj = getInstance(classPath);
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 此方法创建一个指定类的对象
     *
     * @param classPath 指定类的全类名
     */
    public Object getInstance(String classPath) throws Exception {
        Class<?> clazz = Class.forName(classPath);
        return clazz.newInstance();
    }
}
```



## 反射的使用

### 准备工作

（1）自定义接口MyInterface

```java
// 自定义接口
public interface MyInterface {
    void info();
}
```

（2）自定义注解MyAnnotation

```java
// 自定义注解
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
public @interface MyAnnotation {
    String value() default "value属性默认值";
}
```

（3）父类Creature

```java
// Person的父类
public class Creature<T>implements Serializable {
    private char gender;//性别
    public double weight;//体重

    private void breath(){
        System.out.println("生物呼吸");
    }
    public void eat(){
        System.out.println("生物吃东西");
    }
}
```

（4）子类Person

```java
/**
 * Person继承Creature父类
 * 实现了Comparable接口
 * 实现类自定义MyInterface接口
 * 使用了自定义注解@MyAnnotation
 */
@Data// 代表get、set、toString、equals、hashCode等操作
@MyAnnotation(value = "hello!")//自定义注解
public class Person extends Creature<String> implements Comparable<String>, MyInterface {
    private int id;
    public String name;
    int age;

    @MyAnnotation()
    public void show1() {
        System.out.println("非静态方法被使用");
    }

    public static void show2() {
        System.out.println("静态方法被使用");
    }

    @MyAnnotation
    private String show3(String n) {
        System.out.println("私有方法被使用");
        return n;
    }

    @Override
    public void info() {
        System.out.println("重写info()方法被使用");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    // 空参构造器
    public Person() {
        System.out.println("空参构造器被使用");
    }

    // 全参构造器
    public Person(int id, String name, int age) {
        System.out.println("全参构造器被使用");
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
```



### 获取Class类实例对象的四种方式

获取Class类的实例的四种方法（前三种需要掌握，第四种了解，第三种用的多）

| 方法                                                         | 前提                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| Class  clazz = 类名.class;                                   | 若已知具体的类，通过类的class属性获取，该方法最为安全可靠，程序性能最高 |
| Class  clazz = 类实例对象.getClass();                        | 已知某个类的实例对象，调用该实例的getClass()方法获取Class对象 |
| Class  clazz = Class.forName("类的全类名");                  | 已知一个类的全类名，且该类在类路径下，可通过Class类的静态方法forName(String ClassPath)获取，可能抛出ClassNotFoundException |
| ClassLoader cl =  this.getClass().getClassLoader();<br>Class  clazz = cl.loadClass("类的全类名"); | 使用类的加载器：ClassLoader                                  |

```java
/**
 * 获取Class的实例的方式（前三种需要掌握，第三种用的多，第四种了解即可）
 */
public class Demo {
    /**
     * 方式一：调用运行时类的属性
     */
    @Test
    public void test1() {
        Class<Person> clazz = Person.class;
        System.out.println(clazz);
    }

    /**
     * 方式二：通过运行时类的对象，调用getClass()
     */
    @Test
    public void test2() {
        Person person = new Person();
        Class<? extends Person> clazz = person.getClass();
        System.out.println(clazz);
    }

    /**
     * 方式三：调用Class的静态方法：forName(String ClassPath)
     */
    @Test
    public void test3() throws ClassNotFoundException {
        Class<?> clszz = Class.forName("com.wen.common.Person");
        System.out.println(clszz);
    }

    /**
     * 方式四：使用类的加载器：ClassLoader（了解）
     */
    @Test
    public void test4() throws ClassNotFoundException {
        ClassLoader classLoader = Demo.class.getClassLoader();
        Class<?> clazz = classLoader.loadClass("com.wen.common.Person");
        System.out.println(clazz);
    }
}
```

### Class类的实例对象的用途

（1）获取运行时类的完整结构

```
1、获取当前运行时类的属性结构（权限修饰符、数据类型、变量名）
2、获取运行时类的方法结构（注解、权限修饰符、返回值类型、方法名、形参列表、抛出的异常）
3、获取运行时类的构造器结构
4、获取运行时类的父类及父类泛型类型
5、获取运行时类的接口、包、注解
```

（2）调用运行时类的指定结构

```java
1、调操作运行时类中指定的属性
2、操作运行时类中指定的方法
3、操作运行时类的指定构造器
```

### 哪些类型可以有Class的实例对象

| 类型           | 简介                                                         |
| -------------- | ------------------------------------------------------------ |
| class          | 外部类，成员(成员内部类，静态内部类)，局部内部类，匿名内部类 |
| interface      | 接口                                                         |
| []             | 数组                                                         |
| enum           | 枚举                                                         |
| annotation     | 注解                                                         |
| primitive type | 基本数据类型                                                 |

```java
public class Demo {
    /**
     * 哪些类型可以有Class对象？
     */
    @Test
    public void test() {
        Class c1 = Object.class;// 类
        Class c2 = Comparable.class;// 接口
        Class c3 = String[].class;// 一维数组
        Class c4 = int[][].class;// 二维数组
        Class c5 = ElementType.class;// 枚举类
        Class c6 = Override.class;// 注解@interface
        Class c7 = int.class;// 基本数据类型
        Class c8 = void.class;// 空类型
        Class c9 = Class.class;// Class本身

        // 只要元素类型与维度一样，就是同一个Class
        // 同一个元素同一个类只有一个Class对象，一个类只有一个Class对象
        int[] a = new int[10];
        int[] b = new int[100];
        Class aClass = a.getClass();
        Class bClass = b.getClass();
        System.out.println(aClass.hashCode());// 1031980531
        System.out.println(bClass.hashCode());// 1031980531
        System.out.println(aClass == bClass);//true
    }
}
```

### 创建运行时类的对象

有了Class类的实例对象后，可以调用Class对象的newInstance()方法创建类的对象，要想newInstance()方法正常的创建运行时的对象，需要类必须有一个无参数的构造器、类的构造器的访问权限需要足够

```java
public class Demo {
    @Test
    public void test() throws IllegalAccessException, InstantiationException {
        // 获取Class的实例
        Class<Person> clazz = Person.class;
        // newInstance()：调用此方法，创建对应的运行时类的对象，内部调用了运行时类的空参构造器
        Person person = clazz.newInstance();
        System.out.println(person);
    }
}
```



### 获取运行时类的属性结构

有了Class类的实例对象后，还可以获取当前运行时类的属性结构（权限修饰符、数据类型、变量名）

| 方法                          | 简介                                    |
| ----------------------------- | --------------------------------------- |
| getField(String name)         | 根据属性名获取指定的public修饰的属性    |
| getDeclaredField(String name) | 根据属性名获取指定的属性                |
| getFields()                   | 返回类中public修饰的属性，返回Field数组 |
| getDeclaredFields()           | 返回类中所有的属性，返回Field数组       |

```java
public class Demo {
    /**
     * 根据Class类的实例对象，获取当前运行时类的属性结构（权限修饰符 数据类型 变量名）
     */
    @Test
    public void test() {
        // 获取Class实例
        Class<Person> clazz = Person.class;

        // getFields()：获取当前运行时类及其父类中声明为public访问权限的属性，返回给Field数组
        Field[] fields = clazz.getFields();
        for (Field f : fields) {
            // 获取所有属性
            System.out.println("所有属性：" + f);
            // 获取权限修饰符
            int modifiers = f.getModifiers();
            System.out.println("权限修饰符：" + Modifier.toString(modifiers));
            // 获取数据类型
            Class<?> type = f.getType();
            System.out.println("数据类型：" + type);
            // 获取变量名
            String name = f.getName();
            System.out.println("变量名：" + name);
        }

        // getDeclaredFields()：获取当前运行时类中声明的所有属性（不包含父类中的属性）
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            System.out.println(f);// 类中属性
        }
    }
}
```



### 获取运行时类的方法结构

有了Class类的实例对象后，还可以获取运行时类的方法结构（注解、权限修饰符、返回值类型、方法名、形参列表、抛出的异常）

| 方法                 | 简介                                                   |
| -------------------- | ------------------------------------------------------ |
| getMethods()         | 获取当前运行时类及其所有父类中声明为public权限的方法   |
| getDeclaredMethods() | 获取当前运行时类中声明的所有方法（不包含父类中的方法） |

```java
public class Demo {
    /**
     * 根据Class类的实例对象，获取运行时类的方法结构（注解、权限修饰符、返回值类型、方法名、形参列表、抛出的异常）
     */
    @Test
    public void test() {
        // 获取Class实例
        Class<Person> clazz = Person.class;

        // getMethods()：获取当前运行时类及其所有父类中声明为public权限的方法
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            // 获取所有方法
            System.out.println("方法：" + m);
            // 获取方法声明的注解
            Annotation[] annotations = m.getAnnotations();
            for (Annotation a : annotations) {
                System.out.println("注解：" + a);
            }
            // 获取权限修饰符
            System.out.println("权限修饰符：" + Modifier.toString(m.getModifiers()));
            // 获取返回值类型
            System.out.println("返回值类型：" + m.getReturnType().getName());
            // 获取方法名
            System.out.println("方法名：" + m.getName());
            // 形参列表
            Class<?>[] parameterTypes = m.getParameterTypes();
            if (!(parameterTypes == null && parameterTypes.length == 0)) {
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (i == parameterTypes.length - 1) {
                        System.out.println(parameterTypes[i].getName() + i);
                        break;
                    }
                    System.out.println(parameterTypes[i].getName() + i);
                }
            }
            // 获取抛出的异常
            Class<?>[] exceptionTypes = m.getExceptionTypes();
            if (exceptionTypes.length > 0) {
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if (i == exceptionTypes.length - 1) {
                        System.out.println(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.println(exceptionTypes[i].getName());
                }
            }
        }

        // getDeclaredMethods()：获取当前运行时类中声明的所有方法（不包含父类中的方法）
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods) {
            System.out.println(m);
        }
    }
}
```



### 获取运行时类的构造器结构

有了Class类的实例对象后，还可以获取运行时类的构造器结构

| 方法                      | 简介                                   |
| ------------------------- | -------------------------------------- |
| getConstructors()         | 获取当前运行时类中声明为public的构造器 |
| getDeclaredConstructors() | 获取当前运行时类中声明的所有的构造器   |

```java
public class Demo {
    /**
     * 根据Class类的实例对象，还可以获取构造器结构
     */
    @Test
    public void test() {
        // 获取Class实例
        Class<Person> clazz = Person.class;

        // getConstructors()：获取当前运行时类中声明为public的构造器
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c);
        }

        // getDeclaredConstructors()：获取当前运行时类中声明的所有的构造器
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor c : declaredConstructors) {
            System.out.println(c);
        }
    }
}
```



### 获取运行时类的父类

有了Class类的实例对象后，还可以获取运行时类的及父类泛型类型

| 方法                     | 简介                       |
| ------------------------ | -------------------------- |
| getSuperclass()          | 获取运行时类的父类         |
| getGenericSuperclass()   | 获取运行时类的带泛型的父类 |
| getActualTypeArguments() | 获取泛型类型               |

```java
public class Demo {
    /**
     * 根据Class类的实例对象，获取运行时类的父类及父类泛型类型
     */
    @Test
    public void test() {
        // 获取Class实例
        Class<Person> clazz = Person.class;

        // 获取运行时类的父类
        Class<? super Person> superclass = clazz.getSuperclass();
        System.out.println(superclass);

        // 获取运行时类的带泛型的父类
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);

        // 获取运行时类的带泛型的父类的泛型类型
        ParameterizedType genericSuperclass1 = (ParameterizedType) genericSuperclass;
        // getActualTypeArguments()：获取泛型类型
        Type[] actualTypeArguments = genericSuperclass1.getActualTypeArguments();
        System.out.println(actualTypeArguments[0].getTypeName());
    }
}
```



### 获取运行时类的接口、包、注解

有了Class类的实例对象后，还可以获取运行时类的接口、包、注解

| 方法             | 简介                     |
| ---------------- | ------------------------ |
| getInterfaces()  | 获取运行时类的实现的接口 |
| getInterfaces()  | 获取运行时类实现的接口   |
| getPackage()     | 获取运行时类所在的包     |
| getAnnotations() | 获取运行时类声明的注解   |

```java
public class Demo {
    /**
     * 获取运行时类的接口、包、注解
     */
    @Test
    public void test() {
        // 获取Class实例
        Class<Person> clazz = Person.class;

        // 获取运行时类的实现的接口
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class c : interfaces) {
            System.out.println("运行时类的实现的接口"+c);
        }

        // 获取运行时类的父类实现的接口
        Class<?>[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for (Class c : interfaces1) {
            System.out.println("运行时类的父类实现的接口:"+c);
        }

        // 获取运行时类所在的包
        Package pack = clazz.getPackage();
        System.out.println("运行时类所在的包:"+pack);

        // 获取运行时类声明的注解
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation a : annotations) {
            System.out.println("运行时类声明的注解:"+a);
        }
    }
}
```



### 操作运行时类中指定的属性

有了Class类的实例对象后，还可以操作运行时类中指定的属性

| 方法                          | 简介       |
| ----------------------------- | ---------- |
| set(Object obj, Object value) | 设置属性值 |
| get(Object obj)               | 读取属性值 |

```java
public class Demo {
    /**
     * 操作运行时类中指定的属性，使用getField()
     */
    @Test
    public void test1() throws Exception {
        // 获取Class实例
        Class<Person> clazz = Person.class;

        // 创建运行时类的对象
        Person person = clazz.newInstance();

        // 返回类中public修饰的属性（因为此方法要求运行时类中属性声明为public，所有通常不采用此方法）
        // Field id = clazz.getField("id");// 不能获取私有的
        Field name = clazz.getField("name");

        // 设置当前属性的值
        // set()：参数1用于指明设置哪个对象的属性，参数2用于将属性值设置为多少
        name.set(person, "小明");

        // 获取当前属性的值
        // get()：获取哪个对象的当前属性值
        Object obj = name.get(person);
        System.out.println(obj);
    }

    /**
     * 操作运行时类中指定的属性，使用getDeclaredField()
     */
    @Test
    public void test2() throws Exception {
        // 获取Class实例
        Class<Person> clazz = Person.class;

        // 创建运行时类的对象
        Person person = clazz.newInstance();

        // getDeclaredField(String fileldName)：根据属性名name获取指定的属性
        Field id = clazz.getDeclaredField("id");
        Field name = clazz.getDeclaredField("name");
        // 保证当前属性可以访问
        id.setAccessible(true);
        name.setAccessible(true);

        // 设置当前属性的值
        // set()：参数1:指明设置哪个对象的属性  参数2:将属性值设置为多少
        id.set(person, 1001);
        name.set(person,"小明");

        // 获取当前属性的值
        // get()：获取哪个对象的当前属性值
        Object pId = id.get(person);
        Object pName = name.get(person);
        System.out.println("id:"+pId);
        System.out.println("name:"+pName);
    }
}
```



### 操作运行时类中指定的方法

有了Class类的实例对象后，还可以操作运行时类中指定的方法

```java
public class Demo {
    /**
     * 操作运行时类中指定的方法
     */
    @Test
    public void test1() throws Exception {
        // 获取Class实例
        Class<Person> clazz = Person.class;

        // 创建运行时类的对象
        Person person = clazz.newInstance();

        // 获取指定的某个方法
        // getDeclaredMethod()：参数1指明获取方法的名称  参数2指明获取的方法的形参列表
        Method show1 = clazz.getDeclaredMethod("show1");
        Method show2 = clazz.getDeclaredMethod("show2");
        Method show3 = clazz.getDeclaredMethod("show3", String.class);

        // 保证当前属性可以访问
        show1.setAccessible(true);
        show2.setAccessible(true);
        show3.setAccessible(true);

        // 调用invoke()执行此方法
        // invoke()：参数1:方法的调用者  参数2:给方法形参复制的实参
        show1.invoke(person);
        show2.invoke(person);
        show3.invoke(person, "实参");
    }

    /**
     * 操作运行时类中指定的静态方法
     */
    @Test
    public void test2() throws Exception {
        // 获取Class实例
        Class<Person> clazz = Person.class;

        // 创建运行时类的对象
        Person person = clazz.newInstance();

        // 获取指定的某个方法
        // getDeclaredMethod()：参数1:指明获取方法的名称  参数2:指明获取的方法的形参列表
        Method show2 = clazz.getDeclaredMethod("show2");

        // 保证当前属性可以访问
        show2.setAccessible(true);

        // 调用invoke()执行此方法
        // invoke()：参数1是方法的调用者  参数2是给方法形参复制的实参
        show2.invoke(person);

        // 获取静态的方法
        // 如果调用的运行时类中的方法没有返回值，则此invoke()返回null
        Object invoke2 = show2.invoke(Person.class);
        System.out.println(invoke2);

        // 如果反射的方法是static静态方法时，参数用null也可以调用此方法
        show2.invoke(null);
    }
}
```



### 操作运行时类的指定构造器

有了Class类的实例对象后，还可以操作运行时类的指定构造器

```java
public class Demo {
    /**
     * 操作运行时类的指定构造器
     */
    @Test
    public void test() throws Exception {
        // 获取Class实例
        Class<Person> clazz = Person.class;

        // 获取指定的构造器
        // getDeclaredConstructor()：参数，指明构造器的参数列表
        Constructor<Person> constructor = clazz.getDeclaredConstructor(int.class,String.class,int.class);

        // 保证此构造器是可以访问的
        constructor.setAccessible(true);

        // 调用此构造器创建运行时类的对象
        Person per = constructor.newInstance(1001,"小明",18);
        System.out.println(per);
    }
}
```



## 反射的应用：动态代理

### 代理模式

#### 代理模式简介

（1）代理模式是二十三种设计模式中的一种，属于结构型模式，作用是在不修改目标对象（被代理对象）的基础上，通过代理对象（扩展代理类），进行一些功能的附加与增强

（2）代理模式优点：解耦，可以把附加功能从业务功能代码中抽取出来

（3）代理模式应用：Spring AOP面向切面编程

#### 代理模式分类

（1）代理模式有静态代理和动态代理两种实现方式

| 代理模式 | 简介                                             |
| -------- | ------------------------------------------------ |
| 静态代理 | 代理类在程序运行前就已经存在                     |
| 动态代理 | 代理类是运行时根据在Java代码中的“指示”动态生成的 |

（2）静态代理和动态代理的对比

| 对比     | 简介                                                         |
| -------- | ------------------------------------------------------------ |
| 灵活性   | 静态代理中，接口一旦新增加方法，目标对象和代理对象都要进行修改，非常麻烦！<br>动态代理更加灵活，不需要必须实现接口，可以直接代理实现类，不需要针对每个目标类都创建一个代理类。 |
| JVM 层面 | 静态代理在编译时就将接口、实现类、代理类这些都变成了一个个实际的 class 文件<br>动态代理是在运行时动态生成类字节码，并加载到 JVM 中 |



### 静态代理

#### 静态代理的特点

```java
1、代理对象和被代理对象实现同一个接口，代理对象中的核心功能由被代理对象来完成，代理对象负责增强功能。
2、代理对象可以做很多被代理对象做不了的事情，而真实对象专注做自己的事情
3、代理对象在程序运行前就已经存在，支持被代理对象灵活的切换，但无法对功能灵活的处理（动态代理可解决此问题）
```

#### 静态代理的缺点

| 缺点     | 简介                                                         |
| -------- | ------------------------------------------------------------ |
| 代码重复 | 代理类和目标类实现了相同的接口，每个代理都需要实现目标类的方法，这样就出现了大量的代码重复 |
| 难于管理 | 如果接口增加一个方法，除了所有目标类需要实现这个方法外，所有代理类也需要实现此方法。<br/>所以静态代理只适合业务功能固定不变的情况，即业务接口方法不进行增加和减少，此时实现类不需要改动 |
| 代理复杂 | 代理类只服务于一种类型的目标类，如果要服务多个类型，势必要为每一种目标类都进行代理<br>若程序规模变大的话，代理类数量就会越来越多 |



#### 静态代理案例

（1）接口ClothFactory

```java
interface ClothFactory {
    void produceCloth();
}
```

（2）被代理类实现ClothFactory接口重写方法produceCloth()，完成某些具体操作

```java
public class Nike implements ClothFactory {
    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生产运动服");
    }
}
```

（3）代理类实现ClothFactory接口重写方法produceCloth()，做功能增强

```java
public class ProxyClothFactory implements ClothFactory {
    // 用被代理类对象进行实例化
    private ClothFactory factory;

    // 构造器
    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");
        // 实质上在代理类中是调用了被代理实现接口的produceCloth()方法
        factory.produceCloth();
        System.out.println("代理工厂做一些后续的工作");
    }
}
```

（4）测试使用

```java
public class Demo {
    public static void main(String[] args) {
        // 创建被代理类的对象
        Nike nike = new Nike();
        // 创建代理类的对象,并告知代理谁
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nike);
        // 触发代理方法，调用的是代理类中的produceCloth()方法
        proxyClothFactory.produceCloth();
    }
}
```

#### 静态代理计算机案例

（1）计算机接口

```java
public interface Calculator {
    // 加
    int add(int i, int j);

    // 减
    int sub(int i, int j);

    // 乘
    int mul(int i, int j);

    // 除
    int div(int i, int j);
}
```

（2）计算机接口实现类，负责实际的操作

```java
public class CalculatorImpl implements Calculator {
    @Override
    public int add(int i, int j) {
        int result = i + j;
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = i - j;
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result = i * j;
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result = i / j;
        return result;
    }
}
```

（3）代理工厂：计算机接口实现类，为实际操作提供功能扩展（日志记录）

```java
public class CalculatorStaticProxy implements Calculator {
    // 将被代理的目标对象声明为成员变量
    private Calculator target;

    // 用于初始化被代理的目标对象
    public CalculatorStaticProxy(Calculator target) {
        this.target = target;
    }

    @Override
    public int add(int i, int j) {
        // 附加功能由代理类中的代理方法来实现
        System.out.println("[日志] add 方法开始了，参数是：" + i + "," + j);
        // 通过目标对象来实现核心业务逻辑
        int addResult = target.add(i, j);
        System.out.println("[日志] add 方法结束了，结果是：" + addResult);
        return addResult;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("[日志] sub 方法开始了，参数是：" + i + "," + j);
        int result = target.sub(i, j);
        System.out.println("方法内部 result = " + result);
        return result;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("[日志] mul 方法开始了，参数是：" + i + "," + j);
        int result = target.mul(i, j);
        System.out.println("方法内部 result = " + result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("[日志] div 方法开始了，参数是：" + i + "," + j);
        int result = target.div(i, j);
        System.out.println("方法内部 result = " + result);
        return result;
    }
}
```

（4）静态代理测试

```java
public class CalculatorStaticProxyTest {
    public static void main(String[] args) {
        // 实现类接口
        CalculatorImpl calculator = new CalculatorImpl();
        // 使用代理类的有参构造，为计算器类赋值
        CalculatorStaticProxy calculatorStaticProxy = new CalculatorStaticProxy(calculator);
        // 调用方法
        int add = calculatorStaticProxy.add(1, 3);
    }
}
```



### 动态代理

#### 动态代理简介

（1）在不改变方法源码的情况下，增强方法功能，提高复用性

（2）提高开发效率和可扩展性

（3）可为被代理对象所有方法做代理、可以为任意接口的实现类对象做代理

（4）动态代理的实现方式有很多种，比如 JDK 动态代理、CGLIB 动态代理等等

| 动态代理      | 简介                                                         |
| ------------- | ------------------------------------------------------------ |
| JDK动态代理   | 要求必须有接口，最终生成的代理类和目标类实现相同的接口，JDK 动态代理`只能代理实现了接口的类或者直接代理接口` |
| cglib动态代理 | 最终生成的代理类，会继承目标类，并且和目标类在相同的包下，CGLIB 动态代理`可以代理未实现任何接口的类` |

（5）JDK 动态代理和 CGLIB 动态代理对比

```
从效率方面，大部分情况都是 JDK 动态代理更优秀，随着 JDK 版本的升级，这个优势更加明显
```



#### 动态代理案例

（1）接口

```java
interface Human {
    // 吃饭
    void eat(String food);
}
```

（2）被代理类

```java
class SupperMan implements Human {
    @Override
    public void eat(String food) {
        System.out.println("超人喜欢吃" + food);
    }
}
```

（3）创建实现InvocationHandler接口的类

```java
/**
 * 这个类实现了InvocationHandler接口，并持有一个被代理类的对象，
 * InvocationHandler中有一个invoke方法，所有执行代理对象的方法都会被替换成执行invoke方法。
 * 然后可以通过反射在invoke方法中执行代理类的方法。
 * 在代理过程中，在执行代理类的方法前后可以执行自己的操作，这就是spring aop的主要原理。
 */
class MyInvocationHandler implements InvocationHandler {
    // 需要使用被代理的对象进行赋值
    private Object target;

    /**
     * 此方法用于初始化被代理的对象
     */
    public void bind(Object target) {
        this.target = target;
    }

    /**
     * 当通过代理类的对象，调用方法a时，就会自动的调用invoke()方法
     * 可以在 invoke() 方法中自定义处理逻辑，比如在方法执行前后做一些通用事情
     *
     * @param proxy  代表动态代理对象
     * @param method 代理对象需要实现的方法，即代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
     * @param args   method所对应方法的参数，代表调用目标方法时传入的实参
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 代理过程中插入其他操作
        System.out.println("===========代理前执行==========");

        // 动态代理的本质就是使用反射机制来实现
        // target表示被代理类的对象
        Object returnValue = method.invoke(target, args);

        System.out.println("===========代理后执行==========");
        return returnValue;
    }
}
```

（4）动态代理测试使用

```java
public class Demo {
    public static void main(String[] args) {
        // 创建代理类的对象
        SupperMan supperMan = new SupperMan();

        // getProxyInstance：返回一个代理类的对象
        Human proxyInstance = (Human) getProxyInstance(supperMan);

        // 当通过代理类对象调用方法时，会自动调用被代理类中同名的方法
        proxyInstance.eat("早餐");
    }

    /**
     * 根据加载到内存中的被代理类，动态的创建一个代理类及其对象
     *
     * @param obj 被代理类的对象
     * @return 返回一个代理类的对象
     */
    public static Object getProxyInstance(Object obj) {
        // 创建InvocationHandler对象
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        // 创建代理对象,代理对象的每个执行方法都会替换执行Invocation中的invoke方法
        // newProxyInstance()：创建一个代理实例，其中有三个参数
        // 1、classLoader：获取加载动态生成的代理类的类加载器
        // 2、interfaces：获取目标对象实现的所有接口的class对象所组成的数组
        // 3、invocationHandler：设置代理对象实现目标对象方法的过程，即代理类中如何重写接口中的抽象方法
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}
```

#### 动态代理计算机案例

（1）计算机接口

```java
public interface Calculator {
    // 加
    int add(int i, int j);

    // 减
    int sub(int i, int j);

    // 乘
    int mul(int i, int j);

    // 除
    int div(int i, int j);
}
```

（2）计算机接口实现类，负责实际的操作

```java
public class CalculatorImpl implements Calculator {
    @Override
    public int add(int i, int j) {
        int result = i + j;
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = i - j;
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result = i * j;
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result = i / j;
        return result;
    }
}
```

（3）生产代理对象的工厂类

```java
public class ProxyFactory {
    // 将被代理的目标对象声明为成员变量
    private Object target;

    // 用于初始化被代理的目标对象
    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 根据加载到内存中的被代理类，动态的创建一个代理类及其对象
     * @return 返回一个代理类的对象
     */
    public Object getProxy() {
        // 加载动态生成的代理类的类加载器
        ClassLoader classLoader = target.getClass().getClassLoader();

        // 目标对象实现的所有接口的class对象所组成的数组
        Class<?>[] interfaces = target.getClass().getInterfaces();

        // 创建匿名内部类，设置代理对象实现目标对象方法的过程，即代理类中如何重写接口中的抽象方法
        InvocationHandler invocationHandler = new InvocationHandler() {
            /**
             * @param proxy 代理对象
             * @param method 代理对象需要实现的方法，即其中需要重写的方法
             * @param args method所对应方法的参数
             * @return 根据加载到内存中的被代理类，动态的创建一个代理类及其对象
             * */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                try {
                    System.out.println("[动态代理][日志] " + method.getName() + "，参 数：" + Arrays.toString(args));
                    result = method.invoke(target, args);
                    System.out.println("[动态代理][日志] " + method.getName() + "，结 果：" + result);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("[动态代理][日志] " + method.getName() + "，异 常：" + e.getMessage());
                } finally {
                    System.out.println("[动态代理][日志] " + method.getName() + "，方法 执行完毕");
                }
                return result;
            }
        };

        // newProxyInstance()：创建一个代理实例，其中有三个参数：
        // 1、classLoader：获取加载动态生成的代理类的类加载器
        // 2、interfaces：获取目标对象实现的所有接口的class对象所组成的数组
        // 3、invocationHandler：设置代理对象实现目标对象方法的过程，即代理类中如何重写接口中的抽象方法
        return Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }
}
```

（4）动态代理测试使用

```java
public class ProxyFactoryTest {
    public static void main(String[] args) {
        // 实现类接口
        CalculatorImpl calculator = new CalculatorImpl();
        // 使用代理类的有参构造，为计算器类赋值
        ProxyFactory factory = new ProxyFactory(calculator);
        // 调用方法创建动态代理类
        Calculator proxy = (Calculator) factory.getProxy();
        // 调用方法
        int add = proxy.add(1, 3);
    }
}
```

#### CGLIB动态代理简介

（1）上述案例都是基于JDK实现的动态代理，有一个最致命的问题是其只能代理实现了接口的类。为了解决这个问题，可以用 CGLIB 动态代理机制来避免，CGLIB 可以代理未实现任何接口的类

（2）[CGLIB](https://github.com/cglib/cglib)(*Code Generation Library*)是一个基于[ASM](http://www.baeldung.com/java-asm)的字节码生成库，它允许我们在运行时对字节码进行修改和动态生成。CGLIB 通过继承方式实现代理。很多知名的开源框架都使用到了[CGLIB](https://github.com/cglib/cglib)， 例如 Spring 中的 AOP 模块中：如果目标对象实现了接口，则默认采用 JDK 动态代理，否则采用 CGLIB 动态代理。

（3）CGLIB 动态代理是通过生成一个被代理类的子类来拦截被代理类的方法调用，因此不能代理声明为 final 类型的类和方法

（4）CGLIB 动态代理类使用步骤

```java
1、定义一个类，用于被增强
2、自定义类实现MethodInterceptor接口，重写接口的intercept方法
3、通过Enhancer类的create()方法创建代理类
```



#### CGLIB动态代理计算机案例

（1）JDK 动态代理不需要额外的依赖，但CGLIB实际是属于一个开源项目，如果要使用，需要手动添加相关依赖。

```xml
<dependencies>
    <!-- CGLIB依赖 -->
	<dependency>
		<groupId>cglib</groupId>
		<artifactId>cglib</artifactId>
		<version>3.3.0</version>
	</dependency>
</dependencies>
```

（2）计算机接口

```java
public interface Calculator {
    // 加
    int add(int i, int j);

    // 减
    int sub(int i, int j);

    // 乘
    int mul(int i, int j);

    // 除
    int div(int i, int j);
}
```

（3）计算机接口实现类，负责实际的操作

```java
public class CalculatorImpl implements Calculator {
    @Override
    public int add(int i, int j) {
        int result = i + j;
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = i - j;
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result = i * j;
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result = i / j;
        return result;
    }
}
```

（4）方法拦截器

```java
/**
 * 自定义类实现MethodInterceptor接口，重写接口的intercept方法（方法拦截器）
 */
public class DebugMethodInterceptor implements MethodInterceptor {
    /**
     * intercept方法用于拦截并增强被代理类的方法，类似JDK动态代理中的invoke方法
     *
     * @param o           代理对象（增强的对象）
     * @param method      被拦截的方法（需要增强的方法）
     * @param args        方法入参
     * @param methodProxy 用于调用原始方法
     */
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Object result = null;
        try {
            System.out.println("[动态代理][日志] " + method.getName() + "，参 数：" + Arrays.toString(args));
            result = methodProxy.invokeSuper(o, args);
            System.out.println("[动态代理][日志] " + method.getName() + "，结 果：" + result);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[动态代理][日志] " + method.getName() + "，异 常：" + e.getMessage());
        } finally {
            System.out.println("[动态代理][日志] " + method.getName() + "，方法 执行完毕");
        }
        return result;
    }
}
```

（5）生产代理对象的工厂类

```java
/**
 * 代理工厂，用于获取代理类
 */
public class CglibProxyFactory {
    /**
     * 根据加载到内存中的被代理类，动态的创建一个代理类及其对象
     * @return 返回一个代理类的对象
     */
    public static Object getProxy(Class<?> clazz) {
        // 创建动态代理增强类
        Enhancer enhancer = new Enhancer();
        // 设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        // 设置被代理类
        enhancer.setSuperclass(clazz);
        // 设置方法拦截器
        enhancer.setCallback(new DebugMethodInterceptor());
        // 创建代理类
        return enhancer.create();
    }
}
```

（6）CGLIB动态代理测试使用

```java
public class DebugMethodInterceptorTest {
    public static void main(String[] args) {
        // 调用方法创建动态代理类对象
        CalculatorImpl proxy = (CalculatorImpl) CglibProxyFactory.getProxy(CalculatorImpl.class);
        // 调用方法
        int add = proxy.add(1, 3);
    }
}
```

