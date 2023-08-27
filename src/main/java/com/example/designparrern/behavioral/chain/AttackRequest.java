package com.example.designparrern.behavioral.chain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author mucheng
 * @date 2023/08/27 16:28:06
 * @description 指责链模式 - Request 请求角色 攻击请求
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class AttackRequest {

    /**
     * 武器
     */
    private String weapon;

    /**
     * 攻击的国家
     */
    private String country;
}
