package com.example.designparrern.creational.simpleFactory;

/**
 * @author shuiyu
 * @date 2023/08/09
 * @description 简单工厂模式 - 需要生产的具体对象类 华为手机
 */
public class HuaweiMobilePhone implements MobilePhone {

    @Override
    public void setOperationSystem() {
        System.out.println("华为手机安装鸿蒙操作系统");
    }
}
