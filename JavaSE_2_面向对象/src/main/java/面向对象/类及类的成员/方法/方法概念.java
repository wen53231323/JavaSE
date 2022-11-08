package 面向对象.类及类的成员.方法;

/*类中的方法声明和使用
 * 方法：描述类应该具有的功能
 *1.例：
 *		无参数无返回值
 *		public void eat(){}
 *		有参数无返回值
 *      public void tlak(String language){}
 *		无参数有返回值    
 *      public String getName(){}
 *      有参数有返回值
 *      public String getNation(String language){}
 * 
 *2.方法声明：权限修饰符 返回值类型 方法名(形参列表){
 * 						方法体
 * 				}
 *    注意：static、final、abstract来修饰的方法，后面再讲
 * 3.说明：
 * 		3.1关于权限修饰符：默认方法的权限修饰符先都用public
 * 		java现有的四种权限修饰符：private、public、缺省、protected-->封装性再细说
 * 		private:私有的
 * 		3.2返回值类型，有返回值VS无返回值
 * 			3.2.1如果方法有返回值，则必须在方法声明时，指定返回值的类型，
 * 					同时方法中需要使用return关键字来返回指定类型的变量或常量
 * 				 如果方法没有返回值，则方法声明时，使用void来表示，通常，没有返回值的方法中，
 * 					就不需要使用return，但是，如果使用的话，只能return,表示结束此方法的意思
 * 		3.3方法名：属于标识符，遵循标识符的规则和规范“见名知名”
 * 		3.4形参列表，方法可以声明0个，1个，或多个形参
 * 			3.4.1格式：数据类型1，数据类型2，形参3，......
 * 			3.4.2我们定义方法时，该不该定义形象
 * 		3.5方法体：方法功能的体现
 * 4.return关键字的使用：
 *    1.使用范围：使用在方法体中
 *    2.作用：结束方法
 *    		  针对有返回值的方法，使用“return 数据”方法返回所要的数据
 *    3.注意点：return关键字后不可以声明执行语句
 *    
 * 5.方法的使用中，可以调用当前类的属性或方法
 * 			特殊的：方法A中又调用了方法A(递归方法)
 * 		方法中不可以定义方法
 * 
 * */

public class 方法概念 {
	public static void main(String[] args) {
		//创建类的对象
		Custom xin=new Custom();
		//调用属性
		xin.name="小明";
		xin.age=19;
		
		//调用方法：“对象.方法”
		xin.eat();
		xin.tlak("中文");
		String jieshou1=xin.getName();
		System.out.println(jieshou1);
		String jieshou2=xin.getNation("中国");
		System.out.println(jieshou2);
	}

}
class Custom{
	//属性(或者成员变量)
	String name;
	int age;
	//方法
	//无参数无返回值
	public void eat() {
		String food="馒头";//局部变量
		System.out.println("我们吃："+food);
		
	}
	//有参数无返回值
	public void tlak(String language) {//language:形参，也是局部变量
		System.out.println("我们使用"+language+"进行交流");
		eat();//方法内可调用方法
	}
	//无参数有返回值
	public String getName() {
		if(age>18) {
			return name;
		}else {
			return "tom";
		}
	}
	//有参数有返回值
	public String getNation(String natinon) {
		String info="我的国籍是"+natinon;
		return info;
	}
}
