package 面向对象.关键字.抽象_abstract;
//long start=System.currentTimeMillis();
//获得系统的时间，单位为毫秒

public class 模板方法的设计模式 {
	public static void main(String[] args) {
		Temptest t=new Tempss();
		t.spendtime();
	}	

}
abstract class Temptest{
	//计算某段代码执行所需要花费的时间
	public void spendtime() {
		long start=System.currentTimeMillis();//获得系统的时间，单位为毫秒
		code();//不确定的部分、易变的部分
		long end=System.currentTimeMillis();
		System.err.println("花费的时间为"+(end-start));
	}
	public abstract void code();
}
class Tempss extends Temptest{
	//获取质数
	public void code() {
		for (int i=2;i<1000;i++) {
			boolean isFlag=true;
			for (int j=2;j<=Math.sqrt(i);j++) {
				if (i%j==0) {
				isFlag=false;
				break;
			}
		}
			if(isFlag) {
			System.out.println(i);	
			}
			}
	}
}
