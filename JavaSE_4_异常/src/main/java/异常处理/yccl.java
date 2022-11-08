package 异常处理;
/*
 * 异常的处理：抓抛模型
 * 过程一：
 *   “抛”：程序在正常执行中，一旦出现异常，就会在异常代码处生成一个
 *    对应异常类的对象并将此对象抛出
 *   一旦抛出对象以后其后的代码就不再执行
 * 
 * 过程二：
 *   “抓”：可以理解为为异常的处理方式：1.try-catch-finally 2.throws
 *   
 *   二：try-catch-finally的使用
 *   try{
 *   	//可能出现异常的代码
 *   }catch(异常类型1 变量名1){
 *   	//处理异常的方式1
 *   }catch(异常类型2 变量名2){
 *   	//处理异常的方式1catch
 *   }(异常类型3 变量名3){
 *   	//处理异常的方式3
 *   ....
 *   finally{
 *   	//一定会执行的异常
 *   }
 *  
 *  说明：
 *  1.finally是可选的
 *  2.使用try将可能出现异常代码包装起来，在执行过程中，一旦出现异常，
 *  就会生成一个对应异常类的对象，根据此对象的类型、去catch中进行匹配
 *  3.一旦try中的异常对象匹配到某一个catch时，就进入catch中进行异常的处理
 *  一旦处理完成，就跳出当前的try-catch结构(在没有写finally的情况),继续执行其后的代码
 *  4.catch中的异常类型如果没有子父类关系，则谁声明在上，谁声明在下无所谓
 *    catch中的异常类型如果满足子父类关系，则要求子类一定声明在父类的上面，否则，报错
 *  5.常用的异常处理方式：1.String getMessage() 2.printStackTrace()
 *  6.在try结构中声明的变量，再出了try结构以后，就不能再被调用
 * 
 * 体会：使用try-catch-finally处理编译时异常，使得程序在编译时就不再报错，但是运行时仍可能报错
 * 相当于我们使用try-catch-finally将一个编译时可能出现的异常，延迟到运行时出现
 * 
 * */

import java.io.*;

import org.junit.Test;

public class yccl {
	@Test
	public void test(){
		try {
			System.out.println("可能出现异常的方法");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("一定会执行的代码");
		}
	}

	@Test
	public void test1() {
		String string="123";
		string="abc";
		int num=0;
		try {
			num=Integer.parseInt(string);
			System.out.println("1111111");
		} catch (NumberFormatException e) {
//			System.out.println("出现数值转换异常了，");
			//String getMessage()
			System.out.println(e.getMessage());
			//printStackTrace()
//			e.printStackTrace();
		}catch (NullPointerException e) {
			System.out.println("出现空指针异常了，");
		}catch (Exception e) {
			System.out.println("出现异常了，");
		}
		System.out.println(num);
		System.out.println("22222222");
	}
	
	@Test
	public void test2(){
		try{
			File file=new File("hello.txt");
			FileInputStream fis=new FileInputStream(file);
			
			int data=fis.read();
			while (data!=-1) {
				System.out.println((char)data);
				data=fis.read();
			}
			fis.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
