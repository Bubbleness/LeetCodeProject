package com.example.leetcode.listnode.hard;

import org.w3c.dom.css.CSSStyleRule;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author shuiyu
 */
public class LeetCodeNum432 {

    static class AllOne {

        Map<String, DoubleListNode> markMap;
        DoubleListNode head, tail;

        public AllOne() {
            markMap = new HashMap<>();
            head = new DoubleListNode("");
            tail = new DoubleListNode("");
            head.next = tail;
            tail.prev = head;
        }

        public void inc(String key) {

            if (!markMap.containsKey(key)) {
                // 当前的key还没有插入到链表
                DoubleListNode insertNode = new DoubleListNode(key, 1);
                // 插入到双链表的表头
                insertToHead(insertNode);
                // 添加缓存
                markMap.put(key, insertNode);
            } else {
                // 当前key已经在链表中
                DoubleListNode existNode = markMap.get(key);
                existNode.cnt++;
                DoubleListNode p = existNode.next, pre = existNode;
                if (p == tail || p.cnt >= existNode.cnt) {
                    return;
                }
                while (p != tail && p.cnt < existNode.cnt) {
                    pre = p;
                    p = p.next;
                }

                // 说明已经移动到了尾巴（原本不在尾部）
                // 插入在 pre 和 p之间
                removeNode(existNode);
                existNode.next = p;
                p.prev = existNode;
                pre.next = existNode;
                existNode.prev = pre;
            }
        }

        public void dec(String key) {

            if (markMap.containsKey(key)) {
                DoubleListNode existNode = markMap.get(key);
                if (existNode.cnt == 1) {
                    // 直接删掉改节点
                    removeNode(existNode);
                    markMap.remove(key);
                } else {
                    // 当前节点的cnt大于1 cnt--后要移动位置
                    existNode.cnt--;
                    DoubleListNode pre = existNode.prev, p = existNode;
                    if (pre == head || pre.cnt <= existNode.cnt) {
                        return;
                    }
                    while (pre != head && pre.cnt > existNode.cnt) {
                        p = pre;
                        pre = pre.prev;
                    }
                    // 原本不在头部 但是移动到了头部
                    // 插入在pre和p之间
                    removeNode(existNode);
                    existNode.next = p;
                    p.prev = existNode;
                    pre.next = existNode;
                    existNode.prev = pre;
                }
            }
        }

        public String getMaxKey() {
            return tail.prev.string;
        }

        public String getMinKey() {
            return head.next.string;
        }

        public void insertToHead(DoubleListNode node) {

            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
        }

        public void removeNode(DoubleListNode node) {

            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
        }

        public void print(DoubleListNode head) {
            DoubleListNode p = head;
            while (p != tail) {
                System.out.print(p.string+"_"+p.cnt + " -> ");
                p = p.next;
            }
            System.out.println();
        }


        public static void main(String[] args) {
            AllOne obj = new AllOne();
            obj.inc("a");
            obj.inc("b");
            obj.inc("b");
            obj.inc("c");
            obj.inc("c");
            obj.dec("c");
            obj.dec("b");
            obj.dec("b");
            obj.dec("a");
            System.out.println("max key : " + obj.getMaxKey());
            System.out.println("min key : " + obj.getMinKey());
        }
    }

    static class DoubleListNode {
        public String string;
        public Integer cnt ;
        public DoubleListNode next;
        public DoubleListNode prev;

        public DoubleListNode() {
        }

        public DoubleListNode(String string) {
            this.string = string;
        }

        public DoubleListNode(String string, Integer cnt) {
            this.string = string;
            this.cnt = cnt;
        }
    }
}
