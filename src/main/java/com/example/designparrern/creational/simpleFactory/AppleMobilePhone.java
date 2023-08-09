package com.example.designparrern.creational.simpleFactory;

/**
 * @author shuiyu
 * @date 2023/08/09
 * @description 简单工厂模式 - 要生产的具体对象类 苹果手机
 */
public class AppleMobilePhone implements MobilePhone {

    @Override
    public void setOperationSystem() {
        System.out.println("苹果手机安装IOS操作系统");
    }
}
