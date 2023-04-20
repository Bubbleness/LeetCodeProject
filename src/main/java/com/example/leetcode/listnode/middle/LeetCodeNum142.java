package com.example.leetcode.listnode.middle;

import com.example.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shuiyu
 */
public class LeetCodeNum142 {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        List<ListNode> allreadyExist = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            if (allreadyExist.contains(p)) {
                return p;
            }
            allreadyExist.add(p);
            p = p.next;
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head, slow = head, ptr = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                while (ptr != slow) {
                    slow = slow.next;
                    ptr = ptr.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
