package 练习题;

//	计算阶乘
// 例：5的阶乘：1x2x3x4x5
public class 计算阶乘 {
    public static void main(String[] args) {
        System.out.println( test1(5));
        System.out.println( test2(5));
    }

    //方法一：循环实现
    public static int test1(int num){
        int n=1;
        for (int i=1;i<=num;i++){
            n=n*i;
        }
        return n;
    }
    //方法二：递归实现
    public static int test2(int num){
        if (num==0){
            return 1;
        }
        return test2(num-1)*num;
    }
}
