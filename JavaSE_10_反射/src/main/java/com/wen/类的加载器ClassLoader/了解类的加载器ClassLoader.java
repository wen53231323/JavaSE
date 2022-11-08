package com.wen.类的加载器ClassLoader;

import org.junit.Test;

public class 了解类的加载器ClassLoader {
    @Test
    public void test() {
        // 对于自定义类，使用系统类加载器进行加载
        ClassLoader classloader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classloader);// sun.misc.Launcher$AppClassLoader@18b4aac2

        // 调用系统类加载器的父类加载器getParent()：即获取扩展类加载器
        ClassLoader parent = classloader.getParent();
        System.out.println(parent);// sun.misc.Launcher$ExtClassLoader@54bedef2

        // 调用扩展类加载器的父类加载器getParent()：无法获取引导类加载器
        // 引导类加载器主要负责加载java的核心类库，无法加载自定义类的
        ClassLoader classLoader3 = parent.getParent();
        System.out.println(classLoader3);// null
    }
}

class ClassLoaderTest {
}
