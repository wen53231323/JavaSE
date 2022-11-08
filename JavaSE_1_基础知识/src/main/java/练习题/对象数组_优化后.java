package 练习题;
/*
 *  创建对象数组，记录20个学生成绩，学号1-20，年级1-3，成绩1-100
 * 1.打印出3年级的学生信息
 * 2.用冒泡排序按学生成绩排序，并遍历所有学生信息
 * */
//对对象数组的优化
public class 对象数组_优化后 {
		public static void main(String[] args) {
			//创建对象数组
			student[] diao=new student[10];
			for (int i = 0; i < diao.length; i++) {
				//给数组元素赋值
				diao[i]=new student();
				//给student对象的属性赋值
				//学号[1,20]
				diao[i].xuehao=(i+1);
				//年级[1,6]
				diao[i].nianji=(int)(Math.random()*(3-1+1)+1);
				//成绩[0-100]
				diao[i].chengji=(int)(Math.random()*(100-0)+1);
			}
			
			//创建对象
			对象数组_优化后 ceshi=new 对象数组_优化后();
			System.out.println("遍历学生数组:");
			ceshi.bianli(diao);
			System.out.println("______________________________________");
			System.out.println("打印指定年级学生成绩:");
			ceshi.dayin(diao,3);
			System.out.println("______________________________________");
			System.out.println("冒泡排序,并打印:");
			ceshi.paixu(diao);
			
		}
		//遍历学生数组
		public void bianli(student[] diao) {
			for (int i = 0; i < diao.length; i++) {
				System.out.println(diao[i].name());
			}
		}
		//打印指定年级学生成绩
		public void dayin(student[] diao,int nianji) {
			for (int i = 0; i < diao.length; i++) {
				if (diao[i].nianji==nianji) {
					System.out.println(diao[i].name());
				}
			}
	}
		//冒泡排序,并打印
		public void paixu(student[] diao) {
			//问题二
			for (int i = 0; i < diao.length; i++) {
				for (int j = 0; j < diao.length-1-i; j++) {
					if (diao[j].chengji>diao[j+1].chengji) {
						//如果需要换序，交换的是数组的元素，student对象
						//声明临时变量
						student zhuan=diao[j];
						diao[j]=diao[j+1];
						diao[j+1]=zhuan;
					}
				}
			}
			//遍历
				for (int i = 0; i < diao.length; i++) {
					System.out.println(diao[i].name());
		}
		
	}
}
class student{
		int xuehao;//学号
		int nianji;//年级
		int chengji;//成绩
		public String name() {
			return "学号:"+xuehao+"  年级:"+nianji+"  成绩:"+chengji;
		}

	}
