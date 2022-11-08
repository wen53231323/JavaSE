package com.wen.common;

import lombok.Data;

/**
 * Person继承Creature父类
 * 实现了Comparable接口
 * 实现类自定义MyInterface接口
 * 使用了自定义注解@MyAnnotation
 */
@Data// 代表get、set、toString、equals、hashCode等操作
@MyAnnotation(value = "hello!")//自定义注解
public class Person extends Creature<String> implements Comparable<String>, MyInterface {
    private int id;
    public String name;
    int age;

    @MyAnnotation()
    public void show1() {
        System.out.println("非静态方法被使用");
    }

    public static void show2() {
        System.out.println("静态方法被使用");
    }

    @MyAnnotation
    private String show3(String n) {
        System.out.println("私有方法被使用");
        return n;
    }

    @Override
    public void info() {
        System.out.println("重写info()方法被使用");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    // 空参构造器
    public Person() {
        System.out.println("空参构造器被使用");
    }

    // 全参构造器
    public Person(int id, String name, int age) {
        System.out.println("全参构造器被使用");
        this.id = id;
        this.name = name;
        this.age = age;
    }
}