package com.wen.common;

import java.io.Serializable;

// Person的父类
public class Creature<T>implements Serializable {
    private char gender;//性别
    public double weight;//体重

    private void breath(){
        System.out.println("生物呼吸");
    }
    public void eat(){
        System.out.println("生物吃东西");
    }
}
