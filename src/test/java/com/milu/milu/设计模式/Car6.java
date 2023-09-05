package com.milu.milu.设计模式;

public class Car6 {
    private static Car6 instance;
    // 1.私有化构造方法
    private Car6(){}
    // 2.静态内部类，该类中有一个静态属性Singleton
    private static class CarInstance{
        private static final Car6 INSTANCE = new Car6();
    }
    // 3.提供一个静态的公有方法，直接返回静态内部类中的属性
    public static Car6 getCar(){
        return CarInstance.INSTANCE;
    }
}
