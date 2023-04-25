package com.example.leetcode.listnode.middle;

import com.example.leetcode.common.ListNode;

import java.util.List;

/**
 * @author shuiyu
 */
public class LeetCodeNum707 {

    static class MyLinkedList {

//        ListNode head, tail;
//        public MyLinkedList() {
//            this.head = new ListNode(-1);
//            this.tail = head;
//        }
//
//        public int get(int index) {
//
//            ListNode p = head.next;
//            while (index > 0 && p != null) {
//                p = p.next;
//                --index;
//            }
//            if (index > 0 || p == null) {
//                return -1;
//            }
//            return p.val;
//        }
//
//        public void addAtHead(int val) {
//            ListNode newNode = new ListNode(val);
//            newNode.next = head.next;
//            head.next = newNode;
//            moveTail();
//        }
//
//        public void addAtTail(int val) {
//            tail.next = new ListNode(val);
//            tail = tail.next;
//        }
//
//        public void addAtIndex(int index, int val) {
//
//            if (index == 0) {
//                addAtHead(val);
//                return;
//            }
//            ListNode p = head.next, pre = head;
//            while (index > 0 && p != null) {
//                pre = p;
//                p = p.next;
//                index--;
//            }
//            if (index > 0) {
//                return;
//            }
//            if (p == null) {
//                moveTail();
//                addAtTail(val);
//                return;
//            }
//            ListNode newNode = new ListNode(val);
//            pre.next = newNode;
//            newNode.next = p;
//            moveTail();
//        }
//
//        public void deleteAtIndex(int index) {
//            ListNode pre = head, p = head.next;
//            while (index > 0 && p != null) {
//                pre = p;
//                p = p.next;
//                index--;
//            }
//            if (index > 0 || pre.next == null) {
//                return;
//            }
//            pre.next = p.next;
//        }
//
//        public void moveTail() {
//            while (tail.next != null) {
//                tail = tail.next;
//            }
//        }

        int size;
        ListNode head;

        public MyLinkedList() {
            size = 0;
            head = new ListNode(0);
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            ListNode cur = head;
            for (int i = 0; i <= index; i++) {
                cur = cur.next;
            }
            return cur.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            index = Math.max(0, index);
            size++;
            ListNode pred = head;
            for (int i = 0; i < index; i++) {
                pred = pred.next;
            }
            ListNode toAdd = new ListNode(val);
            toAdd.next = pred.next;
            pred.next = toAdd;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            size--;
            ListNode pred = head;
            for (int i = 0; i < index; i++) {
                pred = pred.next;
            }
            pred.next = pred.next.next;
        }


        public static void main(String[] args) {
            MyLinkedList myLinkedList = new MyLinkedList();
            myLinkedList.addAtHead(1);
            myLinkedList.addAtTail(2);
            myLinkedList.addAtTail(3);
            myLinkedList.addAtHead(4);
            myLinkedList.addAtHead(6);
            myLinkedList.addAtTail(5);
            // 打印列表 6 -> 4 -> 1 -> 2 -> 3 -> 5
            ListNode.printList(myLinkedList.head.next);

            myLinkedList.addAtIndex(0, 7);
            // 7 -> 6 -> 4 -> 1 -> 2 -> 3 -> 5
            ListNode.printList(myLinkedList.head.next);

            myLinkedList.addAtIndex(3, 8);
            // 7 -> 6 -> 4 -> 8 -> 1 -> 2 -> 3 -> 5
            ListNode.printList(myLinkedList.head.next);

            myLinkedList.addAtIndex(8, 9);
            // 7 -> 6 -> 4 -> 8 -> 1 -> 2 -> 3 -> 5 -> 9
            ListNode.printList(myLinkedList.head.next);

            myLinkedList.addAtIndex(10, 10);
            ListNode.printList(myLinkedList.head.next);


            System.out.println(myLinkedList.get(0));
            System.out.println(myLinkedList.get(5));
            System.out.println(myLinkedList.get(8));
            System.out.println(myLinkedList.get(10));

            myLinkedList.deleteAtIndex(0);
            ListNode.printList(myLinkedList.head.next);

            myLinkedList.deleteAtIndex(3);
            ListNode.printList(myLinkedList.head.next);

            myLinkedList.deleteAtIndex(6);
            ListNode.printList(myLinkedList.head.next);

            myLinkedList.deleteAtIndex(9);
            ListNode.printList(myLinkedList.head.next);

            myLinkedList.deleteAtIndex(1);
            ListNode.printList(myLinkedList.head.next);

        }
    }
}
