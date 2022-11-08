package 面向对象.关键字.抽象_abstract.抽象练习;
//成员变量
//生日
public class MyDate {
	private int year;
	private int month;
	private int day;
	//构造器
	public MyDate(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}
	//toString
	public String toDataString() {
		return year + "年" + month + "月" + day + "日";
	}

	//get,set
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	
	
}
