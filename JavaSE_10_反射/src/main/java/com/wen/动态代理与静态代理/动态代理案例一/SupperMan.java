package com.wen.动态代理与静态代理.动态代理案例一;

/**
 * 被代理类
 */
class SupperMan implements Human {
    @Override
    public void eat(String food) {
        System.out.println("超人喜欢吃" + food);
    }
}
