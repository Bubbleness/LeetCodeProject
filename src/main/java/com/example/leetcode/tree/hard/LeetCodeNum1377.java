package com.example.leetcode.tree.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author shuiyu
 */
public class LeetCodeNum1377 {

    public double frogPosition(int n, int[][] edges, int t, int target) {

        List<Integer>[] G = buildGraph(edges, n);
        // 定义标记数组，用来标记第i个节点是否被访问过
        boolean[] visited = new boolean[n + 1];
        return dfs(G, visited, 1, t, target);
    }

    /**
     * 深度优先遍历
     *
     * @param graph   图
     * @param visited 标记数组
     * @param i       当前遍历的节点
     * @param t       剩余时间
     * @param target  目标节点值
     * @return 概率
     */
    public static double dfs(List<Integer>[] graph, boolean[] visited, int i, int t, int target) {

        /**
         * 比如一个图：
         *  1 -> {2, 3, 7}
         *  2 -> {1, 4, 6}
         *  3 -> {1, 5}
         *  4 -> {2}
         *  5 -> {3}
         *  6 -> {2}
         *  7 -> {1}
         *  只要不是根节点，都需要减去1，即去掉父节点
         */

        // 代表当前节点i的孩子节点个数
        int childCount;
        if (i == 1) {
            childCount = graph[i].size();
        } else {
            // 不是根节点则需要减去父节点
            childCount = graph[i].size() - 1;
        }

        // 剩余时间为0 或者 当前节点没有孩子节点
        if (t == 0 || childCount == 0) {
            return i == target ? 1.0 : 0.0;
        }
        // 代表当前节点的概率
        double ans = 0.0;
        visited[i] = true;
        for (int next : graph[i]) {
            if (!visited[next]) {
                ans += dfs(graph, visited, next, t - 1, target);
            }
        }
        return ans / childCount;
    }

    /**
     * 以领接表的方式构建图
     *
     * @param edges 图中的边
     * @param n     节点数量
     * @return 图的领接表
     */
    public static List<Integer>[] buildGraph(int[][] edges, int n) {

        List<Integer>[] graph = new ArrayList[n + 1];
        // 初始化图
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        // 根据边数组来构建图
        for (int[] egde : edges) {
            graph[egde[0]].add(egde[1]);
            graph[egde[1]].add(egde[0]);
        }
        return graph;
    }
}
