package com.example.leetcode.sliding_window.easy;

/**
 * @author shuiyu
 */
public class LeetCodeNum643 {

    public double findMaxAverage(int[] nums, int k) {

        // step 1 : 定义需要维护的变量，这里就是长度为k的连续数字的最大和
        int maxSumValue = -1;
        int tempSumValue = 0;

        for (int i=0; i<k; i++) {
            tempSumValue += nums[i];
        }
        maxSumValue = tempSumValue;
        for (int end=k; end<nums.length; end++) {
            tempSumValue += (nums[end] - nums[end-k]);
            maxSumValue = Math.max(maxSumValue, tempSumValue);
        }
        return (double) maxSumValue / k;
    }

    /*************************************** 模版写法 ***************************************/
    public double findMaxAverage2(int[] nums, int k) {

        // step 1 : 定义需要维护的变量（本题就是数组中连续k个值的最大和）
        int maxSumValue = Integer.MIN_VALUE, tempSumValue = 0;
        // step 2 : 定义滑动窗口的首端和尾端
        int start = 0;
        for (int end=0; end<nums.length; ++end) {
            // step 3 : 更新需要维护的值，有的变量需要一个if语句来维护 (比如最大最小长度)
            tempSumValue += nums[end];
            if (end-start+1 == k) {
                maxSumValue = Math.max(maxSumValue, tempSumValue);
            }

            // step 4 : 情况1，如果题目的窗口长度固定：用一个if语句判断一下当前窗口长度是否达到了限定长度
            // 如果达到了，窗口左指针前移一个单位，从而保证下一次右指针右移时，窗口长度保持不变,
            // 左指针移动之前, 先更新step 1定义的(部分或所有)维护变量
            if (end >= k-1) {
                tempSumValue -= nums[start];
                ++start;
            }
        }
        // step 5 : 返回结果
        return (double) maxSumValue / k;
    }

    public static void main(String[] args) {
        LeetCodeNum643 lc = new LeetCodeNum643();
        int[] nums = new int[]{8860, -853, 6534, 4477, -4589, 8646, -6155, -5577, -1656, -5779, -2619, -8604, -1358, -8009, 4983, 7063, 3104, -1560, 4080, 2763, 5616, -2375, 2848, 1394, -7173, -5225, -8244, -809, 8025, -4072, -4391, -9579, 1407, 6700, 2421, -6685, 5481, -1732, -8892, -6645, 3077, 3287, -4149, 8701, -4393, -9070, -1777, 2237, -3253, -506, -4931, -7366, -8132, 5406, -6300, -275, -1908, 67, 3569, 1433, -7262, -437, 8303, 4498, -379, 3054, -6285, 4203, 6908, 4433, 3077, 2288, 9733, -8067, 3007, 9725, 9669, 1362, -2561, -4225, 5442, -9006, -429, 160, -9234, -4444, 3586, -5711, -9506, -79, -4418, -4348, -5891};
        double res = lc.findMaxAverage2(nums, 93);
        System.out.println(res);
    }
}
