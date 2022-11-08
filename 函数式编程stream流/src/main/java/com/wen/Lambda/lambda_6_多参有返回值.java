package com.wen.Lambda;

import org.junit.Test;


@FunctionalInterface
interface MoreParameterReturn {
    //多参数有返回值
    int test(int a, int b);
}

public class lambda_6_多参有返回值 {
    @Test
    public void test(){
        MoreParameterReturn moreParameterReturn = (int a, int b) -> {
            System.out.println("有返回值多个参数！");
            return a + b;
        };
        int num = moreParameterReturn.test(60, 70);
        System.out.println(num);
    }
}
