package 项目.管理类;

//CustomerList为Customer的对象管理模块，
//内部使用数组一组Customer对象


import 项目.客户类.Customer;

public class CustomerList {
	private Customer[] customers;//用来保存客户对象数组
	private int total=0;//记录已保存的客户对象的数量
	//用来初始化数组的构造器
	public CustomerList(int chushi){
		customers=new Customer[chushi];
	}
	//添加指定客户到数组
	public boolean zeng(Customer customer) {
		if (total>=customers.length) {
			return false;
		}
		customers[total++]=customer;
		return true;
	}
	//修改指定索引的客户信息
	public boolean xiu(int index,Customer cust) {
		if (index<0||index>=total) {
			return false;
		}
		customers[index]=cust;
			return true;
	}
	//删除指定索引的客户
	public boolean shan(int index) {
			if (index<0||index>=total) {
				return false;
			}
			for (int i = index; i < total-1; i++) {
				customers[i]=customers[i+1];
				}
			//有数组的元素置空
			customers[total-1]=null;
			total--;
			//或  customers[--total]=null;
			return true;
		}
		//获取所有客户信息
		public Customer[] cha() {
			Customer[] custs=new Customer[total];
			for (int i = 0;i <total; i++) {
				custs[i]=customers[i];
			}
			return custs;
		}
		
		//获取指定索引的客户
		public Customer huo(int index) {
			if (index<0||index>=total) {
				return null;
			}
			return customers[index];
		}
		//获取客户数量
		public int shuliang() {
			return total;
		}

}
