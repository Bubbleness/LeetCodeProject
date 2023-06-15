package com.example.leetcode.string.middle;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author shuiyu
 * @date 2023/06/15
 */
public class LeetCodeNum1177 {

    /**
     * 核心思想：统计子串中出现个数为奇数个的字母的数量，假设m个，如果m/2 > k则false
     *
     */

    public List<Boolean> canMakePaliQueries2(String s, int[][] queries) {

        int n = s.length();
        // sum[i] 代表第i位上的字母是奇数个还是偶数个
        // 比如 10010 表示b、e出现奇数次
        int[] sum = new int[n+1];
        for (int i=0; i<n; i++) {
            // 第i位上的字符
            // a 对应 1 << 0 = 1
            // b 对应 1 << 1 = 10
            // c 对应 1 << 2 = 100
            // d 对应 1 << 3 = 1000
            // 一个二进制数组哪一位为1则表示这个位上对应的字符为奇数个
            int bit = 1 << (s.charAt(i) - 'a');
            // 计算第i+1位上的字符出现次数
            sum[i+1] = sum[i] ^ bit;
        }

        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            int left = query[0], right = query[1], k = query[2];
            // left到right+1之间的字符出现奇数次的个数
            int m = Integer.bitCount(sum[right + 1] ^ sum[left]);
            res.add(m / 2 <= k);
        }
        return res;
    }




    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {

        List<Boolean> res = new ArrayList<>();
        for (int i=0; i<queries.length; i++) {
            String subStr = s.substring(queries[i][0], queries[i][1]+1);
            res.add(canChangeToPalindrome(subStr, queries[i][2]));
        }
        return res;
    }

    public static boolean isPalindrome(String str) {

        if (str.isEmpty()) {
            return true;
        }
        int start = 0, end = str.length() - 1;
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            ++start;
            --end;
        }
        return true;
    }

    public static boolean canChangeToPalindrome(String str, int k) {

        boolean isPalindromeString = isPalindrome(str);
        if (isPalindromeString) {
            return true;
        }
        if (k == 0) {
            return false;
        }
        Map<Character, Integer> charCountMap = new HashMap<>(str.length());
        for (int i=0; i<str.length(); i++) {
            if (charCountMap.containsKey(str.charAt(i))) {
                charCountMap.put(str.charAt(i), charCountMap.get(str.charAt(i)) + 1);
            } else {
                charCountMap.put(str.charAt(i), 1);
            }
        }
        int charCount = str.length();

        // 过滤掉字母个数为双数的字母
        Set<Map.Entry<Character, Integer>> entrySet = charCountMap.entrySet()
                .stream().filter(item -> item.getValue() % 2 != 0).collect(Collectors.toSet());

        if (charCount % 2 != 0) {
            // 允许有一个字母的数量为奇数
            Map.Entry<Character, Integer> randomEntry = entrySet.stream().findFirst().get();
            entrySet.remove(randomEntry);
        }
        int charTypeNum = entrySet.size();
        if (k >= charTypeNum / 2) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String str = "abcd";
        int[][] queries = new int[][] {{0, 3, 1}, {0, 3, 2}};
        LeetCodeNum1177 lc = new LeetCodeNum1177();
        System.out.println(lc.canMakePaliQueries(str, queries));

        System.out.println(1 ^ 3);
    }
}
