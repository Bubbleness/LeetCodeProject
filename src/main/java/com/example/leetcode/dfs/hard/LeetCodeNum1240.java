package com.example.leetcode.dfs.hard;

/**
 * @author shuiyu
 */
public class LeetCodeNum1240 {

    public int[][] mark;
    public int tilingRectangle(int n, int m) {

        //mark = new int[n][m];
        //for (int i=0; i<n; i++) {
        //    for (int j=0; j<m; j++) {
        //        mark[i][j] = dfs(i, j);
        //    }
        //}
        //return mark[n][m];

        // 会超时，可以使用打表的方法把每个n m对应的值记录下来
        return dfs(n, m);
    }

    public int dfs(int x, int y) {

        // case1 : 为正方形时只需要1块
        if (x == y) {
            return 1;
        }
        // case2 : 长为1时需要y块（1*1的正方形）
        if (x == 1) {
            return y;
        }
        // case3 : 宽为1时需要x块（1*1的正方形）
        if (y == 1) {
            return x;
        }

        // 最多需要的块数（全部为1*1的正方形）
        int totalCount = x * y;

        for (int i=1; i<(x/2 + 1); i++) {
            totalCount = Math.min(totalCount, dfs(i, y) + dfs(x-i, y));
        }

        for (int j=1; j<(y/2 + 1); j++) {
            totalCount = Math.min(totalCount, dfs(x, j) + dfs(x, y-j));
        }

        for (int centreSize=1; centreSize<Math.min(x, y); centreSize++) {
            for (int i=1; i<x-centreSize; i++) {
                for (int j=1; j<y-centreSize; j++) {
                    int partition1 = dfs(i+centreSize, j);
                    int partition2 = dfs(x-i-centreSize, j+centreSize);
                    int partition3 = dfs(i, y-j);
                    int partition4 = dfs(x-i, y-j-centreSize);
                    int partition5 = 1;

                    int totalPartition = partition1 + partition2 + partition3 + partition4 + partition5;
                    totalCount = Math.min(totalCount, totalPartition);
                }
            }
        }
        return totalCount;
    }

    public static void main(String[] args) {
        int n = 11, m = 13;
        LeetCodeNum1240 lc = new LeetCodeNum1240();
        System.out.println(lc.tilingRectangle(n, m));
    }


    //public int ans;
    //
    //public int tilingRectangle(int n, int m) {
    //    ans = Math.max(n, m);
    //    boolean[][] rect = new boolean[n][m];
    //    dfs(0, 0, rect, 0);
    //    return ans;
    //}

    //public void dfs(int x, int y, boolean[][] rect, int cnt) {
    //    // 长为n 宽为m
    //    int n = rect.length, m = rect[0].length;
    //    if (cnt >= ans) {
    //        return;
    //    }
    //    if (x >= n) {
    //        ans = cnt;
    //        return;
    //    }
    //    /* 检测下一行 */
    //    if (y >= m) {
    //        dfs(x + 1, 0, rect, cnt);
    //        return;
    //    }
    //    /* 如当前已经被覆盖，则直接尝试下一个位置 */
    //    if (rect[x][y]) {
    //        dfs(x, y + 1, rect, cnt);
    //        return;
    //    }
    //
    //    for (int k = Math.min(n - x, m - y); k >= 1 && isAvailable(rect, x, y, k); k--) {
    //        /* 将长度为 k 的正方形区域标记覆盖 */
    //        fillUp(rect, x, y, k, true);
    //        /* 跳过 k 个位置开始检测 */
    //        dfs(x, y + k, rect, cnt + 1);
    //        fillUp(rect, x, y, k, false);
    //    }
    //}
    //
    //public boolean isAvailable(boolean[][] rect, int x, int y, int k) {
    //    for (int i = 0; i < k; i++) {
    //        for (int j = 0; j < k; j++) {
    //            if (rect[x + i][y + j]) {
    //                return false;
    //            }
    //        }
    //    }
    //    return true;
    //}
    //
    //public void fillUp(boolean[][] rect, int x, int y, int k, boolean val) {
    //    for (int i = 0; i < k; i++){
    //        for (int j = 0; j < k; j++) {
    //            rect[x + i][y + j] = val;
    //        }
    //    }
    //}
}
