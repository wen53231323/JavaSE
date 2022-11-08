package 类及类的成员.代码块;



public class A {
    // 成员内部类
    public class B {

    }

    // 静态内部类
    public static class C {

    }

    public void m() {
        // 局部内部类
        class C {

        }
    }

    public static void main(String[] args) {
        // 匿名内部类
        new Test() {

        };
    }
}

class Test {

}
