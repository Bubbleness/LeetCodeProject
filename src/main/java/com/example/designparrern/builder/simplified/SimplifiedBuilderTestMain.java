package com.example.designparrern.builder.simplified;

/**
 * @author shuiyu
 * @date 2023/08/08
 */
public class SimplifiedBuilderTestMain {

    public static void main(String[] args) {
        MobilePhoneNew iphone = new MobilePhoneNew.Builder("Apple", 8739.98)
            .setType("14 PRO")
            .setProcessor("Apple A18 Chip")
            .setColour("Red")
            .build();

        System.out.println("Build iphone -> " + iphone);

        MobilePhoneNew huawei = new MobilePhoneNew.Builder("华为", 8729.99)
            .setType("Meta PRO 5")
            .setProcessor("麒麟855芯片")
            .setColour("淡蓝色")
            .build();
        System.out.println("Build huawei -> " + huawei);
    }
}
