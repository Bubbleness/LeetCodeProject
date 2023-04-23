package com.example.leetcode.listnode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shuiyu
 */
public class LeetCodeNum460 {

    // 这个方法是：HashMap + 双链表
    // 思路正确，但是时间复杂度高了 会超时
    static class LFUCache {

        public Map<Integer, Node> nodeMap;
        public Node head, tail;
        public int capacity;
        public int currentSize;

        public LFUCache(int capacity) {
            this.nodeMap = new HashMap<>();
            this.head = new Node();
            this.tail = new Node();
            head.next = tail;
            tail.prev = head;
            this.capacity = capacity;
            this.currentSize = 0;

        }

        public int get(int key) {

            if (!nodeMap.containsKey(key)) {
                // 未找到节点
                return -1;
            }
            Node existNode = nodeMap.get(key);
            existNode.cnt++;
            moveToCurrentRight(existNode);
            return existNode.val;
        }

        public void put(int key, int value) {

            if (nodeMap.containsKey(key)) {
                // 更新key的内容
                Node existNode = nodeMap.get(key);
                existNode.val = value;
                existNode.cnt++;
                moveToCurrentRight(existNode);
                return;
            }

            Node insertNode = new Node(key, value, 1);
            if (currentSize == capacity) {
                Node node = removeNode(head.next);
                nodeMap.remove(node.key);
                currentSize--;
            }
            insertToHead(insertNode);
            moveToCurrentRight(insertNode);
            currentSize++;
            nodeMap.put(key, insertNode);
        }

        public void moveToCurrentRight(Node existNode) {
            // 如果当前节点的cnt值增加了 那么需要判断是否要向后移动
            Node p = existNode.next, pre = existNode;
            if (p == tail || existNode.cnt < p.cnt) {
                // 当前节点已经在最后
                // 或者 后面节点的cnt 比 当前节点cnt大
                return;
            }
            // cnt值如果相同，会放在最后
            // 保证相同cnt值的节点，最前面的是要清除的
            while (p != tail && existNode.cnt >= p.cnt) {
                pre = p;
                p = p.next;
            }
            // 在pre和p之间插入当前节点（插入前先删除）
            removeNode(existNode);
            existNode.next = p;
            p.prev = existNode;
            pre.next = existNode;
            existNode.prev = pre;
        }

        public void insertToHead(Node node) {
            // 采用头插法插入节点
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
        }

        public Node removeNode(Node node) {
            // 删除当前节点
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
            return node;
        }

        public static void main(String[] args) {
            LFUCache lfuCache = new LFUCache(3);
            lfuCache.put(1, 1);
            lfuCache.put(2, 2);
            lfuCache.put(3, 3);
            lfuCache.put(4, 4);
            System.out.println(lfuCache.get(4));
            System.out.println(lfuCache.get(3));
            System.out.println(lfuCache.get(2));
            System.out.println(lfuCache.get(1));
            lfuCache.put(5, 5);
            System.out.println(lfuCache.get(1));
            System.out.println(lfuCache.get(2));
            System.out.println(lfuCache.get(3));
            System.out.println(lfuCache.get(4));
            System.out.println(lfuCache.get(5));
        }
    }

    static class Node {
        public Integer key;
        public Integer val;
        public Integer cnt;
        public Node next;
        public Node prev;

        public Node() {
        }

        public Node(Integer key, Integer val, Integer cnt) {
            this.key = key;
            this.val = val;
            this.cnt = cnt;
        }

        public Node(Integer key, Integer val) {
            this.key = key;
            this.val = val;
        }
    }
}
