package 面向对象.三大特征.封装;

/*
 * 面向对象的特征一：封装与隐藏
 * 一、问题的引入：
 * 当我们创建一个类的对象以后，我们可以通过“对象.属性”的方式，对对象的属性进行赋值，这里，赋值操作要受到
 * 属性的数据类型和储存范围的制约，除此之外，没有其他制约的条件，但是，实际问题中，我们往往需要给属性赋值
 * 加入额外的限制条件，这个条件就不能在属性生命时体现，我们只能通过方法进行限制条件的添加(比如：setj())
 * 同时，我们需要避免用户在使用“对象.属性”的方式对属性的赋值，则需要将属性声明为私有的(paivate)
 * -->此时，针对于属性就体现了封装性
 * 
 * 二：封装性的体现
 * 我们将类的属性XXX私有化(private),同时，提供公共的(public)方法来获取(getXXX)和设置(set)
 * 
 * 拓展，封装性的体现：1.如上  2.不对外暴露的私有的方法  3.单例模式 ......
 * 
 * 三：封装性的体现，需要权限修饰符来配合
 * 1.java规定的四种权限(从小到大排列)，private、缺省、protected、public
 * 2.4种权限可以用来修饰类及；类的内部结构：属性、方法、构造器、内部类
 * 3.具体的，4种权限都可以用来修饰类的内部结构：属性、方法、构造器、内部类
 * 			修饰类的话，只能使用：缺省、public
 * 
 * 总结封装性，java提供了四种权限修饰符来修饰类及类的内部结构，体现类及类的内部结构在被调用时的可见性的大小
 * */
public class 封装{
	public static void main(String[] args) {
		animl diao=new animl();
		diao.a="小白";
//		diao.i=5;
//		diao.j=2;
		diao.num();
		diao.setj(8);
		diao.num();
	}
}
class animl{
	String a;
	private int i;
	private int j;//私有
	//对属性的设置
	public void setj(int k) {
		//j为正数且为偶数
		if (k>=0&&k%2==0) {
			j=k;
		}else {
			j=0;
		}//或者抛出异常
	}
	//对属性的获取
	public int getj() {
		return j;
	}
	public void num() {
		System.out.println("名字:"+a+"年龄:"+"个数:"+j);
	}
	//提供关于属性i的get和set方法
	//get(获取)
	public int geti() {
		return i;
	}
	//set(设置)
	public void seti(int h) {
		i=h;
	}
	
}
