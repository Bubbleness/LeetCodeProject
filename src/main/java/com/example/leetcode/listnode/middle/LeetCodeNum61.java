package com.example.leetcode.listnode.middle;

import com.example.leetcode.common.ListNode;

/**
 * @author shuiyu
 */
public class LeetCodeNum61 {

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }

        int length = getListNodeLength(head);
        k %= length;
        if (k == 0) {
            return head;
        }

        ListNode p = head, pre = head;
        while (k > 0) {
            p = p.next;
            k--;
        }

        while (p.next != null) {
            p = p.next;
            pre = pre.next;
        }

        ListNode res = pre.next;
        pre.next = null;
        p.next = head;
        return res;

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
        int[] nums = new int[]{1, 2, 3, 4, 5};
        ListNode head = ListNode.convert(nums);
        ListNode.printList(head);
        LeetCodeNum61 lc = new LeetCodeNum61();
        ListNode res = lc.rotateRight(head, 3);
        ListNode.printList(res);
    }
}
