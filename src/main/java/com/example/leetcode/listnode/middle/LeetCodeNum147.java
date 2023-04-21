package com.example.leetcode.listnode.middle;

import com.example.leetcode.common.ListNode;

import java.util.List;

/**
 * @author shuiyu
 */
public class LeetCodeNum147 {

    // 解法一：指针模拟解法
    public ListNode insertionSortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(), cur = null, tail = dummy, p = null, pre = null;
        while (head != null) {
            cur = head.next;
            // 及时断链，当时出现循环链表
            head.next = null;
            // 特殊处理当前dummy还没有节点的情况
            if (dummy.next == null) {
                tail.next = head;
                tail = tail.next;
            } else {
                p = dummy.next;
                pre = dummy;
                // 查找新节点的插入位置
                while (p != tail.next) {
                    if (head.val > p.val) {
                        pre = p;
                        p = p.next;
                    } else {
                        // 找到插入位置就插入
                        pre.next = head;
                        head.next = p;
                        break;
                    }
                }
                // 当前插入位置在新链表的最后
                // 除了插入节点到尾部 还要移动tail指针
                // tail 指针只在节点插在尾部时才移动
                if (p == tail.next) {
                    pre.next = head;
                    tail = tail.next;
                }
            }
            head = cur;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3, 5, 2, 7, 4, 6, 1};
        ListNode head = ListNode.convert(nums);
        ListNode.printList(head);

        LeetCodeNum147 lc = new LeetCodeNum147();
        ListNode newHead = lc.insertionSortList(head);
        ListNode.printList(newHead);
    }
}
