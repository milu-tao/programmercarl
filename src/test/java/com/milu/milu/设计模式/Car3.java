package com.milu.milu.设计模式;

public class Car3 {
    //1.私有化构造方法
    private Car3(){}

    private static Car3 car;
    //2. getCar，如果没有就创建，如果有就返回

    public static Car3 getCar(){
        if(car == null ){
            //缺点：如果是单线程，这个代码并没有问题，但多线程情况下，在代码执行到这里，多个线程都判断null，就都会去创建实例，这就破坏了单例模式
            car = new Car3();
        }
        return car;
    }
}
