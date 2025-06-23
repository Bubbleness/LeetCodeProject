package com.example.leetcode.dfs.middle;

/**
 * @author: mucheng.ys
 * @date: 2025-06-23 14:19:58
 * @description: LeetCode第79题：单词搜索
 */
public class LeetCodeNum79 {

    private String targetWord = "";

    public boolean exist(char[][] board, String word) {

        int[][] visited = new int[board.length][board[0].length];
        int rowLen = board.length, colLen = board[0].length;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (dfs(visited, i, j, 0, board, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 思路：怎么去想？
     * 需要对board数组每一个位置 (row,col) 进行校验，判断该位置出发是否能匹配到字符串。那么就能确定下DFS方法
     * 可以返回boolean类型，表示该位置是否能找到字符串。
     * <p>
     * 递归条件思考：
     * 1、递归出口(结束条件)：row、col达到数组边界；当前(row,col)位置已经访问过
     * 2、不满足的条件：当前的(row,col)位置字符与需要比较的word[k]处字符不一样
     * 3、满足的条件：k已经匹配完成了，并且字符都能匹配
     *
     * @param visited 标记数组
     * @param row     当前行号
     * @param col     当前列号
     * @param k       word字符串中的校验位置
     * @param board   目标数字面板
     * @param word    目标字符串
     * @return (row, col)位置开始是否能匹配word字符串
     */
    private boolean dfs(int[][] visited, int row, int col, int k, char[][] board, String word) {

        // 递归边界条件
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        // 递归访问条件：判断当前遍历的字符是否被访问
        if (visited[row][col] == 1) {
            return false;
        }
        // 逻辑判断：校验当前遍历的字符是否与字符串的字符匹配
        if (word.charAt(k) != board[row][col]) {
            return false;
        }
        // 如果已经搜索出结果，则返回true
        if (k == word.length() - 1) {
            return true;
        }

        // 执行具体操作
        visited[row][col] = 1;

        // 往右遍历
        boolean moveRight = dfs(visited, row, col + 1, k + 1, board, word);
        // 往下便利
        boolean moveDown = dfs(visited, row + 1, col, k + 1, board, word);
        // 往左遍历
        boolean moveLeft = dfs(visited, row, col - 1, k + 1, board, word);
        // 往上遍历
        boolean moveUp = dfs(visited, row - 1, col, k + 1, board, word);

        // 回溯
        visited[row][col] = 0;

        return moveDown || moveUp || moveLeft || moveRight;
    }

    @Deprecated
    private void dfs1(int[][] mark, int row, int col, int k, char[][] board, String word) {

        // 递归退出条件1: 数组边界条件
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }
        // 递归退出条件2:
        if (k == word.length() || mark[row][col] == 1) {
            return;
        }

        if (board[row][col] != word.charAt(k)) {
            return;
        }

        if (targetWord.length() == word.length()) {
            return;
        }

        // 走到这里说明 board[row][col] == word.charAt(k)
        // 则继续递归遍历4个方向 匹配下一个字母
        mark[row][col] = 1;
        targetWord += board[row][col];

        // 往下走
        dfs(mark, row + 1, col, k + 1, board, word);
        // 往左走
        dfs(mark, row, col - 1, k + 1, board, word);
        // 往右走
        dfs(mark, row, col + 1, k + 1, board, word);
        // 往上走
        dfs(mark, row - 1, col, k + 1, board, word);

        // 回退
        mark[row][col] = 0;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        char[][] board2 = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word = "ABCESEEEFS";
        LeetCodeNum79 lc = new LeetCodeNum79();
        boolean res = lc.exist(board2, word);
        System.out.println(res);
        System.out.println("targetWord is : " + lc.targetWord);
    }
}
