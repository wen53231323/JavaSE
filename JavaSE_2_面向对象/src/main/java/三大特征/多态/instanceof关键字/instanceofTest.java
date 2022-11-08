package 三大特征.多态.instanceof关键字;

public class instanceofTest {
    public static void main(String[] args) {
        /**
         *  instanceof关键字的使用方式：a instanceof A
         *  判断对象a是否是类A的实例，如果是，返回true：如果不是，返回false
         *  使用情境：为了避免在向下转型时出现ClassCastException的异常
         *  在向下转型之前，先进行instanceof的判断，
         *  如果返回true就进行向下转型，如果返回false，不进行向下转型
         */
        Animal cat = new Cat();
        Animal dog = new Dog();

        // 如果cat是Cat类的实例，就执行强制类型转换
        if (cat instanceof Cat) {
            Cat c = (Cat) cat; // 强制类型转换
            c.sleep(); // 调用子类特有方法
        }
        // 如果cat是Dog类的实例，就执行强制类型转换
        if (cat instanceof Dog) {
            Cat c = (Cat) cat; // 强制类型转换
            c.sleep(); // 调用子类特有方法
        }
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

// 子类1
class Cat extends Animal {
    int id = 1002;

    // 重写父类方法
    @Override
    public void eat() {
        System.out.println("子类1吃饭");
    }

    // 子类1特有方法
    public void sleep() {
        System.out.println("子类1睡觉");
    }
}

// 子类2
class Dog extends Animal {
    int id = 1003;

    // 重写父类方法
    @Override
    public void eat() {
        System.out.println("子类2吃饭");
    }

    // 子类2特有方法
    public void sleep() {
        System.out.println("子类2睡觉");
    }
}
