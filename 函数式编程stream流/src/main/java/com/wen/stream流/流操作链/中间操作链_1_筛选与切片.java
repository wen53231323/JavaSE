package com.wen.stream流.流操作链;

import com.wen.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 中间操作链_1_筛选与切片 {

    /**
     * filter(Predicate p)：过滤，接收 Lambda，通过设置的条件，从流中排除某些元素
     * 案例：输出ID大于5的user对象
     */
    @Test
    public void test1() {
        List<User> userList = User.getUserList();
        userList.stream().filter(user -> user.getId() > 5).forEach(System.out::println);
    }

    /**
     * limit(long maxSize)：截断，返回一个不超过给定长度的流
     * 案例：输出前5个user对象
     */
    @Test
    public void test2() {
        List<User> userList = User.getUserList();
        userList.stream().limit(5).forEach(System.out::print);
    }

    /**
     * skip(long n)：跳过，返回一个扔掉了前 n 个元素的流，若流中元素不足 n 个，则返回一个空流，与 limit(n) 互补
     * 案例：跳过前5个user对象
     */
    @Test
    public void test3() {
        List<User> userList = User.getUserList();
        userList.stream().skip(5).forEach(System.out::println);
    }

    /**
     * distinct()去重，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
     * 案例：对list集合进行去重
     */
    @Test
    public void test4() {
        List<User> userList = User.getUserList();
        userList.stream().distinct().forEach(System.out::println);
    }

    /**
     * peek(Predicate p)：处理，对元素进行遍历处理
     * 案例：对元素进行遍历处理，每个用户年龄加1输出
     */
    @Test
    public void test6() {
        List<User> userList = User.getUserList();
        userList.stream().peek(user -> user.setId(user.getAge() + 1)).forEach(System.out::println);
    }

}
