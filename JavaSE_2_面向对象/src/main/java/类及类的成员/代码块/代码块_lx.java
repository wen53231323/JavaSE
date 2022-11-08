package 类及类的成员.代码块;
//体会优先级
//总结：由父及子，静态先行
public class 代码块_lx {
	public static void main(String[] args) {
		new Leaf();
		System.out.println();
		//静态只加载一次
		new Leaf();
	}
}

class Root{
	static {
		System.out.println("Root:静态代码块");
	}
	{
		System.out.println("Root:非静态代码块");
	}
	//构造器
	public Root(){
		System.out.println("Root:无参构造器");
	}
}

class Mid extends Root{
	static {
		System.out.println("Mid静态代码块");
	}
	{
		System.out.println("Mid非静态代码块");
	}
	public Mid(){
		System.out.println("Mid:无参构造器");
	}
}

class Leaf extends Mid{
	static {
		System.out.println("Leaf静态代码块");
	}
	{
		System.out.println("Leaf非静态代码块");
	}
	public Leaf(){
		System.out.println("Leaf:无参构造器");
	}
}

