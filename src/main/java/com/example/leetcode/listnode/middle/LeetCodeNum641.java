package com.example.leetcode.listnode.middle;

import com.example.leetcode.common.DoubleListNode;
import com.example.leetcode.common.ListNode;

/**
 * @author shuiyu
 */
public class LeetCodeNum641 {

    static class MyCircularDeque {

        DoubleListNode doubleCircleQueue, front, tail;

        public MyCircularDeque(int k) {
            this.doubleCircleQueue = new DoubleListNode(-1);
            // front始终指向空节点
            front = doubleCircleQueue;
            tail = front;
            DoubleListNode p = doubleCircleQueue;
            while (k > 0) {
                p.next = new DoubleListNode(-1);
                p.next.prev = p;
                p = p.next;
                k--;
            }
            p.next = front;
            front.prev = p;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            front.val = value;
            front = front.prev;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            tail = tail.next;
            tail.val = value;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            front.next.val = -1;
            front = front.next;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            tail.val = -1;
            tail = tail.prev;
            return true;
        }

        public int getFront() {
            return front.next.val;
        }

        public int getRear() {
            return tail.val;
        }

        public boolean isEmpty() {
            if (front == tail) {
                return true;
            }
            return false;
        }

        public boolean isFull() {
            if (tail.next == front) {
                return true;
            }
            if (front.prev == tail) {
                return true;
            }
            return false;
        }

        public static void main(String[] args) {
            MyCircularDeque deque = new MyCircularDeque(3);
            print(deque.insertLast(1));
            print(deque.insertLast(2));
            print(deque.insertFront(3));
            print(deque.insertFront(4));
            deque.printQueue();
            System.out.println("tail -> " + deque.getRear());
            print(deque.isFull());
            print(deque.deleteLast());
            print(deque.insertFront(4));
            System.out.println("front -> " + deque.getFront());

        }

        public static void print(Boolean flag) {
            if (flag) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }

        public void printQueue() {
            DoubleListNode p = front.next;
            while (p != tail) {
                System.out.print(p.val + " -> ");
                p = p.next;
            }
            System.out.print(p.val);
            p = p.next;
            System.out.print(" -> " + p.val);
            p = p.next;
            System.out.print(" -> " + p.val);
            p = p.next;
            System.out.print(" -> " + p.val);
            p = p.next;
            System.out.print(" -> " + p.val);
            p = p.next;
            System.out.print(" -> " + p.val);
            p = p.next;
            System.out.print(" -> " + p.val);
            p = p.next;
            System.out.print(" -> " + p.val);
            System.out.println();
        }
    }
}
