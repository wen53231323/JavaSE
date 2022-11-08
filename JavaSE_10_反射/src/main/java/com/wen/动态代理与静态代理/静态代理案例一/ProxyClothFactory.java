package com.wen.动态代理与静态代理.静态代理案例一;


/**
 * 代理类
 */
public class ProxyClothFactory implements ClothFactory {
    // 用被代理类对象进行实例化
    private ClothFactory factory;

    // 构造器
    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");
        // 实质上在代理类中是调用了被代理实现接口的produceCloth()方法
        factory.produceCloth();
        System.out.println("代理工厂做一些后续的工作");
    }
}
