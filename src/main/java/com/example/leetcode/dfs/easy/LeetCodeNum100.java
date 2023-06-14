package com.example.leetcode.dfs.easy;

import com.example.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shuiyu
 * @date 2023/06/13
 */
public class LeetCodeNum100 {


    /**
     * DFS思路：两个树是否相同，需要比较根是否相同，根相同则需要左子树和右子树都要相同
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // 先定义递归的出口
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        // 因为当前节点不会再次遍历，省略当前状态的标记处理和标记还原操作
        boolean isSameLeftChild = isSameTree(p.left, q.left);
        boolean isSameRightChild = isSameTree(p.right, q.right);
        return isSameRightChild && isSameLeftChild;
    }






    /**
     * 思路：获取前序和中序遍历结果，比较两颗树的两种遍历结果是否完全一致
     *      前序 + 中序 可以确定一颗二叉树
     */
    public boolean isSameTree2(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }
        if (p.left != null && q.left == null) {
            return false;
        }
        if (p.right != null && q.right == null) {
            return false;
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        preOrder(p, list1);
        preOrder(q, list2);
        System.out.println(list1);
        System.out.println(list2);
        boolean isSamePreOrder = isSame(list1, list2);
        list1.clear();
        list2.clear();
        inOrder(p, list1);
        inOrder(q, list2);
        return isSame(list1, list2) && isSamePreOrder;
    }

    public void preOrder(TreeNode p, List<Integer> prelist) {
        if (p == null) {
            return;
        }
        prelist.add(p.val);
        preOrder(p.left, prelist);
        preOrder(p.right, prelist);
    }

    public void inOrder(TreeNode p, List<Integer> inList) {
        if (p == null) {
            return;
        }
        inOrder(p.left, inList);
        inList.add(p.val);
        inOrder(p.right, inList);
    }

    public boolean isSame(List<Integer> list1, List<Integer> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i=0; i<list1.size(); i++) {
            if (list1.get(i) != list2.get(i)) {
                return false;
            }
        }
        return true;
    }
}
