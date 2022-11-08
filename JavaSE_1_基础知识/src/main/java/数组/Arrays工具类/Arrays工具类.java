package 数组.Arrays工具类;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

//Arrays工具类：java.util.Arrays类即为操作数组的工具类
//包含了用来操作数组(比如排序和搜索)的各种方法
public class Arrays工具类 {

    /**
     * 判断两个数组是否相等
     * boolean equals(int[] a,int[],b)
     */
    @Test
    public void testEquals() {
        int[] arr1 = new int[]{1, 2, 3};
        int[] arr2 = new int[]{3, 2, 1};
        boolean isEquals = Arrays.equals(arr1, arr2);
        System.out.println(isEquals);
    }

    /**
     * 输出数据信息
     * String toString(int[] a)
     */
    @Test
    public void testToString() {
        int[] arr = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 将指定的值填充到数组中
     * void fill(int[] a,int val)
     */
    @Test
    public void testFill() {
        int[] arr = new int[]{1, 2, 3};
        Arrays.fill(arr, 10);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 对数组进行排序
     * void sort(int[] a)
     */
    @Test
    public void testSort() {
        int[] arr = new int[]{3, 1, 2};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 对排序后的数组进行二分法检索指定的值
     * int (int[] a,int key)
     */
    @Test
    public void testBinarySearch() {
        int[] arr = new int[]{3, 2, 1, 4, 5};
        int index = Arrays.binarySearch(arr, 5);
        if (index >= 0) {
            System.out.println(index);
        } else {
            System.out.println("未找到");
        }
    }

}
