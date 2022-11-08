package 面向对象.三大特征.封装;

import java.util.Scanner;
import java.util.Vector;

/*
 * 利用Vector代替数组处理：从键盘读入学生成绩(以负数代表输入结束)，找出最高分，并输出学生成绩等级
 * 提示：数组一旦创建,长度固定不变，所以在创建数组前就需要知道它的长度
 * 而向量类java.util.Vector可以根据需要动态伸缩
 * 
 * 创建Vector对象：Vector v=new Vector();
 * 给向量添加元素：v.addElement(Object obj); //obj必须是对象
 * 取出向量中的元素：Object obj=v.elementAt(0);
 * 注意第一个元素的下标是0，返回值是Object类型的
 * 计算向量的长度：v.seze()
 * 若与最高分相差10分内：A等、20分内：B等、30分内：C等、其他：D等 
 * 
 * */
public class 包装类_lx {
	public static void main(String[] args) {
		//1.实例化Scanner，用于从键盘获取学生成绩
		Scanner sca=new Scanner(System.in);
		//2.创建Vector对象:Vector v=new Vector();相当于原来的数组
		Vector v=new Vector();
		//3.通过for(;;)或while(true)方式，给Vector中添加数组
		int cj=0;
		for (;;) {
			System.out.println("请输入任意个学生成绩，输入负数退出");
			int score=sca.nextInt();
			//3.2当输入负数时，跳出循环
			if (score<0) {
				break;
			}
			if (score>100) {
				System.out.println("输入数据太大");
				continue;//结束当次循环
			}
			
			//3.1添加操作：v.addElement(Object obj);
			//jdk5.0之前
//			Integer d=new Integer(score);
//			v.addElement(d);//多态
			
			//jdk5.0之后
			v.addElement(score);//自动装箱
			
			//4.获取最大值
			if (cj<score) {
				cj=score;
			}
		}
		
		//5.遍历Vector,得到每个学生的成绩，并与最大成绩比较，得到每个学生的等级
		char leva;
		for (int i=0;i<v.size();i++) {
			Object obj=v.elementAt(i);
			//jdk5.0之前：
//			Integer gu=(Integer)obj;
//			int score=gu.intValue();
			
			//jdk5.0之后
			int score=(int)obj;
			
			if (cj-score<=10) {
				leva='A';
			}else if (cj-score<=20) {
				leva='B';
			}else if (cj-score<=30) {
				leva='c';
			}else{
				leva='D';
			}
			
			System.out.println("数组中位置 "+i+"成绩 "+score+"等级 "+leva);
		}
	}
}

