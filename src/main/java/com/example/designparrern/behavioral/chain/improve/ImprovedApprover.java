package com.example.designparrern.behavioral.chain.improve;

import com.example.designparrern.behavioral.chain.AttackRequest;

/**
 * @author shuiyu
 * @date 2023/08/27
 */
public abstract class ImprovedApprover {

    protected ImprovedApprover approver;

    public void setApprover(ImprovedApprover approver) {
        this.approver = approver;
    }

    /**
     * 处理请求
     */
    public final void handle(AttackRequest attackRequest) {

        boolean handled = doHandle(attackRequest);
        if (approver != null && !handled) {
            approver.handle(attackRequest);
        }
    }

    /**
     * 具体处理者实现
     *
     * @param attackRequest 请求
     * @return boolean
     */
    protected abstract boolean doHandle(AttackRequest attackRequest);
}
