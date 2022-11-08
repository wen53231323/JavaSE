package 流程控制.循环;
/* 

 break：结束当前循环
 continue：循环结构，结束当次循环
 return：结束一个方法
*/
public class break_continue {
	public static void main(String[] args) {
		//一个数恰好等于它的因子之和，这个数就称为完数，例如6=1+2+3
		//找出1000以内的所有完数（因子：除去这个数本身的其他约数）
		int jilu=0;//记录因子
		for(int i=1;i<=1000;i++) {
			for(int j=1;j<i;j++) {
				if(i%j==0) {
				jilu+=j;//因子之和
				}
			}if (jilu==i) {
				System.out.println(jilu);
			}
			jilu=0;
		}	
	}
}
