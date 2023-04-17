package com.example.leetcode.common;

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

    public static void printTree(TreeNode tree) {
        if (tree == null) {
            System.out.println("tree is null");
            return;
        }

    }


}
