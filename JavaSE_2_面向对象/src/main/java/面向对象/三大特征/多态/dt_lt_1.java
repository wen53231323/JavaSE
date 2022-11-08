package 面向对象.三大特征.多态;


public class dt_lt_1 {
	public static void main(String[] args) {
		dt_lt_1 d1=new dt_lt_1();
		//有多态
		d1.func(new dog());
		d1.func(new cat());
		//无多态
		d1.name1(new dog());
		d1.name2(new cat());
		
	}
	
	//有多态：
	public void func(animal diao) {
		diao.eat();
		diao.shout();
	}
	//无多态：
	public void name1(dog d) {
		d.eat();
		d.shout();
	}
	public void name2(cat c) {
		c.eat();
		c.shout();
	}
}
//动物类(父类)
class animal{
	public void eat() {
		System.out.println("吃");
	}
	public void shout() {
		System.out.println("叫");
	}
	
}

//狗(子类)
class dog extends animal{
	
	public void eat() {
		System.out.println("狗吃肉");
	}
	public void shout() {
		System.out.println("汪！汪！汪！");
	}
	
}

//猫(子类)
class cat extends animal{
	
	public void eat() {
		System.out.println("猫吃鱼");
	}
	public void shout() {
		System.out.println("喵！喵！喵！");
	}
	
}
