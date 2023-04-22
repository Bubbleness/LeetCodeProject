package com.example.leetcode.listnode.middle;

import com.example.leetcode.common.ListNode;

/**
 * @author shuiyu
 */
public class LeetCodeNum328 {

    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = new ListNode(), even = new ListNode();
        ListNode p = head, tailOdd = odd, tailEven = even;
        while (p != null) {
            tailOdd.next = p;
            tailOdd = p;
            p = p.next;
            tailOdd.next = null;

            if (p == null) {
                break;
            }
            tailEven.next = p;
            tailEven = p;
            p = p.next;
            tailEven.next = null;
        }
        tailOdd.next = even.next;
        return odd.next;
    }

    public static ListNode getOddListNode(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head, dummy = new ListNode(), tail = dummy;
        while (p != null) {
            tail.next = p;
            tail = p;
            p = p.next;
            if (p != null) {
                p = p.next;
            } else {
                break;
            }
        }
        return dummy.next;
    }

    public static ListNode getEvenListNode(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode p = head.next, dummy = new ListNode(), tail = dummy;
        while (p != null) {
            tail.next = p;
            tail = p;
            p = p.next;
            if (p.next != null) {
                p = p.next;
            } else {
                break;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ListNode head = ListNode.convert(nums);
        ListNode.printList(head);
        LeetCodeNum328 lc = new LeetCodeNum328();
//        ListNode odd = getOddListNode(head);
//        ListNode.printList(odd);
//        ListNode even = getEvenListNode(head);
//        ListNode.printList(even);
        ListNode newHead = lc.oddEvenList(head);
        ListNode.printList(newHead);
    }
}
