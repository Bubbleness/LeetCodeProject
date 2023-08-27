package com.example.designparrern.behavioral.chain;

/**
 * @author mucheng
 * @date 2023/08/27 16:50:37
 * @description 指责链模式 - ConcreteHandler角色 具体请求处理者 司令
 */
public class Commander extends Approver {

    @Override
    public void handle(AttackRequest attackRequest) {

        if (attackRequest.getWeapon().equals("Nuclear Bomb")) {
            // 使用「核弹」攻击，司令有权利批准战斗
            // 当前处理者能够处理请求
            System.out.printf("「司令」同意战斗申请，允许使用「%s」攻击「%s」%n",
                attackRequest.getWeapon(), attackRequest.getCountry());
        } else {
            // 司令是最顶层的处理者
            System.out.println("「司令」召开军事会议讨论是否进行攻击！");
        }
    }
}
