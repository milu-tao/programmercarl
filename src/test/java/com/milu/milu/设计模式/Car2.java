package com.milu.milu.设计模式;

public class Car2 {
    private Car2(){
    }
    private final static Car2 car;

    static {
        car = new Car2();
    }
    public static Car2 getCar(){
        return car;
    }
}
