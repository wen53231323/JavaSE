package 面向对象.关键字.最终_final;

/*
 * final:最终的
 * 1.final可以用来修饰的结构：类、方法、变量
 * 2.final 用来修饰一个类:此类不能被其他类继承
 * 		比如：String类、System类、StringBuffer
 * 3.final 用来修饰方法，表明此方法不可以被重写
 * 		比如：Object类中getClass方法
 * 
 * 4.final 用来修饰变量：此时的“变量”就称为常量
 * 		4.1final修饰属性：
 * 			可以考虑赋值的位置有：显式初始化、代码块中初始化、构造器中初始化
 * 		4.2final修饰局部变量：
 * 			尤其是使用final形参时，表明此形参是一个常量，当我们调用此方法时，
 * 			给常量形参赋一个实参，一旦赋值以后，就只能在方法体内使用此形参，
 * 			但不能进行重新赋值
 * 
 * static final 用来修饰属性：全局变量
 * 
 * */
public class final_ {
	final int width=1;//显式初始化
	final int left;//代码块初始化
	final int right;//构造器初始化
	//代码块
	{
		left=1;
	}
	//构造器
	public final_() {
		right=10;
	}
	//方法
	public void show() {
		final int num=10;//常量
	}
	public void show(final int num) {
//		num=10;//只能调用不能修改
	}
	public static void main(String[] args) {
		
		
	}
	

}
//此类不能被其他类继承
final class Final{
	
}
class AA{
	//此方法不能被重写
	public final void name() {
		
	}
	
}
class BB extends AA{
	
}