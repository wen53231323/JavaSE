package com.wen.stream流.流终止;

import com.wen.User;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class 流终止_1_匹配与查找 {

    /**
     * allMatch(Predicate p)：检查是否匹配所有元素
     * 案例：判断用户年龄是否都大于10岁
     */
    @Test
    public void test1() {
        List<User> userList = User.getUserList();
        boolean b = userList.stream()
                .distinct()// 去重
                .allMatch(user -> user.getAge() > 10);// 其余的用户年龄是否都大于10
        System.out.println(b);
    }

    /**
     * anyMatch(Predicate p)：检查是否至少匹配一个元素
     * 案例：是否有一个用户名称为小明
     */
    @Test
    public void test2() {
        List<User> userList = User.getUserList();
        boolean b = userList.stream()
                .distinct()// 去重
                .anyMatch(user -> user.getName().equals("小明"));
        System.out.println(b);
    }

    /**
     * anyMatch(Predicate p)：检查是否至少匹配一个元素
     * 案例：是否没有用户名称为小明
     */
    @Test
    public void test3() {
        List<User> userList = User.getUserList();
        boolean b = userList.stream()
                .distinct()// 去重
                .noneMatch(user -> user.getName().equals("小明"));
        System.out.println(b);
    }

    /**
     * findFirst()：返回第一个元素
     * 案例：返回第一个元素
     */
    @Test
    public void test4() {
        List<User> userList = User.getUserList();
        Optional<User> first = userList.stream()
                .distinct()// 去重
                .findFirst();// 返回第一个元素
        System.out.println(first);
    }

    /**
     * findAny()：返回当前流中的任意元素
     * 案例：返回当前流中的任意元素
     * */
    @Test
    public void test5() {
        List<User> userList = User.getUserList();
        Optional<User> any = userList.parallelStream()
                .distinct()// 去重
                .findAny();// 返回当前流中的任意元素
        System.out.println(any);
    }

    /**
     * count()：返回流中元素总数
     * 案例：求总记录数
     * */
    @Test
    public void test6() {
        List<User> userList = User.getUserList();
        long count = userList.parallelStream()
                .distinct()// 去重
                .count();// 求总记录数
        System.out.println(count);
    }

    /**
     *sum(Comparator c)：求和，与maptoint中间操作结合使用
     *案例：求和
     * */
    @Test
    public void test7() {
        List<User> userList = User.getUserList();
        int sum = userList.parallelStream()
                .mapToInt(User::getId)// 转为IntStream
                .sum();// 求和
        System.out.println(sum);
    }

    /**
     *max(Comparator c)：返回流中最大值
     *案例：求最大值
     * */
    @Test
    public void test8() {
        List<User> userList = User.getUserList();
        OptionalInt max = userList.parallelStream()
                .mapToInt(User::getId)// 转为IntStream
                .max();// 最大值
        System.out.println(max);
    }

    /**
     * min(Comparator c)：返回流中最小值
     * 案例：求最小值
     *
     * */
    @Test
    public void test9() {
        List<User> userList = User.getUserList();
        OptionalInt max = userList.parallelStream()
                .mapToInt(User::getId)// 转为IntStream
                .min();// 最小值
        System.out.println(max);
    }

    /**
     * forEach(Consumer c)：遍历流
     * 案例：遍历打印
     * */
    @Test
    public void test10() {
        List<User> userList = User.getUserList();
        userList.parallelStream()
                .mapToInt(User::getId)// 转为IntStream
                .forEach(System.out::println);// 遍历
    }

}
