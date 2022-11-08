package com.wen.反射的动态性;

import org.junit.Test;

import java.util.Random;

public class dynamic {
    /**
     * 体会反射的动态性
     * 通过随机数，动态创建类的对象
     */
    @Test
    public void test() {
        // 返回0、1、2之中的随机数
        int num = new Random().nextInt(3);
        System.out.println(num);
        String classPath = "";
        switch (num) {
            case 0:
                classPath = "java.util.Random";
                break;
            case 1:
                classPath = "java.util.Date";
                break;
            case 2:
                classPath = "java.lang.Object";
                break;
        }
        try {
            Object obj = getInstance(classPath);
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 此方法创建一个指定类的对象
     *
     * @param classPath 指定类的全类名
     */
    public Object getInstance(String classPath) throws Exception {
        Class<?> clazz = Class.forName(classPath);
        return clazz.newInstance();
    }
}
