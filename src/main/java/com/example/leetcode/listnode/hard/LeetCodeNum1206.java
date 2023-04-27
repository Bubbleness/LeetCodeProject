package com.example.leetcode.listnode.hard;

import java.util.Random;

/**
 * @author shuiyu
 */
public class LeetCodeNum1206 {

    static class Skiplist {

        public int level;
        public Random random;
        public SkipNode dummy;

        public Skiplist() {
            this.level = 10;
            this.random = new Random();
            this.dummy = new SkipNode(-1, level);
        }

        public boolean search(int target) {

            // 每一层严格小于num的最后一个节点
            SkipNode[] lastSkipNodes = new SkipNode[level];
            findSkipNode(target, lastSkipNodes);
            // lastSkipNodes[0].next[0]表示最底层的严格小于target值的节点
            // 如果该节点的下一个节点的值等于target则查找成功
            return lastSkipNodes[0].next[0] != null
                    && lastSkipNodes[0].next[0].val == target;
        }

        public void add(int num) {

            // 每一层严格小于num的最后一个节点
            SkipNode[] lastSkipNodes = new SkipNode[level];
            findSkipNode(num, lastSkipNodes);
            // 创建出要插入的节点
            SkipNode skipNode = new SkipNode(num, level);
            for (int i=0; i<level; i++) {
                // lastSkipNodes[i]表示第i层上严格小于num的最后一个节点
                // 待插入的节点skipNode应该插入在 lastSkipNodes[i] 和 lastSkipNodes[i].next[i] 之间
                skipNode.next[i] = lastSkipNodes[i].next[i];
                lastSkipNodes[i].next[i] = skipNode;
                // 随机来决定构建几层
                if (random.nextInt(2) == 0) {
                    break;
                }
            }
        }

        public boolean erase(int num) {

            // 每一层严格小于num的最后一个节点
            SkipNode[] lastSkipNodes = new SkipNode[level];
            findSkipNode(num, lastSkipNodes);
            // 要删除节点，从最下层开始往上找
            // 第一层（最底层）严格小于num的最后一个节点
            SkipNode skipNode = lastSkipNodes[0].next[0];
            // 第一层没有节点比num小 或者 当前节点不在跳表里面 则不用处理
            if (skipNode == null || skipNode.val != num) {
                return false;
            }
            // lastSkipNodes[i]为小于num的最后一个节点，lastSkipNodes[i].next[i] >= num
            // 注意判断的条件：是判断节点的引用是否相同，不是判断值是否相同
            for (int i=0; i<level && lastSkipNodes[i].next[i]==skipNode; i++) {
                // 如果lastSkipNodes[i].next[i] == num
                // 则需要删除 lastSkipNodes[i].next[i]
                lastSkipNodes[i].next[i] = lastSkipNodes[i].next[i].next[i];
            }
            return true;
        }

        /**
         * 查找值为target的跳表节点
         *
         * @param target        目标值
         * @param lastSkipNodes 保存每一层严格比target小的最后一个节点，lastSkipNodes[i]为level=i层严格比target小的最后一个节点
         */
        public void findSkipNode(int target, SkipNode[] lastSkipNodes) {

            // dummy为空的头节点
            SkipNode cur = dummy;
            // 查找值等于num的节点 从最上层开始往下找
            for (int i=level-1; i>=0; i--) {
                // 遍历每一层的单链表 直到走到每一层严格小于num值的最后一个节点
                while (cur.next[i] != null && cur.next[i].val < target) {
                    cur = cur.next[i];
                }
                lastSkipNodes[i] = cur;
            }
        }
    }

    static class SkipNode {
        int val;
        SkipNode[] next;

        public SkipNode(int val) {
            this.val = val;
        }

        public SkipNode(int val, int level) {
            this.val = val;
            this.next = new SkipNode[level];
        }
    }
}


