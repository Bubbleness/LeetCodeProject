package com.example.leetcode.string;

import com.example.leetcode.common.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shuiyu
 */
public class LeetCodeNum1023 {

    public List<Boolean> camelMatch(String[] queries, String pattern) {

        if (queries.length == 0) {
            return new ArrayList<>();
        }
        List<Boolean> list = new ArrayList<>();
        for (String str : queries) {
            list.add(canMatchPattern(str, pattern));
        }
        return list;
    }

    public static Boolean canMatchPattern(String target, String pattern) {

        if (target.length() < pattern.length()) {
            return false;
        }

        for (int i=0; i<target.length();) {

            int j = 0;
            while (j < pattern.length()) {
                if (target.charAt(i) == pattern.charAt(j)) {
                    j++;
                    i++;
                } else {
                    i++;
                }
            }
            if (j == pattern.length()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] queries = new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        String pattern = "FB";
        LeetCodeNum1023 lc = new LeetCodeNum1023();
        List<Boolean> res = lc.camelMatch(queries, pattern);
        for (Boolean item : res) {
            System.out.print(StringUtils.convertBooleanToString(item));
            System.out.print(" ");
        }
    }
}
