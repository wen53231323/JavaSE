package 关键字.关键字_this;
//this关键字练习
public class this关键字_lx {
	public static void main(String[] args) {
		boy diao1=new boy("大黄",22);
		diao1.shout();
		girl diao2=new girl("小白",33);
		diao2.marry(diao1);
		
		girl diao3=new girl("小白",22);
		System.out.println(diao2.compare(diao3));
		
	}
}

class boy{
	
	private String name;
	private int age;
	//快捷键构造器
	public boy() {
		
	}
	public boy(String name) {
		this.name=name;
	}
	public boy(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	//快捷键set，get方法
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void marry(girl gril) {
		System.out.println("我要娶"+gril.getName());
		
	}
	public void shout() {
		if (age>=22) {
			System.out.println("适合结婚");
		}else {
			System.out.println("再等几年");
		}
	}
}

class girl{
	
	private String name;
	private int age;
	//快捷键构造器
	public girl() {
	
	}
	public girl(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	//快捷键set，get方法
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void marry(boy boy) {
		System.err.println("我要嫁给"+boy.getName());
		boy.marry(this);
	}
	//排序
	public int compare(girl duibi) {
		if (this.age>duibi.age) {
			return 1;
		}else if(this.age<duibi.age) {
			return -1;
		}else {
			return 0;
		}
		
	}
}