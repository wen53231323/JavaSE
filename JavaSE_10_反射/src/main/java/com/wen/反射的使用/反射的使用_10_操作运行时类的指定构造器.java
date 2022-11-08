package com.wen.反射的使用;

import com.wen.common.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;

public class 反射的使用_10_操作运行时类的指定构造器 {
    /**
     * 操作运行时类的指定构造器
     */
    @Test
    public void test() throws Exception {
        // 获取Class实例
        Class<Person> clazz = Person.class;

        // 获取指定的构造器
        // getDeclaredConstructor()：参数，指明构造器的参数列表
        Constructor<Person> constructor = clazz.getDeclaredConstructor(int.class,String.class,int.class);

        // 保证此构造器是可以访问的
        constructor.setAccessible(true);

        // 调用此构造器创建运行时类的对象
        Person per = constructor.newInstance(1001,"小明",18);
        System.out.println(per);
    }
}
