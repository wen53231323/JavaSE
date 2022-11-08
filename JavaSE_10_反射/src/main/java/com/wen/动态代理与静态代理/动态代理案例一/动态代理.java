package com.wen.动态代理与静态代理.动态代理案例一;

import java.lang.reflect.Proxy;

public class 动态代理 {
    public static void main(String[] args) {
        // 创建代理类的对象
        SupperMan supperMan = new SupperMan();

        // getProxyInstance：返回一个代理类的对象
        Human proxyInstance = (Human) getProxyInstance(supperMan);

        // 当通过代理类对象调用方法时，会自动调用被代理类中同名的方法
        proxyInstance.eat("早餐");
    }

    /**
     * 根据加载到内存中的被代理类，动态的创建一个代理类及其对象
     *
     * @param obj 被代理类的对象
     * @return 返回一个代理类的对象
     */
    public static Object getProxyInstance(Object obj) {
        // 创建InvocationHandler对象
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        // 创建代理对象,代理对象的每个执行方法都会替换执行Invocation中的invoke方法
        // newProxyInstance()：创建一个代理实例，其中有三个参数
        // 1、classLoader：获取加载动态生成的代理类的类加载器
        // 2、interfaces：获取目标对象实现的所有接口的class对象所组成的数组
        // 3、invocationHandler：设置代理对象实现目标对象方法的过程，即代理类中如何重写接口中的抽象方法
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}

