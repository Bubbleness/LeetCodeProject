package com.example.designparrern.structural.decorator;

/**
 * @author shuiyu
 * @date 2023/08/09
 * @description 测试类
 */
public class DecoratorTestMain {

    public static void main(String[] args) {

        // 先做原味咖啡
        Coffee coffee = new OriginalCoffee();
        coffee.makeCoffee();

        System.out.println("------------------------------------------");

        // 装饰原味咖啡 - 给咖啡加入牛奶
        CoffeeDecorator milkDecorator = new MilkCoffeeDecorator(coffee);
        milkDecorator.makeCoffee();

        System.out.println("------------------------------------------");

        // 装饰原味咖啡 - 给咖啡加入白糖
        CoffeeDecorator sugarDecorator = new SugarCoffeeDecorator(coffee);
        sugarDecorator.makeCoffee();

    }
}
