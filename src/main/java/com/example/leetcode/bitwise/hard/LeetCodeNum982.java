package com.example.leetcode.bitwise.hard;

/**
 * @author shuiyu
 * @date 2023/06/16
 */
public class LeetCodeNum982 {

    public int countTriplets(int[] nums) {

        int count = 0;
        for (int i=0; i<nums.length; i++) {
            for (int j=0; j<nums.length; j++) {
                for (int k=0; k<nums.length; k++) {
                    int temp = nums[i] & nums[j] & nums[k];
                    if (temp == 0) {
                        ++count;
                    }
                }
            }
        }
        return count;
    }

    public int countTriplets2(int[] nums) {

        // nums数组的每个元素的取值不超过2^16
        int[] bitCnt = new int[1 << 16];
        // 记录下 nums[i] & nums[j] 的结果
        for (int x : nums) {
            for (int y : nums) {
                // 记录x&y的结果出现的次数
                bitCnt[x & y]++;
            }
        }
        int count = 0;
        // 需要计算 nums[k] 与 (nums[i] & nums[j]) 取&运算的结果
        // nums[k] 代表的十进制数对应的二进制数可以看成一个数组
        // 比如：nums[k] = 15，对应二进制数为：1111，可以看成数组集合：{0, 1, 2, 3}
        // 比如：nums[k] = 12，对应二进制数为：1100，可以看成数组集合：{2, 3}
        // 记 m = (nums[i] & nums[j])，要使得nums[k] & m = 0，由于 nums[k] & ~nums[k] = 0
        // 所以 m 一定是nums[k]的补码的子集，则只需要计算nums[k]对应二进制的补码对应的集合的子集个数即可
        for (int k : nums) {
            // 计算k的补码（计算方式：与 2^16-1 取异或）
            k = k ^ 0xffff;
            // 计算k对应的二进制对应的集合的子集个数
            int s = k;
            do {
                // 如果bitCnt里面记录了s出现的个数，说明s 与之间的 nums[i] & nums[j] 的结果相同
                // 由于s是nums[i] & nums[j]的补集的子集合，所以s取补码后与 nums[i] & nums[j] 进行&运算结果必为0
                count += bitCnt[s];
                s = (s-1) & k;
            } while (s != k);
        }
        return count;
    }
}
