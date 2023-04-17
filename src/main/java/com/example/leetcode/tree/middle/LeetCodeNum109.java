package com.example.leetcode.tree.middle;

import com.example.leetcode.common.ListNode;
import com.example.leetcode.common.TreeNode;

/**
 * @author shuiyu
 */
public class LeetCodeNum109 {

    /**
     * 链表有序，安中位数插入就行了
     * 对于有序链表找中位数：可以使用快慢指针 （思考一下快慢指针的其他应用）
     */
    public TreeNode sortedListToBST(ListNode head) {

        if (head == null) {
            return null;
        }
        return buildAvlTree(head, null);
    }

    public static TreeNode buildAvlTree(ListNode left, ListNode right) {

        if (left == right) {
            return null;
        }
        ListNode mid = getMiddleNode(left, right);
        TreeNode treeNode = new TreeNode(mid.val);
        treeNode.left = buildAvlTree(left, mid);
        treeNode.right = buildAvlTree(mid.next, right);
        return treeNode;
    }

    public static ListNode getMiddleNode(ListNode left, ListNode right) {

        // 没有中位数
        if (left == right) {
            return null;
        }

        // 搜索链表从left到right的中位数
        // 快慢指针：
        //    1. 奇数个节点，fast会走到right，slow会指向中位数
        //    2. 偶数个节点，fast会走到right的前一个节点，slow会指向中位数
        ListNode slow = left, fast = left;
        while (fast != right && fast.next != right) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
