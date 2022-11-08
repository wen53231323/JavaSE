package com.wen.动态代理与静态代理.动态代理案例二;

public class ProxyFactoryTest {
    public static void main(String[] args) {
        // 接口实现类
        CalculatorImpl calculator = new CalculatorImpl();
        // 使用代理类的有参构造，为计算器类赋值
        ProxyFactory factory = new ProxyFactory(calculator);
        // 调用方法创建动态代理类
        Calculator proxy = (Calculator) factory.getProxy();
        // 调用方法
        int add = proxy.add(1, 3);
    }
}
