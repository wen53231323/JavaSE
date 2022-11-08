package 面向对象.关键字.抽象_abstract.抽象练习;

import java.util.Calendar;

//创建Employee数组并初始化，存放各类雇员对象的引用
//利用循环结构遍历数组元素，输出各个对象的类型，以及生日
//当键盘输入本月月份值时，如果本月是某个Employee对象的生日，还要输出增加工资信息
public class PayrollSystm {
	public static void main(String[] args) {
		//方法一
//		Scanner ss=new Scanner(System.in);
//		System.out.println("请输入月份：");
//		int yue=ss.nextInt();
		
		//方法二
		Calendar rili= Calendar.getInstance();
		int yue=rili.get(Calendar.MONTH);//获取当前月份
		System.out.println(yue);//一月份：0 二月份：1 ........十二月份：11
		
		Employee[] emps=new Employee[2];
		emps[0]=new SalariedEmployee("小白", 1, new MyDate(2001, 6, 6),1000);
		emps[1]=new HourlyEmployee("大黄", 2, new MyDate(2002,3,3),50,200);
		
		for(int i=0;i<emps.length;i++) {
			System.out.println(emps[i]);
			double salary=emps[i].earnings();
			System.out.println("月工资为"+salary);
			if (yue+1==emps[i].getBirthday().getMonth()) {
				System.out.println("生日快乐，奖励100");
			}
		}
		
	}

}
