package 三大特征.多态.类型转换;

public class 类型转换 {
    public static void main(String[] args) {
        /**
         * 有了对象的多态性以后，内存中实际上是加载了子类特有的属性和方法的，
         * 但是由于变量声明为父类类型，导致编译时，只能调用父类中声明的属性和方法,子类特有的属性和方法不能调用
         * */
        Animal cat = new Cat();
        // cat.sleep(); // 不能调用子类中特有的方法、属性,编译时，cat是父类Animal类型

        // 调用子类特有的属性和方法需要向下转型，使用强制类型转换符()
        Cat cat1 = (Cat) cat;
        cat1.sleep(); // 子类睡觉
    }
}

// 父类
class Animal {
    int id = 1001;
    String name;

    // 父类方法
    public void eat() {

    }
}

// 子类
class Cat extends Animal {
    int id = 1002;

    // 重写父类方法
    @Override
    public void eat() {
        System.out.println("子类吃饭");
    }

    // 子类特有方法
    public void sleep() {
        System.out.println("子类睡觉");
    }
}
