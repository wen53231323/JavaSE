package 项目.主模块;

import 项目.客户类.Customer;
import 项目.工具类.gongjulei;
import 项目.管理类.CustomerList;

//CustomerView为主模块，负责菜单的显示和处理用户操作
public class CustomerView {
	private CustomerList customerList=new CustomerList(10);
	public CustomerView(){
		Customer cust=new Customer("张三", '男', 20, "26387", "58767");
		customerList.zeng(cust);
	}
	
	public static void main(String[] args) {
		//主要调用操作
		CustomerView diaoCustomerView=new CustomerView();
		diaoCustomerView.jiemian();
	}
	//方法，界面
	public void jiemian() {
		//界面
		boolean isFlag=true;
		while(isFlag) {
		System.out.println("客户信息管理系统");
		System.out.println("	1.添加客户");
		System.out.println("	2.修改客户");
		System.out.println("	3.删除客户");
		System.out.println("	4.客户列表");
		System.out.println("	5.退出");
		System.out.println();
		System.out.println("请输入1-5:");
		
			char a= gongjulei.readMenuSelection();
			switch (a) {
			//1.添加客户
			case '1':
				tianjia();
				break;
			//2.修改客户
			case '2':
				xiugai();
				break;
			//3.删除客户	
			case '3':
				shanchu();
				break;
			//4.客户列表
			case '4':
				liebiao();
				break;
			//5.退出
			case '5':
				tuichu();
				char b=gongjulei.readConfirmSelection();
				if (b=='X') {
					isFlag=false;
				}
			}
		}
	}
		
	
	//方法: 1.添加客户
	public void tianjia() {
		System.out.println("姓名：");
		String name= gongjulei.readString(10);
		
		System.out.println("性别：");
		char gender= gongjulei.readChar();
		
		System.out.println("年龄");
		int age= gongjulei.readInt();
		
		System.out.println("电话");
		String phone= gongjulei.readString(13);
		
		System.out.println("email");
		String email= gongjulei.readString(30);
		//将上述数据封装到对象中
		Customer customer=new Customer(name, gender, age, phone, email);
		boolean h=customerList.zeng(customer);
		if (h) {
			System.out.println("添加成功");
		}else {
			System.out.println("添加失败");
		}
		
	}
	//方法: 2.修改客户
	public void xiugai() {
		System.out.println("修改客户的操作");
		Customer cust;
		int number;
		for (;;) {
			System.out.println("请选择编号，-1退出");
			number=gongjulei.readInt();
			if (number==-1) {
				return;
			}
			cust=customerList.huo(number-1);
			if (cust==null) {
				System.out.println("无法找到指定客户");
			}else {//找到了相应编号的客户
				break;
			}
		}
		//修改
		System.out.println("姓名("+cust.getXingming()+"):");
		String name=gongjulei.readString(10,cust.getXingming());
		
		System.out.println("性别("+cust.getXingbie()+"):");
		char gender=gongjulei.readChar(cust.getXingbie());
		
		System.out.println("年龄("+cust.getNianling()+"):");
		int age=gongjulei.readInt(cust.getNianling());
		
		System.out.println("电话("+cust.getDianhua()+"):");
		String phone=gongjulei.readString(13,cust.getDianhua());
		
		System.out.println("邮箱("+cust.getEmail()+"):");
		String email=gongjulei.readString(30,cust.getEmail());
		
		Customer customer=new Customer(name, gender, age, phone, email);
		boolean h=customerList.xiu(number-1, customer);
		if (h) {
			System.out.println("修改成功");
		}else {
			System.out.println("修改失败");
		}
	}
	//方法: 3.删除客户
	public void shanchu() {
		System.out.println("删除客户的操作");
		Customer cust;
		int number;
		for (;;) {
			System.out.println("请选择编号，-1退出");
			number=gongjulei.readInt();
			if (number==-1) {
				return;
			}
			cust=customerList.huo(number-1);
			if (cust==null) {
				System.out.println("无法找到指定客户");
			}else {//找到了相应编号的客户
				break;
			}
		}
		//删除操作
		System.out.println("是否确认删除x/y");
		char b=gongjulei.readConfirmSelection();
		if (b=='X') {
			boolean h=customerList.shan(number-1);
			if (h) {
				System.out.println("删除成功");
			}else {
				System.out.println("删除失败");
			}
			
		}
		
	}
	//方法: 4.客户列表
	public void liebiao() {
		System.out.println("客户列表：");
		System.out.println("————————————————————客户列表————————————————————");
		System.out.println();
		//结构
		int shuzi=customerList.shuliang();
		if (shuzi==0) {
			System.out.println("没有客户记录");
		}else {
			System.out.println("编号\t姓名\t性别\t年龄\t电话\t邮箱");
			Customer[] shuzu=customerList.cha();
			for (int i = 0; i < shuzu.length; i++) {
				Customer s= shuzu[i];
				System.out.println((i+1)+"\t"+s.getXingming()+"\t"+s.getXingbie()+"\t"+s.getNianling()+"\t"+s.getDianhua()+"\t"+s.getEmail());
			}
		}
		
		System.out.println();
		System.out.println("——————————————————客户列表完成————————————————————");
	}
	//方法: 5.退出
	
	public void tuichu() {
		System.out.println("是否退出x/y");
	}
	
	
	
	
}