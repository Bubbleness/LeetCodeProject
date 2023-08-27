package com.example.designparrern.behavioral.chain.improve;

import java.util.LinkedList;
import java.util.List;

import com.example.designparrern.behavioral.chain.AttackRequest;
import org.springframework.util.CollectionUtils;

/**
 * @author shuiyu
 * @date 2023/08/27
 */
public class ApproverChain {

    private ImprovedApprover head = null;
    private ImprovedApprover tail = null;

    public void addHandler(ImprovedApprover approver) {
        approver.setApprover(null);

        if (head == null) {
            head = approver;
            tail = approver;
            return;
        }

        tail.setApprover(approver);
        tail = approver;
    }

    public void handle(AttackRequest attackRequest) {
        if (head != null) {
            head.handle(attackRequest);
        }
    }
}
