package com.wen.反射的使用;

import com.wen.common.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class 反射的使用_3_获取当前运行时类的属性结构 {
    /**
     * 根据Class类的实例对象，获取当前运行时类的属性结构（权限修饰符 数据类型 变量名）
     */
    @Test
    public void test() {
        // 获取Class实例
        Class<Person> clazz = Person.class;

        // getFields()：获取当前运行时类及其父类中声明为public访问权限的属性，返回给Field数组
        Field[] fields = clazz.getFields();
        for (Field f : fields) {
            // 获取所有属性
            System.out.println("所有属性：" + f);
            // 获取权限修饰符
            int modifiers = f.getModifiers();
            System.out.println("权限修饰符：" + Modifier.toString(modifiers));
            // 获取数据类型
            Class<?> type = f.getType();
            System.out.println("数据类型：" + type);
            // 获取变量名
            String name = f.getName();
            System.out.println("变量名：" + name);
        }

        // getDeclaredFields()：获取当前运行时类中声明的所有属性（不包含父类中的属性）
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            System.out.println(f);// 类中属性
        }
    }
}
