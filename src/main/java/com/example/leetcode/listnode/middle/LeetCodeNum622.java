package com.example.leetcode.listnode.middle;

import com.example.leetcode.common.ListNode;

public class LeetCodeNum622 {

    static class MyCircularQueue {

        ListNode circleQueue, front, tail;

        public MyCircularQueue(int k) {
            this.circleQueue = new ListNode(-1);
            this.front = circleQueue;
            ListNode p = circleQueue;
            while (k > 0) {
                p.next = new ListNode(-1);
                p = p.next;
                k--;
            }
            p.next = circleQueue;
            tail = front;
        }

        public boolean enQueue(int value) {

            // tail始终指向尾节点，先移动指针在插入值
            if (isFull()) {
                return false;
            }
            tail = tail.next;
            tail.val = value;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            // front始终指向一个空的头节点
            // 先出队front后面的节点值
            front.next.val = -1;
            // 再移动指针
            front = front.next;
            return true;
        }

        public int Front() {
            return front.next.val;
        }

        public int Rear() {
            return tail.val;
        }

        public boolean isEmpty() {
            // front始终指向空节点
            if (front == tail) {
                return true;
            }
            return false;
        }

        public boolean isFull() {
            // front指空，tail.next为front时表示满了
            if (tail.next == front) {
                return true;
            }
            return false;
        }

        public void printQueue() {
            ListNode p = front.next;
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

        public static void main(String[] args) {
            MyCircularQueue myCircularQueue = new MyCircularQueue(3);
            print(myCircularQueue.enQueue(1));
            print(myCircularQueue.enQueue(2));
            print(myCircularQueue.enQueue(3));
            print(myCircularQueue.enQueue(4));
            myCircularQueue.printQueue();
            System.out.println("tail -> " + myCircularQueue.Rear());
            print(myCircularQueue.isFull());

            print(myCircularQueue.deQueue());
            myCircularQueue.printQueue();
            print(myCircularQueue.enQueue(4));
            myCircularQueue.printQueue();
            System.out.println("tail -> " + myCircularQueue.Rear());

        }

        public static void print(Boolean flag) {
            if (flag) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }
}
