package com.example.designparrern.behavioral.chain;

/**
 * @author mucheng
 * @date 2023/08/27 16:46:33
 * @description 指责链模式 - ConcreteHandler角色 具体请求处理者 师长
 */
public class DivisionCommander extends Approver {

    @Override
    public void handle(AttackRequest attackRequest) {

        if (attackRequest.getWeapon().equals("Hydrogen Bomb")) {
            // 使用「氢弹」攻击，师长有权利批准战斗
            // 当前处理者能够处理请求
            System.out.printf("「师长」同意战斗申请，允许使用「%s」攻击「%s」%n",
                attackRequest.getWeapon(), attackRequest.getCountry());
        } else {
            // 当前处理者处理不了请求，则传递给下一个处理者
            approver.handle(attackRequest);
        }
    }
}
