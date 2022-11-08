package 流程控制.分支;

import java.util.Scanner;

/*
	• if-else结构：
	Ø 1. if(条件表达式){ 
		执行代码块；
		 }
	Ø 2. if(条件表达式){ 
		执行代码块1; 
		} else{ 
		执行代码块2;
		}
	Ø 3. if(条件表达式1){ 
		执行代码块1; 
		} else if (条件表达式2){ 
		执行代码块2; 
		} …… else{ 
		执行代码块n; 
		}
*/
public class if_else {
	//if-else
	public void if_else1() {
		Scanner zidingyi=new Scanner(System.in); 
		
		System.out.println("请输入姓名");
		String xingming=zidingyi.next();
		System.out.println(xingming);
		
		System.out.println("请输入成绩");
		int chengji=zidingyi.nextInt();
		if(chengji>100|chengji<0) {
			System.err.println("输入错误");
		}else if(chengji>=80) {
			System.out.println("优秀");
		}else if(chengji>=60) {
			System.out.println("及格");
		}else {
			System.out.println("不及格");
		}
	}
	//if-else
	public void if_else2() {
		Scanner zidingyi=new Scanner(System.in);
		
		System.out.println("请输入第一个数");
		int num1=zidingyi.nextInt();
		
		System.out.println("请输入第二个数");
		int num2=zidingyi.nextInt();
		
		System.out.println("请输入第三个数");
		int num3=zidingyi.nextInt();
		
		System.out.println("最大数为：");
		
		if(num1>num2) {
			if(num1>num3) {
				System.out.println(num1);
			}else {
				System.out.println(num3);
			}
		}else {
			if(num2>num3) {
				System.out.println(num2);
			}else {
				System.out.println(num3);
			}
		}
	}
}
