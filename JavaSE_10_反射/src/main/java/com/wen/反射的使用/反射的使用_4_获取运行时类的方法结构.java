package com.wen.反射的使用;

import com.wen.common.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class 反射的使用_4_获取运行时类的方法结构 {
    /**
     * 根据Class类的实例对象，获取运行时类的方法结构（注解、权限修饰符、返回值类型、方法名、形参列表、抛出的异常）
     */
    @Test
    public void test() {
        // 获取Class实例
        Class<Person> clazz = Person.class;

        // getMethods()：获取当前运行时类及其所有父类中声明为public权限的方法
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            // 获取所有方法
            System.out.println("方法：" + m);
            // 获取方法声明的注解
            Annotation[] annotations = m.getAnnotations();
            for (Annotation a : annotations) {
                System.out.println("注解：" + a);
            }
            // 获取权限修饰符
            System.out.println("权限修饰符：" + Modifier.toString(m.getModifiers()));
            // 获取返回值类型
            System.out.println("返回值类型：" + m.getReturnType().getName());
            // 获取方法名
            System.out.println("方法名：" + m.getName());
            // 形参列表
            Class<?>[] parameterTypes = m.getParameterTypes();
            if (!(parameterTypes == null && parameterTypes.length == 0)) {
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (i == parameterTypes.length - 1) {
                        System.out.println(parameterTypes[i].getName() + i);
                        break;
                    }
                    System.out.println(parameterTypes[i].getName() + i);
                }
            }
            // 获取抛出的异常
            Class<?>[] exceptionTypes = m.getExceptionTypes();
            if (exceptionTypes.length > 0) {
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if (i == exceptionTypes.length - 1) {
                        System.out.println(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.println(exceptionTypes[i].getName());
                }
            }
        }

        // getDeclaredMethods()：获取当前运行时类中声明的所有方法（不包含父类中的方法）
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods) {
            System.out.println(m);
        }
    }
}
