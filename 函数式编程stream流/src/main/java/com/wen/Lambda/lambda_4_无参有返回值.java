package com.wen.Lambda;


import org.junit.Test;

@FunctionalInterface
interface NoParameterReturn {
    // 无参数有返回值
    int test();
}

public class lambda_4_无参有返回值 {
    @Test
    public void test(){
        NoParameterReturn noParameterReturn = () -> {
            System.out.println("有返回值无参数！");
            return 30;
        };
        // 接收函数的返回值
        int num = noParameterReturn.test();
        System.out.println(num);
    }
}
