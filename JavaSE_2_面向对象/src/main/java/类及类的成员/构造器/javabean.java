package 类及类的成员.构造器;
/*javaBean是一种java语言写成的可重用组件
 * 
 * 所谓javaBean，是指符合如下标准的java类
 * >类是公共的
 * >是一个无参的公共的构造器
 * >有属性，且有对应的get、set方法
 * 
 * */
public class javabean {
		private int i;
		private int j;
		//公共构造器
		public javabean(){
			
		}
		//set方法
		public void seti(int a) {
			i=a;
		}
		public void setj(int b) {
			j=b;
		}
		//get方法
		public int geti() {
			return i;
		}
		public int getj() {
			return j;
		}
}

