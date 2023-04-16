package com.example.leetcode.listnode.middle;

import com.example.leetcode.common.ListNode;

/**
 * @auther shuiyu
 */
public class LeetCodeNum82 {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head, q = null, pre = null;

        while (p != null && p.next != null) {
            if (p.val != p.next.val) {
                pre = p;
                p = p.next;
            } else {
                q = p;
                while (q != null && q.val == p.val) {
                    q = q.next;
                }

                if (pre != null) {
                    pre.next = q;
                } else {
                    head = q;
                }
                p = q;
            }
        }

        if (pre == null && p != null) {
            return p;
        }

        if (pre == null && p == null) {
            return null;
        }
        return head;
    }

    public static ListNode removeDuplicateHead(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head;

        // 先去除头部重复的 比如 1 -> 1 -> 1 -> 2 -> 3
        boolean flag = true;
        while (p.next != null && p.val == p.next.val) {
            flag = false;
            p = p.next;
        }
        // 退出循环 1. p.next为空 2. p.val != p.next.val
        // 如果p的值等于head的值且flag = false 说明p是重复的节点，需要删除
        if (!flag && p.val == head.val) {
            return p.next;
        }
        return p;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 4};
        ListNode head = ListNode.convert(nums);
        ListNode.printList(head);
        LeetCodeNum82 lc = new LeetCodeNum82();
//        ListNode newHead = removeDuplicateHead(head);
//        ListNode.printList(newHead);
        ListNode newHead = lc.deleteDuplicates(head);
        ListNode.printList(newHead);
    }
}
