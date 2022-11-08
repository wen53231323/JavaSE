package 流程控制.循环;

import org.junit.Test;

/*
 * 	
• for循环结构：
	Ø for (①初始化部分; ②循环条件部分; ④迭代部分)｛ 
				③循环体部分; 
		｝
	执行过程：①-②-③-④-②-③-④-②-③-④-.....-②
	说明： 
		②循环条件部分为boolean类型表达式，当值为false时，退出循环 
		①初始化部分可以声明多个变量，但必须是同一个类型，用逗号分隔 
		④可以有多个变量更新，用逗号分隔			
关键字：
	break：结束当前循环
 	continue：结束当次循环
 
 */
public class for循环 {
	public static void main(String[] args) {
		
	}
	
	@Test
	public void forxh1() {
		//循环9次
		for(int i=1;i<=9;++i) {
			System.out.println("循环9次");
		}
	}
	@Test
	public void forxh2() {
		//遍历100以内的偶数,并获取所有偶数的和，输出偶数的个数
				int i=0;//记录偶数的和
				int d=0;//记录偶数的个数
				for(int num=1;num<=100;num++){
					if(num%2==0) {
						System.out.println(num);
						//累加
						i+=num;
						d++;
				}
			}
				//结束循环求出总和
				System.out.println("偶数和为："+i);	
				//结束循环求出偶数个数
				System.out.println("偶数个数为："+d);	
	}
	
	@Test
	public void forxh3() {
		//遍历1-150，每行一个值，3的倍数后打印foo，
		//5的倍数后面打印biz,7d的倍数后打印	
		for(int bianli=1;bianli<=150;bianli++) {
				System.out.println(bianli);
				if (bianli%3==0) {
					System.out.println("-----3的倍数");
				}if(bianli%5==0) {
					System.out.println("-----5的倍数");
				}if(bianli%7==0){
					System.out.println("-----7的倍数");
				}
		}
	}
}
























