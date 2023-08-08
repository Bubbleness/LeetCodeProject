package com.example.designparrern.builder.traditional;

/**
 * @author shuiyu
 * @date 2023/08/08
 * @description 建造者模式 - ConcreteBuilder角色 - 具体建造者，Builder的实现类
 */
public class IPhone14ProBuilder extends MobilePhoneBuilder{

    private MobilePhone iphone;

    public IPhone14ProBuilder(String brand, Double price) {
        this.iphone = new MobilePhone(brand, price);
    }

    @Override
    public void setType() {
        this.iphone.setType("14 PRO");
    }

    @Override
    public void setProcessor() {
        this.iphone.setProcessor("Apple A18 Chip");
    }

    @Override
    public void setColour() {
        this.iphone.setColour("暗夜紫色");
    }

    @Override
    public MobilePhone getMobilePhone() {
        return this.iphone;
    }
}
