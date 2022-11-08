package 面向对象.类及类的成员.方法;
/*
 * 方法的重载
 * 1.定义：在同一个文件中，允许存在一个以上的同名方法，只要他们的参数个数或者参数类型不同即可
 * 	‘两同一不同’：同一个类、相同方法名
 * 				参数列表不同，参数个数不同，参数类型不同
 * 2.判断是否重载：
 * 跟方法的权限修饰符、返回值类型、形参变量名、方法体都没有关系 
 * 
 * 例题：
 * 1.定义三个重载方法并调用
 * 三个方法分别接收一个int参数、两个int参数、一个字符串参数
 * 分别执行平方运算并输出结果，相乘并输出结果，输出字符串信息
 * 在main()方法中分别用参数区别调用三个方法
 * 2.定义三个重载方法max()
 * 第一个方法求两个int值中的最大值
 * 第二个方法求两个double值中的最大值
 * 第三个方法求三个double值中的最大值
 */
public class 方法的重载 {
	public static void main(String[] args) { 
		//例题1
		//平方运算并输出结果
		System.out.println(new 方法的重载().getti(3));//匿名对象
		//相乘并输出结果
		System.out.println(new 方法的重载().getti(3,5));
		//输出字符串信息
		System.out.println(new 方法的重载().getti("哈哈哈"));
		//例题2
		//求两个int值中的最大值
		System.out.println(new 方法的重载().getmax(3,4));
		//求两个double值中的最大值
		System.out.println(new 方法的重载().getmax(3.1,4.1));
		//求三个double值中的最大值
		System.out.println(new 方法的重载().getmax(3.1,4.1,5.1));
		
	}
	
	//如下方法构成了重载
	public void getsum(int i) {
		
	}
	public void getsum(Double i) {
		
	}
	public void getsum(String i) {
		
	}
	public void getsum(int i,String j) {
	
	}
	//例题1
	public int getti(int i) {
		return i*i;
	}
	public int getti(int i,int j) {
		return i*j;
	}
	public String getti(String i) {
		return i;
	}
	//例题2
	public int getmax(int i,int j) {
		return (i>j)?i:j;
	}
	public double getmax(Double i,Double j) {
		return (i>j)?i:j;
	}
	public double getmax(Double i,Double j,double k) {
		double max=(i>j)?i:j;
		return (max>k)?max:k;
	}	
}
