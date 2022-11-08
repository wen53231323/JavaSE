package 面向对象.关键字.抽象_abstract.抽象练习;
//继承Employee类
//实现按月计算工资的员工处理
public class SalariedEmployee extends Employee{
	//工资
	private double mothlysalary;
	//构造器
	public SalariedEmployee(String name, int number, MyDate birthday) {
		super(name, number, birthday);
	}
	
	public SalariedEmployee(String name, int number, MyDate birthday, double mothlysalary) {
		super(name, number, birthday);
		this.mothlysalary = mothlysalary;
	}

	//重写抽象方法
	public double earnings() {
		return mothlysalary;
	}
	@Override
	public String toString() {
		return "SalariedEmployee [" + super.toString();
	}
	
	//get、set方法
	public double getMothlysalary() {
		return mothlysalary;
	}
	public void setMothlysalary(double mothlysalary) {
		this.mothlysalary = mothlysalary;
	}
	

}
