package com.example.leetcode.listnode.middle;

import com.example.leetcode.common.ListNode;

import java.util.List;
import java.util.Random;

/**
 * @author shuiyu
 */
public class LeetCodeNum382 {

    /**
     * 水塘抽样算法：
     *  从链表头开始，遍历整个链表，对遍历到的第i个节点，随机选择区间 [0,i)中的一个整数，
     *  如果为0，则返回当前节点的值
     *
     *  每个节点被返回的概率为 1/n
     */
    class Solution {

        ListNode head;
        Random random;

        public Solution(ListNode head) {
            this.head = head;
            this.random = new Random();
        }

        public int getRandom() {

            int i = 1 , ans = 0;
            ListNode p = head;
            while (p != null) {
                if (random.nextInt(i) == 0) {
                    ans = p.val;
                }
                p = p.next;
                i++;
            }
            return ans;
        }
    }
}
