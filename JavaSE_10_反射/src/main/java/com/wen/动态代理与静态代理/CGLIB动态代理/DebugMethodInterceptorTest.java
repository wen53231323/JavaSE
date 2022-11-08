package com.wen.动态代理与静态代理.CGLIB动态代理;


import com.wen.动态代理与静态代理.动态代理案例二.ProxyFactory;

public class DebugMethodInterceptorTest {
    public static void main(String[] args) {
        // 调用方法创建动态代理类对象
        CalculatorImpl proxy = (CalculatorImpl) CglibProxyFactory.getProxy(CalculatorImpl.class);
        // 调用方法
        int add = proxy.add(1, 3);
    }
}
