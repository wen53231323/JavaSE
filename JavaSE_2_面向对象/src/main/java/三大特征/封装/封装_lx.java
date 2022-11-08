package 三大特征.封装;

//使用封装，set设置一个(1-130)的年龄，并用get获取
public class 封装_lx {
	public static void main(String[] args) {
		lianxi diao=new lianxi();
		diao.seti(3);
		System.out.println("年龄为："+diao.geti());
		//错误的：
		System.out.println("年龄为："+diao.get(56));
	}
}

class lianxi{
	private int i;
	//设置
	public void seti(int j) {
		if (i<0||i>130) {
			System.out.println("非法，不合题义");
			return;
		}
		i=j;
	}
	//获取
	public int geti() {
		return i;
	}
	//绝对不能这样写
	public int get(int k) {
		i=k;
		return i;
	}
	
}
