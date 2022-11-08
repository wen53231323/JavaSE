package com.wen.反射的使用;

import com.wen.common.Person;
import org.junit.Test;

import java.lang.reflect.Method;

public class 反射的使用_9_操作运行时类中指定的方法 {
    /**
     * 操作运行时类中指定的方法
     */
    @Test
    public void test1() throws Exception {
        // 获取Class实例
        Class<Person> clazz = Person.class;

        // 创建运行时类的对象
        Person person = clazz.newInstance();

        // 获取指定的某个方法
        // getDeclaredMethod()：参数1指明获取方法的名称  参数2指明获取的方法的形参列表
        Method show1 = clazz.getDeclaredMethod("show1");
        Method show2 = clazz.getDeclaredMethod("show2");
        Method show3 = clazz.getDeclaredMethod("show3", String.class);

        // 保证当前属性可以访问
        show1.setAccessible(true);
        show2.setAccessible(true);
        show3.setAccessible(true);

        // 调用invoke()执行此方法
        // invoke()：参数1:方法的调用者  参数2:给方法形参复制的实参
        show1.invoke(person);
        show2.invoke(person);
        show3.invoke(person, "实参");
    }

    /**
     * 操作运行时类中指定的静态方法
     */
    @Test
    public void test2() throws Exception {
        // 获取Class实例
        Class<Person> clazz = Person.class;

        // 创建运行时类的对象
        Person person = clazz.newInstance();

        // 获取指定的某个方法
        // getDeclaredMethod()：参数1:指明获取方法的名称  参数2:指明获取的方法的形参列表
        Method show2 = clazz.getDeclaredMethod("show2");

        // 保证当前属性可以访问
        show2.setAccessible(true);

        // 调用invoke()执行此方法
        // invoke()：参数1是方法的调用者  参数2是给方法形参复制的实参
        show2.invoke(person);

        // 获取静态的方法
        // 如果调用的运行时类中的方法没有返回值，则此invoke()返回null
        Object invoke2 = show2.invoke(Person.class);
        System.out.println(invoke2);

        // 如果反射的方法是static静态方法时，参数用null也可以调用此方法
        show2.invoke(null);
    }
}
