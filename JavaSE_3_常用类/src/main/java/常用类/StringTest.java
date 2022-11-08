package 常用类;

import org.junit.Test;

public class StringTest {

    @Test
    public void test(){
        // 1、使用字符串常量直接初始化一个String对象
        String str="abc";

        // 2、使用String的构造方法初始化字符串对象
        String str1=new String();// 创建一个空的字符串
        String str2=new String ("小明");//创建字符串"小明"
        char[] charArray=new char[]{'A','B','C'};
        String str3=new String(charArray);//创建一个内容为字符数组的字符串
    }

    public static void main(String[] args) {
        String str = "小明";
        change(str); // 修改为:小刚
        System.out.println(str); // 小明

    }

    public static void change(String str) {
        str = "小刚";
        System.out.println("修改为:" + str);
    }


}
