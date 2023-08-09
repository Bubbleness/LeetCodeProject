package com.example.designparrern.behavioral.observer;

/**
 * @author shuiyu
 * @description 观察者-路上的骑摩托车的人
 */
public class Motorcyclist implements People{

    @Override
    public void action(Object msg) {
        System.out.println("Motorcyclist : " + msg);
        System.out.println("我们骑摩托车的人开始通行啦～");
    }
}
