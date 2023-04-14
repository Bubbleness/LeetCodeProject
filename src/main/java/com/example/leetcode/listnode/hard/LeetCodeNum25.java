package com.example.leetcode.listnode.hard;

import com.example.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shuiyu
 */
public class LeetCodeNum25 {

    /**
     * 耗时一个多小时，时间太长了
     * <p>
     * 思路一：暴力求解，按照k来划分链表，每一段的长度 <= k，然后遍历切割后的链表，依次进行反转和连接
     * 思路二：递归法，每次遍历k个节点，进行翻转和连接，然后递归遍历后面的节点
     */
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }
        List<ListNode> list = getListNodeArr(head, k);
        ListNode res = new ListNode();
        ListNode newHead = res;
        for (int i = 0; i < list.size(); i++) {
            ListNode pre = list.get(i);
            int tempLength = getListNodeLength(pre);
            if (tempLength == k) {
                res.next = reverseOneListNode(list.get(i));
            } else {
                res.next = list.get(i);
            }
            res = pre;
            //pre.next = reverseOneListNode(list.get(i+1))；
        }
        return newHead.next;
    }

    // 解法一：暴力破解
    public static List<ListNode> getListNodeArr(ListNode ln, int k) {

        if (ln == null) {
            return new ArrayList<>();
        }
        List<ListNode> res = new ArrayList<>();
        int length = getListNodeLength(ln);
        if (length <= k) {
            res.add(ln);
            return res;
        }

        ListNode p = ln, head = ln, tail = null;
        int index = 1;
        while (p != null && p.next != null) {
            p = p.next;
            index++;
            if (index == k) {
                index = 1;
                tail = p.next;
                p.next = null;
                res.add(head);
                head = tail;
                p = tail;
            }
        }
        res.add(head);
        return res;
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

    public static ListNode reverseOneListNode(ListNode ln) {
        if (ln == null || ln.next == null) {
            return ln;
        }
        ListNode p = ln, pre = null, tail = p.next;

        while (tail != null) {
            p.next = pre;
            pre = p;
            p = tail;
            tail = p.next;
        }
        p.next = pre;
        return p;
    }


    // 解法二：递归
    public ListNode reverseKGroup2(ListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        for (int i=0; i<k; i++) {
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }
        ListNode temp = reverseListNode(head, tail);
        head.next = reverseKGroup2(tail, k);
        return temp;
    }

    /**
     * 翻转head链表从start节点开始到end节点前的链表 [start, end)
     */
    public ListNode reverseListNode(ListNode head, ListNode tail) {

        ListNode pre = null, p = head, q = null;
        while (p != tail) {
            q = p.next;
            p.next = pre;
            pre = p;
            p = q;
        }
        return pre;
    }

    public static ListNode reverseMerge(List<ListNode> lists, int start, int end, int k) {
        if (start == end) {
            return lists.get(start);
        }
        if (start > end) {
            return null;
        }
        int mid = (start + end) >> 1;
        ListNode left = reverseMerge(lists, start, mid, k);
        ListNode right = reverseMerge(lists, mid + 1, end, k);
        return merge(left, right, k);
    }

    public static ListNode merge(ListNode l1, ListNode l2, int k) {

        if (l1 == null && l2 == null) {
            return null;
        }
        int len1 = getListNodeLength(l1);
        int len2 = getListNodeLength(l2);
        if (l1 == null) {
            if (len2 < k) {
                return l2;
            } else {
                return reverseOneListNode(l2);
            }
        }
        if (l2 == null) {
            if (len1 < k) {
                return l1;
            } else {
                return reverseOneListNode(l1);
            }
        }

        ListNode reverseL1 = reverseOneListNode(l1);
        l1.next = reverseOneListNode(l2);
        return reverseL1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int k = 3;
        ListNode ln = ListNode.convert(nums);
        ListNode.printList(ln);

        LeetCodeNum25 lc = new LeetCodeNum25();
//        List<ListNode> res = getListNodeArr(ln, k);
//        for (ListNode item : res) {
//            ListNode.printList(item);
//
//        }
//
//        System.out.println("============");

//        ListNode lll = lc.reverseKGroup2(ln, k);
//        ListNode.printList(lll);
    }
}
