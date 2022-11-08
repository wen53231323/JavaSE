package 关键字.接口_interface;

//新特性练习
public class 接口_java8_lx {
    public static void main(String[] args) {
        D d = new D();
        d.Help();
    }
}

//接口A
interface A {
    default void Help() {
        System.out.println("aaa");
    }
}

//接口B
interface B {
    default void Help() {
        System.out.println("bbb");
    }
}

//父类C
class C {
    public void Help() {
        System.out.println("ccc");
    }
}

//继承D实现A,B
class D extends C implements A, B {
    public void Help() {
        System.out.println("ddd");////调用自己定义的重写的方法
        A.super.Help();//调用接口中的默认方法
        B.super.Help();//调用接口中的默认方法
        super.Help();//调用的是父类中声明的

    }

}