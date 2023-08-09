package com.example.designparrern.creational.builder.traditional;

/**
 * @author shuiyu
 * @date 2023/08/08
 * @description 建造者模式 - Builder角色 - 抽象建造者，定义了构建Product的抽象步骤，包含一个用来返回最终产品的方法Product getProduct()
 * 使用场景：当一个类的构造函数参数个数超过4个，而且这些参数有些是可选的参数，考虑使用构造者模式。
 */
public abstract class MobilePhoneBuilder {

    /**
     * 填写手机型号
     */
    public abstract void setType();

    /**
     * 填写手机处理器
     */
    public abstract void setProcessor();

    /**
     * 填写手机颜色
     */
    public abstract void setColour();

    /**
     * 构建一部手机
     *
     * @return 构建的手机
     */
    public abstract MobilePhone getMobilePhone();
}
