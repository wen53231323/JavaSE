package 类及类的成员.方法;

//判断半径、颜色是否相等，
public class toString_lx {
	public static void main(String[] args) {
		yuan2 diao1=new yuan2(5);
		yuan2 diao2=new yuan2("rad",34,5);
		//比较颜色
		System.out.println("颜色是否相等:"+diao1.getColor().equals(diao2.getColor()));
		//比较半径
		System.out.println("半径是否相等："+diao1.equals(diao2));
		//使用重写的toString
		System.err.println(diao1);
		System.out.println(diao2.toString());
	}

}

class yuan1{
	private String color;
	private double weight;
	//构造器
	public yuan1() {
		this.weight=34;
		this.color="rad";
	}
	public yuan1(String color, double weight) {
		super();
		this.color = color;//颜色
		this.weight = weight;//高
	}
	//set、get
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
}

class yuan2 extends yuan1{
	private double radius;//半径
	//构造器
	public yuan2() {
		super();
	}
	public yuan2(double radius) {
		super();
		this.radius=radius;
	}
	public yuan2(String color, double weight ,double radius) {
	super(color,weight);
	this.radius=radius;
	}
	//set、get
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	//求圆的面积
	public double mainji() {
		return 3.14*radius*radius;
	}
	//重写equals
	public boolean equals(Object obj) {
		if (this==obj) {
			return true;
		}
		if (obj instanceof yuan2) {
			yuan2 d=(yuan2)obj;
			return this.radius==d.radius;
		}
		return false;
	}
	//重写toString
	@Override
	public String toString() {
		return "yuan2 [radius=" + radius + "]";
	}
	
	
	
	
	
	
}
