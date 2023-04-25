package com.example.designparrern.observer;

/**
 * @author shuiyu
 * @description 观察者-路上的开汽车的人
 */
public class Driver implements People{

    @Override
    public void action(Object msg) {
        System.out.println("Driver : " + msg);
        System.out.println("我们开汽车的人开始通行啦～");
    }
}
