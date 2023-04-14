package com.example.leetcode.listnode.middle;

import com.example.leetcode.common.ListNode;

/**
 * @author shuiyu
 */
public class LeetCodeNum24 {

    /**
     * 思路很快就能想到，但是总体的耗时有点长
     * 总结一下问题：边界问题没有思考清除，这一类问题的难点就在于如何去把边界思考清除
     */
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head, p = head.next, preTail = null, tail = null, res = head.next;
        if (p.next != null) {
            preTail = p.next;
            if (preTail.next != null) {
                tail = preTail.next;
            } else {
                // 链表只有三个节点
                p.next = pre;
                pre.next = preTail;
                return res;
            }
        } else {
            // 链表只有两个节点
            p.next = pre;
            pre.next = null;
            return res;
        }

        while (p != null) {

            p.next = pre;
            pre.next = tail;
            p = tail;
            if (p == null) {
                break;
            }
            pre = preTail;

            // 移动tail和preTail指针
            if (tail.next == null) {
                preTail = null;
                tail = null;
                continue;
            }

            preTail = tail.next;
            tail = preTail.next;
        }

        if (preTail != null) {
            pre.next = preTail;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        ListNode ln = ListNode.convert(nums);
        ListNode.printList(ln);

        LeetCodeNum24 lc = new LeetCodeNum24();
        ListNode res = lc.swapPairs(ln);
        ListNode.printList(res);

    }
}
