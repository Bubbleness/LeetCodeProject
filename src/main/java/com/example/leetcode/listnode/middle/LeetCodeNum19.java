package com.example.leetcode.listnode.middle;

import com.example.leetcode.common.ListNode;

/**
 * @author shuiyu
 */
public class LeetCodeNum19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return head;
        }
        int length = getListNodeLength(head);
        if (n == length) {
            return head.next;
        }
        ListNode p = head, pre = null, q = null;
        for (int i = 1; i < length - n + 1; i++) {
            pre = p;
            p = p.next;
        }
        if (p.next == null) {
            pre.next = null;
            return head;
        }
        q = p.next;
        pre.next = q;
        p.next = null;
        return head;
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

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        ListNode head = ListNode.convert(nums);
        int n = 1;
        LeetCodeNum19 lc = new LeetCodeNum19();
        ListNode.printList(head);
        System.out.println();
        ListNode res = lc.removeNthFromEnd(head, n);
        ListNode.printList(res);
    }
}
