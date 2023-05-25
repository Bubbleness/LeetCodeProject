package com.example.leetcode.tree.easy;

import com.example.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author shuiyu
 */
public class LeetCodeNum145 {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }

    public static void postOrder(TreeNode root, List<Integer> list) {

        if (root == null) {
            return;
        }
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }

    public static void postOrderNoRecursion(TreeNode root, List<Integer> list) {

        if (root == null) {
            return;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode tempRoot = root;
        stack1.push(tempRoot);

        while (!stack1.isEmpty()) {
            TreeNode tempNode = stack1.pop();
            stack2.push(tempNode);
            if (tempNode.left != null) {
                stack1.push(tempNode.left);
            }
            if (tempNode.right != null) {
                stack1.push(tempNode.right);
            }
        }

        while (!stack2.isEmpty()) {
            TreeNode tempNode = stack2.pop();
            list.add(tempNode.val);
        }
    }
}
