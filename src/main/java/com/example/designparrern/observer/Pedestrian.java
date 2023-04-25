package com.example.designparrern.observer;

/**
 * @author shuiyu
 * @description 观察者-路上的行人类
 */
public class Pedestrian implements People{

    @Override
    public void action(Object msg) {
        System.out.println("Pedestrian : " + msg);
        System.out.println("我们行人开始通行啦～");
    }
}
