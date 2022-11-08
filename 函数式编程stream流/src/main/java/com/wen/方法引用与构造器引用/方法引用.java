package com.wen.方法引用与构造器引用;

import com.wen.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

@FunctionalInterface
interface MethodReferences<T> {
    T test();
}

public class 方法引用 {

    /**
     * 方法引用是java8中特定情况下,简化lambada表达式的一种语法糖
     */
    @Test
    public void test() {
        List<String> city = Arrays.asList("A", "B", "C");
        // 使用lambada表达式遍历
        city.forEach(i -> System.out.println(i));
        // 使用方法引用遍历打印
        city.forEach(System.out::println);
    }

    /**
     * 对象::非静态方法
     */
    @Test
    public void test1() {
        User user = new User();
        // 不使用方法引用
        MethodReferences<Integer> m1 = () -> user.getAge();
        // 使用方法引用
        MethodReferences<Integer> m2 = user::getAge;
    }

    /**
     * 类名::静态方法
     */
    @Test
    public void test2() {
        // 类名::静态方法
        MethodReferences<List<User>> getUserList = User::getUserList;
    }

    /**
     * 类名::非静态方法（实例方法）
     */
    @Test
    public void test3() {
        // 类名::非静态方法
        Function<User, String> getName = User::getName;
    }
}

