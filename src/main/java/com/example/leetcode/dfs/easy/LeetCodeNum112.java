package com.example.leetcode.dfs.easy;

import com.example.leetcode.common.TreeNode;

import java.util.List;
import java.util.Set;

/**
 * @author shuiyu
 * @date 2023/06/13
 */
public class LeetCodeNum112 {

    /**
     * 思考过程：
     *  1. 首先思考清楚，这个递归函数的含义，要做什么事情：要判断一颗树是否有从root到叶子的路径之和为targetSum，返回这颗树是否满足这个条件。
     *  2. 思考递归的出口：这个树怎么才能满足条件？如果root就是叶子，只要判断root的值是否为targetSum；
     *     如果root不是叶子，那么需要判断左子树或者右子树是否能满足从根到叶子的路径之和为targetSum-root.val
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {

        // 思考递归的出口：根节点如果是叶子且值等于targetSum则true
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        // 根节点不是叶子，则判断左右子树的值是否为 targetSum - root.val
        int expectNum = targetSum - root.val;
        boolean left = hasPathSum(root.left, expectNum);
        boolean right = hasPathSum(root.right, expectNum);
        return left || right;
    }
}
