package com.wen.动态代理与静态代理.CGLIB动态代理;

import net.sf.cglib.proxy.Enhancer;

/**
 * 代理工厂，用于获取代理类
 */
public class CglibProxyFactory {
    /**
     * 根据加载到内存中的被代理类，动态的创建一个代理类及其对象
     * @return 返回一个代理类的对象
     */
    public static Object getProxy(Class<?> clazz) {
        // 创建动态代理增强类
        Enhancer enhancer = new Enhancer();
        // 设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        // 设置被代理类
        enhancer.setSuperclass(clazz);
        // 设置方法拦截器
        enhancer.setCallback(new DebugMethodInterceptor());
        // 创建代理类
        return enhancer.create();
    }
}
