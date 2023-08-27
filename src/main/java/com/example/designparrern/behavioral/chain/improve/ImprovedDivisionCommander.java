package com.example.designparrern.behavioral.chain.improve;

import com.example.designparrern.behavioral.chain.AttackRequest;

/**
 * @author shuiyu
 * @date 2023/08/27
 */
public class ImprovedDivisionCommander extends ImprovedApprover {

    @Override
    protected boolean doHandle(AttackRequest attackRequest) {

        if (attackRequest.getWeapon().equals("Hydrogen Bomb")) {
            // 使用「氢弹」攻击，师长有权利批准战斗
            // 当前处理者能够处理请求
            System.out.printf("「师长」同意战斗申请，允许使用「%s」攻击「%s」%n",
                attackRequest.getWeapon(), attackRequest.getCountry());
            return true;
        }
        return false;
    }
}
