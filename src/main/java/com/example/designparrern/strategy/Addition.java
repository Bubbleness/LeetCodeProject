package com.example.designparrern.strategy;

/**
 * @author shuiyu
 * @date 2023/06/08
 * @description 具体的计算策略：执行加法计算
 */
public class Addition implements CalculateStrategy{

    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
