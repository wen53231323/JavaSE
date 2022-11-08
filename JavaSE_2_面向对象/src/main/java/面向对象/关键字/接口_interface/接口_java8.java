package 面向对象.关键字.接口_interface;
/*
 * jdk8:除了定义全局常量和抽象方法之外，还可以定义静态方法，默认方法
 *
 */
public class 接口_java8 {
	public static void main(String[] args) {
		SubClass s=new SubClass();
//		s.method1();
//		SubClass.method1();
		//知识点1：接口中定义的静态方法，只能通过接口来调用
		CompareA.method1();
		//知识点2：通过实现类的对象，可以调用接口中的默认方法
		//如果实现类重写了接口中的默认方法，调用时。仍然调用的是重写以后的方法
		s.method2();
		//知识点3：如果子类(或实现类)继承的父类和实现的接口中声明了同名同参的方法
		//那么子类在没有重写此方法的情况下，默认调用的是父类中同名同参数的方法-->类优先原则
		//知识点4:如果实现类实现了多个接口，而这多个接口中定义了同名同参数的默认方法
		//那么在实现类没有重写此方法的情况下，报错-->接口冲突
		//这就需要我们必须在实现类中重写此方法
		s.method3();
		System.out.println("--------------");
		s.method();
	}
}
//接口A
interface CompareA{
	//静态方法
	public static void method1() {
		System.out.println("北京1");
	}
	//默认方法
	public default void method2() {
		System.out.println("上海1");
	}
	default void method3() {
		System.out.println("广州1");
	}
}
//接口B
interface CompareB{
	default void method3() {
		System.out.println("广州3");
	}
}
//父类
class Superclass{
	public void method3() {
		System.out.println("广州2");
	}
}
//继承父类并多实现接口AB
//class SubClass implements CompareA,CompareB{
class SubClass extends Superclass implements CompareA,CompareB{
	public void method2() {
		System.out.println("上海2");
	}
	public void method3() {
		System.out.println("广州4");
	}
	//知识点5：如何在子类(或实现类)的方法中调用父类、接口中被重写的方法
	public void method() {
		method3();//调用自己定义的重写的方法
		super.method3();//调用的是父类中声明的
		//调用接口中的默认方法
		CompareA.super.method3();
		CompareB.super.method3();
	}
}