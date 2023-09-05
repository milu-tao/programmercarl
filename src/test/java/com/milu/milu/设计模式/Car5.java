package com.milu.milu.设计模式;

public class Car5 {
    private Car5(){}

    private static Car5 car;

    public Car5 getCar(){
        if(car == null){
            synchronized (Car5.class){
                if(car == null){
                    car = new Car5();
                }
            }
        }
        return  car;
    }
}
