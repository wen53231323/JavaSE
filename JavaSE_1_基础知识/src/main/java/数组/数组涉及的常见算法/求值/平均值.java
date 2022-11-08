package 数组.数组涉及的常见算法.求值;

import org.junit.Test;

public class 平均值 {
    @Test
    public void avg(){
        int[] array = {1, 2, 3};
        //求数组元素总和
        int sumNum = 0;
        for (int i = 0; i < array.length; i++) {
            sumNum += array[i];
        }
        int avg = sumNum / array.length;
        System.out.println("平均值：" + avg);

    }
}
