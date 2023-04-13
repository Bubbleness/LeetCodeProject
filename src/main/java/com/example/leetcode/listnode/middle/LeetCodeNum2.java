package com.example.leetcode.listnode.middle;

import com.example.leetcode.common.ListNode;

import java.util.Scanner;

/**
 * @author shuiyu
 */
public class LeetCodeNum2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return reverse(l2);
        }
        if (l2 == null) {
            return reverse(l1);
        }

        ListNode p1 = l1, p2 = l2, ln = l1;
        if (getListNodeLength(l1) < getListNodeLength(l2)) {
            ln = l2;
        }
        ListNode res = ln, lnPre = null;
        int e = 0;
        while (p1 != null && p2 != null) {
            int temp = p1.val + p2.val + e;
            ln.val = temp % 10;
            e = temp / 10;
            p1 = p1.next;
            p2 = p2.next;
            lnPre = ln;
            ln = ln.next;
        }

        while (p1 != null) {
            int temp = p1.val + e;
            ln.val = temp % 10;
            e = temp / 10;
            p1 = p1.next;
            lnPre = ln;
            ln = ln.next;
        }

        while (p2 != null) {
            int temp = p2.val + e;
            ln.val = temp % 10;
            e = temp / 10;
            p2 = p2.next;
            lnPre = ln;
            ln = ln.next;
        }

        if (e != 0) {
            lnPre.next = new ListNode(e);
        }

        return res;
    }

    public static ListNode reverse(ListNode ln) {
        if (ln == null || ln.next == null) {
            return ln;
        }
        ListNode p = ln, pre = null, q = p.next;
        while (q != null) {
           p.next = pre;
           pre = p;
           p = q;
           q = p.next;
        }
        p.next = pre;
        return p;
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

        int[] nums1 = new int[]{2, 4, 3};
        int[] nums2 = new int[]{5, 6, 4};
        LeetCodeNum2 lc = new LeetCodeNum2();
        ListNode l1 = ListNode.convert(nums1), l2 = ListNode.convert(nums2);
        ListNode res = lc.addTwoNumbers(l1, l2);
        ListNode.printList(l1);
        System.out.println();
        ListNode.printList(l2);
        System.out.println();
        ListNode.printList(res);

    }
}
