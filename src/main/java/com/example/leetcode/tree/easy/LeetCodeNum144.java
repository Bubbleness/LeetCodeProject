package com.example.leetcode.tree.easy;

import com.example.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author shuiyu
 */
public class LeetCodeNum144 {

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
//        preOrderTraversal(root, list);
        preOrderTraversalNoRecursion(root, list);
        return list;
    }


    /**
     * 二叉树前序遍历（递归的写法）
     *
     * @param root 树的根节点
     * @param list 前序遍历结果列表
     */
    public static void preOrderTraversal(TreeNode root, List<Integer> list) {

        if (root == null) {
            return;
        }
        list.add(root.val);
        preOrderTraversal(root.left, list);
        preOrderTraversal(root.right, list);
    }

    /**
     * 二叉树前序遍历（非递归的写法）
     *
     * @param root 树的根节点
     * @param list 前序遍历结果列表
     */
    public static void preOrderTraversalNoRecursion(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> preOrderStack = new Stack<>();
        preOrderStack.push(root);
        while (!preOrderStack.empty()) {
            TreeNode topNode = preOrderStack.pop();
            list.add(topNode.val);
            if (topNode.right != null) {
                preOrderStack.push(topNode.right);
            }
            if (topNode.left != null) {
                preOrderStack.push(topNode.left);
            }
        }
    }
}
