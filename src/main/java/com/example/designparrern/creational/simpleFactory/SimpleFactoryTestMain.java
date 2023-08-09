package com.example.designparrern.creational.simpleFactory;

/**
 * @author shuiyu
 * @date 2023/08/09
 * @description 测试类
 */
public class SimpleFactoryTestMain {

    /**
     * 简单工厂模式其实就是定义一个工厂类，在工厂类里面通过switch语句来根据传递的条件选择实例化哪一个具体的类
     */

    public static void main(String[] args) {

        MobilePhone iphone = SimpleMobilePhoneFactory.produceMobilePhone("apple");
        iphone.setOperationSystem();

        MobilePhone huawei = SimpleMobilePhoneFactory.produceMobilePhone("huawei");
        huawei.setOperationSystem();
    }
}
