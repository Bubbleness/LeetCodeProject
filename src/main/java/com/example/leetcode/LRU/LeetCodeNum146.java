package com.example.leetcode.LRU;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shuiyu
 */
public class LeetCodeNum146 {

    /**
     * 设计思路：
     * 1. Map标记key对应的value节点在双链表中的位置
     * 2. put之前先找一下当前节点是否已经在缓存中，如果在的话就移到表头，如果超过长度就删除尾节点
     * 3. get会先找元素，找到了会移到表头，没有找到返回-1
     *
     * 关键点在于：
     *  初始时候构建一个首尾相连的空链表
     *    head -> tail
     *    head <- tail
     */

    class LRUCache {

        public Map<Integer, DoubleWayNode> lruMap;
        public DoubleWayNode head = null, tail = null;
        public int capacity = 0;
        public int currentCapacity = 0;

        public LRUCache(int capacity) {

            this.capacity = capacity;
            this.currentCapacity = 0;
            this.lruMap = new HashMap<>(capacity);
            // 构造一个首尾相连的双向链表
            this.head = new DoubleWayNode();
            this.tail = new DoubleWayNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {

            DoubleWayNode tempNode = lruMap.get(key);
            if (tempNode != null) {
                // 移动当前的key对应的value节点到表头
                moveToHead(tempNode);
                return tempNode.value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            DoubleWayNode tempNode = lruMap.get(key);
            if (tempNode == null) {
                // 当前key不存在，需要插入
                DoubleWayNode newNode = new DoubleWayNode(key, value);
                insertToHead(newNode);
                currentCapacity++;
                lruMap.put(key, newNode);
                if (currentCapacity > capacity) {
                    int tempKey = removeTail().key;
                    lruMap.remove(tempKey);
                    --currentCapacity;
                }
            } else {
                moveToHead(tempNode);
                DoubleWayNode exist = lruMap.get(key);
                exist.value = value;
                //lruMap.put(key, tempNode);
            }
        }

        public DoubleWayNode removeTail() {
            DoubleWayNode temp = tail.prev;
            temp.prev.next = tail;
            tail.prev = temp.prev;
            temp.next = null;
            temp.prev = null;
            return temp;
        }

        public void insertToHead(DoubleWayNode node) {
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
        }

        public void moveToHead(DoubleWayNode value) {

            // 先移除当前value节点
            value.prev.next = value.next;
            value.next.prev = value.prev;
            // 将当前节点插入到表头
            value.next = head.next;
            head.next.prev = value;
            value.prev = head;
            head.next = value;
        }

        // LRU双链表节点
        class DoubleWayNode {

            public int key;
            public int value;
            public DoubleWayNode next;
            public DoubleWayNode prev;

            public DoubleWayNode() {
            }

            public DoubleWayNode(int key, int value) {
                this.key = key;
                this.value = value;
            }

            public DoubleWayNode(int key, int value, DoubleWayNode next, DoubleWayNode prev) {
                this.key = key;
                this.value = value;
                this.next = next;
                this.prev = prev;
            }
        }
    }
}
