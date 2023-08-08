package com.example.designparrern.builder.traditional;

import com.alibaba.fastjson.JSON;

/**
 * @author shuiyu
 * @date 2023/08/08
 * @description 测试类
 */
public class BuilderTestMain {

    public static void main(String[] args) {

        MobilePhoneDirector director = new MobilePhoneDirector();
        MobilePhoneBuilder iphoneBuilder = new IPhone14ProBuilder("Apple", 8893.22);
        director.produceMobilePhone(iphoneBuilder);

        MobilePhone iphone = iphoneBuilder.getMobilePhone();
        System.out.println("Build iPhone -> " + iphone);

        MobilePhoneBuilder huaweiBuilder = new HuaweiMetaProBuilder("华为", 7628.23);
        director.produceMobilePhone(huaweiBuilder);
        MobilePhone huawei = huaweiBuilder.getMobilePhone();
        System.out.println("Build huawei -> " + huawei);
    }
}
