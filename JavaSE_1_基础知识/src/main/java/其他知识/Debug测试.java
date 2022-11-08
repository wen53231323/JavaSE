package 其他知识;

/*
 * 	操作					作用
 * step into 跳入		进入当前行所调用的方法中
 * step over 跳过		执行完当前行的语句，进入下一行
 * step return 跳回		执行完当前行所在的方法，进入下一行
 * drop to frame		回到当前行所在方法的第一行
 * resume 恢复			执行完当前行所在断点的所有代码，进入下一个断点，如果没有就结束
 */
public class Debug测试 {
    public static void main(String[] args) {
        String str = "A";
        int num = 1;
        System.out.println(str);
        System.out.println(num);
    }

}
