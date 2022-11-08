package com.wen.Lambda;

import org.junit.Test;


@FunctionalInterface
interface OneParameterReturn {
    //一个参数有返回值
    int test(int a);
}

public class lambda_5_一参有返回值 {
    @Test
    public void test(){
        OneParameterReturn oneParameterReturn = (int a) -> {
            System.out.println("有返回值有参数！");
            return a;
        };
        // 接收函数的返回值
        int num = oneParameterReturn.test(50);
        System.out.println(num);
    }
}
