package 异常处理;

import java.util.Date;
import java.util.Scanner;

import org.junit.Test;

/*
 * Error:
 *java虚拟机无法解决的严重问题。
 *如：JVM系统内部错误、资源耗尽等严重情况。比如：StackOverflowError
 * 
 * 一般不编写针对性的代码进行处理
 * 
 * 一.异常体系结构
 * Java.long.Throwable
 * 		|---java.lang.Error:一般不编写针对性的代码
 * 		|---java.long.Exception:可以进行异常的处理
 * 			|---编译时异常(checked)
 * 				|---IOException
 * 					|---FileNotFoundException
 * 				|---ClassNotFoundException
 * 			|---运行时异常(unchecked,RuntimeException)
 * 				|---NullPointerException:空指针
 * 				|---IndexOutOfBoundsException:角标越界
 * 				|---ClassCastException:类型转换异常
 * 				|---NumberFormatException:格式异常
 * 				|---InputMismatchException:输入不匹配
 * 				|---ArithmeticException:算数的异常
 * 
 * */
public class yichang {
	public static void main(String[] args) {
		//1.栈溢出：java.lang.StackOverflowError
//		main(args);
		//2.堆溢出：java.lang.OutOfMemoryError
		Integer[] arr=new Integer[1024*1024*1024];
	}
	
	//--------以下是运行时异常-----------
	@Test
	//NullPointerException:空指针
	public void test1() {
		int[] arr=null;
		System.out.println(arr[3]);
	}
	@Test
	//IndexOutOfBoundsException:角标越界
	public void test2() {
		int[] arr=new int[10];
		System.out.println(arr[10]);
	}
	@Test
	//ClassCastException:类型转换异常
	public void test3() {
		Object obj=new Date();
		String string=(String)obj;
	}
	@Test
	//NumberFormatException:格式异常
	public void test4() {
		String string="123";
		string="abc";
		int num=Integer.parseInt(string);
	}
	@Test
	//InputMismatchException:输入不匹配
	public void test5() {
		Scanner sca=new Scanner(System.in);
		int score=sca.nextInt();
		System.out.println(score);
	}
	@Test
	//ArithmeticException:算数的异常
	public void test6() {
		int a=10;
		int b=0;
		System.out.println(a/b);
	}
	//------------以下是编译时异常----------
//	@Test
//	public void test7() {
//		File file=new File("hello.txt");
//		FileInputStream fiS=new FileInputStream(file);
//		
//		int data=fiS.read();
//		while (data!=-1) {
//			System.out.println((char)data);
//			data=fiS.read();
//		}
//		fiS.close();
//	}	
	
}
