package com.example.leetcode.array.middle;

/**
 * @author shuiyu
 */
public class LeetCodeNum1073 {

    public int[] addNegabinary(int[] arr1, int[] arr2) {

        return null;
    }

    public static int calculateValue(int[] arr, int k) {

        int res = 0, len = arr.length-1;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] != 0) {
                res += Math.pow(k, len);
            }
            --len;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCodeNum1073 lc = new LeetCodeNum1073();
        int[] arr = new int[] {1, 1, 1, 1, 1};
        System.out.println(calculateValue(arr, -2));
    }
}
