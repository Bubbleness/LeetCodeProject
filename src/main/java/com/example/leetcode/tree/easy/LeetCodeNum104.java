package com.example.leetcode.tree.easy;

import com.example.leetcode.common.TreeNode;

/**
 * @author shuiyu
 */
public class LeetCodeNum104 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return getTreeHight(root);
    }

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
}
