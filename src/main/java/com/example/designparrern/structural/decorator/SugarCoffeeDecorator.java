package com.example.designparrern.structural.decorator;

/**
 * @author shuiyu
 * @date 2023/08/09
 * @description 装饰者模式 - 具体装饰者类 实现操作是给原味咖啡加糖
 */
public class SugarCoffeeDecorator extends CoffeeDecorator{

    public SugarCoffeeDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public void makeCoffee() {
        super.makeCoffee();
        addSugar();
    }

    private void addSugar() {
        System.out.println("给原味咖啡加入白糖～");
    }
}
