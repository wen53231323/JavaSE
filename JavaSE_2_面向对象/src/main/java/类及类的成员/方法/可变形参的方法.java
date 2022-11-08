package 类及类的成员.方法;
/*
 * 可变个数形参的方法
 * 具体使用：
 *1.格式：数据类型 ... 变量名
 *2.当调用可变形参的方法时，传入的形参个数可以0个或多个
 *3.可变个数形参的方法与本类中方法名相同，形参不同的方法之间构成重载
 *4.可变个数形参的方法与本类中方法名相同，形参类型也相同的数组之间不构成重载，换句话说，二者不能共存
 *5.可变个数形参在方法的形参中，必须声明在末尾
 *6.可变个数形参在方法的形参中，最多只能声明一个可变形参
 * 
 * */
public class 可变形参的方法 {
	public static void main(String[] args) {
		可变形参的方法 diao=new 可变形参的方法();
		diao.kebian(3);
		diao.kebian("ww","aa");
	}
	public void kebian(int i) {
		System.out.println("形参只能一个");
	}
	public void kebian(String... arr) {
		System.out.println("形参可以0个或多个");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
