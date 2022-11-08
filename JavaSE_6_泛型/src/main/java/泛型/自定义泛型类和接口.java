package 泛型;

import org.junit.Test;

public class 自定义泛型类和接口 {
    @Test
    public void test(){
        //如果定义了泛型类，实例化时没指明类的泛型，则默认泛型类型为Object类型
        //要求：如果定义了类是带泛型的，建议在实例化时要指明类的泛型
        test1<String> t1 = new test1<String>("a","b");
        t1.setT("String");
        test2 t2 = new test2();
        t2.setT(1);
        test3<Object> t3 = new test3<>();
        t3.setT("Object");
    }

}
//自定义泛型类
class test1<T>{
    String name;
    //类的内部可以使用类的泛型
    T t;

    //构造器
    public test1(){

    }
    public test1(String name, T t) {
        this.name = name;
        this.t = t;
    }

    //get、set
    public T getT() {
        return t;
    }
    public void setT(T t) {
        this.t = t;
    }

    //toString
    @Override
    public String toString() {
        return "test{" +
                "name='" + name + '\'' +
                ", t=" + t +
                '}';
    }
}
//此时test2是普通类，test2继承test1
//由于子类在继承带泛型的父类时，指明了泛型类型，则实例化子类对象时，不再需要指明泛型
class test2 extends test1<Integer>{

}
//此时test3<T>是泛型类
class test3<T>extends test1<T>{

}

