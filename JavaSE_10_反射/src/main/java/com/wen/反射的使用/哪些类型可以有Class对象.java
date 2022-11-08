package com.wen.反射的使用;

import org.junit.Test;

import java.lang.annotation.ElementType;

public class 哪些类型可以有Class对象 {
    /**
     * 哪些类型可以有Class对象？
     */
    @Test
    public void test() {
        Class c1 = Object.class;// 类
        Class c2 = Comparable.class;// 接口
        Class c3 = String[].class;// 一维数组
        Class c4 = int[][].class;// 二维数组
        Class c5 = ElementType.class;// 枚举类
        Class c6 = Override.class;// 注解@interface
        Class c7 = int.class;// 基本数据类型
        Class c8 = void.class;// 空类型
        Class c9 = Class.class;// Class本身

        // 只要元素类型与维度一样，就是同一个Class
        // 同一个元素同一个类只有一个Class对象，一个类只有一个Class对象
        int[] a = new int[10];
        int[] b = new int[100];
        Class aClass = a.getClass();
        Class bClass = b.getClass();
        System.out.println(aClass.hashCode());// 1031980531
        System.out.println(bClass.hashCode());// 1031980531
        System.out.println(aClass == bClass);//true
    }
}
