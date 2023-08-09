package com.example.designparrern.structural.decorator;

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
}
