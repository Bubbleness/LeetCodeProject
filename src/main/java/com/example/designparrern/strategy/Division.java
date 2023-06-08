package com.example.designparrern.strategy;

/**
 * @author shuiyu
 * @date 2023/06/08
 * @description 具体计算策略：执行除法运算
 */
public class Division implements CalculateStrategy{

    @Override
    public int doOperation(int num1, int num2) {
        return num1 / num2;
    }
}
