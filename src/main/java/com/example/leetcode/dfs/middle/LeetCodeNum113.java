package com.example.leetcode.dfs.middle;

import com.example.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shuiyu
 * @date 2023/06/14
 */
public class LeetCodeNum113 {

    public static List<List<Integer>> paths = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return paths;
        }
        List<Integer> path = new ArrayList<>();
        dfs(root, targetSum, path);
        return paths;
    }

    public static void dfs(TreeNode root, int targetSum, List<Integer> path) {

        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && root.val == targetSum) {
            path.add(root.val);
            paths.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        int expect = targetSum - root.val;
        path.add(root.val);
        dfs(root.left, expect, path);
        dfs(root.right, expect, path);
        path.remove(path.size() - 1);
    }
}
