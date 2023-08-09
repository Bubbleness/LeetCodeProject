package com.example.designparrern.behavioral.strategy;

/**
 * @author shuiyu
 * @date 2023/06/08
 */
public class Client {

    public static void main(String[] args) {

        // 加法策略
        CalculateContext context = new CalculateContext(new Addition());
        int addRes = context.execute(12, 43);
        System.out.println("addRes = " + addRes);

        // 减法策略
        context.setCalculateStrategy(new Subtraction());
        int subRes = context.execute(43, 12);
        System.out.println("subRes = " + subRes);

        // 减法策略
        context.setCalculateStrategy(new Multiplication());
        int mulRes = context.execute(15, 20);
        System.out.println("mulRes = " + mulRes);

        // 除法策略
        context.setCalculateStrategy(new Division());
        int divRes = context.execute(15, 3);
        System.out.println("divRes = " + divRes);

    }
}
