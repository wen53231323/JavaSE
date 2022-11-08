package 面向对象.类及类的成员.属性;
/*
 * 类中属性的使用：
 * 属性(成员变量)VS局部变量
 * 1.相同点：
 * 		1.1定义变量的格式：数据类型 变量名=变量值
 * 		1.2先声明，后使用
 * 		1.3变量都有其对应的作用域
 *
 * 2.不同点：
 * 		2.1在类中声明的位置的不同
 * 		属性：直接定义在类的一对{}内
 * 		局部变量：声明在方法内、方法形参、代码块内、构造器形参、构造器内部的变量
 * 		2.2关于权限修饰符的不同
 * 		属性：可以在声明属性时，指明其权限，使用权限修饰符
 * 			  常用的权限修饰符：private、public、缺省、protected-->封装性
 * 	局部变量：不可以使用权限修饰符
 * 		2.3默认初始化值得情况
 * 		属性：类的属性，根据其类型，都有默认初始化值
 * 			整型(byte,short,int,long):0
 * 			浮点型(float,double):0.0
 * 			字符型(char):0(或'/u0000'
 * 			布尔型(boolean):false
 *
 * 			引用数据类型(类，数组，接口)：null
 * 	局部变量：没有默认初始化值
 * 		意味着我们在调用局部变量之前，一定要显示赋值
 * 		特别的，形参在使用时，我们赋值即可
 * 		2.4在内存中加载的位置
 * 		属性：加载到堆空间中(非static)
 * 		局部变量：加载到栈空间
 *
 *对属性可以赋值的位置：
 * 1.默认初始化
 * 2.显式初始化
 * 3.构造器中初始化
 * 4.有了对象以后，可以通过"对象.属性"，"对象.方法"进行赋值
 * 5.在代码块中赋值
 *
 * 执行的先后顺序：1 --> 2/5 --> 3 --> 4
 * */
public class 属性概念 {
    public static void main(String[] args) {
        //创建类的对象
        srr xin=new srr();
        //调用属性：“对象.属性”
        System.out.println("整型默认初始化值"+xin.ceshi1);
        System.out.println("浮点型默认初始化值"+xin.ceshi2);
        System.out.println("字符型默认初始化值"+xin.ceshi3);
        System.out.println("布尔型默认初始化值"+xin.ceshi4);
        System.out.println("引用数据类型默认初始化值"+xin.ceshi5);

        //调用方法：“对象.方法”
        xin.tlak("中文");
        xin.eat();
    }
}

//创建类
class srr{
    //属性(或者成员变量)
    int ceshi1;
    double ceshi2;
    char ceshi3;
    boolean ceshi4;
    String ceshi5;
    //方法
    public void tlak(String language) {//language:形参，也是局部变量
        System.out.println("我们使用"+language+"进行交流");
    }
    public void eat() {
        String food="馒头";//局部变量
        System.out.println("我们吃："+food);
    }
}
