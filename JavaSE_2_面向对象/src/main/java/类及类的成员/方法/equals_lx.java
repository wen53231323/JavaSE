package 类及类的成员.方法;


public class equals_lx{
	public static void main(String[] args) {
		order diao1=new order(18,"小白");
		order diao2=new order(18,"小白");
		//比较
		if (diao1==diao2) {
			System.out.println("diao1==diao2");
		}else {
			System.out.println("diao1!=diao2");
		}
		
		if (diao1.equals(diao2)) {
			System.out.println("diao1 is equals to diao2");
		}else {
			System.out.println("diao1 is not equals to diao2");
		}
		
	}

}

class order{
	private int id;
	private String name;
	//构造器
	public order(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	//get、set方法
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

//自动生成
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		order other = (order) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	/*
	//方法
	//重写equals,手写
	public boolean equals(Object vv) {
		//这个方法是否与vv的引用地址是否相同
		if(this==vv) {
			return true;
		}
		//判断对象vv是否是类order的实例
		if (vv instanceof order) {
			//向下转型
			order or=(order)vv;
//			if (this.id==or.id&&this.name.equals(or.name)) {
//				return true;
//			}
			return this.id==or.id&&this.name.equals(or.name);
		}
		return false; 
	}
	
	*/
	
	
}
