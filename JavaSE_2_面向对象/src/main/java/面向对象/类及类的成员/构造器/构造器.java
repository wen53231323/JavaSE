package 面向对象.类及类的成员.构造器;

/*
 * 类的结构之三，构造器(或构造方法、construction)的使用
 *
 * 一、构造器的作用
 * 1.创建对象
 * 2.初始化对象属性
 * 二、说明：
 * 1.如果没有显式的定义类的构造器的话，则系统默认提供一个空参的构造器
 * 2.定义构造器的格式：权限修饰符 类名(形参列表){}
 * 3.一个类中定义的多个构造器，彼此构成重载
 * 4.一旦我们显式的定义了类的构造器之后，系统就不再提供默认的空参构造器
 * 5.一个类中，至少会有一个构造器
 * */


//public class 构造器 {
//    public static void main(String[] args) {
//        //作用1创建类的对象：new+构造器
//        person diao = new person();
//        //作用2初始化对象属性
//        person diao1 = new person("小白");
//        System.out.println(diao1.name);
//    }
//}

// 类
class Person {
    // 属性
    String name;
    int age;

    // 无参构造器
    public Person() {
        System.out.println("使用了构造器");
    }

    // 含参构造器
    public Person(String n) {
        name = n;
    }

    //方法
    public void eat() {

    }
}
