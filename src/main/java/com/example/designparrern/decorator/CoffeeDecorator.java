package com.example.designparrern.decorator;

/**
 * @author shuiyu
 * @date 2023/08/09
 * @description 装饰者模式 - 装饰者基类 一般为抽象类 实现Coffee接口，里面持有一个Coffee的引用
 */
public abstract class CoffeeDecorator implements Coffee{

    /**
     * 装饰者类需要维持一个被装饰类父类型的引用
     */
    private Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public void makeCoffee() {
        coffee.makeCoffee();
    }
}
