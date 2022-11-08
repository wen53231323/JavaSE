package 三大特征.多态;

/*
 * 面向对象特征之三：多态性
 *
 * 1.理解多态性：可以理解为一个事物的多种形态
 * 2.何为多态性：
 * 		父类的引用指向子类的对象(或子类的对象赋给父类引用)
 * 3.多态的使用：虚拟方法调用
 * 		有了对象的多态性以后，我们在编译期，只能调用父类中声明的方法，但在运行期，我们实际执行的是子类重写父类的方法
 * 		总结：编译，看左边，运行，看右边
 *
 * 4.多态性的使用前提：
 * 		1.要有类的继承关系
 * 		2.要有方法的重写
 *
 * 5.对象的多态性只适用于方法，不适用于属性(编译和运行都看左边)
 *
 * 6.多态性是运行时的行为
 *
 * 7.有了对象的多态性以后，内存中实际上是加载了子类特有的属性和方法的，
 * 但是由于变量声明为父类类型，导致编译时，只能调用父类中声明的属性和方法,
 * 子类特有的属性和方法不能调用
 *
 * 8.如何调用子类特有的属性和方法?
 * 向下转型，使用强制类型转换符
 * 使用强制转换时，可能出现ClassCastException的异常
 *
 * 9.instanceof关键字的使用：
 * 		a instanceof A:判断对象a是否是类A的实例，
 * 		如果是，返回true：如果不是，返回false
 * 使用情境：为了避免在向下转型时出现ClassCastException的异常
 * 我们在向下转型之前，先进行instanceof的判断，一旦返回true
 * 就进行向下转型，如果返回false，不进行向下转型
 *
 * 如果a instanceof A返回true，则a instanceof B也返回true
 * 	其中，类B是类A的父类
 *
 * */
public class 多态例子 {
    public static void main(String[] args) {
        // 对象的多态性：父类的引用指向子类的对象
        Animal animal1 = new Cat();
        Animal animal2 = new Dog();

        // 多态的使用：当调用父类同名同参数的方法时，实际执行的是子类重写父类的方法（虚拟方法调用）
        animal1.eat();// 子类1吃饭
        animal2.eat();// 子类2吃饭

        // 对象的多态性只适用于方法，不适用于属性(静态绑定)
        System.out.println(animal1.id); //1001
        System.out.println(animal2.id); //1001
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
}

// 子类2
class Dog extends Animal {
    int id = 1003;

    // 重写父类方法
    @Override
    public void eat() {
        System.out.println("子类2吃饭");
    }
}

