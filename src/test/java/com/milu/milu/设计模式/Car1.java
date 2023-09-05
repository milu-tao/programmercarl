package com.milu.milu.设计模式;

public class Car1 {
    // 1.将构造器私有化,外部不能new
    private Car1(){
    }
    // 2.本类内部创建对象实例
    private final static Car1 car = new Car1();
    // 3.对外提供一个共有的静态方法，返回实例对象
    public static Car1 getCar(){
        return car;
    }
}
