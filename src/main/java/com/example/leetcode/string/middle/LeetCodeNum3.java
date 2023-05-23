package com.example.leetcode.string.middle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author shuiyu
 */
public class LeetCodeNum3 {

    /*************************** 解法一：暴力破解 ***************************/
    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 0) {
            return 0;
        }
        int len = s.length();
        while (len > 0) {
            for (int i=0; i<s.length(); i++) {
                for (int j=i+len-1; j<s.length(); j++) {
                    String subString = s.substring(i, j+1);
                    if (!hasDuplicateCharacter(subString)) {
                        System.out.println(subString);
                        return len;
                    }
                }
            }
            --len;
        }

        return 0;
    }

    public static boolean hasDuplicateCharacter(String str) {

        if (Objects.equals(str, "") || str == null) {
            return false;
        }
        List<Character> mapList = new ArrayList<>();
        for (int i=0; i<str.length(); i++) {
            Character tempChar = str.charAt(i);
            if (mapList.contains(tempChar)) {
                return true;
            }
            mapList.add(tempChar);
        }
        return false;
    }


    /*************************** 解法二：滑动窗口 ***************************/
    public int lengthOfLongestSubstring2(String s) {

        if (s.length() == 0) {
            return 0;
        }
        int left = 0, right = 0;
        int maxLen = -1;
        while (left < s.length() && right < s.length()) {
            String subStr = s.substring(left, right+1);
            if (!hasDuplicateCharacter(subStr)) {
                int tempLen = right-left+1;
                if (tempLen > maxLen) {
                    maxLen = tempLen;
                }
            } else {
                ++left;
            }
            right++;
        }
        return maxLen;
    }

    // 优化
    public int lengthOfLongestSubstring3(String s) {

        if (s.length() == 0) {
            return 0;
        }
        Set<Character> mapSet = new HashSet<>();
        int maxLen = -1, right = -1;
        for (int left=0; left<s.length(); left++) {
            if (left != 0) {
                mapSet.remove(s.charAt(left-1));
            }

            while (right+1<s.length() && !mapSet.contains(s.charAt(right+1))) {
                mapSet.add(s.charAt(right+1));
                ++right;
            }
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }




    /*************************** 主函数：测试使用  ***************************/
    public static void main(String[] args) {

        LeetCodeNum3 lc = new LeetCodeNum3();
        String str = "pwwkew";
        int res = lc.lengthOfLongestSubstring2(str);
        System.out.println(res);
    }
}
