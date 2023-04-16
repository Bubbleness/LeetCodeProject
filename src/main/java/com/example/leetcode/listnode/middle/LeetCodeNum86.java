package com.example.leetcode.listnode.middle;

import com.example.leetcode.common.ListNode;

/**
 * @author shuiyu
 */
public class LeetCodeNum86 {

    public ListNode partition(ListNode head, int x) {

        if (head == null) {
            return head;
        }

        ListNode less = new ListNode();
        ListNode greater = new ListNode();

        less.next = head;
        greater.next = head;

        ListNode cur = head, lessHead = less, greaterHead = greater;
        while (cur != null) {
            if (cur.val < x) {
                less.next = cur;
                less = less.next;
            } else {
                greater.next = cur;
                greater = greater.next;
            }
            cur = cur.next;
        }

        less.next = null;
        greater.next = null;

        cur = lessHead;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = greaterHead.next;
        return lessHead.next;


//        ListNode less = getAllElemLessThanX(head, x);
//        ListNode.printList(less);
//        ListNode greater = getAllElemGreateThanOrEqualToX(head, x);
//        ListNode.printList(greater);
//        ListNode tail = less;
//        while (tail.next != null) {
//            tail = tail.next;
//        }
//        tail.next = greater;
//        return less;
    }

    public static ListNode getAllElemLessThanX(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p = head, q = null, cur = dummy;

        while (p != null) {
            if (p.val < x) {
                cur = cur.next;
            } else {
                cur.next = p.next;
            }
            p = p.next;
        }
        return dummy.next;
    }

    public static ListNode getAllElemGreateThanOrEqualToX(ListNode head, int x) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy, p = head;
        while (p != null) {
            if (p.val >= x) {
                cur = cur.next;
            } else {
                cur.next = p.next;
            }
            p = p.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 3, 2, 5, 2};
        ListNode head = ListNode.convert(nums);
        ListNode.printList(head);

        LeetCodeNum86 lc = new LeetCodeNum86();
        ListNode newHead = lc.partition(head, 3);
        ListNode.printList(newHead);
    }
}
