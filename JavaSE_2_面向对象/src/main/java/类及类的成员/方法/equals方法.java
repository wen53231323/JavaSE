package 类及类的成员.方法;

/*
 * 面试题：== 和equals()方法的区别
 *   
 * 一、== ：运算符
 *1.可以使用在基本数据变量和引用数据类型变量中
 *2.如果比较的是基本数据类型变量：比较两个变量保存的数据是否相等(不一定类型要相同)
 *  如果比较的是引用数据类型变量：比较两个变量的地址值是否相同，即两个引用是否指向同一个对象实体
 * 补充：==符号使用时，必须保证符号左右两边的变量类型一致
 * 
 * 二、equals()
 * 1.是一个方法
 * 2.适用于引用数据类型
 * 3.Object类中equals()的定义：
 * 	public boolean equals(Object obj) {
        return (this == obj);
    }
    
 * 说明：Object类中定义的equals()和==的作用是相同的：比较两个变量的地址值是否相同，即两个引用是否指向同一个对象实体
 *
 * 4.像String、Data、File、包装类等都重写了Object类中的equals()方法，重写以后
 * 比较的不是两个引用的地址是否形同，而是比较两个对象的“实体内容”是否相同
 * 
 * 5.通常情况下，我们自定义的类如果使用equals()的话，也通常是比较两个对象的“实体内容”是否相同。那么，我们就需要
 * 对Object类中的equals()进行重写
 * 重写的原则：比较两个对象的实体内容是否相同
 * 
 * */
public class equals方法 extends Object{
	public static void main(String[] args) {
		//基本数据类型：
		int a=10;
		int b=10;
		double c=10;
		char d=10;
		char e='A';
		char f=65;
		
		System.out.println(a==b);//比较两个变量保存的数据是否相等
		System.out.println(a==c);//比较两个变量保存的数据是否相等
		System.out.println(a==d);//比较两个变量保存的数据是否相等
		System.out.println(e==f);//比较两个变量保存的数据是否相等
		//引用数据类型
		System.out.println("_____________________");
		sdf diao1=new sdf(18,"小白");
		sdf diao2=new sdf(18,"小白");
		System.out.println(diao1==diao2);//比较两个变量的地址值是否相同
		
		System.out.println(diao1.equals(diao2));//false-->true
		
		String g1=new String("abcd");
		String g2=new String("abcd");
		System.out.println(g1.equals(g2));//true
	
	}

}

class sdf{
	int h;
	String j;
	
	public sdf() {
		super();
	}

	public sdf(int h, String j) {
		super();
		this.h = h;
		this.j = j;
	}
	
	//自动生成的 equals()
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		sdf other = (sdf) obj;
		if (h != other.h)
			return false;
		if (j == null) {
			if (other.j != null)
				return false;
		} else if (!j.equals(other.j))
			return false;
		return true;
	}
	
	/*
	//手写实现equals()的重写
	//重写的原则：比较两个对象的实体内容(即：h和j)是否相同
	public boolean equals(Object vv) {
		//这个方法是否与vv的引用地址是否相同
		if (this == vv) {
			return true;
		}
		//判断对象vv是否是类sdf的实例
		if (vv instanceof sdf) {
			sdf dSdf=(sdf)vv;//向下转型
			//比较两个对象的每个属性是否相同
//			if (this.h==dSdf.h&&this.j.equals(dSdf.j)){
//				return true;
//			}else {
//				return false;
//			}
			//或：
			return this.h==dSdf.h&&this.j.equals(dSdf.j);
		}
		return false;
	}
	*/
}

