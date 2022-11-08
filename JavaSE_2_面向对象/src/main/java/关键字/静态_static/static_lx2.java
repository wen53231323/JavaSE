package 关键字.静态_static;
//编写一个实现银行账户的概念，包含的属性有：账号、密码、存款余额、利率、最小余额
//考虑，那些属性需要声明为static的

public class static_lx2 {
	public static void main(String[] args) {
		Accoud d1=new Accoud();
		Accoud d2=new Accoud("mima",1000);
		
		System.out.println(d1);
		System.out.println(d2);
		
		Accoud.setLilv(0.01);
		Accoud.setMinyue(1);
		
		System.out.println(d1.getLilv());
		System.out.println(d1.getMinyue());
		
		
	}
}

class Accoud{
	private int id;//账号
	private String mi="000000";//密码
	private double yue;//余额
	
	private static double lilv;//利率
	private static double minyue;//最小余额
	private static int inid=1001;//自动生成id
	
	//构造器
	public Accoud() {
		id=inid++;
	}
	
	public Accoud(String mi, double yue) {
		this();
		this.mi = mi;
		this.yue = yue;
	}
	//toString方法，返回"实体内容"信息
	@Override
	public String toString() {
		return "Accoud [id=" + id + ", mi=" + mi + ", yue=" + yue + "]";
	}

	//set、get
	public String getMi() {
		return mi;
	}

	public void setMi(String mi) {
		this.mi = mi;
	}

	public static double getLilv() {
		return lilv;
	}

	public static void setLilv(double lilv) {
		Accoud.lilv = lilv;
	}

	public static double getMinyue() {
		return minyue;
	}

	public static void setMinyue(double minyue) {
		Accoud.minyue = minyue;
	}

	public int getId() {
		return id;
	}

	public double getYue() {
		return yue;
	}

}
