package com.example.designparrern.structural.decorator;

import com.example.leetcode.common.StringUtils;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author shuiyu
 * @date 2023/08/09
 * @description 装饰者模式 - 具体装饰者类 实现操作是给原味咖啡加奶
 */
public class MilkCoffeeDecorator extends CoffeeDecorator{

    /**
     * 装饰者模式与代理模式的区别：
     *  1. 一般认为代理模式侧重于使用代理类增强被代理对象的访问，而装饰者模式侧重于使用装饰者类来对被装饰对象的功能进行增减。
     *  2. 装饰者模式主要是提供一组装饰者类，然后形成一个装饰者栈，来动态的对某一个对象不断加强，而代理一般不会使用多级代理。
     */

    public MilkCoffeeDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public void makeCoffee() {
        super.makeCoffee();
        addMilk();
    }

    private void addMilk() {
        System.out.println("给原味咖啡加入牛奶～");
    }

//    public static void main(String[] args) {
//
//        String str = UUID.randomUUID().toString();
//        System.out.println(str.replaceAll("-", ""));
//    }

    public static void main(String[] args) {

//        String msg1 = "四大啊啥的退运费   8元湿答答 --阿里健康自营:执业药师1117 2024-12-10 12:06:53";
//        String msg2 = "时间啊宋丹丹辣烧烤  退差价  :    1222323.2  元三大数据的垃圾收到啦\"，你需要返回给我 12.24";
//        String msg3 = "==【仅退款异常】类型错误待修改/金额不符应退X元 已留言 售后yc1202 2024-12-12 23:11:41 介入";
//
//
//        String msg4 = "运营（友博）同步，拍4盒以上按照548元，顾客分开提交，此订单收到货，退差价：210元【健康指导师_371 12-20 17:23】 考虑体验退红包29，已反馈组长 --阿里健康自营:售后ja1446 2024-12-23 16:08:35";
//
//        String regex = "退运费\\s*(\\d+)\\s*元";
//        String regex2 = "退差价\\s*[:|：]\\s*(\\d+(\\.\\d+)?)";
//
//
//
//        Pattern pattern = Pattern.compile(regex2);
//        Matcher matcher = pattern.matcher(msg2);
//
//        if (matcher.find()) {
//            if (matcher.group(1) != null) {
//                System.out.println(matcher.group(1));
//            } else if (matcher.group(2) != null) {
//                System.out.println(matcher.group(2));
//            }
//        }

        String str = "共1件商品，合计¥232.22";

        int index = str.indexOf("¥");
        index = index - 2;

        System.out.println(str.substring(0, index));
    }
}
