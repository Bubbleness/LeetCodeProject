package com.example.leetcode.tree.middle;

import com.example.leetcode.common.Node;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shuiyu
 */
public class LeetCodeNum116 {

    public Node connect(Node root) {

        if (root == null) {
            return null;
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 1));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (!queue.isEmpty() && pair.height == queue.peek().height) {
                pair.node.next = queue.peek().node;
            } else {
                pair.node.next = null;
            }
            if (pair.node.left != null) {
                queue.offer(new Pair(pair.node.left, pair.height+1));
            }
            if (pair.node.right != null) {
                queue.offer(new Pair(pair.node.right, pair.height+1));
            }
        }
        return root;
    }

    /**
     * 解法二 ： 优化空间复杂度 和 时间复杂度
     */
    public Node connect2(Node root) {

        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                Node tempNode = queue.poll();
                if (i < size-1) {
                    tempNode.next = queue.peek();
                }
                if (tempNode.left != null) {
                    queue.offer(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.offer(tempNode.right);
                }
            }
        }
        return root;
    }

    static class Pair{

        public Node node;
        public int height;

        public Pair(Node node, int height) {
            this.node = node;
            this.height = height;
        }

        public Pair() {
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        LeetCodeNum116 lc = new LeetCodeNum116();
        Node res = lc.connect(root);

    }
}
