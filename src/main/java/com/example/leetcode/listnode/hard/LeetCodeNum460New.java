package com.example.leetcode.listnode.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author shuiyu
 */
public class LeetCodeNum460New {

    static class LFUCache {

        public int capacity, currentSize;
        Map<Integer, Node> nodeMap;
        TreeSet<Node> treeSet;

        public LFUCache(int capacity) {
            this.nodeMap = new HashMap<>();
            this.capacity = capacity;
            this.treeSet = new TreeSet<>();
            this.currentSize = 0;
        }

        public int get(int key) {

            if (!nodeMap.containsKey(key)) {
                return -1;
            }
            Node existNode = nodeMap.get(key);
            treeSet.remove(existNode);
            existNode.cnt++;
            existNode.time = ++currentSize;
            treeSet.add(existNode);
            nodeMap.put(key, existNode);
            return existNode.val;
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            if (!nodeMap.containsKey(key)) {
                // 如果到达缓存容量上限
                if (nodeMap.size() == capacity) {
                    // 从哈希表和平衡二叉树中删除最近最少使用的缓存
                    nodeMap.remove(treeSet.first().key);
                    treeSet.remove(treeSet.first());
                }
                // 创建新的缓存
                Node cache = new Node(key, value, 1, ++currentSize);
                // 将新缓存放入哈希表和平衡二叉树中
                nodeMap.put(key, cache);
                treeSet.add(cache);
            } else {
                // 这里和 get() 函数类似
                Node cache = nodeMap.get(key);
                treeSet.remove(cache);
                cache.cnt += 1;
                cache.time = ++currentSize;
                cache.val = value;
                treeSet.add(cache);
                nodeMap.put(key, cache);
            }
        }
    }

    static class Node  implements Comparable<Node> {
        public Integer key;
        public Integer val;
        public Integer cnt;
        public Integer time;

        public Node() {
        }

        public Node(Integer key, Integer val, Integer cnt, Integer time) {
            this.key = key;
            this.val = val;
            this.cnt = cnt;
            this.time = time;
        }

        public Node(Integer key, Integer val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public int compareTo(Node node) {
            return cnt.equals(node.cnt) ? time - node.time : cnt - node.cnt;
        }

        @Override
        public int hashCode() {
            return cnt * 1000000007 + time;
        }
    }
}
