package 面向对象.类及类的成员.方法;
/*
 * 递归方法的使用(了解)
 * 1.递归方法：一个方法体内调用他自身
 * 2.方法递归包含了一种隐式的循环，它会重复执行某段代码，但这种重复执行无需循环控制
 * 递归一定要向已知方向递归，否则这种递归就变成了无穷循环，类似于死循环 
 * */
public class 递归方法 {
public static void main(String[] args) {
	    递归方法 diao=new 递归方法();
		//练习1
		System.out.println(diao.he(100));
		//练习2
		System.out.println(diao.f(5));
	} 
	//练习1
	//(递归)求1-n的和
	public int he(int n) {
		if (n==1) {
			return 1;
		}else {
			return n+he(n-1);
		}
	}
	//练习2
	//已知有一个数列，f(0)=1，f(1)=4,f(n+2)=2*f(n+1)+f(n)
	//其中n是大于0的整数
	public int f(int n) {
		if (n==0) {
			return 1;
		}if (n==1) {
			return 4;
		}else {
			return 2*f(n-1)+f(n-2);
		}
	}
	//斐波那契数列
	
	//汉诺塔问题
	
	//快排
}
