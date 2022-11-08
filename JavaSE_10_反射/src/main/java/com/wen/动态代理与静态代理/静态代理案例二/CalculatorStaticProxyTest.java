package com.wen.动态代理与静态代理.静态代理案例二;

public class CalculatorStaticProxyTest {
    public static void main(String[] args) {
        // 实现类接口
        CalculatorImpl calculator = new CalculatorImpl();
        // 使用代理类的有参构造，为计算器类赋值
        CalculatorStaticProxy calculatorStaticProxy = new CalculatorStaticProxy(calculator);
        // 调用方法
        int add = calculatorStaticProxy.add(1, 3);
    }
}
