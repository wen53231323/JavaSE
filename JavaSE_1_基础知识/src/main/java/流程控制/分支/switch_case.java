package 流程控制.分支;

import java.util.Scanner;

/*
说明：
(1)根据switch表达式中的值，依次匹配各个case中的常量，一旦匹配成功，则进入相应case结构中，调用其执行语句。
当调用完执行语句后，则仍然继续向下执行其他case结构中的执行语句，直到遇到break关键字或switch-case结构末尾结束为止。
(2)break，可以使用在switch-case结构中，表示一旦执行到此关键字就跳出switch-case结构
(3)switch结构中的表达式，只能是如下的6种数据 类型之一：
	byte，short,char,int,枚举类型(jdk5.0新增)，String类型(jdk7.0新增)
(4)default：相当于if-else结构中的else，也是可选的，而且位置是灵活的
(5)如果switch-case结构中的多个case的执行语句相同，则可以考虑和并
(6)凡是可以使用switch-case的结构，都可以转换为if-else
• switch-case结构
switch(表达式){
	case 常量1: 
		语句1; 
	  //break; 
	case 常量2: 
		语句2;
	  //break;
… … case 常量N:
		语句N;
	  //break;
	default:
		语句;
	 //break;
	} 

*/
public class switch_case {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入数字10或20");
		String next = scan.next();
		int i = Integer.parseInt(next);
		switch (i) {
			case 10:
				System.out.println("输入了10");
				break;
			case 20:
				System.out.println("输入了20");
				break;
			default:
				System.out.println("输入错误");
				break;
		}
	}

}
