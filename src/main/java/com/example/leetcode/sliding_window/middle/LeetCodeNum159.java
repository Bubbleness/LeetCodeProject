package com.example.leetcode.sliding_window.middle;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author shuiyu
 */
public class LeetCodeNum159 {

    public int lengthOfLongestSubstringTwoDistinct(String s) {

        // 1. 定义需要维护的变量
        int maxSubstringLength = 0;
        Map<Character, Integer> charMap = new HashMap<>(s.length());
        // 2. 定义滑动窗口的首尾端口
        int start = 0;
        for (int end=0; end<s.length(); ++end) {
            // 3. 更新需要维护的变量
            if (!charMap.containsKey(s.charAt(end))) {
                charMap.put(s.charAt(end), 1);
                // 检查添加原始后map的key是否超过2个
                Set<Character> keySet = charMap.keySet();
                if (keySet.size() > 2) {
                    // 需要移动start指针
                    int count = charMap.get(s.charAt(start));
                    if (count == 1) {
                        charMap.remove(s.charAt(start));
                    } else {
                        charMap.put(s.charAt(start), charMap.get(s.charAt(start))-1);
                    }
                    ++start;
                    // 要先把插入的end原始删除掉 在回退一下end，以便下一次循环重新操作
                    charMap.remove(s.charAt(end));
                    --end;
                } else {
                    maxSubstringLength = Math.max(maxSubstringLength, end-start+1);
                }
            } else {
                charMap.put(s.charAt(end), charMap.get(s.charAt(end))+1);
                maxSubstringLength = Math.max(maxSubstringLength, end-start+1);
            }
        }
        return maxSubstringLength;
    }

    public static void main(String[] args) {
        LeetCodeNum159 lc = new LeetCodeNum159();
        String str = "eceba";
        System.out.println(lc.lengthOfLongestSubstringTwoDistinct(str));
    }
}
