
## 准备工作

（1）创建Maven工程，在pom中引入lobok依赖

```xml
<dependencies>
	<!-- lombok -->
	<dependency>
		<groupId>org.projectlombok</groupId>
		<artifactId>lombok</artifactId>
		<version>1.18.22</version>
	</dependency>
</dependencies>
```

（2）创建一个用户类，类中提供静态方法，用来返回用户集合列表

```java
// 代表get、set、toString、equals、hashCode等操作
@Data
// 代表无参构造
@NoArgsConstructor
// 代表全参构造
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private List<String> hobby;

    /**
     * 静态方法，返回用户集合列表
     */
    public static List<User> getUserList() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1001, "张三", 18, Arrays.asList("唱歌", "打球")));
        userList.add(new User(1001, "张三", 18, Arrays.asList("唱歌", "打球")));
        userList.add(new User(1002, "李四", 19, Arrays.asList("唱歌", "打球")));
        userList.add(new User(1002, "李四", 19, Arrays.asList("唱歌", "打球")));
        userList.add(new User(1003, "王五", 20, Arrays.asList("唱歌", "打球")));
        userList.add(new User(1004, "赵六", 21, Arrays.asList("唱歌", "打球")));
        userList.add(new User(1005, "小明", 24, Arrays.asList("唱歌", "打球")));
        userList.add(new User(1006, "小刚", 22, Arrays.asList("唱歌", "打球")));
        userList.add(new User(1007, "小红", 25, Arrays.asList("唱歌", "打球")));
        userList.add(new User(1008, "小林", 13, Arrays.asList("唱歌", "打球")));
        return userList;
    }
}
```



## Lambda表达式（Java8）

### Lambda表达式简介

（1）Lambda表达式是Java SE 8中一个重要的新特性中（语法糖），可以对某些匿名内部类的写法进行简化，是函数式编程思想的一个重要体现。

（2）函数式编程思想不用关注是什么对象，而是更关注对数据进行了什么操作

（3）Lambda 表达式（Lambda expression）可以看作是一个匿名函数，基于数学中的λ演算得名，也可称为闭包（Closure）

### Lambda表达式的语法

```java
(paramaters)->{方法体}
```

| 组成       | 简介                                                         |
| ---------- | ------------------------------------------------------------ |
| paramaters | 参数列表，这里的参数是函数式接口里的参数。  可以明确的声明，也可不声明而由JVM隐含的推断，当只有一个推断类型时可以省略掉圆括号。 |
| ->         | 箭头操作符，可理解为“被用于”的意思                           |
| 方法体     | 表达式或代码块，抽象方法的实现逻辑，是函数式接口里方法的实现。<br>如果是代码块，可以返回一个值或者什么都不返回，等同于方法的方法体<br>如果是表达式，可以返回一个值或者什么都不反回，等同于方法的方法体 |

### Lambda省略规则

```java
1、参数类型可以省略，如果需要省略，每个参数的类型都要省略。
2、参数的小括号里面只有一个参数，那么小括号可以省略
3、如果方法体当中只有一句代码，那么大括号可以省略
4、如果方法体中只有一条语句，其是return语句，那么大括号可以省略，且去掉return关键字。
```

### Lambda表达式优缺点

| 优缺点 | 简介                                                         |
| ------ | ------------------------------------------------------------ |
| 优点   | 代码简洁，开发迅速，方便函数式编程，非常容易进行并行计算  Java 引入 Lambda，改善了集合操作 |
| 缺点   | 代码可读性变差，不容易进行调试  在非并行计算中，很多计算未必有传统的 for 性能要高 |

### 函数式接口

有且仅有一个抽象方法的接口称为函数式接口，`使用Lambda必须具有函数式接口，且要求接口中有且只有一个抽象方法`

#### Java 内置四大核心函数式接口

| 函数式接口              | 参数类型 | 返回类型 | 用途                                                         |
| ----------------------- | -------- | -------- | ------------------------------------------------------------ |
| Consumer<T> 消费型接口  | T        | void     | 对类型为T的对象应用操作，包含方法：  void accept(T t)        |
| Supplier<T> 供给型接口  | 无       | T        | 返回类型为T的对象，包含方法：T  get()                        |
| Function<T,R>函数型接口 | T        | R        | 对类型为T的对象应用操作，并返回结果。结  果是R类型的对象。包含方法：R apply(T t) |
| Predicate<T> 断定型接口 | T        | boolean  | 确定类型为T的对象是否满足某约束，并返回  boolean 值。包含方法：boolean test(T t) |

#### 其他函数式接口

| 函数式接口                            | 参数类型 | 返回类型 | 用途                                                         |
| ------------------------------------- | -------- | -------- | ------------------------------------------------------------ |
| BiFunction<T,U,R>                     | T,U      | R        | 对类型为 T, U 参数应用操作，返回 R  类型的结 果。包含方法为： R apply(T t, U u); |
| UnaryOperator<T> (Function子接口)     | T        | T        | 对类型为T的对象进行一元运算，并返回T类型的  结果。包含方法为：T apply(T t); |
| BinaryOperator<T> (BiFunction 子接口) | T,T      | T        | 对类型为T的对象进行二元运算，并返回T类型的  结果。包含方法为： T apply(T t1, T t2); |
| BiConsumer<T,U>                       | T,U      | void     | 对类型为T, U 参数应用操作。  包含方法为： void accept(T t, U u) |
| BiPredicate<T,U>                      | T,U      | boolean  | 包含方法为： boolean test(T  t,U u                           |
| ToIntFunction<T>                      | T        | int      | 计算int值的函数                                              |
| ToLongFunction<T>                     | T        | long     | 计算long值的函数                                             |
| ToDoubleFunction<T>                   | T        | double   | 计算double值的函数                                           |
| IntFunction<R>                        | int      | R        | 参数为int类型的函数                                          |
| LongFunction<R>                       | long     | R        | 参数为long类型的函数                                         |
| DoubleFunction<R>                     | double   | R        | 参数为double 类型的函数                                      |

#### 自定义函数式接口

如果一个接口只有一个抽象方法，那么该接口就是一个函数式接口

```java
// 自定义函数式接口
interface NoParameterNoReturn {
    //注意：只能有一个抽象方法
    void test();
}
```

#### @FunctionalInterface注解

如果在某个接口上声明了@FunctionalInterface注解，那么编译器就会按照函数式接口的定义来要求该接口，这样如果有两个抽象方法，会自动进行检测，程序编译就会报错，只要保证接口中只有一个抽象方法，可以不加这个注解

```java
@FunctionalInterface
interface NoParameterNoReturn {
    //注意：只能有一个抽象方法
    void test();
}
```

### Lambda表达式简单使用

```java
// 函数式接口
@FunctionalInterface
interface NoParameterNoReturn {
    //注意：只能有一个抽象方法
    void test();
}

public class LambdaTest {
    // 原本方式
    @Test
    public void test1() {
        // 实现接口，重写方法（匿名实现类）
        new NoParameterNoReturn() {
            @Override
            public void test() {
                System.out.println("");
            }
        };
    }

    // Lambda简化
    @Test
    public void test2() {
        NoParameterNoReturn e = () -> System.out.println("hello world");
        e.test();
    }

}
```

### Lambda表达式六种使用情况

#### 无参无返回值

```java
// 函数式接口
@FunctionalInterface
interface NoParameterNoReturn {
    // 无参无返回值，注意：只能有一个抽象方法
    void test();
}

public class lambdaTest {
    // 原本方式
    @Test
    public void test1() {
        // 实现接口，重写方法（匿名实现类）
        new NoParameterNoReturn() {
            @Override
            public void test() {
                System.out.println("无参数无返回值");
            }
        };
    }

    // Lambda简化
    @Test
    public void test2() {
        NoParameterNoReturn n = () -> System.out.println("无参数无返回值");
        n.test();
    }

}
```

#### 一参数无返回值

```java
// 函数式接口
@FunctionalInterface
interface OneParameterNoReturn {
    //一个参数无返回值
    void test(int a);
}

public class lambdaTest {
    @Test
    public void test() {
        OneParameterNoReturn oneParameterNoReturn = (int a) -> {
            System.out.println("无参数一个返回值：" + a);
        };
        oneParameterNoReturn.test(10);
    }
}
```

#### 多参数无返回值

```java
// 函数式接口
@FunctionalInterface
interface MoreParameterNoReturn {
    // 多个参数无返回值
    void test(int a, int b);
}

public class lambdaTest {
    @Test
    public void test() {
        MoreParameterNoReturn moreParameterNoReturn = (int a, int b) -> {
            System.out.println("无返回值多个参数：" + a + "," + b);
        };
        moreParameterNoReturn.test(20, 30);
    }
}
```

#### 无参有返回值

```java
// 函数式接口
@FunctionalInterface
interface NoParameterReturn {
    // 无参数有返回值
    int test();
}

public class lambdaTest {
    @Test
    public void test(){
        NoParameterReturn noParameterReturn = () -> {
            System.out.println("有返回值无参数！");
            return 30;
        };
        // 接收函数的返回值
        int num = noParameterReturn.test();
        System.out.println(num);
    }
}
```

#### 一参数有返回值

```java
// 函数式接口
@FunctionalInterface
interface OneParameterReturn {
    //一个参数有返回值
    int test(int a);
}

public class lambdaTest {
    @Test
    public void test(){
        OneParameterReturn oneParameterReturn = (int a) -> {
            System.out.println("有返回值有参数！");
            return a;
        };
        // 接收函数的返回值
        int num = oneParameterReturn.test(50);
        System.out.println(num);
    }
}
```

#### 多参有返回值

```java
// 函数式接口
@FunctionalInterface
interface MoreParameterReturn {
    //多参数有返回值
    int test(int a, int b);
}

public class lambdaTest {
    @Test
    public void test(){
        MoreParameterReturn moreParameterReturn = (int a, int b) -> {
            System.out.println("有返回值多个参数！");
            return a + b;
        };
        int num = moreParameterReturn.test(60, 70);
        System.out.println(num);
    }
}
```



### 方法引用

（1）方法引用可以看做是Lambda表达式深层次的表达，当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用

（2）使用双冒号操作符（**::**） 将类(或对象) 与 方法名分隔开来。

```java
对象::实例方法名
类::静态方法名
类::实例方法名（非静态方法）
```

（3）代码示例

```java
// 函数式接口
@FunctionalInterface
interface MethodReferences<T> {
    T test();
}

public class 方法引用 {

    /**
     * 方法引用是java8中特定情况下,简化lambada表达式的一种语法糖
     */
    @Test
    public void test() {
        List<String> city = Arrays.asList("A", "B", "C");
        // 使用lambada表达式遍历
        city.forEach(i -> System.out.println(i));
        // 使用方法引用遍历打印
        city.forEach(System.out::println);
    }

    /**
     * 对象::非静态方法
     */
    @Test
    public void test1() {
        User user = new User();
        // 不使用方法引用
        MethodReferences<Integer> m1 = () -> user.getAge();
        // 使用方法引用
        MethodReferences<Integer> m2 = user::getAge;
    }

    /**
     * 类名::静态方法
     */
    @Test
    public void test2() {
        // 类名::静态方法
        MethodReferences<List<User>> getUserList = User::getUserList;
    }

    /**
     * 类名::非静态方法（实例方法）
     */
    @Test
    public void test3() {
        // 类名::非静态方法
        Function<User, String> getName = User::getName;
    }
}
```



### 构造器引用

```java
public class Demo {
    public void test() {
        // 这里是调用的无惨构造方法，因为Supplier的get()无参
        Supplier<User> sup = User::new;
        User user = sup.get();
    }
}
```



## Stream流（Java8）

### Stream流简介

（1）Stream流结合了Lambda表达式，用于简化集合、数组操作的API

（2）Stream 和 Collection 集合的区别

| 对比       | 区别                                                         |
| ---------- | ------------------------------------------------------------ |
| Collection | 是一种静态的内存数据  结构，面向内存，存储在内存中           |
| Stream     | 用于操作数据源（集合、数组等）所生成的元素序列，面向  CPU，通过 CPU 实现计算 |

（3）Stream流使用流程

| 流程   | 简介                                               |
| ------ | -------------------------------------------------- |
| 创建流 | 将数据源转换为Stream流                             |
| 操作流 | 中间操作链，对数据源的数据进行处理（过滤、聚合等） |
| 结束流 | 终止操作，执行中间操作链，并产生结果               |

### Stream流创建的五种方式

#### 通过集合创建Stream流（最常用）

通过集合创建Stream流（最常用），Java8 中的 Collection 接口被扩展，提供了两个获取流的方法

| 方法               | 简介           |
| ------------------ | -------------- |
| `stream()`         | 返回一个顺序流 |
| `parallelStream()` | 返回一个并行流 |

```java
@Test
public void test1() {
    ArrayList list = new ArrayList();
    list.add(1);
    list.add(2);
    list.add(3);
    // 根据集合创建顺序流
    Stream stream1 = list.stream();
    // 根据集合创建并行流
    Stream stream2 = list.parallelStream();
}
```



#### 通过数组创建Stream流

通过数组创建Stream流，Java8 中的 Arrays 的静态方法 stream() 可以获取数组流

| 方法              | 简介       |
| ----------------- | ---------- |
| stream(T[] array) | 返回一个流 |

```java
@Test
public void test2() {
    int[] ints = {};
    // 根据int数组创建流
    IntStream stream = Arrays.stream(ints);
}
```



#### 通过Stream本身创建Stream流

通过Stream本身创建Stream流，调用Stream类静态方法 of(),通过显示值创建一个流,可以接收任意数量的参数

| 方法            | 简介       |
| --------------- | ---------- |
| of(T... values) | 返回一个流 |

```java
@Test
public void test3() {
    // 通过Stream本身创建Stream流
    Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
}
```



#### 通过函数创建Stream无限流

通过函数创建Stream无限流，使用静态方法 Stream.iterate() 和 Stream.generate()创建无限流

| 方法                                             | 简介                                                         |
| ------------------------------------------------ | ------------------------------------------------------------ |
| iterate(final T seed,  final UnaryOperator<T> f) | 迭代，指定一个常量seed，生成从seed到常量f的流                |
| generate(Supplier<T>  s)                         | 生成，返回无限顺序无序流，其中每个元素由提供的供应商生成，适用于生成恒定流，随机元素流等 |

```java
@Test
public void test4() {
    // 迭代
    Stream<Integer> iterate = Stream.iterate(0, n -> n + 2);
    // 生成
    Stream<Double> generate = Stream.generate(Math::random);
}
```



#### 通过文件创建Stream流

通过文件创建Stream流，通过Files.line方法得到一个流，并且得到的每个流是给定文件中的一行

```java
@Test
public void test5() {
    try {
        Stream<String> fileStream = Files.lines(Paths.get("test.txt"), Charset.defaultCharset());
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```



### Stream流中间操作链

#### 中间操作链简介

（1）通常对于Stream的中间操作，可以视为是源的查询，与数据库中视图的原理相似；

（2）Stream流的强大之处便是在于提供了丰富的中间操作，相比集合或数组这类容器，极大的简化源数据的计算复杂度

多个中间操作可以连接起来形成一个流水线，在终止操作时一次性全部处理，否则中间操作不会执行任何的处理，称为“惰性求值”

（3）一个流可以跟随零个或多个中间操作，其目的主要是打开流，做出某种程度的数据映射/过滤，然后返回一个新的流，交给下一个操作使用，这类操作都是惰性化的，仅仅调用到这类方法，并没有真正开始流的遍历，真正的遍历需等到终止操作时



#### 筛选与切片

| 流方法                 | 含义                                                         |
| ---------------------- | ------------------------------------------------------------ |
| `filter(Predicate p)`  | 过滤，接收  Lambda，通过设置的条件，从流中排除某些元素       |
| `distinct()`           | 去重，通过流所生成元素的  hashCode() 和 equals() 去除重复元素 |
| `limit(long maxSize) ` | 截断，返回一个不超过给定长度的流                             |
| skip(long n)           | 跳过，返回一个扔掉了前 n  个元素的流，若流中元素不足 n 个，则返回一 个空流，与 limit(n) 互补 |
| peek(Predicate p)      | 处理，对元素进行遍历处理                                     |

```java
public class Demo {

    /**
     * filter(Predicate p)：过滤，接收 Lambda，通过设置的条件，从流中排除某些元素
     * 案例：输出ID大于5的user对象
     */
    @Test
    public void test1() {
        List<User> userList = User.getUserList();
        userList.stream().filter(user -> user.getId() > 5).forEach(System.out::println);
    }

    /**
     * limit(long maxSize)：截断，返回一个不超过给定长度的流
     * 案例：输出前5个user对象
     */
    @Test
    public void test2() {
        List<User> userList = User.getUserList();
        userList.stream().limit(5).forEach(System.out::print);
    }

    /**
     * skip(long n)：跳过，返回一个扔掉了前 n 个元素的流，若流中元素不足 n 个，则返回一个空流，与 limit(n) 互补
     * 案例：跳过前5个user对象
     */
    @Test
    public void test3() {
        List<User> userList = User.getUserList();
        userList.stream().skip(5).forEach(System.out::println);
    }

    /**
     * distinct()去重，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
     * 案例：对list集合进行去重
     */
    @Test
    public void test4() {
        List<User> userList = User.getUserList();
        userList.stream().distinct().forEach(System.out::println);
    }

    /**
     * peek(Predicate p)：处理，对元素进行遍历处理
     * 案例：对元素进行遍历处理，每个用户年龄加1输出
     */
    @Test
    public void test6() {
        List<User> userList = User.getUserList();
        userList.stream().peek(user -> user.setId(user.getAge() + 1)).forEach(System.out::println);
    }

}
```

#### 映射

| 流方法                           | 含义                                                         |
| -------------------------------- | ------------------------------------------------------------ |
| `map(Function f)`                | 对流中每一个元素进行处理，返回一个值  接受一个函数作为参数，这个函数会被应用到每个元素上，并将其映射成一个新的元素 |
| `flatMap(Function f)`            | 流扁平化，将一个整体拆成一个一个的个体，称为扁平化（拆分层级，放到同一层）  接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流 |
| mapToDouble(ToDoubleFunction  f) | 接收一个函数作为参数，该函数会被应用到每个元  素上，产生一个新的 DoubleStream。 |
| mapToInt(ToIntFunction  f)       | 接收一个函数作为参数，该函数会被应用到每个元  素上，产生一个新的 IntStream。 |
| mapToLong(ToLongFunction  f)     | 接收一个函数作为参数，该函数会被应用到每个元  素上，产生一个新的 LongStream。 |

map(Function f)与flatMap(Function f)的区别与应用场景

| 流方法              | 本质区别                           |
| ------------------- | ---------------------------------- |
| map(Function f)     | 对一级元素进行操作，返回一个值     |
| flatMap(Function f) | 对二级元素操作，返回一个流，多个值 |

```java
public class Demo {

    // 静态方法，用来返回 列表中列表 [[1,2,3],[1,2,3]]
    private static List<List<Integer>> getList() {
        List<Integer> integers = Arrays.asList(1, 2, 3);
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(integers);
        lists.add(integers);
        return lists;
    }

    /**
     * map(Function f)：对流中每一个元素进行处理
     * 接受一个函数作为参数，这个函数会被应用到每个元素上，并将其映射成一个新的元素
     * 案例：将集合中的小写字符串转为大小
     */
    @Test
    public void test1() {
        List<String> arrayList = Arrays.asList("a", "b", "c");
        arrayList.stream().map(str -> str.toUpperCase()).forEach(System.out::print);
    }

    /**
     * flatMap(Function f)：流扁平化，将一个整体拆成一个一个的个体，称为扁平化（拆分层级，放到同一层）
     * 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
     * 案例1：拆分 ["Hello", "World"] 为 HelloWorld
     */
    @Test
    public void test2() {
        String[] words = new String[]{"Hello", "World"};// ["Hello", "World"]
        Arrays.stream(words)
                .map(str -> str.split("")) // 按空格分隔字符，形成多个字符（H e l l o W o r l d）
                .flatMap(
                        Arrays::stream // 获取内层数组的流对象
                )// 生成的多个流被合并起来，即扁平化为一个流
                .forEach(System.out::print);// 输出HelloWorld
    }

    /**
     * flatMap(Function f)：流扁平化，将一个整体拆成一个一个的个体，称为扁平化（拆分层级，放到同一层）
     * 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
     * 案例2：拆分 [[1,2,3],[1,2,3]] 为 123123
     */
    @Test
    public void test3() {
        List<List<Integer>> lists = getList();// [[1,2,3],[1,2,3]]
        lists.stream()
                .flatMap(
                        item -> item.stream()// 获取内层数组的流对象
                )// 将多个流扁平化为一个流
                .forEach(System.out::print);
    }

    /**
     * flatMap(Function f)：流扁平化，将一个整体拆成一个一个的个体，称为扁平化（拆分层级，放到同一层）
     * 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
     * 案例3：拆分 用户集合列表 获取 集合中数组中的数据
     */
    @Test
    public void test4() {
        List<User> userList = User.getUserList();
        userList.stream()
                .flatMap(
                        user -> user.getHobby().stream() // 获取数组的流对象
                )// 将多个流扁平化为一个流
                .forEach(System.out::print);
    }

}
```

#### 排序

| 流方法                  | 含义                             |
| ----------------------- | -------------------------------- |
| sorted()                | 自然排序，返回自然排序后的流     |
| sorted(Comparator  com) | 定制排序，返回按比较器排序后的流 |

```java
public class Demo {

    /**
     * sorted()：自然排序，返回自然排序后的流
     * 案例：从小到大自然排序
     */
    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(3, 1, 4, 2, 5);
        list.stream().sorted().forEach(System.out::print);// 12345
    }

    /**
     * sorted(Comparator com)：定制排序，按比较器排序后的流
     * 案例：按用户年龄排序
     */
    @Test
    public void test2() {
        List<User> userList = User.getUserList();
        userList.stream()
                .sorted((a, b) -> Integer.compare(a.getAge(), b.getAge()))
                .forEach(System.out::println);
    }

}
```

### Stream流终止操作

#### 终止操作简介

（1）终止操作的执行，才会真正开始流的中间操作，会从流的中间操作链生成结果，其结果可以是任何不是流的值

（2）Stream流执行完终端操作之后，无法再执行其他动作，否则会报状态异常，提示该流已经被执行操作或者被关闭，想要再次执行操作必须重新创建Stream流

（3）一个流有且只能有一个终端操作，当这个操作执行后，流就被关闭了，无法再被操作，因此一个流只能被遍历一次，若想在遍历需要通过源数据在生成流。



#### 匹配与查找

| **流方法**              | **含义**                                                     |
| ----------------------- | ------------------------------------------------------------ |
| allMatch(Predicate p)   | 检查是否匹配所有元素                                         |
| anyMatch(Predicate p)   | 检查是否至少匹配一个元素                                     |
| noneMatch(Predicate  p) | 检查是否没有匹配所有元素                                     |
| findFirst()             | 返回第一个元素                                               |
| findAny()               | 返回当前流中的任意元素                                       |
| count()                 | 返回流中元素总数                                             |
| sum(Comparator c)       | 求和，与maptoint中间操作结合使用                             |
| max(Comparator c)       | 返回流中最大值                                               |
| min(Comparator c)       | 返回流中最小值                                               |
| forEach(Consumer c)     | 遍历流，Stream  API内部进行迭代，若使用 Collection 接口需要用户去做迭代， 称为外部迭代。 |

```java
public class Demo {

    /**
     * allMatch(Predicate p)：检查是否匹配所有元素
     * 案例：判断用户年龄是否都大于10岁
     */
    @Test
    public void test1() {
        List<User> userList = User.getUserList();
        boolean b = userList.stream()
                .distinct()// 去重
                .allMatch(user -> user.getAge() > 10);// 其余的用户年龄是否都大于10
        System.out.println(b);
    }

    /**
     * anyMatch(Predicate p)：检查是否至少匹配一个元素
     * 案例：是否有一个用户名称为小明
     */
    @Test
    public void test2() {
        List<User> userList = User.getUserList();
        boolean b = userList.stream()
                .distinct()// 去重
                .anyMatch(user -> user.getName().equals("小明"));
        System.out.println(b);
    }

    /**
     * anyMatch(Predicate p)：检查是否至少匹配一个元素
     * 案例：是否没有用户名称为小明
     */
    @Test
    public void test3() {
        List<User> userList = User.getUserList();
        boolean b = userList.stream()
                .distinct()// 去重
                .noneMatch(user -> user.getName().equals("小明"));
        System.out.println(b);
    }

    /**
     * findFirst()：返回第一个元素
     * 案例：返回第一个元素
     */
    @Test
    public void test4() {
        List<User> userList = User.getUserList();
        Optional<User> first = userList.stream()
                .distinct()// 去重
                .findFirst();// 返回第一个元素
        System.out.println(first);
    }

    /**
     * findAny()：返回当前流中的任意元素
     * 案例：返回当前流中的任意元素
     * */
    @Test
    public void test5() {
        List<User> userList = User.getUserList();
        Optional<User> any = userList.parallelStream()
                .distinct()// 去重
                .findAny();// 返回当前流中的任意元素
        System.out.println(any);
    }

    /**
     * count()：返回流中元素总数
     * 案例：求总记录数
     * */
    @Test
    public void test6() {
        List<User> userList = User.getUserList();
        long count = userList.parallelStream()
                .distinct()// 去重
                .count();// 求总记录数
        System.out.println(count);
    }

    /**
     *sum(Comparator c)：求和，与maptoint中间操作结合使用
     *案例：求和
     * */
    @Test
    public void test7() {
        List<User> userList = User.getUserList();
        int sum = userList.parallelStream()
                .mapToInt(User::getId)// 转为IntStream
                .sum();// 求和
        System.out.println(sum);
    }

    /**
     *max(Comparator c)：返回流中最大值
     *案例：求最大值
     * */
    @Test
    public void test8() {
        List<User> userList = User.getUserList();
        OptionalInt max = userList.parallelStream()
                .mapToInt(User::getId)// 转为IntStream
                .max();// 最大值
        System.out.println(max);
    }

    /**
     * min(Comparator c)：返回流中最小值
     * 案例：求最小值
     *
     * */
    @Test
    public void test9() {
        List<User> userList = User.getUserList();
        OptionalInt max = userList.parallelStream()
                .mapToInt(User::getId)// 转为IntStream
                .min();// 最小值
        System.out.println(max);
    }

    /**
     * forEach(Consumer c)：遍历流
     * 案例：遍历打印
     * */
    @Test
    public void test10() {
        List<User> userList = User.getUserList();
        userList.parallelStream()
                .mapToInt(User::getId)// 转为IntStream
                .forEach(System.out::println);// 遍历
    }

}
```



#### 规约

| 流方法                            | 含义                                                      |
| --------------------------------- | --------------------------------------------------------- |
| reduce(T iden,  BinaryOperator b) | 可以将流中元素反复结合起来，得到一个值。返回  T           |
| reduce(BinaryOperator  b)         | 可以将流中元素反复结合起来，得到一个值。返回  Optional<T> |

```java
public class Demo {

    /**
     * reduce(T iden, BinaryOperator b)：可以将流中元素反复结合起来，得到一个值。返回 T
     * 案例：求和
     */
    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(1, 2, 3, 3);
        Integer reduce = list.stream()
                .distinct()// 去重 1,2,3
                .reduce(5, Integer::sum);// 初始值1，求和，5+1+2+3

        System.out.println(reduce);
    }

    /**
     * reduce(BinaryOperator b)：可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
     * 案例：求年龄之和
     */
    @Test
    public void test2() {
        List<User> userList = User.getUserList();
        OptionalInt reduce = userList.stream()
                .mapToInt(User::getAge)// 转为IntStream
                .reduce((a1, a2) -> a1 + a2);// 规约求年龄之和
        System.out.println(reduce);
    }

}
```

#### 汇总

| **流方法**           | **含义**                                                     |
| -------------------- | ------------------------------------------------------------ |
| collect(Collector c) | 收集器，把Stream流操作后的结果数据转换为其他形式（集合、数组）  接收一个 Collector  接口的实现，用于给Stream中元素做汇总的方法 |

```java
public class Demo {

    /**
     * collect(Collector c)：收集器，把Stream流操作后的结果数据转换为其他形式（集合、数组）
     * 接收一个 Collector 接口的实现，用于给Stream中元素做汇总的方法
     * 案例：收集用户名到列表
     */
    @Test
    public void test() {
        List<User> userList = User.getUserList();
        List<String> collect = userList.stream()
                .distinct()// 去重
                .map(user -> user.getName())// 获取用户名
                .collect(Collectors.toList());// 转换为数值
        System.out.println(collect);
    }

}
```



#### Collector收集策略接口

（1）Collector接口是结果收集策略的核心接口，具备将指定元素累加存放到结果容器中的能力

（2）在Collectors工具中提供了Collector接口的实现类，可以方便地创建常见收集器实例

| 方法              | 作用                                                         |
| ----------------- | ------------------------------------------------------------ |
| toList            | 把流中元素收集到List                                         |
| toSet             | 把流中元素收集到Set                                          |
| toMap             | 把流中元素收集到Map                                          |
| toCollection      | 把流中元素收集到创建的集合                                   |
| counting          | 计算流中元素的个数                                           |
| summingInt        | 对流中元素的整数属性求和                                     |
| averagingInt      | 计算流中元素Integer属性的平均值                              |
| summarizingInt    | 收集流中Integer属性的统计值,平均值                           |
| joining           | 连接流中每个字符串                                           |
| maxBy             | 根据比较器选择最大值                                         |
| minBy             | 根据比较器选择最小值                                         |
| reducing          | 从一个作为累加器的初始值开始，   利用BinaryOperator与流中元素逐个结合从而归约成单个值 |
| collectingAndThen | 包裹另一个收集器，对其结果转 换函数                          |
| partitioningBy    | 根据某属性值对流分组  属性为K， 结果为V                      |
| partitioningBy    | 根据true或false进行分区                                      |

## Optional类（Java8）

### Optional类简介

（1）为了解决空指针异常，Google公司著名的Guava项目引入了Optional类， Guava通过使用检查空值的方式来防止代码污染，它鼓励程序员写更干净的代码。

（2）受到Google Guava的启发，Optional类已经成为Java 8类库的一部分

 （3）Optional 类(java.util.Optional) 是一个容器类，它可以保存类型T的值，代表这个值存在，或者仅仅保存null，表示这个值不存在。原来用 null 表示一个值不存在，现在 Optional 可以更好的表达这个概念，并且可以避免空指针异常

（4）Optional提供很多有用的方法，这样我们就不用显式进行空值检测

### 创建Optional类对象的方法

| 方法                      | 简介                                 |
| ------------------------- | ------------------------------------ |
| Optional.of(T t)          | 创建一个 Optional  实例，t必须非空； |
| Optional.empty()          | 创建一个空的 Optional 实例           |
| Optional.ofNullable(T  t) | t可以为null                          |

### 判断Optional容器中是否包含对象

| 方法                               | 简介                                                         |
| ---------------------------------- | ------------------------------------------------------------ |
| boolean isPresent()                | 判断是否包含对象                                             |
| void  ifPresent(Consumer consumer) | 如果有值，就执行Consumer  接口的实现代码，并且该值会作为参数传给它。 |

### 获取Optional容器的对象

| 方法                                       | 简介                                                         |
| ------------------------------------------ | ------------------------------------------------------------ |
| T get()                                    | 如果调用对象包含值，返回该值，否则抛异常                     |
| T orElse(T other)                          | 如果有值则将其返回，否则返回指定的other对象。                |
| T orElseGet(Supplier  other)               | 如果有值则将其返回，否则返回由  Supplier接口实现提供的对象。 |
| T  orElseThrow(Supplier exceptionSupplier) | 如果有值则将其返  回，否则抛出由Supplier接口实现提供的异常。 |
