package com.wen;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 代表get、set、toString、equals、hashCode等操作
@Data
// 代表无参构造
@NoArgsConstructor
// 代表全参构造
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private List<String> hobby;

    /**
     * 静态方法，返回用户集合列表
     */
    public static List<User> getUserList() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1001, "张三", 18, Arrays.asList("唱歌", "打球")));
        userList.add(new User(1001, "张三", 18, Arrays.asList("唱歌", "打球")));
        userList.add(new User(1002, "李四", 19, Arrays.asList("唱歌", "打球")));
        userList.add(new User(1002, "李四", 19, Arrays.asList("唱歌", "打球")));
        userList.add(new User(1003, "王五", 20, Arrays.asList("唱歌", "打球")));
        userList.add(new User(1004, "赵六", 21, Arrays.asList("唱歌", "打球")));
        userList.add(new User(1005, "小明", 24, Arrays.asList("唱歌", "打球")));
        userList.add(new User(1006, "小刚", 22, Arrays.asList("唱歌", "打球")));
        userList.add(new User(1007, "小红", 25, Arrays.asList("唱歌", "打球")));
        userList.add(new User(1008, "小林", 13, Arrays.asList("唱歌", "打球")));
        return userList;
    }
}
