package 数组.数组涉及的常见算法.求值;

import org.junit.Test;

public class 最大值 {
    @Test
    public void max(){
        int[] array = {1, 2, 3};
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        System.out.println("最大数：" + max);
    }
}
