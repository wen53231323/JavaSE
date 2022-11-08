package 练习题;
/*
 * 定义一个类求圆的面积
 * 定义一个time，打印半径为1-time的圆的面积
 * 
 * */
public class 求圆面积2 {
	public static void main(String[] args) {
		求圆面积2 diao2=new 求圆面积2();
		
		yuan diao=new yuan();
		diao2.prantArens(diao, 5);
	}
	
	public void prantArens(yuan diao,int time) {
		System.out.println("半径\t\t面积");
		for (int j = 0; j<=time; j++) {
			diao.r=j;
			System.out.println(diao.r+"\t\t"+diao.mianji());
		}
	}
}
class yuan {
	double r;
	
	public double mianji() {
			
		return Math.PI*r*r;
	}
}
