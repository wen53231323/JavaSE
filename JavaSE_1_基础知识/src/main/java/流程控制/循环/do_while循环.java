package 流程控制.循环;


import org.junit.Test;

/*
 • do-while循环结构：
	Ø ①初始化部分;
		do{ 
			③循环体部分 
			④迭代部分 
			}while(②循环条件部分);
	
	Ø 执行过程： ①-③-④-②-③-④-②-③-④-...②
	Ø 说明: 1.do-while循环至少执行一次循环体。
			2.do-while至少会执行一次循环体
 			3.开发中使用for和while循环多一些，较少使用do-while

 */
public class do_while循环 {
	
	@Test
	public void name() {
		// 遍历100以内的偶数,并求偶数总和
		int num=1;
		int sum=0;//记录总和
		int count=0;//记录次数
		do {
			if(num%2==0) {
				System.err.println(num);
				count++;
				sum+=num;	
			}
			num++;
		} while (num<=100);
		System.out.println("偶数个数为："+count);
		System.out.println("偶数总和为："+sum);
	}

}
