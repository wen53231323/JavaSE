package 面向对象.类及类的成员.代码块;
/*
 * 类的成员之四：代码块(或初始化块)
 * 1.代码块的作用：用来初始化类、
 * 2.代码块如果有修饰的话，只能使用static，
 * 3.分类：静态代码块、非静态代码块
 * 
 * 4.静态代码块
 * 		>内部可以有输出语句
 * 		>随着类的对象加载而执行，而且只执行一次
 * 		>作用：初始化类的信息
 * 		>如果一个类中定义了多个静态代码块，则按照声明的先后顺序执行
 * 		>静态代码块的执行优先于非静态代码块的执行
 * 		>静态代码块内只能调用静态的属性、方法，不能调用非静态的结构
 * 
 * 5.非静态代码块
 * 		>内部可以有输出语句
 * 		>随着对象的创建而执行
 * 		>每创建一个对象，就执行一次非静态代码块
 * 		>作用：可以在创建对象时，对对象的属性等进行初始化
 * 		>如果一个类中定义了多个非静态代码块，则按照声明的先后顺序执行 
 * 		>非静态代码块内可以调用静态的属性、静态的方法，或非静态的属性、非静态的方法
 * 
 * *对属性可以赋值的位置：
* 1.默认初始化
* 2.显式初始化
* 3.构造器中初始化
* 4.有了对象以后，可以通过"对象.属性"，"对象.方法"进行赋值
* 5.在代码块中赋值
 * 
 * 执行的先后顺序：1 --> 2/5 --> 3 --> 4
 * 
 * */
public class 代码块 {
	
	public static void main(String[] args) {
		String ss=Daimakuai.names;
		System.out.println(ss);
		Daimakuai diao1=new Daimakuai();
		Daimakuai diao2=new Daimakuai();
	}
}
	class Daimakuai{
		//属性
		int age;
		String name;
		static String names;
		//构造器
		public Daimakuai(){
			
		}
		public Daimakuai(int age, String name) {
			this.age = age;
			this.name = name;
		}
		//代码块
		//静态代码块
		static{
			System.out.println("静态代码块");
			//调用静态结构
			names="我是。。。";
		}
		//非静态代码块
		{
			System.out.println("非静态代码块");
			//调用静态结构
			names="我是。。。";
			//调用非静态结构
			age=1;
			name="小白";
			eat();
		}
		//方法
		public void eat() {
			System.out.println("吃饭");
		}
		@Override
		public String toString() {
			return "Daimakuai [age=" + age + ", name=" + name + ", names=" + names + "]";
		}
}
