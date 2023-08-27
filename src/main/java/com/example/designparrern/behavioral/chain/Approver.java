package com.example.designparrern.behavioral.chain;

/**
 * @author mucheng
 * @date 2023/08/27 16:32:19
 * @description 指责链模式 - Handler角色 抽象处理者
 */
public abstract class Approver {

    /**
     * 下一个处理请求的处理者
     */
    protected Approver approver;

    public void setApprover(Approver approver) {
        this.approver = approver;
    }

    /**
     * 处理请求的具体方法
     *
     * @param attackRequest 攻击请求
     */
    public abstract void handle(AttackRequest attackRequest);
}
