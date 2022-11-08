package 面向对象.关键字.抽象_abstract;
//抽象类的匿名子类对象

public class 抽象类的匿名子类对象 {
	public static void main(String[] args) {
		method(new Student());//匿名对象
		
		Worker w=new Worker();
		method1(w);//非匿名的类非匿名的对象
		
		method1(new Worker());//非匿名的类匿名的对象
		
		Person per=new Person() {//匿名子类对象
			//重写抽象类中的方法
			@Override
			public void breath() {
				System.out.println("呼吸新鲜空气");
			}
			@Override
			public void eat2() {
				System.out.println("吃好吃的");
			}
		};
		method1(per);
		System.out.println("-------------");
		//匿名子类的匿名对象
		method1(new Person() {
			//重写抽象类中的方法
			@Override
			public void breath() {
				System.out.println("呼吸新鲜空气");
			}
			@Override
			public void eat2() {
				System.out.println("吃好吃的");
			}
		});
	}
	//方法
	public static void method() {
		
	}
	//方法的重载
	public static void method(Student s) {
		
	}
	public static void method1(Person p) {
		p.eat2();
		p.breath();
	}

}
//Person的子类
class Worker extends Person{
	
	//重写抽象类的方法
	@Override
	public void eat2() {
		
	}
	@Override
	public void breath() {
		
	}
	
}