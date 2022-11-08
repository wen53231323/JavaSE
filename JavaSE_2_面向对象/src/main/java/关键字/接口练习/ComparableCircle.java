package 关键字.接口练习;
//比较两个圆的半径大小
public class ComparableCircle extends Circle implements CompareObject {
	//构造器
	public ComparableCircle(double radius) {
		super(radius);
	}
	@Override
	//方法
	public int compareTo(Object o) {
		if (this==o) {
			return 0;
		}
		if (o instanceof ComparableCircle) {
			ComparableCircle c=(ComparableCircle)o;
			if (this.getRadius()>c.getRadius()) {
				return 1;
			}else if (this.getRadius()<c.getRadius()) {
				return -1;
			}else {
				return 0;
			}
//		当属性radius声明为Double类型时，可以调用包装类的方法
//			return this.getRadius().compareTo(c.getRadius());
		}else {
			return 0;
			
		}
	}
}
