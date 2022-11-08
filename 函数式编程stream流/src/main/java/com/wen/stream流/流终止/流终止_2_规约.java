package com.wen.stream流.流终止;

import com.wen.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class 流终止_2_规约 {

    /**
     * reduce(T iden, BinaryOperator b)：可以将流中元素反复结合起来，得到一个值。返回 T
     * 案例：求和
     */
    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(1, 2, 3, 3);
        Integer reduce = list.stream()
                .distinct()// 去重 1,2,3
                .reduce(5, Integer::sum);// 初始值1，求和，5+1+2+3

        System.out.println(reduce);
    }

    /**
     * reduce(BinaryOperator b)：可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
     * 案例：求年龄之和
     */
    @Test
    public void test2() {
        List<User> userList = User.getUserList();
        OptionalInt reduce = userList.stream()
                .mapToInt(User::getAge)// 转为IntStream
                .reduce((a1, a2) -> a1 + a2);// 规约求年龄之和
        System.out.println(reduce);
    }

}
