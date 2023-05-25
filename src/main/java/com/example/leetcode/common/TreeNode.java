package com.example.leetcode.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author shuiyu
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 计算树高
     *
     * @param tree 二叉树
     * @return 最大高度
     */
    public static int getTreeHight(TreeNode tree) {
        if (tree == null) {
            return 0;
        }
        if (tree.left == null && tree.right == null) {
            return 1;
        }
        int leftHight = getTreeHight(tree.left);
        int rightHight = getTreeHight(tree.right);
        return leftHight > rightHight ? leftHight + 1 : rightHight + 1;
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
     * 二叉树中序遍历（递归的写法）
     *
     * @param root 树的根节点
     * @param list 中序遍历结果列表
     */
    public static void inOrderTraversal(TreeNode root, List<Integer> list) {

        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, list);
        list.add(root.val);
        inOrderTraversal(root.right, list);
    }


    /**
     * 二叉树后序遍历（递归的写法）
     *
     * @param root 树的根节点
     * @param list 后序遍历结果列表
     */
    public static void postOrderTraversal(TreeNode root, List<Integer> list) {

        if (root == null) {
            return;
        }
        postOrderTraversal(root.left, list);
        postOrderTraversal(root.right, list);
        list.add(root.val);
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


    /**
     * 二叉树中序遍历（非递归的写法）
     *
     * @param root 树的根节点
     * @param list 中序遍历结果列表
     */
    public static void inOrderTraversalNoRecursion(TreeNode root, List<Integer> list) {

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
                list.add(tempNode.val);
                tempRoot = tempNode.right;
            }
        }
    }


    /**
     * 二叉树后序遍历（非递归的写法）
     *
     * @param root 树的根节点
     * @param list 后序遍历结果列表
     */
    public static void postOrderTraversalNoRecursion(TreeNode root, List<Integer> list) {

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

    /**
     * 打印二叉树前序遍历的结果
     *
     * @param root 二叉树根节点
     */
    public static void printPreOrderTreeNodeValue(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        preOrderTraversal(root, list);
        for (Integer num : list) {
            System.out.print(num + " ");
        }
    }

    /**
     * 先序打印二叉树的节点（包含null值的打印）
     *
     * @param root 树的根节点
     */
    public static void printPreOrderTreeNodeValueWithNull(TreeNode root) {

        if (root == null) {
            System.out.println("null ");
            return;
        }
        System.out.print(root.val + " ");
        printPreOrderTreeNodeValueWithNull(root.left);
        printPreOrderTreeNodeValueWithNull(root.right);
    }

}
