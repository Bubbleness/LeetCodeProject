package com.example.leetcode.array.hard;

/**
 * @author shuiyu
 */
public class LeetCodeNum4 {

    /**
     * 思路1: 合并两个数组成一个有序数组，计算出中位数
     * 空间复杂度会比较高
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n = nums1.length, m = nums2.length;
        int[] nums = new int[m+n];

        int index = 0;
        int i = 0, j = 0;
        while (i<n && j<m) {
            if (nums1[i] <= nums2[j]) {
                nums[index] = nums1[i];
                ++i;
            } else {
                nums[index] = nums2[j];
                ++j;
            }
            ++index;
        }

        while (i < n) {
            nums[index] = nums1[i];
            ++index;
            ++i;
        }
        while (j < m) {
            nums[index] = nums2[j];
            ++index;
            ++j;
        }

        int middle = (m+n) / 2;
        if ( (m+n) % 2 == 0) {
            return (nums[middle] + nums[middle-1]) / 2.0;
        } else {
            return (double) nums[middle];
        }
    }


    /**
     * 思路2:
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        return 0L;
    }


    public static void main(String[] args) {
        LeetCodeNum4 lc = new LeetCodeNum4();
        int[] nums1 = new int[] {1,2};
        int[] nums2 = new int[] {3,4, 5};
        double res = lc.findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }
}
