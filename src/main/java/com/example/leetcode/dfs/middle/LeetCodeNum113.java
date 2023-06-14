package com.example.leetcode.dfs.middle;

import com.example.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shuiyu
 * @date 2023/06/14
 */
public class LeetCodeNum113 {

    public List<List<Integer>> paths = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        dfs(root, targetSum, new ArrayList<>());
        return paths;
    }

    /**
     * 思考：需要遍历整棵树去枚举结果，
     */
    public void dfs(TreeNode root, int targetSum, List<Integer> path) {

        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && root.val == targetSum) {
            // 遍历到叶子节点且值刚好为targetSum说明找到了满足条件的路径。
            // 需要加入当前节点到路径path中，当前到path是一条完整路径，需要加入到结果集中。
            path.add(root.val);
            paths.add(new ArrayList<>(path));
            // 为什么要回溯？
            // 当前path添加的节点只是左或者右子树中满足条件的路径的叶子节点
            // 假设是左子树中的叶子，如果不去除的话，会影响右子树的结果
            path.remove(path.size() - 1);
            return;
        }
        int expect = targetSum - root.val;
        // root此时是中间节点（非叶子节点）
        // 则需要记录root节点
        path.add(root.val);
        // 去root的左子树找路径
        dfs(root.left, expect, path);
        // 去root的右子树找路径
        dfs(root.right, expect, path);
        // 这里回溯的原因在于：这里的root为中间节点，
        // 可能为某父节点的左、右孩子，访问完root后，需要去掉root的值，然后访问root的兄弟
        path.remove(path.size() - 1);
    }
}
