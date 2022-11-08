package com.wen.反射的使用;

import com.wen.common.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;

public class 反射的使用_7_获取运行时类的接口_包_注解 {
    /**
     * 获取运行时类的接口、包、注解
     */
    @Test
    public void test() {
        // 获取Class实例
        Class<Person> clazz = Person.class;

        // 获取运行时类的实现的接口
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class c : interfaces) {
            System.out.println("运行时类的实现的接口"+c);
        }

        // 获取运行时类的父类实现的接口
        Class<?>[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for (Class c : interfaces1) {
            System.out.println("运行时类的父类实现的接口:"+c);
        }

        // 获取运行时类所在的包
        Package pack = clazz.getPackage();
        System.out.println("运行时类所在的包:"+pack);

        // 获取运行时类声明的注解
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation a : annotations) {
            System.out.println("运行时类声明的注解:"+a);
        }
    }
}
