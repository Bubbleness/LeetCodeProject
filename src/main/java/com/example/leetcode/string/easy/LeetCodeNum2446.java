package com.example.leetcode.string.easy;

/**
 * @author shuiyu
 */
public class LeetCodeNum2446 {

    public boolean haveConflict(String[] event1, String[] event2) {

        boolean flag1 = isBetweenTwoTimes(event1[0], event1[1], event2[0])
                || isBetweenTwoTimes(event1[0], event1[1], event2[1]);
        boolean flag2 = isBetweenTwoTimes(event2[0], event2[1], event1[0])
                || isBetweenTwoTimes(event2[0], event2[1], event1[1]);
        return flag1 || flag2;
    }

    public static boolean isBetweenTwoTimes(String startTime, String endTime, String targetTime) {

        return targetTime.compareTo(startTime) >= 0
                && targetTime.compareTo(endTime) <= 0;
    }

    public static void main(String[] args) {

        LeetCodeNum2446 lc = new LeetCodeNum2446();

    }
}
