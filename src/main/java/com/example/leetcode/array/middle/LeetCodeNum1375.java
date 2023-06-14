package com.example.leetcode.array.middle;

import com.alibaba.fastjson.JSON;

/**
 * @author shuiyu
 * @date 2023/06/14
 */
public class LeetCodeNum1375 {

    public int numTimesAllBlue(int[] flips) {

        int[] nums = new int[flips.length];
        int count = 0;
        for (int i = 0; i < flips.length; i++) {
            nums[flips[i]-1] = 1;
            if (check(nums, 0, i)) {
                count++;
            }
            System.out.println(JSON.toJSONString(nums));
        }
        return count;
    }

    public static boolean check(int[] nums, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (nums[i] != 1) {
                return false;
            }
        }
        for (int i = end + 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] filps = new int[]{3,2,4,1,5};
        LeetCodeNum1375 lc = new LeetCodeNum1375();
        System.out.println(lc.numTimesAllBlue(filps));
    }
}
