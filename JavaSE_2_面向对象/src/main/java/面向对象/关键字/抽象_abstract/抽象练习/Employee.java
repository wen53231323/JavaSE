package 面向对象.关键字.抽象_abstract.抽象练习;
//成员变量
//姓名、编号、生日（生日调用MyData中定义的toDataString()）
//属性birthday为MyData类
public abstract class Employee {
	private String name;
	private int number;
	private MyDate birthday;
	//抽象方法
	public abstract double earnings();
	//toString，生日调用MyData中定义的toDataString()
	@Override
	public String toString() {
		return "name=" + name + ", number=" + number + ", birthday=" + birthday.toDataString();
	}
	//构造器
	public Employee(String name, int number, MyDate birthday) {
		super();
		this.name = name;
		this.number = number;
		this.birthday = birthday;
	}
	//get、set方法
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public MyDate getBirthday() {
		return birthday;
	}
	public void setBirthday(MyDate birthday) {
		this.birthday = birthday;
	}
	
	
}
