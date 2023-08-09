package com.example.designparrern.behavioral.strategy;

/**
 * @author shuiyu
 * @date 2023/06/08
 * @description （计算机计算的策略）抽象策略角色接口
 */
public interface CalculateStrategy {

    /**
     * 对两个数依据具体的操作符进行计算
     *
     * @param num1 操作数1
     * @param num2 操作数2
     * @return 计算的结果
     */
    int doOperation(int num1, int num2);
}
