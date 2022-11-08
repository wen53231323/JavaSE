package 类及类的成员.方法;
/*
 * 方法的形参的传递机制，值传递
 * 1.形参：方法定义时，声明的小括号内的参数
 * 2.实参：方法调用时，实际传递给形参的数据
 * 3.值传递机制
 * 如果参数是基本数据类型，此时实参赋给形参的是实参真实存储的数据值
 * 如果参数是引用数据类型，此时实参赋给形参的是实参存储数据的地址值
 * */
public class 方法的形参的传递机制 {
	public static void main(String[] args) {
		data diaoData=new data();
		diaoData.m=1;
		diaoData.n=2;
		System.out.println("n="+diaoData.m+"m="+diaoData.n);
		方法的形参的传递机制 diaoMxdx7=new 方法的形参的传递机制();
		diaoMxdx7.huan(diaoData);
		System.out.println("n="+diaoData.m+"m="+diaoData.n);
	}
	public void huan(data diaoData) {
		int zhuan=diaoData.m;
		diaoData.m=diaoData.n;
		diaoData.n=zhuan;
	}
}

class data{
	int m;
	int n;
}
