package com.example.leetcode.listnode.easy;

import com.example.leetcode.common.ListNode;

import java.util.Stack;

/**
 * @author shuiyu
 */
public class LeetCodeNum234 {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            stack.push(slow.val);
            slow = slow.next;
        }

        if (fast != null) {
            // 奇数
            slow = slow.next;
        }
        while (slow != null) {
            if (slow.val == stack.peek()) {
                stack.pop();
            }
            slow = slow.next;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 1};
        ListNode head = ListNode.convert(nums);
        LeetCodeNum234 lc = new LeetCodeNum234();
        boolean flag = lc.isPalindrome(head);
        if (flag) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
