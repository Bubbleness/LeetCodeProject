package com.example.designparrern.behavioral.chain;

/**
 * @author mucheng
 * @date 2023/08/27 16:53:30
 * @description 测试类
 */
public class ChainMainTest {

    public static void main(String[] args) {

        AttackRequest attackRequest1 = new AttackRequest("Missile", "日本");
        AttackRequest attackRequest2 = new AttackRequest("Hydrogen Bomb", "日本");
        AttackRequest attackRequest3 = new AttackRequest("Nuclear Bomb", "日本");
        AttackRequest attackRequest4 = new AttackRequest("Bomb", "日本");

        // 团长
        RegimentalCommander regimentalCommander = new RegimentalCommander();
        // 师长
        DivisionCommander divisionCommander = new DivisionCommander();
        // 司令
        Commander commander = new Commander();

        // 团长的上级是师长
        regimentalCommander.setApprover(divisionCommander);
        // 师长的上级是司令
        divisionCommander.setApprover(commander);

        // 「团长」同意战斗申请，允许使用「Missile」攻击「日本」
        regimentalCommander.handle(attackRequest1);
        // 「师长」同意战斗申请，允许使用「Hydrogen Bomb」攻击「日本」
        regimentalCommander.handle(attackRequest2);
        // 「司令」同意战斗申请，允许使用「Nuclear Bomb」攻击「日本」
        regimentalCommander.handle(attackRequest3);
        // 「司令」召开军事会议讨论是否进行攻击！
        regimentalCommander.handle(attackRequest4);

    }
}
