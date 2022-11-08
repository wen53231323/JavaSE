

## 注解简介

（1）注解（Annotation）是JDK1.5引入的特性，可以用于对代码进行说明

（2）注解其实就是代码里的特殊标记，这些标记可以在编译、类加载、运行时被读取，并执行相应的处理，通过使用注解，程序员可以在不改变原有逻辑的情况下，在源文件中嵌入一些补充信息

（3）注解可以像修饰符一样被使用，可用于修饰包,类, 构造器, 方法, 成员变量, 参数, 局部变量的声明，这些信息被保存在注解的“name=value” 对中，

（4）在JavaSE中，注解的使用目的比较简单，例如标记过时的功能， 忽略警告等。在JavaEE/Android中注解占据了更重要的角色，例如 用来配置应用程序的任何切面，代替JavaEE旧版中所遗留的繁冗代码和XML配置等

（5）未来的开发模式都是基于注解的，注解是一种趋势，一定程度上可以说：框架 = 注解 + 反射 + 设计模式。

（6）JDK8中注解的新特性：可重复的注解、可用于类型的注解。

## 常见用途

| 作用     | 简介                                                         |
| -------- | ------------------------------------------------------------ |
| 编写文档 | 通过代码里标识的注解生成文档【生成文档doc文档】              |
| 代码分析 | 通过代码里标识的注解对代码进行分析【使用反射】               |
| 编译检查 | 通过代码里标识的注解让编译器能够实现基本的编译检查【Override】 |

## 注解分类

| 分类       | 简介                                                         |
| ---------- | ------------------------------------------------------------ |
| 基本注解   | Java自带的注解，使用注解标明后编译器就会进行检查。例如@Override、@Deprecated、@SuppressWarnings |
| 元注解     | 元注解是用于定义注解的注解，在JDK 1.5中提供了4个标准的元注解：@Target，@Retention，@Documented，@Inherited, 在JDK 1.8中提供了两个元注解 @Repeatable和@Native。 |
| 自定义注解 | 根据自己的需求定义注解，并可用元注解对自定义注解进行注解     |

## 基本注解

| 基本注解          | 简介                                                         |
| ----------------- | ------------------------------------------------------------ |
| @Override         | 用于标明重写某个方法，用于表示一个子类的方法重写了父类的方法，此注解只能修饰方法 |
| @Deprecated       | 用于标明某个类或方法过时，当程序使用已过时的类、方法时，编译器会给出警告。 |
| @SuppressWarnings | 用于标明要忽略的警告，被该注解修饰的元素以及它的所有子元素会取消显示指定的编译器警告 |

## 元注解

所有元注解定义在java.lang.annotation包下面，其中Annotation是注解的基本接口，所有的注解都继承这个接口。

| 元注解      | 简介                                                         |
| ----------- | ------------------------------------------------------------ |
| @Retention  | 用于标明注解被保留的阶段（生命周期）                         |
| @Target     | 用于标明注解使用的范围                                       |
| @Documented | 用于标明是否生成javadoc文档                                  |
| @Inherited  | 用于标明注解可继承                                           |
| @Native     | Java8 新增，指定字段是一个常量，使用 @Native 注解修饰成员变量，则表示这个变量可以被本地代码引用，常常被代码生成工具使用。不常使用，了解即可 |
| @Repeatable | Java8 新增，允许在相同的程序元素中重复注解，即可以在一个地方可以重复使用同一个注解，在需要对同一种注解多次使用时，往往需要借助 @Repeatable 注解，像spring中的包扫描注解就使用了这个 |

### @Retention

（1）用于标明注解被保留的阶段（生命周期），一共有三种策略，定义在RetentionPolicy枚举中

```java
public enum RetentionPolicy {
    /**
     * 源文件保留,注释将被编译器丢弃
     */
    SOURCE,

    /**
     * 编译期保留,注释由编译器记录在类文件中,但不需要在运行时被JVM保留,这是默认设置行为
     */
    CLASS,

    /**
     * 运行期保留，可通过反射去获取注解信息,注释由编译器和记录在类文件中,在运行时被JVM保留，因此它们可以被反射式读取
     */
    RUNTIME
}
```

（2）使用方式

```java
// 源文件保留
@Retention(RetentionPolicy.SOURCE)
// 编译期保留，默认值
@Retention(RetentionPolicy.CLASS)
// 运行期保留，可通过反射去获取注解信息
@Retention(RetentionPolicy.RUNTIME)
```

### @Target

（1）Target注解用来说明那些被它所注解的注解类可修饰的对象范围，取值范围定义在ElementType 枚举中

```java
public enum ElementType {
    TYPE, // 类、接口、枚举类

    FIELD, // 成员变量（包括enum枚举常量）

    METHOD, // 成员方法

    PARAMETER, // 方法参数

    CONSTRUCTOR, // 构造方法

    LOCAL_VARIABLE, // 局部变量

    ANNOTATION_TYPE, // 注解类型声明

    PACKAGE, // 包声明

    TYPE_PARAMETER, // 类型参数，JDK 1.8 新增

    TYPE_USE // 使用类型的任何地方，JDK 1.8 新增
}
```

（2）使用方式

```java
// 单个使用
@Target(ElementType.TYPE)
// 多个使用
@Target({TYPE, FIELD, METHOD})
```

### @Deprecated

表示所修饰的注解在被javadoc解析时，保留下来，生成javadoc文档

### @Inherited

被修饰的注解可以被继承

### @Native

 Java8 新增，指定字段是一个常量，使用 @Native 注解修饰成员变量，则表示这个变量可以被本地代码引用，常常被代码生成工具使用。不常使用，了解即可

### @Repeatable

Java8 新增，允许在相同的程序元素中重复注解，即可以在一个地方可以重复使用同一个注解，在需要对同一种注解多次使用时，往往需要借助 @Repeatable 注解，像spring中的包扫描注解就使用了这个

## 自定义注解

### 定义自定义注解

（1）自定义注解和创建接口非常相似，使用@interface声明，使用@interface自定义注解时，自动继承了java.lang.annotation.Annotation接口

```java
// 访问修饰符必须为public，不写默认为public;
[public] @interface 注解名称{
    方法体;
}
```

（2）方法体中的每一个方法实际上是声明了一个属性，方法名是属性的名称，方法的返回值类型是属性的类型，属性的类型可以为基本类型、String、enum、Class，如果方法体中只有一个参数，通常参数名为value

```java
@interface MyAnnotation {
    // 方法名称就是配置参数，类型可以为基本类型、String、enum、Class
    String value();
}
```

（3）在定义注解时也可以通过default来声明属性的默认值，如果没有默认值，代表后续使用注解时必须给该类型元素赋值

```java
@interface MyAnnotation {
    // 方法名称就是配置参数，可以为基本类型、String、enum、Class，通过default声明参数的默认值
    String value() default "参数默认值";
}
```

（4）在定义注解时，通常使用元注解@Retention指定注解的保留策略、使用元注解@Target指定注解的作用对象。

```java
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@interface MyAnnotation {
    // 方法名称就是配置参数，可以为基本类型、String、enum、Class，通过default声明参数的默认值
    String value() default "参数默认值";
}
```

（5）自定义注解必须配上注解的信息处理流程（使用反射）才有意义

### 使用自定义注解

自定义注解可以在类上使用、方法上使用、字段上使用

```java
// 类上使用自定义注解
@MyAnnotation(value = "test")
public class Demo {
	// 字段上使用自定义注解
    @MyAnnotation
    public int id;

    // 方法上使用自定义注解
    @MyAnnotation
    public void test() {
    }
}
```



