package 数组.一维数组与多维数组;

import org.junit.Test;

/*
 * 二维数组的使用：
 * 1.理解：可以看做是一维数组arr1有作为另一个数组arr2的
 * 元素而存在其实，从数组底层的运行机制来看，没有多维数组
 *
 * 规定：二维数组分为外层数组的元素，内层数组的元素
 * 		int[][] arr=new int[4][3];
 * 		外层元素：arr[0],arr[1]等
 * 		内层元素：arr[0][0],arr[1][2]等等
 *
 * 2.多维数组的使用：
 * 一维数组的声明和初始化
 * 如何调用数组的指定位置的元素
 * 如何获取数组的长度
 * 如何遍历数组
 * 数组元素的默认初始化值
 * 数组的内存解析
 *
 */
public class 二维数组 {

    /**
     * 二维数组创建
     */
    @Test
    public void test1() {
        int[][] array1 = new int[][]{{1, 2, 3}, {4, 5, 6}};// 静态初始化
        int[][] array3 = {{1, 2, 3}, {4, 5, 6}};// 静态初始化
        int[][] array2 = new int[3][2];//动态初始化
        array2[0] = new int[]{1, 2, 3};
        array2[1] = new int[]{4, 5, 6};
    }

    /**
     * 二维数组的访问
     */
    @Test
    public void test2() {
        int[][] array = {{1, 2, 3}, {4, 5, 6}};// 静态初始化
        System.out.println(array[0][0]);// 数组的访问
        System.out.println(array[0][1]);// 数组的访问
        System.out.println(array[0][2]);// 数组的访问
        System.out.println(array[1][0]);// 数组的访问
        System.out.println(array[1][1]);// 数组的访问
        System.out.println(array[1][2]);// 数组的访问
    }

    /**
     * 二维数组的遍历
     */
    @Test
    public void test3() {
        int[][] array = {{1, 2, 3}, {4, 5, 6}};// 静态初始化
        // 数组的遍历
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 二维数组求和
     */
    @Test
    public void test4() {
        int[][] are = new int[][]{{1, 2}, {3, 4}, {5, 6}};
        int sum = 0;
        for (int i = 0; i < are.length; i++) {
            for (int j = 0; j < are[i].length; j++) {
                sum += are[i][j];
            }
        }
        System.out.println("总和为：" + sum);
    }

}
