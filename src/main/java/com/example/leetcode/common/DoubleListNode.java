package com.example.leetcode.common;

/**
 * @author shuiyu
 * @description 自定义双链表节点
 */
public class DoubleListNode {

    public int val;
    public DoubleListNode next;
    public DoubleListNode prev;

    public DoubleListNode() {
    }

    public DoubleListNode(int val) {
        this.val = val;
    }

    public DoubleListNode(int val, DoubleListNode next, DoubleListNode prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}
