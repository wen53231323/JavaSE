package com.wen.反射的使用;

import com.wen.common.Person;
import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class 反射的使用_6_获取运行时类的父类 {
    /**
     * 根据Class类的实例对象，获取运行时类的父类及父类泛型类型
     */
    @Test
    public void test() {
        // 获取Class实例
        Class<Person> clazz = Person.class;

        // 获取运行时类的父类
        Class<? super Person> superclass = clazz.getSuperclass();
        System.out.println(superclass);

        // 获取运行时类的带泛型的父类
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);

        // 获取运行时类的带泛型的父类的泛型类型
        ParameterizedType genericSuperclass1 = (ParameterizedType) genericSuperclass;
        // getActualTypeArguments()：获取泛型类型
        Type[] actualTypeArguments = genericSuperclass1.getActualTypeArguments();
        System.out.println(actualTypeArguments[0].getTypeName());
    }
}
