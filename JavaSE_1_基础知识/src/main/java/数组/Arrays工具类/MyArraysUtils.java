package 数组.Arrays工具类;

/**
 * 自定义数组工具类
 */
public class MyArraysUtils {
    /**
     * 求数组最大值
     */
    public int getmax(int[] arr) {
        int fmax = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (fmax < arr[i]) {
                fmax = arr[i];
            }
        }
        return fmax;
    }

    /**
     * 求数组最小值
     */
    public int getmin(int[] arr) {
        int fmin = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (fmin > arr[i]) {
                fmin = arr[i];
            }
        }
        return fmin;
    }

    /**
     * 数组求和
     */
    public int gethe(int[] arr) {
        int he = 0;
        for (int i = 0; i < arr.length; i++) {
            he += arr[i];
        }
        return he;
    }

    /**
     * 数组平均值
     */
    public int getjun(int[] arr) {

        return gethe(arr) / arr.length;
    }

    /**
     * 数组反转
     */
    public void getfan(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int zhuan = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = zhuan;
        }
    }

    /**
     * 数组的复制
     */
    public int[] getfuzhi(int[] arr) {

        int[] srr = new int[arr.length];
        for (int i = 0; i < srr.length; i++) {
            srr[i] = arr[i];
        }
        return srr;

    }

    /**
     * 数组的排序
     */
    public void getpai(int[] arr) {
        //冒泡排序
        for (int i = 0; i < arr.length; i++) {//记录数组中有多少元素
            for (int j = 0; j < arr.length - 1 - i; j++) {//循环的次数
                if (arr[j] > arr[j + 1]) {
                    int zhuan = arr[j];//第一个数据与第二个数据转换，大后小前
                    arr[j] = arr[j + 1];
                    arr[j + 1] = zhuan;
                }
            }

        }
        //遍历排序后的数组
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * 数组遍历
     */
    public void bianli(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
