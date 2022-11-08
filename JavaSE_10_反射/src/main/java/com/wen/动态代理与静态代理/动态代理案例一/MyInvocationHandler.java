package com.wen.动态代理与静态代理.动态代理案例一;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 这个类实现了InvocationHandler接口，并持有一个被代理类的对象，
 * InvocationHandler中有一个invoke方法，所有执行代理对象的方法都会被替换成执行invoke方法。
 * 然后可以通过反射在invoke方法中执行代理类的方法。
 * 在代理过程中，在执行代理类的方法前后可以执行自己的操作，这就是spring aop的主要原理。
 */
class MyInvocationHandler implements InvocationHandler {
    // 需要使用被代理的对象进行赋值
    private Object target;

    /**
     * 此方法用于初始化被代理的对象
     */
    public void bind(Object target) {
        this.target = target;
    }

    /**
     * 当通过代理类的对象，调用方法a时，就会自动的调用invoke()方法
     * 可以在 invoke() 方法中自定义处理逻辑，比如在方法执行前后做一些通用事情
     *
     * @param proxy  代表动态代理对象
     * @param method 代理对象需要实现的方法，即代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
     * @param args   method所对应方法的参数，代表调用目标方法时传入的实参
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 代理过程中插入其他操作
        System.out.println("===========代理前执行==========");

        // 动态代理的本质就是使用反射机制来实现
        // target表示被代理类的对象
        Object returnValue = method.invoke(target, args);

        System.out.println("===========代理后执行==========");
        return returnValue;
    }
}
