package 关键字.导入_import;

import java.util.Scanner;

import static java.lang.System.out;

/*
 * 关键字package的使用
 * 1.为了更好的实现项目中类的管理，提供包的概念
 * 2.使用package声明类或接口所属的包，声明在源文件的首行
 * 3.包，属于标识符，遵循标识符的命名规则、规范(xxxyyyzzz)“见名如意”
 * 4.每“.”一次，就代表一层文件目录
 * 
 * 补充：同一个包下，不能命名同名的接口、类
 * 		 不同的包下，可以命名同名的接口、类
 * 
 * 关键字import的使用
 * import：导入
 * 1.在源文件中显式的使用import结构导入指定包下的类、接口
 * 2.声明在包的声明和类的声明之间
 * 3.如果需要导入多个结构，则并列写出即可
 * 4.可以使用"xxx.*"的方式，表示可以导入xxx包下的所有结构
 * 5.如果使用的类或者接口是java.long包下定义的，则可以省略import结构
 * 6.如果使用的类或接口是本包下定义的
 * 7.如果在源文件中，使用了不同包下的同名的类，则必须至少有一个类需要以全类名的方式显示
 * 8.使用"xxx.*"的方式，表示可以导入xxx包下的所有结构,但是如果使用的是xxx子包下的结构，则仍需要显式导入
 * 
 * 9.import static:导入指定类或按接口中的静态结构：属性或方法
 * */
public class import_{
	public static void main(String[] args) {
		System.out.println("请输入：");
		Scanner zidingyi=new Scanner(System.in);
		System.out.println();
		String diao=zidingyi.next();
		System.out.println("输入了："+diao);
		
		//import static的例子
		out.println("import static");
		
		
	}

}