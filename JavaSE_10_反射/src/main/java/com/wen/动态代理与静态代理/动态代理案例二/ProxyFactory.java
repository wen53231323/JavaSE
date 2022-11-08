package com.wen.动态代理与静态代理.动态代理案例二;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 生产代理对象的工厂类
 */
public class ProxyFactory {
    // 将被代理的目标对象声明为成员变量
    private Object target;

    // 用于初始化被代理的目标对象
    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 根据加载到内存中的被代理类，动态的创建一个代理类及其对象
     * @return 返回一个代理类的对象
     */
    public Object getProxy() {
        // 加载动态生成的代理类的类加载器
        ClassLoader classLoader = target.getClass().getClassLoader();

        // 目标对象实现的所有接口的class对象所组成的数组
        Class<?>[] interfaces = target.getClass().getInterfaces();

        // 创建匿名内部类，设置代理对象实现目标对象方法的过程，即代理类中如何重写接口中的抽象方法
        InvocationHandler invocationHandler = new InvocationHandler() {
            /**
             * @param proxy 代理对象
             * @param method 代理对象需要实现的方法，即其中需要重写的方法
             * @param args method所对应方法的参数
             * @return 根据加载到内存中的被代理类，动态的创建一个代理类及其对象
             * */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                try {
                    System.out.println("[动态代理][日志] " + method.getName() + "，参 数：" + Arrays.toString(args));
                    result = method.invoke(target, args);
                    System.out.println("[动态代理][日志] " + method.getName() + "，结 果：" + result);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("[动态代理][日志] " + method.getName() + "，异 常：" + e.getMessage());
                } finally {
                    System.out.println("[动态代理][日志] " + method.getName() + "，方法 执行完毕");
                }
                return result;
            }
        };

        // newProxyInstance()：创建一个代理实例，其中有三个参数：
        // 1、classLoader：获取加载动态生成的代理类的类加载器
        // 2、interfaces：获取目标对象实现的所有接口的class对象所组成的数组
        // 3、invocationHandler：设置代理对象实现目标对象方法的过程，即代理类中如何重写接口中的抽象方法
        return Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }
}
