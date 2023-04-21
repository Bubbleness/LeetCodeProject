package com.example.leetcode.listnode.middle;

import com.example.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shuiyu
 */
public class LeetCodeNum231 {

    public void deleteNode(ListNode node) {

        List<Integer> list = new ArrayList<>();
        ListNode pre = null, p = node;
        while (p.next != null) {
            pre = p;
            p = p.next;
            list.add(p.val);
        }
        pre.next = null;
        int i = 0;
        while (node != null) {
            node.val = list.get(i);
            i++;
            node = node.next;
        }
    }

    public void deleteNode2(ListNode node) {

        ListNode p = node, pre = null;
        while (p.next != null) {
            p.val = p.next.val;
            pre = p;
            p = p.next;
        }
        pre.next = null;
    }

    public void deleteNode3(ListNode node) {
        // 最佳解法 和下一个节点交换，然后删除下一个节点
        ListNode p = node, q = p.next;
        if (q != null) {
            p.val = q.val;
        }
        if (q.next == null) {
            node.next = null;
        } else {
            node.next = q.next;
        }

    }
}
