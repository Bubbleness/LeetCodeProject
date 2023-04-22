package com.example.leetcode.listnode.easy;

import com.example.leetcode.common.ListNode;

/**
 * @author shuiyu
 */
public class LeetCodeNum705 {

    class MyHashSet {

        public ListNode hashSet;

        public MyHashSet() {
            this.hashSet = new ListNode();
        }

        public void add(int key) {

            if (contains(key)) {
                return;
            }
            ListNode p = hashSet.next;
            if (p == null) {
                hashSet.next = new ListNode(key);
                return;
            }

            while (p.next != null) {
                p = p.next;
            }
            p.next = new ListNode(key);
        }

        public void remove(int key) {

            if (!contains(key)) {
                return;
            }

            if (hashSet.next.val == key) {
                hashSet.next = hashSet.next.next;
                return;
            }
            ListNode p = hashSet.next, pre = null, q = null;
            while (p != null) {
                if (p.val == key) {
                    pre.next = p.next;
                    return;
                }
                pre = p;
                p = p.next;
            }
        }

        public boolean contains(int key) {
            if (hashSet.next == null) {
                return false;
            }
            ListNode p = hashSet.next;
            while (p != null) {
                if (p.val == key) {
                    return true;
                }
                p = p.next;
            }
            return false;
        }
    }


}
