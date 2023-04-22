package com.example.leetcode.listnode.middle;

import java.util.List;

/**
 * @author shuiyu
 */
public class LeetCodeNum430 {

    public Node flatten(Node head) {
        dfs(head);
        return head;

    }

    public static Node dfs(Node head) {
        Node pre = head;
        while (head != null) {
            if (head.child == null) {
                pre = head;
                head = head.next;
            } else {
                Node next = head.next;
                Node childList = dfs(head.child);
                head.next = head.child;
                head.child.prev = head;
                head.child = null;
                if (childList != null) {
                    childList.next = next;
                }
                if (next != null) {
                    next.prev = childList;
                }
                pre = head;
                head = childList;
            }
        }
        return pre;
    }
}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}
