package 面向对象.三大特征.多态;

/*
 * 1.若子类重写了父类方法，就意味着子类里定义的方法彻底覆盖了父类里的同名方法
 * 系统将不可能把父类里的方法转移到子类中：编译看左边，运行看右边
 * 
 * 2.对于实例对象则不存在这样的现象，即使子类里定义了与父类完全相同的实例变量
 * 这个实例变量依然不可能覆盖父类中定义的实例变量：编译运行都看左边
 * 
 * 
 * */

public class dt_lt_3 {
	public static void main(String[] args) {
		sub sub=new sub();
		System.out.println(sub.count);//20
		sub.dis();//20
		
		base base=sub;//多态
		// ==:对于引用数据类型，比较的是两个引用数据类型的地址值是否相同
		System.out.println(base==sub);//true
		System.out.println(base.count);//10
		base.dis();//20
	}

}
class base{
	int count=10;
	public void dis() {
		System.out.println(this.count);
	}
}
class sub extends base{
	int count=20;
	public void dis() {
		System.out.println(this.count);
	}
}
