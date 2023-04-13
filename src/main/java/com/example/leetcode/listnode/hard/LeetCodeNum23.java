package com.example.leetcode.listnode.hard;

import com.example.leetcode.common.ListNode;

/**
 * @author shuiyu
 */
public class LeetCodeNum23 {

    /**
     * 考点：递归分治法、二路归并排序
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length-1);
    }

    public static ListNode merge(ListNode[] listNodes, int start, int end) {

        // 链表数组里面只有一条链表 -> 直接返回
        if (start == end) {
            return listNodes[start];
        }
        if (start > end) {
            return null;
        }
        int mid = (start + end) >> 1;
        ListNode mergeLeft = merge(listNodes, start, mid);
        ListNode mergeRight = merge(listNodes, mid+1, end);
        return mergeTwoLists(mergeLeft, mergeRight);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode p1 = list1, p2 = list2, res = new ListNode(), head = res;

        while (p1 != null && p2 != null) {

            if (p1.val <= p2.val) {
                res.next = p1;
                res = p1;
                p1 = p1.next;
            } else {
                res.next = p2;
                res = p2;
                p2 = p2.next;
            }
        }

        if (p1 != null) {
            res.next = p1;
        }

        if (p2 != null) {
            res.next = p2;
        }
        return head.next;
    }
}
