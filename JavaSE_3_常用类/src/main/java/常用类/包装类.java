package 常用类;

import org.junit.Test;

/*
 * 包装类的使用：
 * 1.java提供了8种基本数据类型对应的包装类，
 * 使得基本数据类型的变量具有类的特征
 *
 * 2.掌握的：基本数据类型、包装类、String之间的相互转换
 *
 *
 */
public class 包装类 {

    /**
     * String类型-->基本数据类型、包装类:调用包装类的parseXxx(String s)
     */
    @Test
    public void test5() {
        // 通过包装类的构造器实现
        int i = new Integer("123");
        System.out.println(i);
        // 通过包装类的parseXxx(String s)静态方法
        int num = Integer.parseInt("123");
        System.out.println(num);
    }

    /***
     * 基本数据类型、包装类-->String类型，调用String重载的valueOf(Xxx xxx)
     */
    @Test
    public void test4() {
        // 调用字符串重载的valueOf()方法
        String str = String.valueOf(1.23f);
        // 连接运算
        String intStr = 5 + "";
		System.out.println(str);
		System.out.println(intStr);
    }

    //jdk 5.0新特性：自动装箱与自动拆箱
    @Test
    public void test3() {
        //自动装箱：基本数据类型-->包装类
        int a = 13;
        Integer b = a;//自动装箱

        boolean c = true;
        Boolean d = c;//自动装箱

        //自动拆箱：包装类-->基本数据类型
        Integer e = 13;
        int f = e;//自动拆箱

    }

    //基本数据类型-->包装类：使用包装类的构造器
    @Test
    public void test1() {
        int num = 10;
//		System.out.println(num.toString());//基本数据类型没有类的方法
        //包装类Integer
        Integer bao1 = new Integer(num);
        //由于Integer类中重写了toString()方法所以输出的不是地址值
        System.out.println(bao1.toString());

        Integer bao2 = new Integer("123");//包装类Integer
        System.out.println(bao2.toString());

        Float bao3 = new Float("1.2f");//包装类Float
        System.out.println(bao3.toString());

        Boolean bao4 = new Boolean("123");//包装类Boolean
        System.out.println(bao4.toString());//false

        Order order = new Order();
        System.out.println(order.isMale);//false
        System.out.println(order.isfale);//null
    }

    //包装类-->基本数据类型：调用包装类的xxxValue()
    @Test
    public void test2() {
        Integer d1 = new Integer(12);
        int i1 = d1.intValue();
        System.out.println(i1);

        Float d2 = new Float("1.2");
        float i2 = d2.floatValue();
        System.out.println(i2);

    }

    //面试题
    @Test
    public void test6() {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        //地址值不同
        System.out.println(i == j);//flase

        //Integer内部定义了IntegerCache结构，IntegerCache中定义了Integer[]
        //保存了从-128——127范围的整数，如果我们使用自动装箱的方式，给Integer赋值的范围在
        //-128——127范围内时，可以直接使用数组中的元素，不用再new了。目的：提高效率
        Integer m = 1;
        Integer n = 1;

        System.out.println(m == n);//true

        Integer x = 128;
        Integer y = 128;

        System.out.println(x == y);//flase
    }
}

class Order {
    boolean isMale;
    Boolean isfale;
}


