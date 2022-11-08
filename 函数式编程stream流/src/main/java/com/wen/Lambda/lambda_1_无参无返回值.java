package com.wen.Lambda;

import org.junit.Test;

// 如果一个接口只有一个抽象方法，那么该接口就是一个函数式接口
// 在某个接口上声明@FunctionalInterface注解，那么编译器就会按照函数式接口的定义来要求该接口，
// 这样如果有两个抽象方法，程序编译就会报错的
// 只要保证接口中只有一个抽象方法,可以不加这个注解,加上就会自动进行检测的。
@FunctionalInterface
interface NoParameterNoReturn {
    // 无参无返回值，注意：只能有一个抽象方法
    void test();
}

public class lambda_1_无参无返回值 {
    // 原本方式
    @Test
    public void test1() {
        // 实现接口，重写方法（匿名实现类）
        new NoParameterNoReturn() {
            @Override
            public void test() {
                System.out.println("无参数无返回值");
            }
        };
    }

    // Lambda简化
    @Test
    public void test2() {
        NoParameterNoReturn n = () -> System.out.println("无参数无返回值");
        n.test();
    }

}
