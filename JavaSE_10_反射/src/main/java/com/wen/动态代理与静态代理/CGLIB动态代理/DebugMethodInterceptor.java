package com.wen.动态代理与静态代理.CGLIB动态代理;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 自定义类实现MethodInterceptor接口，重写接口的intercept方法（方法拦截器）
 */
public class DebugMethodInterceptor implements MethodInterceptor {
    /**
     * intercept方法用于拦截并增强被代理类的方法，类似JDK动态代理中的invoke方法
     *
     * @param o           代理对象（增强的对象）
     * @param method      被拦截的方法（需要增强的方法）
     * @param args        方法入参
     * @param methodProxy 用于调用原始方法
     */
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Object result = null;
        try {
            System.out.println("[动态代理][日志] " + method.getName() + "，参 数：" + Arrays.toString(args));
            result = methodProxy.invokeSuper(o, args);
            System.out.println("[动态代理][日志] " + method.getName() + "，结 果：" + result);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[动态代理][日志] " + method.getName() + "，异 常：" + e.getMessage());
        } finally {
            System.out.println("[动态代理][日志] " + method.getName() + "，方法 执行完毕");
        }
        return result;
    }
}
