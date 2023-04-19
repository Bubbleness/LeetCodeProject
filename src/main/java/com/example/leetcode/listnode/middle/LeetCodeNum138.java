package com.example.leetcode.listnode.middle;

import com.example.leetcode.common.Node2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shuiyu
 */
public class LeetCodeNum138 {

    Map<Node2, Node2> allreadyCreated = new HashMap<>();

    public Node2 copyRandomList(Node2 head) {

        if (head == null) {
            return null;
        }
        // 问题难点在于如何处理random的复制和连接 -> 可以记录相对位置
        //解法一：针对每一个节点，都创建一个拷贝节点连接在当前节点的后面
        // A -> A' -> B -> B' -> C -> C' -> NULL
        Node2 p = head, q;
        while (p != null) {
            q = p.next;
            Node2 copyQ = new Node2(p.val);
            p.next = copyQ;
            copyQ.next = q;
            p = q;
        }

        p = head;
        while (p != null) {
            Node2 curNew = p.next;
            if (p.random != null) {
                curNew.random = p.random.next;
            } else {
                curNew.random = null;
            }
            p = curNew.next;
        }

        // 注意： 这里除了要保证新链表的指针准确，还要保证原来的旧链表指针准确
        Node2 headNew = head.next;
        p = head;
        while (p != null) {
            q = p.next;
            // 移动旧的链表指针 （就链表不用考虑空指针问题）
            p.next = p.next.next;
            // 移动新的链表指针
            q.next = (q.next != null) ? q.next.next : null;
            p = p.next;
        }
        return headNew;
    }

    // 解法二：回溯 + Map标记
    // 当前节点已经创建，则添加到Map，没有创建则创建，同时递归去创建next和random节点
    public Node2 copyRandomList2(Node2 head) {

        if (head == null) {
            return null;
        }

        if (!allreadyCreated.containsKey(head)) {
            // 当前的head节点还没有创建
            Node2 newHead = new Node2(head.val);
            // 对于已经创建的节点加入缓存
            allreadyCreated.put(head, newHead);
            // 先递归创建当前节点的next节点
            newHead.next = copyRandomList2(head.next);
            // 再递归创建当前节点的random节点
            newHead.random = copyRandomList2(head.random);
        }
        return allreadyCreated.get(head);
    }

    public static int getLength(Node2 head) {
        if (head == null) {
            return 0;
        }
        Node2 p = head;
        int len = 1;
        while (p != null) {
            p = p.next;
            len++;
        }
        return len;
    }
}
