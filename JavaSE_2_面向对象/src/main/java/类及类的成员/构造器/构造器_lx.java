package 类及类的成员.构造器;
//添加构造器初始年龄为18
//修改构造器，使得每次创建都可以初始化name和age
public class 构造器_lx {
	public static void main(String[] args) {
		person diao=new person("tom",10);
		diao.nianling();
		diao.setshu("小白", 19);
		diao.nianling();
	}
}

class person{
	//属性
	private String name;
	private int age;
	//构造器
	public person(){
		age=18;
	}
	public person(String k,int i){
		name=k;
		age=i;
	}
	//方法
	public void nianling() {
		System.out.println("姓名为："+name+"\t年龄为："+age);
	}
	public void setshu(String a,int b) {
		name=a;
		age=b;
	}
	public void getshu(String a,int b) {
		name=a;
		age=b;
	}
}