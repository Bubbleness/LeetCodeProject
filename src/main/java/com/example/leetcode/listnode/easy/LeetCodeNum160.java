package com.example.leetcode.listnode.easy;

import com.example.leetcode.common.ListNode;

/**
 * @author shuiyu
 */
public class LeetCodeNum160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null && headB == null) {
            return null;
        }
        int lenA = getListNodeLength(headA);
        int lenB = getListNodeLength(headB);
        int count = Math.abs(lenA - lenB);
        ListNode curA = headA, curB = headB;
        if (lenA >= lenB) {
            while (count > 0) {
                curA = curA.next;
                count--;
            }
        } else {
            while (count > 0) {
                curB = curB.next;
                count--;
            }
        }

        while (curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }

    public static int getListNodeLength(ListNode ln) {
        if (ln == null) {
            return 0;
        }
        ListNode p = ln;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        return len;
    }
}
