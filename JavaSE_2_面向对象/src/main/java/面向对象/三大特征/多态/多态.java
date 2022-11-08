package 面向对象.三大特征.多态;

/*
 * 面向对象特征之三：多态性
 * 
 * 1.理解多态性：可以理解为一个事物的多种形态
 * 2.何为多态性：
 * 		父类的引用指向子类的对象(或子类的对象赋给父类引用)
 * 3.多态的使用：虚拟方法调用
 * 		有了对象的多态性以后，我们在编译期，只能调用父类中声明的方法，但在运行期，我们实际执行的是子类重写父类的方法
 * 		总结：编译，看左边，运行，看右边
 * 
 * 4.多态性的使用前提：
 * 		1.要有类的继承关系
 * 		2.要有方法的重写
 * 
 * 5.对象的多态性只适用于方法，不适用于属性(编译和运行都看左边)
 * 
 * 6.多态性是运行时的行为
 * 
 * 7.有了对象的多态性以后，内存中实际上是加载了子类特有的属性和方法的，
 * 但是由于变量声明为父类类型，导致编译时，只能调用父类中声明的属性和方法,
 * 子类特有的属性和方法不能调用
 * 
 * 8.如何调用子类特有的属性和方法?
 * 向下转型，使用强制类型转换符
* 使用强制转换时，可能出现ClassCastException的异常
* 
* 9.instanceof关键字的使用：
* 		a instanceof A:判断对象a是否是类A的实例，
* 		如果是，返回true：如果不是，返回false
* 使用情境：为了避免在向下转型时出现ClassCastException的异常
* 我们在向下转型之前，先进行instanceof的判断，一旦返回true
* 就进行向下转型，如果返回false，不进行向下转型
* 
* 如果a instanceof A返回true，则a instanceof B也返回true
* 	其中，类B是类A的父类
*
 * */
public class 多态 {
	public static void main(String[] args) {
		//对象的多态性:父类的引用指向子类的对象
		person p1=new man();
		person p2=new woman();

		//多态的使用：当调用父类同名同参数的方法时，实际执行的是子类重写父类的方法（虚拟方法调用）
		p1.eat();
		p2.walk();
		
		//对象的多态性只适用于方法，不适用于属性(静态绑定)
		System.out.println(p1.id);//1001
		System.out.println(p2.id);//1001
		
		//不能调用子类中特有的方法、属性，编译时，p1、p2是person类型
		//有了对象的多态性以后，内存中实际上是加载了子类特有的属性和方法的，但是由于变量声明为父类类型，
		//导致编译时，只能调用父类中声明的属性和方法,子类特有的属性和方法不能调用
		//p1.money();
		//p2.shopping();

		//如何调用子类特有的属性和方法?
		//向下转型，使用强制类型转换符
		man d1=(man)p1;
		d1.money();
		woman d2=(woman)p2;
		d2.shopping();

		//woman w1=(woman)p1;
		//w1.shopping();
		//man w2=(man)p2;
		//w2.money();

		//instanceof关键字的使用：
		//a instanceof A:判断对象a是否是类A的实例，如果是，返回true：如果不是，返回false
		if (p1 instanceof woman) {//false不能进入if
			woman w1=(woman)p1;
			w1.shopping();
			System.out.println("woman");
		}
		if (p1 instanceof man) {//true进入if
			man w2=(man)p1;
			w2.money();
			System.out.println("man");
		}
		if (p1 instanceof person) {//true进入if
			System.out.println("person");
		}
		if (p1 instanceof Object) {//true进入if
			System.out.println("Object");
		}

		//问题一：编译通过，运行不过
		//举例一
		//person g1=new woman();
		//man f1=(man)g1;
		//举例二
		//person g2=new person();
		//man f2=(man)g2;
		
		//问题二：编译通过，运行也通过
		//Object object=new woman();
		//person f3=(person)object;
		
		//问题三：编译不通过
		//man f4=new woman();
		
	}
	
}
//父类
class person {
	int id=1001;
	String name;
	int age;

	public void eat() {
		System.out.println("吃饭");
	}
	public void walk() {
		System.out.println("走路");
	}

}
//子类1
class man extends person{
	int id=1002;
	boolean jiu;

	public void eat() {
		System.out.println("多吃肉，长肌肉");
	}
	public void walk() {
		System.out.println("霸气的走路");
	}
	//子类1特有的方法
	public void money() {
		System.out.println("男人挣钱");
	}

}
//子类2
class woman extends person{
	int id=1003;
	boolean mei;

	public void eat() {
		System.out.println("少吃，减肥");
	}
	public void walk() {
		System.out.println("女人窈窕的走路");
	}
	//子类2特有的方法
	public void shopping() {
		System.out.println("购物");
	}

}

