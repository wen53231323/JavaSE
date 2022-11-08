package com.wen.反射的使用;

import com.wen.common.Person;
import org.junit.Test;

/**
 * 获取Class的实例的方式（前三种需要掌握，第三种用的多，第四种了解即可）
 */
public class 反射的使用_1_获取Class实例的四种方式 {
    /**
     * 方式一：调用运行时类的属性
     */
    @Test
    public void test1() {
        Class<Person> clazz = Person.class;
        System.out.println(clazz);
    }

    /**
     * 方式二：通过运行时类的对象，调用getClass()
     */
    @Test
    public void test2() {
        Person person = new Person();
        Class<? extends Person> clazz = person.getClass();
        System.out.println(clazz);
    }

    /**
     * 方式三：调用Class的静态方法：forName(String ClassPath)
     */
    @Test
    public void test3() throws ClassNotFoundException {
        Class<?> clszz = Class.forName("com.wen.common.Person");
        System.out.println(clszz);
    }

    /**
     * 方式四：使用类的加载器：ClassLoader（了解）
     */
    @Test
    public void test4() throws ClassNotFoundException {
        ClassLoader classLoader = 反射的使用_1_获取Class实例的四种方式.class.getClassLoader();
        Class<?> clazz = classLoader.loadClass("com.wen.common.Person");
        System.out.println(clazz);
    }
}

