package com.example.leetcode.array.easy;

import com.alibaba.fastjson.JSONObject;

/**
 * @author shuiyu
 */
public class LeetCodeNum2460 {

    public int[] applyOperations(int[] nums) {

        int[] res = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] = nums[i] * 2;
                nums[i + 1] = 0;
            }
            if (nums[i] != 0) {
                res[index] = nums[i];
                ++index;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 1, 1, 0};
        LeetCodeNum2460 lc = new LeetCodeNum2460();
        int[] res = lc.applyOperations(nums);
        System.out.println(JSONObject.toJSONString(res));
    }
}
