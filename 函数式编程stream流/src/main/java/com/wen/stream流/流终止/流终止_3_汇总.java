package com.wen.stream流.流终止;

import com.wen.User;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class 流终止_3_汇总 {

    /**
     * collect(Collector c)：收集器，把Stream流操作后的结果数据转换为其他形式（集合、数组）
     * 接收一个 Collector 接口的实现，用于给Stream中元素做汇总的方法
     * 案例：收集用户名到列表
     */
    @Test
    public void test() {
        List<User> userList = User.getUserList();
        List<String> collect = userList.stream()
                .distinct()// 去重
                .map(user -> user.getName())// 获取用户名
                .collect(Collectors.toList());// 转换为数值
        System.out.println(collect);
    }

}
