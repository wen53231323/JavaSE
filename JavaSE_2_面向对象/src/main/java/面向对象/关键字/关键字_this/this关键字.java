package 面向对象.关键字.关键字_this;
/*
 * this关键字的使用
 * 
 * 1.可以用来修饰、调用：属性、方法、构造器
 * 2.this修饰属性和方法
 *   this理解为：当前对象 或 当前正在创建的对象
 *   
 *   2.1在类的方法中，我们可以使用“this.属性”或“this.方法”的方式，调用当前对象属性或方法。
 *   但是通常情况下，我们都选择省略“this.”特殊情况下，如果方法的形参和类的属性同名时，
 *   我们必须显式的使用“this.变量”的方式，表面此变量是属性，而非形参
 *   
 *   2.2在类的构造器中，我们可以使用“this.属性”或“this.方法”的方式，调用当前正在创建的对象属性或方法。
 *   但是通常情况下，我们都选择省略“this.”特殊情况下，如果构造器的形参和类的属性同名时，
 *   我们必须显式的使用“this.变量”的方式，表面此变量是属性，而非形参
 *   
 * 3.this调用构造器
 * 		1.我们在类的构造器中，可以
 * 		2.显式的使用“this(形参列表)”方式，调用本类中指定的其他构造器
 * 		3.构造器中不能通过“this(形参列表)”调用自己
 * 		4.如果一个类中有n个构造器，则最多有n-1构造器使用了“this(形参列表)”
 * 		5.构造器内部，最多只能声明一个“this(形参列表)”来调用其他构造器
 * 
 * */
public class this关键字 {
	public static void main(String[] args) {
		thislei diao=new thislei();//构造器中已经调用方法
		diao.setname("小白");
		diao.setage(18);
		System.out.println(diao.getname());
		System.out.println(diao.getage());
		System.out.println("*******************");
		thislei diao1=new thislei("大黄",19);//构造器中已经调用构造器，且调用的构造器中已经调用方法
		System.out.println(diao1.getname());
		System.out.println(diao1.getage());
	}

}
class thislei{
	private String name;
	private int age;
	public void setname(String name) {
		//this的使用,修饰属性
		this.name=name;
	}
	//构造器
	public thislei() {
		//构造器中调用方法
		this.eat();
	}
	public thislei(String name) {
		//构造器中调用构造器
		this();
		//构造器中调用属性
		this.name=name;
	}
	public thislei(String name,int age) {
		//构造器中调用构造器
		this("小白");
		//构造器中调用属性
		this.name=name;
		this.age=age;
	}
	//方法
	public void setage(int age){
		this.age=age;
	}
	public String getname() {
		return this.name;
	}
	public int getage() {
		return this.age;
	}
	public void eat() {
		System.out.println("吃饭");
		//this的使用,修饰方法
		this.sleep();
	}
	public void sleep() {
		System.out.println("睡觉");
	}
}
