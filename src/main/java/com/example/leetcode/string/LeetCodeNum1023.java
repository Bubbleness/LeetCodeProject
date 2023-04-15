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

        String targetUpCase = removeLowCaseLetter(target);
        String patternUpCase = removeLowCaseLetter(pattern);
        if (!targetUpCase.equals(patternUpCase)) {
            return false;
        }

        int i = 0, j = 0;
        while (i < target.length()) {

            if (target.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
            // 判断模式串是否已经匹配完
            if (j == pattern.length()) {
                break;
            }
        }

        // 模式串已经匹配完但是目标串还有剩余
        // 检查目标串剩余部分是否有大写
        boolean flag = (j == pattern.length());
        if (!flag) {
            // j没走到尾 不匹配
            return false;
        }

        while (i < target.length()) {
            if (target.charAt(i) >= 'A' && target.charAt(i) <= 'Z') {
                flag = false;
                break;
            }
            i++;
        }

        return flag;
    }

    public static String removeLowCaseLetter(String str) {

        if (str == null || "".equals(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] queries = new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        String pattern = "FoBaT";
        LeetCodeNum1023 lc = new LeetCodeNum1023();
        List<Boolean> res = lc.camelMatch(queries, pattern);
        for (Boolean item : res) {
            System.out.print(StringUtils.convertBooleanToString(item));
            System.out.print(" ");
        }
    }
}
