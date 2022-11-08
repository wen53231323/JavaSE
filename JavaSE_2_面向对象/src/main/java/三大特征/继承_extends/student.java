package 三大特征.继承_extends;


public class student extends person  {
	
//	String name;   //person中定义过
//	int age;
	public String major;
	int id=1002;
	
	//构造器
	public student(String major){
		this.major = major;
	}
	public student(){
		
	}
	public student(String name, int age, String major) {
		super(name,age);//super调用构造器
//		this.name = name;
//		this.age = age;
		this.major = major;
	}
	//方法
//	public void eat() {     //person中定义过
//		System.out.println("吃饭");
//	}
//	public void sellp() {
//		System.out.println("睡觉");
//	}
	
	public void study() {
		System.out.println("学习的专业为"+major);
	}
	//对父类中的eat()进行了重写
	public void eat() {
		System.out.println("吃有营养的饭");//重写的eat
		super.eat();//调用父类中的eat方法
	}
	//重写规则：父类返回值是基本数据类型，子类返回值必须是相同的基本数据类型
	public double chongxie(){
		return 2.0;
	}
	//super使用:
	public void show() {
		System.out.println("子类中的id:"+id);
		System.out.println("通过super调用父类中的id:"+super.id);
	}
	

}

