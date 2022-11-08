package 三大特征.多态;

public class dt_lt_4 {
	public static void main(String[] args) {
		base1 ba=new sub1();
		ba.add(1,2,3);//sub1
		
		sub1 ba1=(sub1)ba;
		ba1.add(1,2,3);//sub2
	}

}

class base1{
	public void add(int a,int... arr) {
		System.out.println("bas1");
		
	}
}

class sub1 extends base1{
	public void add(int a,int[] arr) {
		System.out.println("sub1");
	}
	public void add(int a,int b,int c) {
		System.out.println("sub2");
	}
}