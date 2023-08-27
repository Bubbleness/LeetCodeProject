package com.example.designparrern.behavioral.chain.improve;

import com.example.designparrern.behavioral.chain.AttackRequest;

/**
 * @author shuiyu
 * @date 2023/08/27
 */
public class ImprovedChainMainTest {

    public static void main(String[] args) {

        AttackRequest attackRequest1 = new AttackRequest("Missile", "日本");
        AttackRequest attackRequest2 = new AttackRequest("Hydrogen Bomb", "日本");
        AttackRequest attackRequest3 = new AttackRequest("Nuclear Bomb", "日本");
        AttackRequest attackRequest4 = new AttackRequest("Bomb", "日本");

        ApproverChain chain = new ApproverChain();
        ImprovedRegimentalCommander regimentalCommander = new ImprovedRegimentalCommander();
        ImprovedDivisionCommander divisionCommander = new ImprovedDivisionCommander();
        ImprovedCommander commander = new ImprovedCommander();

        chain.addHandler(regimentalCommander);
        chain.addHandler(divisionCommander);
        chain.addHandler(commander);

        chain.handle(attackRequest1);
        chain.handle(attackRequest2);
        chain.handle(attackRequest3);
        // 这种写法要求请求必须被一个处理器给处理
        chain.handle(attackRequest4);
    }
}
