package com.example.leetcode.common;

/**
 * @author shuiyu
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
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

    public static ListNode convert(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        ListNode ln = new ListNode();
        ListNode p = ln;
        for (int item : nums) {
            ListNode temp = new ListNode(item, null);
            p.next = temp;
            p = temp;
        }
        return ln.next;
    }

    public static void printList(ListNode ln) {
        if (ln == null) {
            return;
        }
        ListNode p = ln;
        while (p != null) {
            System.out.print(p.val + " -> ");
            p = p.next;
        }
    }
}
