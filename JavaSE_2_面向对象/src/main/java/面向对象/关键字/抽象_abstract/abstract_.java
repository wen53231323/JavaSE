package 面向对象.关键字.抽象_abstract;
/*
 * abstract关键字的使用
 * 1.abstract:抽象的
 * 2.abstract可以用来修饰的结构:类、方法
 * 
 * 3.abstract修饰类：抽象类
 * 		>此类不能实例化
 * 		>抽象类中一定有构造器，便于子类对象实例化时调用(涉及:子类对象实例化的全过程)
 * 		>开发中，都会提供抽象类的子类，让子类对象实例化，完成相关的操作
 * 4.abstract修饰方法：抽象方法
 * 		>抽象方法只有方法的声明，没有方法体
 * 		>包含抽象方法的类，一定是一个抽象类，反之，抽象类中可以没有抽象方法的
 * 		>若子类重写了父类中的所有的抽象方法后，此子类可实例化
 * 		 若子类没有重写父类中的所有的抽象方法，此子类也是一个抽象类，需要用abstract修饰
 * 5.abstract使用上的注意点：
 * 		>abstract不能用来修饰：属性、构造器等结构
 * 		>abstract不能用来修饰私有方法、静态方法、final的方法、final的类
 * 
 * */
public class abstract_{
	public static void main(String[] args) {
		//一旦Person类抽象了，就不可实例化
//		Person p1=new Person();
//		p1.eat();
	
	}
}
//父
abstract class Creature{
	//抽象方法
	public abstract void breath();
}
//子1
abstract class Person extends Creature{
	String name;
	int age;
	//构造器
	public Person() {
		
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	//不是抽象方法
	public void eat() {
		
	}
	//抽象方法
	public abstract void eat2();
	
}
//子2
class Student extends Person {
	
	//构造器
	public Student(){
		
	}
	public Student(String name,int age) {
		super(name,age);
		
	}
	//重写方法
	public void eat2() {
		System.out.println("吃饭");
	}
	public void breath() {
		System.out.println("呼吸");
	}
}
