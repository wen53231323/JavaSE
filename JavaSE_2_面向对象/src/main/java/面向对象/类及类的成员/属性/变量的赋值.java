package 面向对象.类及类的成员.属性;
/*
 * 关于变量的赋值：
 * 如果变量是基本数据类型，此时赋值的是变量所保存的数据值
 * 如果变量是引用数据类型，此时赋值的是变量所保存的地址值
 * */
public class 变量的赋值 {
	public static void main(String[] args) {
		//基本数据类型
		int n=1;
		int m=2;
		System.out.println("n="+n+"m="+m);
		m=3;
		System.out.println("n="+n+"m="+m);
		//引用数据类型
		drr diao1=new drr();
		diao1.i=23;
		drr diao2=diao1;//赋值以后，diao1和diao2的地址值相同，都指向了堆空间的同一个对象实体
		System.out.println("diao1.i="+diao1.i+"diao2.i="+diao2.i);
		diao2.i=30;
		System.out.println("diao1.i="+diao1.i+"diao2.i="+diao2.i);
	}
}

class drr{
	int i;
}
