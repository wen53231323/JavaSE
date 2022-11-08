package 关键字.静态_static;


public class static_lx1 {
	public static void main(String[] args) {
		yuan c1=new yuan();
		yuan c2=new yuan();
		yuan c3=new yuan(3);
		System.out.println("c1 id:"+c1.getId());
		System.out.println("c2 id:"+c2.getId());
		System.out.println("c3 id:"+c3.getId());
		System.out.println("c的个数:"+yuan.gettotal());
	}
	

}

class yuan{
	
	//属性
	private int id;
	private double radius;//半径

	private static int total;//记录个数
	private static int ide=1001;
	//构造器
	public yuan() {
		id=ide++;
		total++;
	}
	public yuan(int radius) {
		this();
		//id=ide++;
		//total++;
		this.radius = radius;
	}
	//面积
	public double mianji() {
		return 3.14*radius*radius;
	}
	//get
	public int getId() {
		return id;
	}
	public static int gettotal() {
		return total;
	}
}