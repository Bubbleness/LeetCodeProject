package com.example.leetcode.listnode.middle;

import com.example.leetcode.common.ListNode;

import java.util.List;

/**
 * @author shuiyu
 */
public class LeetCodeNum143 {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode fast = head, slow = head, pre = null, l1, l2;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        // 奇数个节点
        if (fast != null) {
            l1 = head;
            l2 = slow.next;
            slow.next = null;
            head = merge(l1, l2);
        } else {
            // 偶数个节点
            l1 = head;
            l2 = slow;
            pre.next = null;
            head = merge(l1, l2);
        }
    }

    public static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        ListNode head = new ListNode(), cur = head;
        ListNode l3 = reverse(l2);
        while (l1 != null && l3 != null) {
            cur.next = l1;
            l1 = l1.next;
            cur = cur.next;

            cur.next = l3;
            l3 = l3.next;
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        return head.next;
    }

    public static ListNode reverse(ListNode ln) {
        if (ln == null || ln.next == null) {
            return ln;
        }
        ListNode pre = null, p = ln, q = null;
        while (p != null) {
            q = p.next;
            p.next = pre;
            pre = p;
            p = q;
        }
        return pre;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5};
        ListNode head = ListNode.convert(nums);
        ListNode.printList(head);
//        ListNode.printList(reverse(head));
        LeetCodeNum143 lc = new LeetCodeNum143();
        lc.reorderList(head);
        ListNode.printList(head);
    }
}
