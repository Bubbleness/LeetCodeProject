package com.example.leetcode.array.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shuiyu
 * @date 2023/07/26
 */
public class LeetCodeNum2569 {

    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {

        int count = getOperatorThreeNum(queries);
        long[] result = new long[count];
        int index = 0;
        for (int i=0; i<queries.length; i++) {
            switch (queries[i][0]) {
                case 1:
                    operatorOne(queries[i], nums1);
                    continue;
                case 2:
                    operatorTwo(queries[i], nums1, nums2);
                    continue;
                case 3:
                    long res = operatorThree(nums2);
                    result[index] = res;
                    ++index;
                    break;
            }
        }
        return result;
    }

    public static void operatorOne(int[] op, int[] nums) {
        int left = op[1], right = op[2];
        for (int i=left; i<=right; i++) {
            if (nums[i] == 0) {
                nums[i] = 1;
            } else if (nums[i] == 1) {
                nums[i] = 0;
            }
        }
    }

    public static void operatorTwo(int[] op, int[] nums1, int[] nums2) {
        int p = op[1];
        for (int i=0; i<nums2.length; i++) {
            nums2[i] = nums2[i] + nums1[i] * p;
        }
    }

    public static long operatorThree(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public static int getOperatorThreeNum(int[][] queries) {
        int count = 0;
        for (int i=0; i<queries.length; i++) {
            if (queries[i][0] == 3) {
                ++count;
            }
        }
        return count;
    }
}
