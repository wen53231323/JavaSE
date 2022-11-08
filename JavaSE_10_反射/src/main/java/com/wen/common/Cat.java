package com.wen.common;

public class Cat {
    // 私有属性
    private Integer id;
    // 非私有属性
    public String name = "小喵";

    // 私有方法
    private void getCatId() {
        System.out.println("私有方法被调用");
        System.out.println("小猫的ID：" + id);
    }
    // 非私有方法
    public void getCatName() {
        System.out.println("非私有方法被调用");
        System.out.println("小猫的名字：" + name);
    }

    // 空参构造
    public Cat() {
    }

    // 全参构造
    public Cat(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
