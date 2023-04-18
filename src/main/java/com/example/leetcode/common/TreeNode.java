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
