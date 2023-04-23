package com.example.leetcode.listnode.middle;

import com.example.leetcode.common.ListNode;
import com.example.leetcode.listnode.hard.LeetCodeNum432;

/**
 * @author shuiyu
 */
public class LeetCodeNum445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode a = reverse(l1);
        ListNode b = reverse(l2);
        int lenA = getListNodeLength(a);
        int lenB = getListNodeLength(b);
        ListNode newHead = a, cur = null;
        if (lenA < lenB) {
            newHead = b;
        }
        cur = newHead;
        int e = 0;
        while (a != null && b != null) {
            int temp = a.val + b.val + e;
            cur.val = temp % 10;
            e = temp / 10;
            a = a.next;
            b = b.next;
            if (cur.next != null) {
                cur = cur.next;
            }
        }

        while (a != null) {
            int temp = a.val + e;
            cur.val = temp % 10;
            e = temp / 10;
            a = a.next;
            if (cur.next != null) {
                cur = cur.next;
            }
        }

        while (b != null) {
            int temp = b.val + e;
            cur.val = temp % 10;
            e = temp / 10;
            b = b.next;
            if (cur.next != null) {
                cur = cur.next;
            }
        }
        if (e != 0) {
            cur.next = new ListNode(e);
        }
        return reverse(newHead);
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

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{7};
        int[] nums2 = new int[]{5};
        ListNode a = ListNode.convert(nums1);
        ListNode b = ListNode.convert(nums2);

        LeetCodeNum445 lc = new LeetCodeNum445();
        ListNode.printList(lc.addTwoNumbers(a, b));
    }
}
