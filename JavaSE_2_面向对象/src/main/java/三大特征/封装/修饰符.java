package 三大特征.封装;

import org.junit.Test;

//四种权限修饰符的测试
//(从小到大排列)，private、缺省、protected、public
public class 修饰符 {
    @Test
    public void xsf1(){
        修饰符 xsf = new 修饰符();
        //diao.a;出了ceshi类后，私有的结构就不可以调用了
        xsf.b=2;
        xsf.c=3;
        //diao.name1();出了ceshi类后，私有的结构就不可以调用了
        xsf.name2();
        xsf.name3();
    }
    private int a;//私有
    int b;//缺省
    public int c;//公有

    private void name1() {
        a=1;
        b=2;
        c=3;
    }
    void name2() {
        a=1;
        b=2;
        c=3;
    }
    public void name3() {
        a=1;
        b=2;
        c=3;
    }
}

class 四种权限修饰符 {
    //四种权限修饰符
    private int order1;
    int order2;
    protected int order3;
    public int order4;
    //构造器
    public 四种权限修饰符() {

    }
    public 四种权限修饰符(int order1, int order2, int order3, int order4) {
        super();
        this.order1 = order1;
        this.order2 = order2;
        this.order3 = order3;
        this.order4 = order4;
    }
    //方法
    private void name1() {
    }
    void name2() {
    }
    protected void name3() {
    }
    public void name4() {
    }
}

//同一个包中的其他类，不可以调用私有的属性、方法
//不同包中的子类中，不可以调用声明为private和缺省权限的属性、方法
//不同包中的普通类中(非子类)，不可以调用声明为private、缺省、protected权限的属性、方法
class xsf3 {
    public static void main(String[] args) {
        四种权限修饰符 xsf = new 四种权限修饰符();
        //调用属性：
//		xsf.order1=1;//私有的不能调用
        xsf.order2=2;
        xsf.order3=3;
        xsf.order4=4;
        //调用方法
//		xsf.name1();//私有的不能调用
        xsf.name2();
        xsf.name3();
        xsf.name4();
    }
}
