package com.example.leetcode.listnode.easy;

import com.example.leetcode.common.ListNode;

/**
 * @author shuiyu
 */
public class LeetCodeNum83 {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head, p = null;
        while (cur.next != null) {

            if (cur.val == cur.next.val) {
                p = cur.next;
                while (p != null && p.val == cur.val) {
                    cur.next = p.next;
                    p =  p.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3, 3, 3, 4};
        ListNode head = ListNode.convert(nums);
        LeetCodeNum83 lc = new LeetCodeNum83();
        ListNode newHead = lc.deleteDuplicates(head);
        ListNode.printList(newHead);
    }
}
