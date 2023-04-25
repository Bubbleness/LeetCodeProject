package com.example.leetcode.listnode.middle;

import com.example.leetcode.common.ListNode;

import java.util.List;

/**
 * @author shuiyu
 */
public class LeetCodeNum725 {

    public ListNode[] splitListToParts(ListNode head, int k) {
        if (head == null) {
            return new ListNode[k];
        }
        int len = getListNodeLength(head);
        if (len < k) {
            return generate(head, k);
        }

        ListNode[] nodes = new ListNode[k];
        int e = len % k;
        int num = len / k;
        int index = 0;
        ListNode tempHead = head, p = head, q = null;
        while (p != null) {
            tempHead = p;
            if (index == k-1) {
                nodes[index] = tempHead;
                break;
            }
            int temp = num;
            if (e > 0) {
                temp++;
                e--;
            }
            while (temp > 1 && p != null) {
                p = p.next;
                --temp;
            }
            if (temp == 1 && p != null) {
                q = p.next;
                p.next = null;
                nodes[index++] = tempHead;
                p = q;
            }
        }
        return nodes;
    }

    public static ListNode[] generate(ListNode head, int k) {
        ListNode[] nodes = new ListNode[k];
        ListNode p = head, q = null;
        int index = 0;
        while (p != null) {
            q = p.next;
            p.next = null;
            nodes[index] = p;
            index++;
            p = q;
        }
        return nodes;
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
        int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ListNode head = ListNode.convert(nums);
        LeetCodeNum725 lc = new LeetCodeNum725();
        ListNode[] nodes = lc.splitListToParts(head, 3);
        for (ListNode node : nodes) {
            ListNode.printList(node);
        }
    }
}
