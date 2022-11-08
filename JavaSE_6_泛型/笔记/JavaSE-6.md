## 泛型概括

（1）Java 泛型（generics）是 JDK 5 中引入的一个新特性，提供了编译时类型安全检测机制，该机制允许程序员在编译时检测到非法的类型

（2）所谓泛型，就是允许在定义类、接口时通过一个`标识`表示类中某个属性的类型或者是某个方法的返回值及参数类型。

（3）泛型可以统一集合中的数据类型，提高安全性，减少强制类型转换

## 集合中使用泛型

（1）不使用泛型时，会出现一些问题

```java
@Test
public void test1() {
    // 需求：不使用泛型，将学生成绩存入集合
    ArrayList arrayList = new ArrayList();
    arrayList.add(70);
    arrayList.add(80);
    arrayList.add(90);
    // 问题一：类型不安全，此时编译不出异常，但是不是需要存储的数据
    arrayList.add("小明");

    // 遍历集合
    for (Object o : arrayList) {
        // 问题二：强转时可能出现ClassCastException（类型转换异常）
        // 由于需要强转成int型输出成绩，一旦出现了其他数据类型的数据就会强转出错
        int results = (Integer) o;
        System.out.println(results);
    }
}
```

（2）使用了泛型后，会解决问题

```java
@Test
public void test2() {
	// 需求：使用泛型，将学生成绩存入集合
	ArrayList<Integer> arrayList = new ArrayList<Integer>();
	arrayList.add(70);
    arrayList.add(80);
    arrayList.add(90);
	// 此时编译非int时会报异常，保证了数据安全
	// arrayList.add("小明");

	// 遍历集合
	for (Integer i : arrayList) {
		// 此时不用强转就可以遍历
		System.out.println(i);
	}
}
```

## 泛型嵌套

```java
@Test
public void test3() {
    HashMap<String, Integer> map = new HashMap<>();
    map.put("a", 1);
    map.put("b", 2);
    map.put("c", 3);

    //泛型嵌套
    Set<Map.Entry<String, Integer>> entry = map.entrySet();
    //遍历
    Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();
    while (iterator.hasNext()) {
        Map.Entry<String, Integer> entry1 = iterator.next();
        String key = entry1.getKey();
        Integer value = entry1.getValue();
        System.out.println("key：" + key + "  " + "value：" + value);
        System.out.println("entry：" + entry1);
    }
}
```

## 泛型结构

### 泛型类

（1）语法

```java
// 类使用泛型
修饰符 class 类名<泛型类型>{}
```

（2）代码示例

```java
/**
 * 类中指定的泛型<T>可以随便写为任意标识，常见的有T、E、K、V等形式的参数。
 * 表示泛型泛型在定义的时候不具体，使用的时候确定泛型的具体数据类型，即在创建对象的时候确定泛型。
 */
public class Demo<T> {
    // 成员变量id的类型为T,T的类型由外部指定
    private T id;

    // 泛型构造方法形参id的类型也为T，T的类型由外部指定
    public Demo(T id) {
        this.id = id;
    }
    // 泛型方法getT的返回值类型为T，T的类型由外部指定
    public void setId(T id) {
        this.id = id;
    }
}
```

### 泛型方法

（1）语法

```java
// 方法使用泛型
修饰符 <泛型类型> 方法返回值 方法名(形参列表){方法体}
```

（2）代码示例

```java
public class Demo<T> {
	/**
     * @param t   传入泛型的参数
     * @param <T> 泛型的类型
     * @return T 返回值为T类型
     * 说明：
     * （1）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
     * （2）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
     * （3）与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E等形式的参数常用于表示泛型。
     */
    public <T> T testMethod(T t) {
        System.out.println(t.getClass());
        System.out.println(t);
        return t;
    }
}
```



### 泛型接口

（1）语法

```java
// 接口使用泛型
修饰符 interface 接口名<泛型类型>{}
```

（2）代码示例

```java
/**
 * 定义一个泛型接口
 */
public interface testInteface<T> {
    public abstract void add(T t);
}
```



## 泛型通配符

泛型通配符是问号`?`符号，可以在使用泛型的时候代表一切类型，不知道使用什么类型来接收的时候使用

```java
// List<?>是List<String>、List<Object>等各种泛型List的父类。
List<?>
Map<?,?>
```

## 泛型上下限

（1）语法及简介

| 上下限                            | 简介                                                         |
| --------------------------------- | ------------------------------------------------------------ |
| 类型名称 <? extends 类 > 对象名称 | 不能往里存，只能往外取，只能接收该类型及其子类，即<=         |
| 类型名称 <? super 类 > 对象名称   | 往外取只能赋值给Object变量，不影响往里存，只能接收该类型及其父类型，即>= |

（2）代码示例

```java
// 只允许泛型为Number及Number子类的引用调用,(无穷小,Number]
<? entends Number>
// 只允许泛型为Number及Number父类的引用调用,[Number,无穷大)
<? super Number> 
// 只允许泛型为实现Comparable接口的实现类的引用调用
<? entends Comparable>
```

（3）已知Object类、Animal类、Dog类、Cat类、其中Animal是Dog和Cat的父类

```java
class Animal{}//父类
class Dog extends Animal{}//子类
class Cat extends Animal{}//子类
```

泛型的上限只能是该类型的类型及其子类<? extends 类 >

```java
// ArrayList<? extends Animal> list1 = new ArrayList<Object>();//报错
ArrayList<? extends Animal> list2 = new ArrayList<Animal>();
ArrayList<? extends Animal> list3 = new ArrayList<Dog>();
ArrayList<? extends Animal> list4 = new ArrayList<Cat>();
```

泛型的下限只能是该类型的类型及其父类<? super 类 >

```java
ArrayList<? super Animal> list5 = new ArrayList<Object>();
ArrayList<? super Animal> list6 = new ArrayList<Animal>();
// ArrayList<? super Animal> list7 = new ArrayList<Dog>();//报错
// ArrayList<? super Animal> list8 = new ArrayList<Cat>();//报错
```

