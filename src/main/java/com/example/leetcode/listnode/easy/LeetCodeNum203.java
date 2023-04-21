package com.example.leetcode.listnode.easy;

import com.example.leetcode.common.ListNode;

/**
 * @author shuiyu
 */
public class LeetCodeNum203 {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return null;
        }

        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) {
            return null;
        }

        ListNode pre = head, p = head.next;
        while (p != null) {
            if (p.val == val) {
                pre.next = p.next;
                p = p.next;
                continue;
            }
            pre = p;
            p = p.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 1, 1};
        ListNode head = ListNode.convert(nums);
        LeetCodeNum203 lc = new LeetCodeNum203();
        ListNode newHead = lc.removeElements(head, 1);
        ListNode.printList(newHead);
    }
}
