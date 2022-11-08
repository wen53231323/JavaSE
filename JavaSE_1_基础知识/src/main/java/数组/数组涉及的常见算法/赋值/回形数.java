package 数组.数组涉及的常见算法.赋值;

import org.junit.Test;

import java.util.Scanner;

public class 回形数 {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入回型数大小数值：");
            int n = scanner.nextInt();
            int[][] arr = new int[n][n];

            int count = 0;//要显示的数量
            int maxX = n - 1;  //x轴的最大下标
            int maxY = n - 1; //y轴的最大下标
            int minX = 0; //x轴的最小下标
            int minY = 0; //y轴的最小下表

            while (minX <= maxX) {
                for (int x = minX; x <= maxX; x++) {
                    arr[minY][x] = ++count;
                }
                minY++;
                for (int y = minY; y <= maxY; y++) {
                    arr[y][maxX] = ++count;
                }
                maxX--;
                for (int x = maxX; x >= minX; x--) {
                    arr[maxY][x] = ++count;
                }
                maxY--;
                for (int y = maxY; y >= minY; y--) {
                    arr[y][minX] = ++count;
                }
                minX++;
                System.out.println(count);
            }
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            return;
        }
    }
}
