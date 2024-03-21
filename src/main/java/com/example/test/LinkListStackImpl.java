package com.example.test;

/**
 * @author shuiyu
 * @date 2024/03/20
 */
public class LinkListStackImpl {

    LinkNode head;
    int stackMaxSize;
    int stackTempSize;

    public LinkListStackImpl(int stackSize) {
        this.head = null;
        this.stackMaxSize = stackSize;
        this.stackTempSize = 0;
    }


    public boolean isFull() {
        return stackTempSize >= stackMaxSize;
    }

    public boolean isEmpty() {
        return stackTempSize == 0;
    }


    /**
     * 使用链表头插法
     */
    public void push(int num) {

        if (isFull()) {
            throw new RuntimeException("栈满了");
        }

       LinkNode node = new LinkNode(num, null);
       // 把新节点插入在链表头部
       node.next = head;
       // 链表头指针指向当前节点
       head = node;
       stackTempSize++;
    }

    /**
     * 出栈头节点
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空了");
        }
        int res = head.data;
        head = head.next;
        stackTempSize--;
        return res;
    }

    public void printStack() {
        LinkNode p = head;

        if (p == null) {
            System.out.println("栈空了");
        }

        while (p != null) {
            System.out.print(p.data);
            p = p.next;

            if (p != null) {
                System.out.print(" -> ");
            }
        }
    }

    public static void main(String[] args) {
        LinkListStackImpl lls = new LinkListStackImpl(5);

        lls.push(1);
        lls.push(2);
        lls.push(3);
        lls.push(4);
        lls.push(5);

        lls.printStack();

        int res1 = lls.pop();
        System.out.println();
        System.out.println("res1 = " + res1);

        lls.printStack();

        int res2 = lls.pop();
        System.out.println();
        System.out.println("res2 = " + res2);

        int res3 = lls.pop();
        System.out.println();
        System.out.println("res3 = " + res3);

        lls.printStack();

    }
}

class LinkNode {
    int data;
    LinkNode next;

    public LinkNode(int data, LinkNode next) {
        this.data = data;
        this.next = next;
    }
}
