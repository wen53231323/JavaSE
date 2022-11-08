package 数组.数组涉及的常见算法.求值;

import org.junit.Test;

public class 最小值 {
    @Test
    public void min() {
        int[] array = {1, 2, 3};
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        System.out.println("最小数：" + min);
    }
}
