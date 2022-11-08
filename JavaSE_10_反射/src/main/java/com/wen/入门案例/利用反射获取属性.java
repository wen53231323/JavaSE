package com.wen.入门案例;

import com.wen.common.Cat;
import org.junit.Test;

import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.Properties;

public class 利用反射获取属性 {

    /**
     * 方式一：普通方法调用name属性
     */
    @Test
    public void test1() {
        Cat cat = new Cat();
        System.out.println(cat.name);
    }

    /**
     * 方式二：利用反射调用name属性
     */
    @Test
    public void test2() throws Exception {
        // （1）加载类
        Class clazz = Class.forName("com.wen.common.Cat");
        // （2）加载的类的对象实例
        Object obj = clazz.newInstance();
        // （3）返回类中 public 修饰的属性
        Field name = clazz.getField("name");
        // （4）获取属性值
        // 传统：对象.成员变量
        // 反射：成员变量.get(对象)
        System.out.println(name.get(obj));
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
        Class clazz = Class.forName("com.wen.common.Cat");
        // （2）加载的类的对象实例
        Object obj = clazz.newInstance();
        // （3）返回类中 public 修饰的属性
        Field field = clazz.getField(name);
        // （4）获取属性值
        // 传统：对象.成员变量
        // 反射：成员变量.get(对象)
        System.out.println(field.get(obj));
    }
}
