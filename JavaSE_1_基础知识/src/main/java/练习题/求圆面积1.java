package 练习题;
/*
 * 设计类Circle并计算圆的面积
 * 
 */
public class 求圆面积1 {
		public static void main(String[] args) {
			//方式一
			Circle m1=new Circle();
			m1.radius=4;
			System.out.println("半径为:"+m1.radius+"面积为："+m1.name());
			//方式二
			Circle m2=new Circle();
			m2.radius=4;
			m2.name1();
		}
	}
	class Circle{
		//属性
		double radius;//半径
		
		//求圆的面积
		//方法一
		public double name() {
			double mianji=3.14*(radius*radius);
			return mianji;
		}
		//方法二
		public void name1() {
			double mianji=3.14*(radius*radius);
			System.out.println("面积为："+mianji);
			}
}
