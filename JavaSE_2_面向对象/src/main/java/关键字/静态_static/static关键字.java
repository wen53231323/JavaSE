package 关键字.静态_static;

/*
 * static关键字的使用：
 * 
 * 1.static：静态的
 * 2.static可以用来修饰：属性、方法、代码块、内部类
 * 3.使用static修饰属性:静态变量
 * 	  3.1 属性,按是否使用static修饰，又分为：静态属性VS非静态属性(实例变量)
 * 	  实例变量：我们创建了类的多个对象，每个对象都独立的拥有一套类中的非静态属性
 * 			当修改其中一个对象中的非静态属性时，不会导致其他对象中同样的属性值的修改
 *    静态变量：我们创建了类的多个对象，多个对象共享同一个静态变量，当通过某一个对象修改
 *          静态变量时，会导致其他对象调用此静态变量时，是修改过了的
 *    3.2 static修饰属性的其他说明
 *    	  1.静态变量随着类的加载而加载，可以通过“类.静态变量”的方式进行调用
 *    	  2.静态变量的加载要早于对象的创建
 *        3.由于类只会加载一次，则静态变量在内存中也只会存在一份:存在方法区的静态域中
 *        
 *        4.	类变量	实例变量
 *        类		yes		no
 *        对象	yes		yes
 *        
 *    3.3 静态属性举例：System.out; Math.PI;
 *    
 * 4.使用static修饰方法:静态方法
 *   1.随着类的加载而加载，可以通过“类.静态方法”的方式进行调用
 *   2.		 静态方法	实例方法
 *     类	 yes		no
 *     对象 	 yes		yes
 * 	 3.静态方法中，只能调用静态的方法和属性
 * 		非静态方法中，既可以调用非静态的方法或属性，也可以调用静态的方法或属性
 * 
 * 5.static注意点：
 * 	 5.1在静态的方法内，不能使用this关键字、super关键字
 *   5.2关于静态属性和静态方法的使用，大家都可以从生命周期的角度去理解
 *   
 * 6.开发中，如何确定一个属性是否要声明为static的
 * 		>属性是可以被多个对象所共享的，不会随着对象的不同而不同的
 * 		>类中的常量也常常声明为static
 * 
 *   开发中，如何确定一个方法是否要声明为static的
 * 		>操作静态属性的方法，通常设置为static的
 * 		>工具类中的方法，习惯上声明为static的，比如：Math、Arrays、Collections
 * 
 * */
public class static关键字{
	
	public static void main(String[] args) {
		//动态属性、方法不用声明对象就可以调用
		Chinese.jing="静态的";
		Chinese.eat();
		
		Chinese d1=new Chinese();
		d1.name="小白";
		d1.age=20;
		
		Chinese d2=new Chinese();
		d2.name="大黄";
		d2.age=22;
		
//当通过某一个对象修改静态变量时，会导致其他对象调用此静态变量时，是修改过了的
		d1.jing="静态的1";
		d2.jing="静态的2";
		System.out.println(d1.jing);
		
	}
}

class Chinese {
	
		String name;
		int age;
		static String jing;//静态属性
		//静态方法
		public static void eat () {
			System.out.println("吃饭");
			
		}
		public void name() {
//非静态方法中，既可以调用非静态的方法或属性，也可以调用静态的方法或属性
			this.name=" ";
			Chinese.jing=" ";// Chinese. 一般省略
			name3();
			name1();
		}
		public static void name1() {
			//静态方法中可以调用类变量，不能调用实例变量
			jing="静态";
			//name

			//静态方法中可以调用静态方法，不能调用非静态方法
			Chinese.name2();// Chinese. 一般省略
			//name3();
		}
		public static void name2() {
	
		}
		public void name3() {
			
		}

}