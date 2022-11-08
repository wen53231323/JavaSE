package 面向对象.类及类的成员.内部类;

/*
 * 类的内部成员之五，内部类
 * 1.Java中允许将一个A声明在另一个B中，则类A就是内部类，类B称为外部类
 * 
 * 2.内部类的分类：成员内部类(静态、非静态)vs局部内部类(方法内、代码块内、构造器内)
 *  
 * 3.成员内部类：
 *  	一方面，作为外部类的成员：
 *  		>调用外部类结构
 *  		>可以被static修饰
 *  		>可以被四个不同的权限修饰
 *  	另一方面，作为一个类：
 *  		>类内可以定义属性、方法、构造器等
 * 			>可以被final修饰，表示此类不能被继承，不使用就可以被继承
 * 			>可以被abstract修饰
 * 4.关注如下的3个问题
 *  4.1如何实例化成员内部类的对象
 *  4.2如何在成员内部类中区分调用外部类的结构
 *  4.3开发中局部内部类的使用:见类xin
 *  
 * 总结：
 *  成员内部类和局部内部类，在编译以后，都会生成字节码文件
 *  格式：成员内部类：外部类$内部类名.class
 *  	局部内部类：外部类$数字 内部类名.class
 * 
 *  在局部内部类的方法中(比如show)如果调用局部内部类所声明的
 *  方法(比如method)中的局部变量的话，要求局部变量声明为final的
 *  jdk7及之前版本：要求此局部变量显式的声明为final
 *  jdk8及之后的版本：可以省略final的声明
 * */
public class 内部类 {
	public static void main(String[] args) {
		//创建AA实例(静态的成员内部类)
		Person.AA aa=new Person.AA();
		aa.sing();
		//创建BB实例(非静态的成员内部类)
		Person p=new Person();
		Person.BB bb=p.new BB();
		bb.sing();
		bb.display("333");
	}
}
class Person{
	String name="111"; 
	public void eat() {
		System.out.println("吃饭");
	}
	//静态成员内部类
	static class AA{
		String name;
		public AA() {}
		public void sing() {
			System.out.println("唱歌");
		}
		{
		
		}
	}
	//非静态成员内部类
	class BB{
		String name="222";
		public BB() {}
		public void sing() {
			System.out.println("唱歌");
			Person.this.eat();//调用外部类的属性
		}
		{}
		public void display(String name) {
			System.out.println(name);//方法的形参
			System.out.println(this.name);//内部类的属性
			System.out.println(Person.this.name);//外部类的属性
		}
	}
	//构造器
	public Person() {
		//局部内部类
		class CC{
			
		}
	}
	//方法
//在局部内部类的方法中(比如show)如果调用局部内部类所声明的
//方法(比如method)中的局部变量的话，要求局部变量声明为final的
	//jdk7及之前版本：要求此局部变量显式的声明为final
	//jdk8及之后的版本：可以省略final的声明
	public void method() {
		int num=10;
		//局部内部类
		class DD{
			public void show() {
				System.out.println(num);
			}
		}
	}
	//代码块
	{
		//局部内部类
		class EE{
			
		}
	}	
}
class xin{
	//开发中很少见
	public void method() {
		//局部内部类
		class AA{
			
		}
	}
	//返回一个实现了Comparable接口的类的对象
	public Comparable getComparable() {
		//创建了一个实现了Comparable接口的类：局部内部类
		//方法一：
//		class MyComparable implements Comparable{
//			public int compareTo(Object o) {
//				return 0;
//			}
//		}
//		return new MyComparable();
		
		//方式二：
		return new Comparable() {
			public int compareTo(Object o) {
				return 0;
			}
		};
	}
}