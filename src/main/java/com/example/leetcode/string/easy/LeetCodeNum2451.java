package com.example.leetcode.string.easy;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author shuiyu
 */
public class LeetCodeNum2451 {

    public String oddString(String[] words) {

        Map<String, Integer> map = new HashMap<>();
        for (int i=0;i<words.length;i++) {
           String toString = calculate(words[i]).toString();
           if (map.containsKey(toString)) {
               map.put(toString, map.get(toString) + 1);
           } else {
               map.put(toString, 1);
           }
        }

        String mark = null;
        for (String str : map.keySet()) {
            if (map.get(str) == 1) {
                mark = str;
                break;
            }
        }

        for (int i=0; i<words.length; i++) {
            String tempStr = calculate(words[i]).toString();
            if (tempStr.equals(mark)) {
                return words[i];
            }
        }
        return null;
    }

    public static List<Integer> calculate(String word) {

        List<Integer> res = new ArrayList<>();
        int i=0, j=i+1;
        while (j < word.length()) {
            int front = word.charAt(i) - 'a';
            int after = word.charAt(j) - 'a';
            res.add(after-front);
            ++i;
            ++j;
        }
        return res;
    }

    public static void main(String[] args) {

        LeetCodeNum2451 lc = new LeetCodeNum2451();
        String[] words = new String[] {"adc","wzy","abc"};
        String[] words2 = new String[] {"aaa","bob","ccc","ddd"};
        String w1 = lc.oddString(words);
        String w2 = lc.oddString(words2);
        System.out.println(w2);
    }
}
