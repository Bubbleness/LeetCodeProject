package com.example.leetcode.dfs.middle;

import com.example.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mucheng.ys
 * @date: 2025-06-23 16:14:03
 * @description: 力扣98. 验证二叉搜索树
 */
public class Solution98 {

    public boolean isValidBST(TreeNode root) {
        // 思路1: 二叉搜索树的特点是中序遍历的数字是递增的。使用中序遍历，然后判断中序序列是否递增
//        List<Integer> list = new ArrayList<>();
//        preOrderTree(root, list);
//        return check(list);

        // 思路2：直接递归搜索

        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 思路：左子树节点要小于根节点，右子树节点要大于根节点
     * 采用先序遍历，依次校验左子树和右子树，判断两边是否都满足
     *
     * @param root
     * @param leftValue
     * @param rightValue
     * @return
     */
    private boolean dfs(TreeNode root, long leftValue, long rightValue) {
        if (root == null) {
            return true;
        }
        if (root.val <= leftValue || root.val >= rightValue) {
            return false;
        }

        return dfs(root.left, leftValue, root.val) && dfs(root.right, root.val, rightValue);
    }


    private boolean check(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            int next = i + 1;
            if (next < list.size() && list.get(i) >= list.get(next)) {
                return false;
            }
        }
        return true;
    }

    private void preOrderTree(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        preOrderTree(root.left, list);
        list.add(root.val);
        preOrderTree(root.right, list);
    }

    public static void main(String[] args) {


    }
}
