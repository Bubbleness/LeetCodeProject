package com.example.designparrern.behavioral.chain;

/**
 * @author mucheng
 * @date 2023/08/27 16:37:51
 * @description 指责链模式 - ConcreteHandler角色 具体请求处理者  团长
 */
public class RegimentalCommander extends Approver {

    @Override
    public void handle(AttackRequest attackRequest) {
        if (attackRequest.getWeapon().equals("Missile")) {
            // 使用「导弹」攻击，团长有权利批准战斗
            // 当前处理者能够处理请求
            System.out.printf("「团长」同意战斗申请，允许使用「%s」攻击「%s」%n",
                attackRequest.getWeapon(), attackRequest.getCountry());
        } else {
            // 当前处理者处理不了请求，则传递给下一个处理者
            approver.handle(attackRequest);
        }
    }
}
