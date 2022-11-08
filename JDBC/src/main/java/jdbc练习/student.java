package jdbc练习;

//封装数据，一般是数据库表中有几个字段则在该类中添加对应属性
public class student {
	//私有的(paivate)
	private int stuid;
	private String stuname;
	private int stuage;
	private int classid;
	
	//构造器
	public student(int stuid, int stuage, int classid) {
		super();
		this.stuid = stuid;
		this.stuage = stuage;
		this.classid = classid;
	}
	//构造器
	public student(int stuid, int stuage, int classid, String stuname) {
		super();
		this.stuid = stuid;
		this.stuname = stuname;
		this.stuage = stuage;
		this.classid = classid;
	}
	//get、set方法,set赋值，get取值
	public int getStuid() {
		return stuid;
	}
	public void setStuid(int stuid) {
		this.stuid = stuid;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public int getStuage() {
		return stuage;
	}
	public void setStuage(int stuage) {
		this.stuage = stuage;
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	

}
