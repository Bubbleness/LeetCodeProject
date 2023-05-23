package com.example.leetcode.sliding_window.middle;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shuiyu
 */
public class LeetCodeNum3 {

    public int lengthOfLongestSubstring(String s) {

        // step 1 ：定义需要维护的变量
        int maxSubstringLength = 0;
        Set<Character> characterSet = new HashSet<>();
        // step 2 ：定义滑动窗口的首端和尾端
        int start = 0;
        for (int end=0; end<s.length(); ++end) {
            // step 3 ：更新需要维护的变量
            if (!characterSet.contains(s.charAt(end))) {
                characterSet.add(s.charAt(end));
                maxSubstringLength = Math.max(maxSubstringLength, end-start+1);
            } else {
                // step 4 ：情况2，如果题目的窗口长度可变: 这个时候一般涉及到窗口是否合法的问题
                // 如果当前窗口不合法时, 用一个while去不断移动窗口左指针, 从而剔除非法元素直到窗口再次合法
                // 在左指针移动之前更新Step 1定义的(部分或所有)维护变量
                characterSet.remove(s.charAt(start));
                ++start;
                // 回退一下end，以便下一次循环还是遍历当前的元素
                --end;
            }
        }
        return maxSubstringLength;
    }

    public static void main(String[] args) {
        LeetCodeNum3 lc = new LeetCodeNum3();
        String s = "abcdefg";
        System.out.println(lc.lengthOfLongestSubstring(s));
    }
}
