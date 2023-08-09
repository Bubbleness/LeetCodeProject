package com.example.designparrern.creational.simpleFactory;

/**
 * @author shuiyu
 * @date 2023/08/09
 * @description 简单工厂模式 - 对象工厂 负责根据条件去生产对应的对象
 */
public class SimpleMobilePhoneFactory {

    /**
     * 简单工厂模式 - 根据品牌来生产对应的手机对象
     *
     * @param brand 手机品牌
     * @return 对应品牌的手机
     */
    public static MobilePhone produceMobilePhone(String brand) {
        MobilePhone mobilePhone = null;
        switch (brand) {
            case "apple":
                mobilePhone = new AppleMobilePhone();
                break;
            case "huawei":
                mobilePhone = new HuaweiMobilePhone();
                break;
            default:
                break;
        }
        return mobilePhone;
    }
}
