package com.wen.方法引用与构造器引用;

import com.wen.User;

import java.util.function.Supplier;

public class 构造器引用 {
    public void test() {
        // 这里是调用的无惨构造方法，因为Supplier的get()无参
        Supplier<User> sup = User::new;
        User user = sup.get();
    }
}
