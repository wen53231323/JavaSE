package 面向对象.类及类的成员.属性;
/*
*对属性可以赋值的位置：
* 1.默认初始化
* 2.显式初始化
* 3.构造器中初始化
* 4.有了对象以后，可以通过"对象.属性"，"对象.方法"进行赋值
* 5.在代码块中赋值
* 
*执行的先后顺序：1 --> 2/5 --> 3 --> 4
* 
*/
public class 属性赋值先后顺序 {
	public static void main(String[] args) {
		Ore o=new Ore();
		System.out.println(o.ore);
	}
}

class Ore{
	//2.显式初始化
	int ore=3;
	//5.在代码块中赋值
	{
		ore=4;
	}
}