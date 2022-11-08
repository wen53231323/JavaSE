package 项目.客户类;

//封装客户信息

public class Customer {
	private String xingming;//姓名
	private char xingbie;//性别
	private int nianling;//年龄
	private String dianhua;//电话
	private String email;//电子邮箱
	
	//构造器
	public Customer() {
		
	}
	
	public Customer(String xingming, char xingbie, int nianling, String dianhua, String email) {
		this.xingming = xingming;
		this.xingbie = xingbie;
		this.nianling = nianling;
		this.dianhua = dianhua;
		this.email = email;
	}
	//set、get
	public String getXingming() {
		return xingming;
	}
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	public char getXingbie() {
		return xingbie;
	}
	public void setXingbie(char xingbie) {
		this.xingbie = xingbie;
	}
	public int getNianling() {
		return nianling;
	}
	public void setNianling(int nianling) {
		this.nianling = nianling;
	}
	public String getDianhua() {
		return dianhua;
	}
	public void setDianhua(String dianhua) {
		this.dianhua = dianhua;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
