package 三大特征.继承_extends;



public class person {
	
	private String name;
	public int age;
	int id=1001;
	
	//构造器
	public person() {
		
	}
	public person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	//方法
	public void eat() {
		System.out.println("吃饭");
	}
	public void sellp() {
		System.out.println("睡觉");
	}
	public double chongxie(){
		return 1.0;
	}
	//set、get方法
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}

