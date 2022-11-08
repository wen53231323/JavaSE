package 关键字.静态_static;

//ArrayUtil工具类
//static的应用
public class static_lx {
	public static void main(String[] args) {
		int[] arr=new int[] {1,4,6,5,3,2,9};
		//数组最大值 
		System.out.println("最大值："+ArrayUtil.getmax(arr));
		//数组最小值
		System.out.println("最小值："+ArrayUtil.getmin(arr));
		//数组求和
		System.out.println("求和："+ArrayUtil.gethe(arr));
		//数组平均值
		System.out.println("平均值："+ArrayUtil.getjun(arr));
		//数组的反转
		System.out.println("反转前：");
		ArrayUtil.bianli(arr);
		ArrayUtil.getfan(arr);//调用反转
		System.out.println();
		System.out.println("反转后：");
		ArrayUtil.bianli(arr);
		//数组的复制
		System.out.println();
		System.out.println("arr:");
		ArrayUtil.bianli(arr);
		System.out.println();
		System.out.println("复制arr的srr:");
		ArrayUtil.bianli(ArrayUtil.getfuzhi(arr));
		//冒泡排序
		System.out.println();
		System.out.println("排序前：");
		ArrayUtil.bianli(arr);
		System.out.println();
		System.out.println("排序后：");
		ArrayUtil.getpai(arr);
		
	}
}

class ArrayUtil{
	//数组最大值 
	public static int getmax(int[] arr) {
		int fmax=arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (fmax<arr[i]) {
				fmax=arr[i];
				}
		}
		return fmax;
	}
	//数组最小值
	public static  int getmin(int[] arr) {
		int fmin=arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (fmin>arr[i]) {
				fmin=arr[i];
				}
		}
				return fmin;
	}
	//数组求和
	public static int gethe(int[] arr) {
		int he=0;
		for (int i = 0; i < arr.length; i++) {
			he+=arr[i];
	}
		return he;
	}
	//数组平均值
	public static int getjun(int[] arr) {
		
		return gethe(arr)/arr.length;
	}
	//数组反转
	public static void getfan(int[] arr) {
			for (int i = 0; i < arr.length/2; i++) {
				int zhuan=arr[i];
				arr[i]=arr[arr.length-i-1];
				arr[arr.length-i-1]=zhuan;
			}
	}
	//数组的复制
	public static int[] getfuzhi(int[] arr) {
		
		int[] srr=new int[arr.length];
		for(int i=0;i<srr.length;i++) {
			srr[i]=arr[i];
		}
		return srr;
	}
	//数组的排序
	public static void getpai(int[] arr) {
		//冒泡排序
		for(int i=0;i<arr.length;i++) {//记录数组中有多少元素
			for(int j=0;j<arr.length-1-i;j++) {//循环的次数
				if(arr[j]>arr[j+1]){
					int zhuan=arr[j];//第一个数据与第二个数据转换，大后小前
					arr[j]=arr[j+1];
					arr[j+1]=zhuan; 
				}
			}
		}
		//遍历排序后的数组
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	//遍历
	public static void bianli(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}

