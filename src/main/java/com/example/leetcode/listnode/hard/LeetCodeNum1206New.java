package com.example.leetcode.listnode.hard;

import java.util.Random;

/**
 * @author shuiyu
 */
public class LeetCodeNum1206New {

    static class Skiplist {

        public int level;
        public SkipNode dummy;
        public Random random;

        public Skiplist() {
            this.level = 10;
            this.dummy = new SkipNode(-1, level);
            this.random = new Random();
        }

        public boolean search(int target) {
            SkipNode[] lastSkipNodes = new SkipNode[level];
            findTargetSkipNode(target, lastSkipNodes);
            return lastSkipNodes[0].next[0] != null && lastSkipNodes[0].next[0].val == target;
        }

        public void add(int num) {

            SkipNode[] lastSkipNodes = new SkipNode[level];
            findTargetSkipNode(num, lastSkipNodes);

            SkipNode skipNode = new SkipNode(num, level);
            for (int i=0; i<level; i++) {
                skipNode.next[i] = lastSkipNodes[i].next[i];
                lastSkipNodes[i].next[i] = skipNode;
                if (random.nextInt(2) == 0) {
                    break;
                }
            }
        }

        public boolean erase(int num) {
            SkipNode[] lastSkipNodes = new SkipNode[level];
            findTargetSkipNode(num, lastSkipNodes);

            SkipNode skipNode = lastSkipNodes[0].next[0];
            if (lastSkipNodes[0].next[0] == null || lastSkipNodes[0].next[0].val != num) {
                return false;
            }
            for (int i=0; i<level && lastSkipNodes[i].next[i] == skipNode; i++) {
                lastSkipNodes[i].next[i] = lastSkipNodes[i].next[i].next[i];
            }
            return true;
        }

        public void findTargetSkipNode(int target, SkipNode[] lastSkipNodes) {

            SkipNode cur = dummy;
            for (int i=level-1; i>=0; i--) {
                // 依次遍历每一层的链表
                while (cur.next[i] != null && cur.next[i].val < target) {
                    // 指针往后移动 找小于target值的最后一个节点
                    cur = cur.next[i];
                }
                // 记录每一层严格小于target
                lastSkipNodes[i] = cur;
            }
        }
    }

    static class SkipNode{
        // 跳表节点
        public int val;
        public SkipNode[] next;

        public SkipNode(int val, int level) {
            this.val = val;
            this.next = new SkipNode[level];
        }
    }
}
