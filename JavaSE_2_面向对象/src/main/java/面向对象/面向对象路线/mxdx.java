package 面向对象.面向对象路线;
/*
 * java面向对象学习的三条主线：
 * 1.java类及类的成员，属性，方法，构造器，代码块，内部类
 * 
 * 2.面向对象的三大特征：封装性，继承性，多态性，(抽象性)
 * 
 * 3.其他关键字：this，super,static,final,abstract,interface,package,import等
 * 
 * 一、面向对象的两个要素：
 * 类：对一类事物的描述，是抽象的，概念上的定义
 * 对象：是实际存在的该类事物的每个个体，因而也称为实例(instance)
 * >面向对象程序设计的重点是类的设计
 * >设计类，就是设计类的成员
 *     属性：对应类中的成员变量
 *     属性=成员变量=field=域、字段
 *     行为：对应类中的成员方法
 *     方法=成员方法=函数=method
 *     
 *     创建类的对象=类的实例化=实例化类
 *     
 *     
 * 面向过程：强调的是功能行为，以函数为最小单位，考虑怎么做
 * 面向对象：强调具备功能的对象，以类/对象为最小单位，考虑谁来做
 * 
 * 二、类和对象的使用(面向对象思想落地的实现)
 * 1.创建类，设计类的成员
 * 2.创建类的对象
 * 3.通过“对象.属性”或“对象.方法”调用对象的结构
 * 
 * 三、如果创建了一个类的多个对象，则每个对象都独立拥有一套类的属性(非static的)
 * 意味着：如果我们修改一个属性a,则不会影响另一个对象属性a的值
 *
 * 四、完成一个项目(或功能)的思路：
 * >根据问题需要，选择问题所针对的现实世界的实体
 * >从实体中寻找解决问题相关的属性和功能， 这些属性和功能就形成了概念世界中的类
 * >把抽象的实体用计算机语言进行描述，形成计算机世界中类的定义。即借助某种程序语言
 * 把类构造成计算机能够识别和处理的数据结构
 * >将类实例化成计算机世界中的对象。对象是计算机世界中解决问题的最终工具
 * 
 * */
//测试类
public class mxdx {
	public static void main(String[] args) {
		//创建person类的对象
		person p1=new person();
		//调用对象的结构、属性、方法
		//调用属性：“对象.属性”
		p1.name="tom";
		p1.isMale=true;
		System.out.println(p1.name);
		//调用方法：“对象.方法”
		p1.eat();
		p1.sleep();
		p1.talk("Chinese");
		//再创建一个对象
		person p2=new person();
		System.out.println(p2.name);//null
		System.out.println(p2.isMale);//false
		
		//将p1变量保存的对象地址值赋给p3,导致p1和p3指向了堆空间中的同一个对象实体(p3变p1随之改变)
		person p3=p1;
		System.out.println(p3.name);
		p3.age=10;
		System.out.println(p1.age);
	}

}
class person{
	// TODO Auto-generated constructor stub
	//属性
	String name;
	int age=1;
	boolean isMale;
	
	//方法
	public void eat() {
		System.out.println("人可以吃饭");
	}
	public void sleep() {
		System.out.println("人可以睡觉");
	}
	public void talk(String language) {
		System.out.println("人可以说话,使用的是"+language);
	}

}