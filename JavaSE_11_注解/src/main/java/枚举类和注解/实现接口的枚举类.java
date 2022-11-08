package 枚举类和注解;

public class 实现接口的枚举类 {
    public static void main(String[] args) {
        B shuzi = B.SHUZI;
        shuzi.show();
        B zimu = B.ZIMU;
        zimu.show();
    }
}

//接口A
interface A{
    void show();
}

//使用enum关键字定义枚举类B
enum B implements A {
    SHUZI("数字","123"){
        //重写接口中的shou()方法
        @Override
        public void show() {
            System.out.println("重写接口中的shou方法1");
        }
    },
    ZIMU("字母","abc"){
        //重写接口中的shou()方法
        @Override
        public void show() {
            System.out.println("重写接口中的shou方法2");
        }
    };
    //声明Season对象属性、 private final修饰
    private final String name;
    private final String names;
    //私有化的构造器，并给对象属性初始化
    private B(String name,String names){
        this.name=name;
        this.names=names;
    }
}

