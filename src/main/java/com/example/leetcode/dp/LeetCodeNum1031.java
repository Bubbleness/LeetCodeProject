package com.example.leetcode.dp;

/**
 * @author shuiyu
 */
public class LeetCodeNum1031 {

    /**
     * 解法一：暴力破解
     *
     * @param nums      数组
     * @param firstLen  第一个区间长度
     * @param secondLen 第二个区间长度
     * @return 最大值
     */
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {

        int maxSum = Integer.MIN_VALUE;
        for (int i=0; i+firstLen<=nums.length; i++) {
            int tempSum1 = 0, tempSum2 = 0;
            // 计算第一个区间的和
            for (int j = i; j<i+firstLen; j++) {
                tempSum1 += j;
            }

            for (int k = i+ firstLen; k+secondLen<=nums.length; k++) {
                tempSum2 = 0;
                // 计算第二个区间的和
                for (int p = k; p<k+secondLen; p++) {
                    tempSum2 += nums[p];
                }
                if (tempSum1 + tempSum2 >= maxSum) {
                    maxSum = tempSum1 + tempSum2;
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0,6,5,2,2,5,1,9,4};
        int firstLen = 1, secondLen = 2;
        LeetCodeNum1031 lc = new LeetCodeNum1031();
        int res = lc.maxSumTwoNoOverlap(nums, firstLen, secondLen);
        System.out.println(res);
    }
}
