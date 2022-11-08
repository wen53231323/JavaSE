package 面向对象.类及类的成员.方法;
/*
 * Object类中toString()的使用
 * 1.当我们输出一个对象的引用时，实际上就是调用当前对象的tostring()
 * 
 * 2. Object中定义的toString方法：
 *  public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }

 * 3.像String、Data、file、包装类等都重写了Object类中的toString()方法
 *   使得在调用对象的toString()时，返回“实体内容信息”
 * 
 * 4.自定义类也可以重写toString()方法，当调用此方法时，返回"实体内容"信息
 * 
 * */
public class tostring方法 {
	int age=18;
	String name="小白";
	public static void main(String[] args) {
		tostring方法 diaoTostring =new tostring方法();
		
		System.out.println(diaoTostring);//tostring_.tostring@41a4555e
		System.out.println(diaoTostring.toString());//tostring_.tostring@41a4555e
		
		String a=new String("mm");
		System.out.println(a);//mm
	}
	//自动生成
	@Override
	public String toString() {
		return "tostring [age=" + age + ", name=" + name + "]";
	}
	
	/*//手写
	public String toString() {
		return "name="+name+"age="+age;
	}
	*/

}

