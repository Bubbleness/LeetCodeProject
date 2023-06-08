package com.example.designparrern.strategy;

/**
 * @author shuiyu
 * @date 2023/06/08
 * @description 环境角色：维持一个策略类的引用
 */
public class CalculateContext {

    private CalculateStrategy calculateStrategy;

    public CalculateContext(CalculateStrategy calculateStrategy) {
        this.calculateStrategy = calculateStrategy;
    }

    public void setCalculateStrategy(CalculateStrategy calculateStrategy) {
        this.calculateStrategy = calculateStrategy;
    }

    /**
     * 执行两个数的计算
     *
     * @param num1 操作数1
     * @param num2 操作数2
     * @return 计算的结果
     **/
    public int execute(int num1, int num2) {
        return calculateStrategy.doOperation(num1, num2);
    }
}
