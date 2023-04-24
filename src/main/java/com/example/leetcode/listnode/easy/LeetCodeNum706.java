package com.example.leetcode.listnode.easy;


/**
 * @author shuiyu
 */
public class LeetCodeNum706 {

    static class MyHashMap {

        EntryNode head, tail, prev;

        public MyHashMap() {
            this.head = new EntryNode(-1, -1);
            this.tail = head;
            this.prev = head;
        }

        public void put(int key, int value) {

            EntryNode exist = getKeyNode(key);
            if (exist == null) {
                // 新增节点
                tail.next = new EntryNode(key, value);
                tail = tail.next;
            } else {
                // 查找节点并修改
                exist.value = value;
            }
        }

        public int get(int key) {

            EntryNode exist = getKeyNode(key);
            if (exist == null) {
                return -1;
            }
            return exist.value;
        }

        public void remove(int key) {
            EntryNode exist = getKeyNode(key);
            if (exist == null) {
                return;
            }
            if (exist == tail) {
                tail = prev;
            }
            prev.next = exist.next;

//            EntryNode p = head.next, pre = head;
//            while (p != null) {
//                if (p.key == key) {
//                    pre.next = p.next;
//                    return;
//                }
//                pre = p;
//                p = p.next;
//            }
        }

        public EntryNode getKeyNode(int key) {
            if (head.next == null) {
                return null;
            }
            EntryNode p = head.next;
            prev = head;
            while (p != null) {
                if (p.key == key) {
                    return p;
                }
                prev = p;
                p = p.next;
            }
            return null;
        }

        public void print() {
            EntryNode p = head.next;
            while (p != null) {
                System.out.print("("+p.key+","+p.value+") -> ");
                p = p.next;
            }
            System.out.println();
        }

        public static void main(String[] args) {
            MyHashMap hashMap = new MyHashMap();
            hashMap.remove(27);
            hashMap.put(65, 65);
            hashMap.print();
            hashMap.remove(19);
            hashMap.remove(0);
            System.out.println(hashMap.get(18));
            hashMap.remove(3);
            hashMap.put(42, 0);
            hashMap.print();
            System.out.println(hashMap.get(19));
            hashMap.remove(42);
            hashMap.put(17, 90);
            hashMap.print();
            hashMap.put(31, 76);
            hashMap.put(48, 71);
            hashMap.put(5, 50);
            hashMap.put(7, 68);
            hashMap.put(73, 74);
            hashMap.put(85, 18);
            hashMap.put(74, 95);
            hashMap.put(84, 82);
            hashMap.put(59, 29);
            hashMap.put(71, 71);
            hashMap.remove(42);
            hashMap.put(51, 40);
            hashMap.put(33, 76);
            System.out.println(hashMap.get(17));
            hashMap.print();

        }
    }
}

class EntryNode {
    public int key;
    public int value;
    public EntryNode next;

    public EntryNode() {
    }

    public EntryNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}


