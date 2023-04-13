package com.example.leetcode.listnode.easy;

import com.example.leetcode.common.ListNode;

/**
 * @author shuiyu
 */
public class LeetCodeNum21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

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

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3, 7, 9};
        int[] nums2 = new int[]{1, 4, 5};
        ListNode list1 = ListNode.convert(nums1);
        ListNode list2 = ListNode.convert(nums2);

        LeetCodeNum21 lc = new LeetCodeNum21();
        ListNode res = lc.mergeTwoLists(list1, list2);
        ListNode.printList(res);
    }
}
