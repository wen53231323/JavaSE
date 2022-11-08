package 数组.数组涉及的常见算法.复制_反转_查找;

import org.junit.Test;

public class 复制 {
    @Test
    public void copy() {
        int[] arr1,arr2;
        //arr1,arr2关系：地址值相同，都指向了堆空间的唯一的一个数组实体
        arr1=new int[] {1,2,3,4,5};
        //遍历arr1
        System.out.println("arr1中元素：");
        for(int i=0;i<arr1.length;i++) {
            System.out.print(arr1[i]+" ");
        }
        System.out.println();
        //数组的复制：(区别于数组变量的赋值，arr1=arr2)
        //重新创建了一个数组实体，并将arr1复制给arr2
        arr2=new int[arr1.length];
        for(int i=0;i<arr2.length;i++) {
            arr2[i]=arr1[i];
        }
        //遍历arr2
        System.out.println("arr2中元素：");
        for(int i=0;i<arr2.length;i++) {
            System.out.print(arr2[i]+" ");
        }
        System.out.println();
    }
}
