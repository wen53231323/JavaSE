package 数组.数组涉及的常见算法.求值;

import org.junit.Test;

public class 求和 {
    @Test
    public void sum() {
        int[] array = {1, 2, 3};
        int sumNum = 0;
        for (int i = 0; i < array.length; i++) {
            sumNum += array[i];
        }
        System.out.println(sumNum);
    }
}
