package com.wen.动态代理与静态代理.静态代理案例一;


/**
 * 静态代理举例：
 * 特点：代理类和被代理类在编译期间，就确定下来了
 */
public class 静态代理 {
    public static void main(String[] args) {
        // 创建被代理类的对象
        Nike nike = new Nike();
        // 创建代理类的对象,并告知代理谁
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nike);
        // 触发代理方法，调用的是代理类中的produceCloth()方法
        proxyClothFactory.produceCloth();
    }
}

