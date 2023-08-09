package com.example.designparrern.creational.builder.traditional;

/**
 * @author shuiyu
 * @date 2023/08/08
 * @description 决定如何构建最终产品的算法. 其会包含一个负责组装的方法void Construct(Builder builder)， 在这个方法中通过调用builder的方法，就可以设置builder，等设置完成后，就可以通过builder的 getProduct() 方法获得最终的产品。
 */
public class MobilePhoneDirector {

    public void produceMobilePhone(MobilePhoneBuilder builder) {
        builder.setType();
        builder.setProcessor();
        builder.setColour();
    }
}
