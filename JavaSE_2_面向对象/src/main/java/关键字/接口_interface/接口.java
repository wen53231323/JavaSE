package 关键字.接口_interface;
/*接口的使用
 * 1.接口使用interface来定义
 * 2.Java中，接口和类是并列的两个结构
 * 3.如何定义接口：定义接口中的成员
 * 		3.1 jdk7及以前：只能定义全局常量和抽象方法
 * 			>全局常量：public static final的，书写时可省略不写
 * 			>抽象方法：public abstract
 * 		3.1 jdk8：除了定义全局常量和抽象方法，还可以定义静态方法、默认方法(略)
 * 4.接口中不能定义构造器:意味着接口不能实例化
 * 5.Java开发中：接口通过让类去实现(implement)的方式来使用
 * 	 如果实现类覆盖了接口中所有的抽象方法，则此实现类就可以实例化
 * 	 如果实现类没有覆盖接口中所有的抽象方法，则此实现类仍为一个抽象类
 * 
 * 6.Java类可以实现多个接口--->弥补了Java单继承性的局限性
 * 	格式：class AA extends BB implements CC,DD,EE...
 * 7.接口与接口之间可以继承，而且可以多继承
 * 
 * -------------------
 * 8.接口的具体使用，体现多态性
 * 9.接口，实际上可以看做是一种规范
 * 
 * 
 * */
public class 接口 {
	public static void main(String[] args) {
		Bullet b=new Bullet();
	}

}

//接口
interface Flyable{
	//全局常量
	public static final int MAX_SPEED=7900;
	int MIN_SPEED=1;//省略了public static final
	//抽象方法
	public abstract void fly();
	void stop();//省略了public abstract
}

//接口
interface Attackable{
	void attack();
}

//实现
class Plane implements Flyable{

	@Override
	public void fly() {
		System.out.println("通过引擎起飞");
	}

	@Override
	public void stop() {
		System.out.println("驾驶员减速停止");
	}
}

//多实现(先写继承，后实现)
class Bullet implements Attackable,CC, Flyable {
	@Override
	public void attack() {
	}
	@Override
	public void fly() {
	}
	@Override
	public void stop() {
	}
	@Override
	public void a() {
	}
	@Override
	public void b() {
	}
}

//接口
interface AA{
	void a();
}

//接口
interface BB{
	void b();
}

//接口多继承接口
interface CC extends AA,BB{
	
}

//抽象
abstract class kite implements Flyable {
	@Override
	public void fly() {
	}	
}
