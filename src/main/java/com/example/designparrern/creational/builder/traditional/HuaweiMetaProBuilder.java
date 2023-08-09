package com.example.designparrern.creational.builder.traditional;

/**
 * @author shuiyu
 * @date 2023/08/08
 * @description 建造者模式 - ConcreteBuilder角色 - 具体建造者，Builder的实现类
 */
public class HuaweiMetaProBuilder extends MobilePhoneBuilder{

    private MobilePhone huawei;

    public HuaweiMetaProBuilder(String brand, Double price) {
        this.huawei = new MobilePhone(brand, price);
    }

    @Override
    public void setType() {
        this.huawei.setType("Meta PRO 5");
    }

    @Override
    public void setProcessor() {
        this.huawei.setProcessor("麒麟855芯片");
    }

    @Override
    public void setColour() {
        this.huawei.setColour("天空之镜蓝");
    }

    @Override
    public MobilePhone getMobilePhone() {
        return this.huawei;
    }
}
