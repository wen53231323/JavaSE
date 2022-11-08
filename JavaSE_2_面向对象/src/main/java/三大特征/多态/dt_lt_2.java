package 三大特征.多态;

import java.util.Random;

//面试题：多态性是编译时行为还是运行时行为？
//多态性是运行时的行为
//证明如下：
public class dt_lt_2 {
    public static dongwu instance(int key) {
        switch (key) {
            case 0:
                return new gou();
            case 1:
                return new mao();
            default:
                return new yang();
        }
    }

    public static void main(String[] args) {
        int key = new Random().nextInt(3);//随机数
        System.out.println(key);
        dongwu d = instance(key);
        d.eat();
        d.shout();
    }

}

//动物(父类)
class dongwu {
    protected void eat() {
        System.out.println("吃");
    }

    public void shout() {
        System.out.println("叫");
    }

}

//狗(子类)
class gou extends dongwu {

    protected void eat() {
        System.out.println("狗吃肉");
    }

    public void shout() {
        System.out.println("汪！汪！汪！");
    }

}

//猫(子类)
class mao extends dongwu {

    protected void eat() {
        System.out.println("猫吃鱼");
    }

    public void shout() {
        System.out.println("喵！喵！喵！");
    }

}

//羊(子类)
class yang extends dongwu {
    protected void eat() {
        System.out.println("羊吃草");
    }

    public void shout() {
        System.out.println("咩！咩！咩！");
    }

}