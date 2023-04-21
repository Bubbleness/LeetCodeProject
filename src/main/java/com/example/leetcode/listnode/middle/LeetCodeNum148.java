package com.example.leetcode.listnode.middle;

import com.example.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shuiyu
 */
public class LeetCodeNum148 {

    // 解法一：投机取巧
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        List<Integer> list = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        list = list.stream().sorted().collect(Collectors.toList());
        p = head;
        int i = 0;
        while (p != null) {
            p.val = list.get(i);
            i++;
            p = p.next;
        }
        return head;
    }

    // 解法二：插入排序（会超时）
    public ListNode sortList2(ListNode head) {

        // 简单插入排序 （会超时）
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        ListNode tail = dummy, pre = null, p = null, cur = null;
        while (head != null) {
            cur = head.next;
            head.next = null;
            if (dummy.next == null) {
                tail.next = head;
                tail = tail.next;
            } else {
                p = dummy.next;
                pre = dummy;
                while (p != tail.next) {
                    if (head.val > p.val) {
                        pre = p;
                        p = p.next;
                    } else {
                        pre.next = head;
                        head.next = p;
                        break;
                    }
                }
                if (p == tail.next) {
                    pre.next = head;
                    tail = tail.next;
                }
            }
            head = cur;
        }
        return dummy.next;
    }

    public ListNode sortList3(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        return merge(head);

    }

    public static ListNode merge(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 问题的关键在于让fast先走两步
        ListNode fast = head.next.next, slow = head, mid = null, rightStart = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        mid = slow;
        rightStart = mid.next;
        mid.next = null;
        ListNode left = merge(head);
        ListNode right = merge(rightStart);
        return mergeTwoListNode(left, right);
    }

    public static ListNode mergeTwoListNode(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(), tail = dummy;
        ListNode p1 = l1, p2 = l2;
        while (p1 != null && p2 != null) {

            if (p1.val <= p2.val) {
                tail.next = p1;
                tail = p1;
                p1 = p1.next;
            } else {
                tail.next = p2;
                tail = p2;
                p2 = p2.next;
            }
        }

        while (p1 != null) {
            tail.next = p1;
            tail = p1;
            p1 = p1.next;
        }

        while (p2 != null) {
            tail.next = p2;
            tail = p2;
            p2 = p2.next;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        int[] nums = new int[] {2, 4, 1, 6, 4, 7, 3};
        ListNode head = ListNode.convert(nums);

        LeetCodeNum148 lc = new LeetCodeNum148();
        ListNode newHead = lc.sortList3(head);
        ListNode.printList(newHead);
    }
}
