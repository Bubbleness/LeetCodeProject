package com.example.leetcode.tree.middle;

import com.example.leetcode.common.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shuiyu
 */
public class LeetCodeNum117 {

    public Node connect(Node root) {

        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            // size表示当前队头节点所在的一层上的所有节点
            int size = queue.size();
            for (int i=0; i<size; i++) {
                Node tempNode = queue.poll();
                // 每一层的最后一个节点不处理
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
}
