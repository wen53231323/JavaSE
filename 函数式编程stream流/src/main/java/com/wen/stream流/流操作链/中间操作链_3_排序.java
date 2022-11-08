package com.wen.stream流.流操作链;

import com.wen.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class 中间操作链_3_排序 {

    /**
     * sorted()：自然排序，返回自然排序后的流
     * 案例：从小到大自然排序
     */
    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(3, 1, 4, 2, 5);
        list.stream().sorted().forEach(System.out::print);// 12345
    }

    /**
     * sorted(Comparator com)：定制排序，按比较器排序后的流
     * 案例：按用户年龄排序
     */
    @Test
    public void test2() {
        List<User> userList = User.getUserList();
        userList.stream()
                .sorted((a, b) -> Integer.compare(a.getAge(), b.getAge()))
                .forEach(System.out::println);
    }

}
