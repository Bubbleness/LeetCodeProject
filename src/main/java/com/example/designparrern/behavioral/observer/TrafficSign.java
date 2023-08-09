package com.example.designparrern.behavioral.observer;

/**
 * @author shuiyu
 * @description 观察者模式-主题类 交通指挥标识接口
 */
public interface TrafficSign {

    /**
     * 注册观察者
     *
     * @param people 观察者
     */
    void register(People people);

    /**
     * 发送通知消息
     *
     * @param msg 通知消息
     */
    void notify(Object msg);
}
