package com.example.designparrern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shuiyu
 * @description 主题类-交警
 */
public class TrafficPolice implements TrafficSign{

    private List<People> observers = new ArrayList<>();

    @Override
    public void register(People people) {
        // 绑定观察者
        observers.add(people);
    }

    @Override
    public void notify(Object msg) {
        // 通知观察者
        for (People people : observers) {
            people.action(msg);
        }
    }
}
