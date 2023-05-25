package com.example.leetcode.tree.easy;

import com.example.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author shuiyu
 */
public class LeetCodeNum94 {

    /**
     * 思路1：递归写法（中序遍历）
     */
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
//        inorder(root, list);
        inorderNoRecursion(root, list);
        return list;
    }

    public static void inorder(TreeNode root, List<Integer> array) {

        if (root == null) {
            return;
        }
        // 先遍历左子树
        inorder(root.left, array);
        // 处理逻辑
        array.add(root.val);
        // 遍历右子树
        inorder(root.right, array);
    }

    /**
     * 思路2: 非递归形式
     */
    public static void inorderNoRecursion(TreeNode root, List<Integer> nodeValueList) {

        if (root == null) {
            return;
        }
        TreeNode tempRoot = root;
        Stack<TreeNode> stack = new Stack<>();

        // 1. 节点不为空 或者 栈不空时循环
        while (tempRoot != null || !stack.isEmpty()) {
            // 2. 若节点不为空 入栈全部的左子树节点
            if (tempRoot != null) {
                stack.push(tempRoot);
                tempRoot = tempRoot.left;
            } else {
                // 3. 若节点为空 出栈栈顶节点并访问 同时指针指向节点右孩子
                TreeNode tempNode = stack.pop();
                nodeValueList.add(tempNode.val);
                tempRoot = tempNode.right;
            }
        }
    }
}
