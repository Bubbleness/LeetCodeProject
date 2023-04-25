package com.example.designparrern.observer;

/**
 * @author shuiyu
 * @description 观察者模式-观察者类 人员接口
 */
public interface People {

    /**
     * 人员能够采取的行动
     *
     * @param msg 信息
     */
    void action(Object msg);
}
