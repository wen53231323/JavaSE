package IO流.其他流;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

public class 标准输入输出流 {
    /**
     * 例题：
     * 从键盘输入字符串，要求将读取到的整行字符串转成大写输出。
     * 然后继续进行输入操作，直至当输入“e”或者“exit”时，退出程序。
     * 实现方式
     * 方式一：使用Scanner实现
     * 方式二：使用标准输入输出流
     */
    @Test
    public void test1() {
        Scanner scan = new Scanner(System.in);
        String num = scan.next();

        System.out.println("请输入字符：");
        while (true) {
            //判断是否为e或exit，如果是就退出，否则变为大写
            //equalsIgnoreCase()：忽略大小写判断是否为某个值
            if ("e".equalsIgnoreCase(num) || "exit".equalsIgnoreCase(num)) {
                System.out.println("安全退出!!");
                break;//退出并结束程序
            } else {
                //toUpperCase()：将读取到的整行字符串转成大写输出
                System.out.println(num.toUpperCase());
            }
        }
    }

    @Test
    public void test2() {
        System.out.println("请输入信息(退出输入e或exit):");
        // 把"标准"输入流(键盘输入)这个字节流包装成字符流,再包装成缓冲流
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        try {
            while ((s = br.readLine()) != null) {
                //判断是否为e或exit，如果是就退出，否则变为大写
                //equalsIgnoreCase()：忽略大小写判断是否为某个值
                if ("e".equalsIgnoreCase(s) || "exit".equalsIgnoreCase(s)) {
                    System.out.println("安全退出!!");
                    break;//退出并结束程序
                }
                //toUpperCase()：将读取到的整行字符串转成大写输出
                System.out.println("-->:" + s.toUpperCase());
                System.out.println("继续输入信息");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    //关闭过滤流时,会自动关闭它包装的底层节点流
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
