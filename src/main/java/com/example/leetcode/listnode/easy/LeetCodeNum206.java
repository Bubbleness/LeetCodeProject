package com.example.leetcode.listnode.easy;

import com.example.leetcode.common.ListNode;

/**
 * @author shuiyu
 */
public class LeetCodeNum206 {

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null, p = head, q = null;
        while (p != null) {
            q = p.next;
            p.next = pre;
            pre = p;
            p = q;
        }
        return pre;
    }

    // 递归写法
    public ListNode reverseList2(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4 , 5};
        ListNode head = ListNode.convert(nums);
        LeetCodeNum206 lc = new LeetCodeNum206();
        ListNode newHead = lc.reverseList2(head);
        ListNode.printList(newHead);
    }
}
