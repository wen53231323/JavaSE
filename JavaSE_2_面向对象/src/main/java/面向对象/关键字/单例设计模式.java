package 面向对象.关键字;

/*
 * 单例设计模式：
 * 1.所谓类单例设计模式，就是采取一定的方法保证在整个的软件系统中，对某个类只能存在一个对象实例
 * 
 * 2.如何实现
 * 饿汉式 VS 懒汉式
 * 
 * 3.区分饿汉式和懒汉式
 * 饿汉式：
 * 		坏处：对象加载时间过长
 * 		好处：饿汉式是线程安全的
 * 懒汉式：
 * 		好处：延迟对象的创建
 * 		目前的写法坏处：线程不安全 --->多线程内容时再修改
 * 
 * */


public class 单例设计模式 {
	public static void main(String[] args) {
		//饿汉式
		Back back1=Back.getBack();
		Back back2=Back.getBack();
		
		System.out.println(back1==back2);//true
		
		//懒汉式
		Orderss order1=Orderss.getorder();
		Orderss order2=Orderss.getorder();
		
		System.out.println(order1==order2);
	}
}
//饿汉式
class Back{
	//1.私有的构造器(为了避免外部创建对象)
	private Back() {
		
	}
	//2.内部创建类的对象
	//4.要求此对象也必须声明为静态的
	private static Back back=new Back();
	
	//3.提供公共的静态的方法，返回类的对象
	public static Back getBack() {
		return back;
	}
	
}
//懒汉式
class Orderss{
	//1.私有化类的构造器
	private Orderss() {
		
	}
	//2.声明当前类对象，没有初始化
	//4.此对象也必须声明为static的
	private static Orderss order=null;

	//3.声明public、static的返回当前类对象的方法
	public static Orderss getorder() {
		if (order==null) {
			order=new Orderss();
		}
		return order;
	}
	
}



