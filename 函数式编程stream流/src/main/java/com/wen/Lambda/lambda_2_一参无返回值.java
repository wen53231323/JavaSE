package com.wen.Lambda;

import org.junit.Test;

// 如果一个接口只有一个抽象方法，那么该接口就是一个函数式接口
// 在某个接口上声明@FunctionalInterface注解，那么编译器就会按照函数式接口的定义来要求该接口，
// 这样如果有两个抽象方法，程序编译就会报错的
// 只要保证接口中只有一个抽象方法,可以不加这个注解,加上就会自动进行检测的。
@FunctionalInterface
interface OneParameterNoReturn {
    //一个参数无返回值
    void test(int a);
}

public class lambda_2_一参无返回值 {
    @Test
    public void test() {
        OneParameterNoReturn oneParameterNoReturn = (int a) -> {
            System.out.println("无参数一个返回值：" + a);
        };
        oneParameterNoReturn.test(10);
    }
}
