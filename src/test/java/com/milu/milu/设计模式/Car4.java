package com.milu.milu.设计模式;

public class Car4 {
    //1.私有化构造方法
    private Car4(){}

    private static Car4 car;
    //2. getCar，如果没有就创建，如果有就返回.通过加锁保证只有一个线程去创建
    public synchronized static Car4 getCar(){
        if(car == null ){
            car = new Car4();
        }
        return car;
    }
}
