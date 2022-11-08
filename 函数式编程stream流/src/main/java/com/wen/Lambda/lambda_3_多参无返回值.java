package com.wen.Lambda;

import org.junit.Test;

@FunctionalInterface
interface MoreParameterNoReturn {
    // 多个参数无返回值
    void test(int a, int b);
}

public class lambda_3_多参无返回值 {
    @Test
    public void test() {
        MoreParameterNoReturn moreParameterNoReturn = (int a, int b) -> {
            System.out.println("无返回值多个参数：" + a + "," + b);
        };
        moreParameterNoReturn.test(20, 30);
    }
}
