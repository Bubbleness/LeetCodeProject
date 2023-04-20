package com.example.leetcode.listnode.easy;

import com.example.leetcode.common.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author shuiyu
 */
public class LeetCodeNum141 {

    // 解法1: 利用List进行标记
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        List<ListNode> allreadyExist = new LinkedList<>();
        ListNode p = head;
        while (p != null) {
            if (allreadyExist.contains(p)) {
                return true;
            }
            allreadyExist.add(p);
            p = p.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
