package 练习题;
//输出m行n列的*，并返回m*n
public class 输出m行n列的字符 {
	public static void main(String[] args) {
		//创建对象
		lei diaoLei=new lei();
		//调用含参的类
		System.out.println("面积为："+diaoLei.mianji(7,9));
	}
}
class lei{	
	public int mianji(int m,int n) {
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				//输出m行n列的*
				System.out.print("* ");
			}
				System.out.println();
		}
		//返回m*n
		return m*n;
	}
}
