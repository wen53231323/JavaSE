package com.wen.反射的使用;

import com.wen.common.Person;
import org.junit.Test;

import java.lang.reflect.Field;

public class 反射的使用_8_操作运行时类中指定的属性 {
    /**
     * 操作运行时类中指定的属性，使用getField()
     */
    @Test
    public void test1() throws Exception {
        // 获取Class实例
        Class<Person> clazz = Person.class;

        // 创建运行时类的对象
        Person person = clazz.newInstance();

        // 返回类中public修饰的属性（因为此方法要求运行时类中属性声明为public，所有通常不采用此方法）
        // Field id = clazz.getField("id");// 不能获取私有的
        Field name = clazz.getField("name");

        // 设置当前属性的值
        // set()：参数1用于指明设置哪个对象的属性，参数2用于将属性值设置为多少
        name.set(person, "小明");

        // 获取当前属性的值
        // get()：获取哪个对象的当前属性值
        Object obj = name.get(person);
        System.out.println(obj);
    }

    /**
     * 操作运行时类中指定的属性，使用getDeclaredField()
     */
    @Test
    public void test2() throws Exception {
        // 获取Class实例
        Class<Person> clazz = Person.class;

        // 创建运行时类的对象
        Person person = clazz.newInstance();

        // getDeclaredField(String fileldName)：根据属性名name获取指定的属性
        Field id = clazz.getDeclaredField("id");
        Field name = clazz.getDeclaredField("name");
        // 保证当前属性可以访问
        id.setAccessible(true);
        name.setAccessible(true);

        // 设置当前属性的值
        // set()：参数1:指明设置哪个对象的属性  参数2:将属性值设置为多少
        id.set(person, 1001);
        name.set(person,"小明");

        // 获取当前属性的值
        // get()：获取哪个对象的当前属性值
        Object pId = id.get(person);
        Object pName = name.get(person);
        System.out.println("id:"+pId);
        System.out.println("name:"+pName);
    }
}
