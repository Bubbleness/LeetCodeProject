package com.example.leetcode.array.easy;

/**
 * @author shuiyu
 * @date 2023/06/13
 */
public class LeetCodeNum2475 {

    public int unequalTriplets(int[] nums) {

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (j == nums.length) {
                    break;
                }
                for (int k = j + 1; k < nums.length; k++) {
                    if (k == nums.length) {
                        break;
                    }
                    if (nums[i] != nums[j] && nums[j] != nums[k] && nums[i] != nums[k]) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1};
        LeetCodeNum2475 lc = new LeetCodeNum2475();
        System.out.println(lc.unequalTriplets(nums));
    }
}
