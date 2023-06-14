package com.example.leetcode.dfs.hard;

/**
 * @author shuiyu
 * @date 2023/06/09
 */
public class LeetCodeNum2699 {

    /**
     * 初步思路：
     *  1. 构建出图 （邻接表 or 邻接矩阵）
     *  2. 从source点开始DFS到target点，找这个两个点间距离最小的路径，需要记录下长度为-1的边，假设最短路径长度为 Len，-1的边有 k 个
     *      a. Len > target-2k 返回空数组
     *      b. Len == target-2k 则-1的边都设置为1返回
     *      c. Len < target-2k 则给每个-1的边分配值，分配的总和等于target-2k-Len，返回
     */
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        return null;
    }
}
