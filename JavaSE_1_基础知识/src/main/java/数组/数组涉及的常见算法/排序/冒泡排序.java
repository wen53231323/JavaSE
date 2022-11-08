package 数组.数组涉及的常见算法.排序;

import org.junit.Test;

public class 冒泡排序 {
    @Test
    public void maopao() {
        // 无序数组
        int[] arr = new int[]{20, 30, -40, 80, 60, -50, 10};

        // 冒泡排序
        for (int i = 0; i < arr.length; i++) {//记录数组中有多少元素
            for (int j = 0; j < arr.length - 1 - i; j++) {//循环的次数
                if (arr[j] > arr[j + 1]) {
                    int zhuan = arr[j];//第一个数据与第二个数据转换，大后小前
                    arr[j] = arr[j + 1];
                    arr[j + 1] = zhuan;
                }
            }
        }
        // 排序后遍历
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
