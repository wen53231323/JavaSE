package com.wen.入门案例;

import com.wen.common.Cat;
import org.junit.Test;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

// 需求：根据配置信息，创建Cat类的对象并调用类中的CatName方法
public class 利用反射调用方法 {
    /**
     * 方式一：普通方法调用catName方法
     */
    @Test
    public void test1() {
        Cat cat = new Cat();
        cat.getCatName();
    }

    /**
     * 方式二：利用反射调用catName方法
     */
    @Test
    public void test2() throws Exception {
        // （1）加载类
        Class clazz = Class.forName("com.wen.common.Cat");
        // （2）加载的类的对象实例
        Object o = clazz.newInstance();
        // （3）根据方法名 获取 方法的对象
        Method method = clazz.getMethod("getCatName");
        // （4）通过 方法的对象 调用 方法
        // 传统方式：对象.方法();
        // 反射方式：方法.invoke(对象);
        method.invoke(o);
    }

    /**
     * 反射方式优化：将配置信息放入配置文件
     */
    @Test
    public void test3() throws Exception {
        // 使用Properties类，读写配置文件
        Properties properties = new Properties();
        // 利用文件流，读取配置文件
        FileInputStream fileInputStream = new FileInputStream("target/classes/Cat.properties");
        // load()：逐行读取properties配置文件，分隔成两个字符串key和value，将他们放进Properties对象中
        properties.load(fileInputStream);
        // 获取配置信息中的字段
        String ClassPath = properties.get("ClassPath").toString();
        String getCatName = properties.get("publicMethod").toString();
        String name = properties.get("publicName").toString();
        System.out.println(ClassPath);
        System.out.println(getCatName);
        System.out.println(name);

        // （1）加载类
        Class clazz = Class.forName(ClassPath);
        // （2）加载的类的对象实例
        Object obj = clazz.newInstance();
        // （3）根据方法名 获取 方法对象
        Method method_new = clazz.getMethod(getCatName);
        // （4）通过方法对象调用方法
        // 传统方式：对象.方法();
        // 反射方式：方法.invoke(对象);
        method_new.invoke(obj);
    }
}

