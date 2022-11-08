package 面向对象.三大特征.多态;

public class 静态绑定和动态绑定 {
    public static void main(String[] args) {
        A b = new B();
        //编译时，只能调用父类中声明的属性和方法, 子类特有的属性和方法不能调用
        //b.name       //静态绑定
        //b.test1();   //静态绑定
        b.test();      //动态绑定

        //如何调用子类特有的属性和方法?
        //向下转型，使用强制类型转换符(可能出现ClassCastException的异常)
        B b1=(B)b;
        b1.test1();

    }
}
//父类A
class A{
    String name="父类属性";
    public void test(){
        System.out.println("父类方法");
    }
}
//子类B
class B extends A{
    String name="子类属性";
    public void test(){
        System.out.println("子类重写父类方法");
    }
    public void test1(){
        System.out.println("子类特有的方法");
    }
}