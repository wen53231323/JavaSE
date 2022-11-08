package 数组.数组涉及的常见算法.复制_反转_查找;

import org.junit.Test;

import java.util.Scanner;

public class 线性查找 {
    // 数组的查找(线性)：
    // 线性查找：通过遍历的方式，一个一个的数据进行比较，查找。
    @Test
    public void chazhao() {
        System.out.println("数组的查找(线性)");
        String[] array = new String[]{"a", "b", "c", "d", "e"};
        String chazhao = "b";
        boolean isFlag = true;
        for (int i = 0; i < array.length; i++) {
            //	String 中 == 比较引用地址是否相同，
            //  equals() 比较字符串的内容是否相同
            if (chazhao.equals(array[i])) {
                System.out.println("找到了指定元素，位置为：" + i);
                isFlag = false;
                break;
            }
        }
        if (isFlag) {
            System.out.println("没找到");
        }
    }
}
