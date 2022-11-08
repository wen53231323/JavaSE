package com.wen.入门案例;

import com.wen.common.Cat;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class 反射前后差别 {
    /**
     * 使用反射之前，对Cat的操作
     * 反射之前，在类的外部，不可以通过类的对象调用其内部的私有private结构
     */
    @Test
    public void test1() {
        // 创建Person类的对象（实例化）
        Cat cat = new Cat(1001, "小咪");
        // 通过对象调用内部的属性、方法
        // System.out.println(cat.id);// 不能调用私有属性
        System.out.println(cat.name);
        cat.getCatName();
        // cat.getCatId();// 不能调用私有方法
    }

    /**
     * 使用反射之后，对应Cat的操作
     * 可以使用setAccessible(boolean flag)方法临时改变访问权限，就可以获取可以调用私有的结构，比如：私有的构造器、方法、属性
     */
    @Test
    public void test2() throws Exception {
        // 加载类
        Class<Cat> clazz = Cat.class;
        // 加载的类的对象实例
        // getConstructors()：获取当前运行时类中声明为public的构造器
        Constructor<Cat> constructor = clazz.getConstructor(int.class, String.class);
        // 保证当前构造器可以访问
        constructor.setAccessible(true);
        // newInstance()：创建对象
        Object obj = constructor.newInstance(1001, "小明");
        Cat cat = (Cat) obj;
        System.out.println(cat.toString());

        // 通过反射调用指定的属性、方法
        // 调用属性
        // getDeclaredField(String name)：根据属性名name获取指定的属性
        Field id = clazz.getDeclaredField("id");
        Field name = clazz.getDeclaredField("name");
        // 保证当前属性可以访问
        name.setAccessible(true);
        System.out.println("id:" + id + "name:" + name);
        // 调用方法
        // getDeclaredMethod(String name, Class<?>… parameterTypes)：根据指定的方法名称和参数，匹配类中的方法，返回Method对象
        Method getCatId = clazz.getDeclaredMethod("getCatId");
        Method getCatName = clazz.getDeclaredMethod("getCatName");
        // 保证当前方法可以访问
        getCatId.setAccessible(true);
        getCatId.invoke(cat);
        getCatName.invoke(cat);
    }
}
