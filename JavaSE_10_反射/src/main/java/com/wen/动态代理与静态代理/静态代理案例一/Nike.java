package com.wen.动态代理与静态代理.静态代理案例一;

/**
 * 被代理类
 */
public class Nike implements ClothFactory {
    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生产运动服");
    }
}

