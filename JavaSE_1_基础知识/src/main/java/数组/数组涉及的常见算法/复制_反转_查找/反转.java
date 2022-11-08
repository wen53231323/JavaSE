package 数组.数组涉及的常见算法.复制_反转_查找;

import org.junit.Test;

public class 反转 {
    @Test
    public void reverse1() {
        int[] array = new int[]{1, 2, 3, 4, 5};

        // 数组反转方式一
        for (int i = 0; i < array.length / 2; i++) {
            int reverse = array[i];//将定义的变量值等于数组第一个值
            array[i] = array[array.length - i - 1];//将第一个值替换为最后一个值
            array[array.length - i - 1] = reverse;//将最后一个替换为定义的值
        }
        // 打印反转后的数组
        System.out.println("反转后：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }

    @Test
    public void reverse2(){
        int[] array = new int[]{1, 2, 3, 4, 5};
        // 数组反转方式二
        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            int reverse = array[i];
            array[i] = array[j];
            array[j] = reverse;
        }
        // 打印反转后的数组
        System.out.println("反转后：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
