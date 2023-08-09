package com.example.designparrern.structural.decorator;

/**
 * @author shuiyu
 * @date 2023/08/09
 * @description 装饰者模式 - 需要被装饰的类 这里是原味咖啡类
 */
public class OriginalCoffee implements Coffee{

    @Override
    public void makeCoffee() {
        System.out.println("原味咖啡做好啦，请慢用～");
    }
}
