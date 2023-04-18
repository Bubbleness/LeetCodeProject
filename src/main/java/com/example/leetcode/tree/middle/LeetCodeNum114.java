package com.example.leetcode.tree.middle;

import com.example.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shuiyu
 */
public class LeetCodeNum114 {

    public void flatten(TreeNode root) {

        // printPreOrderTreeNodeValueWithNull(root);
        List<TreeNode> list = new ArrayList<>();
        getTreeValues(root, list);
        for (int i=1; i<list.size(); i++) {
            TreeNode prev = list.get(i-1), cur = list.get(i);
            prev.right = cur;
            prev.left = null;
        }
    }

    public static void getTreeValues(TreeNode tree, List<TreeNode> list) {
        if (tree == null) {
            return;
        }
        list.add(tree);
        getTreeValues(tree.left, list);
        getTreeValues(tree.right, list);
    }

    public static void printPreOrderTreeNodeValueWithNull(TreeNode root) {

        if (root == null) {
            System.out.print("null ");
            return;
        }

        System.out.print(root.val + " ");
        printPreOrderTreeNodeValueWithNull(root.left);
        printPreOrderTreeNodeValueWithNull(root.right);
    }
}
