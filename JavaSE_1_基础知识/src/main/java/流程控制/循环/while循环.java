package 流程控制.循环;

import org.junit.Test;

import java.util.Scanner;

/*
 • while循环结构：
		Ø ①初始化部分 
		while(②循环条件部分)｛ 
			③循环体部分; 
			④迭代部分;
		} 
	执行过程： ①-②-③-④-②-③-④-②-③-④-...-②
	说明： 
		1.注意不要忘记声明④迭代部分。否则，循环将不能结束，变成死循环。 
		2.for循环和while循环可以相互转换
  	区别：
		for循环和while循环的初始化条件部分的作用范围不同

 * */
public class while循环 {
	
	@Test
	public void while1() {
		//遍历100以内的所有偶数
		int i=1;//初始化条件
		while(i<=100) {
			if(i%2==0) {
				System.out.println(i);//循环内容
			}
			i++;//迭代条件
		}
	}
	
	@Test
	public void name() {
		//判断输入的数字是正数还是负数，并计算出个数
		Scanner zidingyi=new Scanner(System.in);
		System.out.println("请输入一个数字");
		int zhengshu=0;//记录正数个数
		int fushu=0;//记录负数个数
		//while(true)   {
		for(;;) {
			int dayina=zidingyi.nextInt();
			if(dayina>0) {
				System.out.println("正数");
				zhengshu++;
			}else if(dayina<0) {
				System.out.println("负数");
				fushu++;
			}else {
				break;//0跳出循环
			}
		}
		System.out.println("输入正数个数"+zhengshu);
		System.out.println("输入负数个数"+fushu);
	}

}
