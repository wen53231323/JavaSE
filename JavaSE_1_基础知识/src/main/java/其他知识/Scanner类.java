package 其他知识;

import java.util.Scanner;

public class Scanner类 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入姓名：");
        String name = scan.next();
        System.out.println("你好！" + name);
    }
}
