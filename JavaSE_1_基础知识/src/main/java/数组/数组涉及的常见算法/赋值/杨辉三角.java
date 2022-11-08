package 数组.数组涉及的常见算法.赋值;

import org.junit.Test;

public class 杨辉三角 {
    /**
     * 使用二维数组打印一个10行杨辉三角
     * 1：第一行有一个元素，第n行有n个元素
     * 2：每一行的第一个元素和最后一个元素都是1
     * 3：从第三行开始，对于非第一个元素和最后一个元素的元素，即array[i][j]=array[i-1][j-1]+array[i-1][j];
     */
    @Test
    public void test() {
        //（1）声明一个二维数组
        int array[][] = new int[10][];//10行

        //（2）给数组的元素赋值
        for (int i = 0; i < array.length; i++) {
            array[i] = new int[i + 1];//每行有多少元素
            array[i][0] = array[i][i] = 1;//给首末元素赋值1
            //给首末元素赋值
            if (i > 1) {
                for (int j = 1; j < array[i].length - 1; j++) {
                    array[i][j] = array[i - 1][j - 1] + array[i - 1][j];

                }
            }

        }

        //（3）遍历二维数组
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
