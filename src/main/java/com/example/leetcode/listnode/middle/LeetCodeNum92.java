package com.example.leetcode.listnode.middle;

import com.example.leetcode.common.ListNode;

/**
 * @author shuiyu
 */
public class LeetCodeNum92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode leftPre = new ListNode(), leftPtr = head, rightPtr = head, tail = null, cur = leftPre;
        leftPre.next = head;

        while (--left > 0) {
            leftPre = leftPtr;
            leftPtr = leftPtr.next;
        }

        while (--right > 0) {
            rightPtr = rightPtr.next;
        }

        tail = rightPtr.next;
        rightPtr.next = null;
        leftPre.next = null;

        leftPre.next = reverse(leftPtr);
        leftPtr.next = tail;
        return cur.next;
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null, p = head, q = head.next;
        while (q != null) {
            p.next = pre;
            pre = p;
            p = q;
            q = p.next;
        }
        p.next = pre;
        return p;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        ListNode head = ListNode.convert(nums);
        ListNode.printList(head);

        LeetCodeNum92 lc = new LeetCodeNum92();
//        ListNode newHead = reverse(head);
//        ListNode.printList(newHead);
        ListNode newHead = lc.reverseBetween(head, 1, 4);
        ListNode.printList(newHead);
    }
}
