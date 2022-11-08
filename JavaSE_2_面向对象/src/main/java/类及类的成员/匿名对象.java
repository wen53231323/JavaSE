package 类及类的成员;
/*
 * 匿名对象的使用
 * 1.理解：我们创建的对象，没有显示的赋给一个变量名，即为匿名对象
 * 2.特征：匿名对象只能调用一次
 * 
 * */
public class 匿名对象 {
	public static void main(String[] args) {
		phone diao=new phone();
		diao.sendemail();
		diao.jiage();
		
		//匿名对象
		new phone().sendemail();
		new phone().jiage();
		
		new phone().price=1999;
		new phone().jiage();
	}
}

class phone{
	double price;//价格
	
	public void sendemail(){
		System.out.println("发邮件");
	}
	public void jiage(){
		System.out.println("手机价格为："+price);
	}
}