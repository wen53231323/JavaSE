package 练习题;
//值传递机制的练习(理解)
public class 值传递机制 {
	public static void main(String[] args) {
		值传递机制 test=new 值传递机制();
		test.first();
		
	}
	public void first() {
		int i=5;
		Value v=new Value();
		v.i=25;
		second(v,i);
		System.out.println(v.i);
	}
	public void second(Value v,int i) {
		i=0;
		v.i=20;
		Value val=new Value();
		v=val;
		System.out.println(v.i+" "+i);
	}
}
class Value{
	int i=15;
}