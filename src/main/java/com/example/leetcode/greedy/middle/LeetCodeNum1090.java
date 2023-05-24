package com.example.leetcode.greedy.middle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author shuiyu
 */
public class LeetCodeNum1090 {

    /**
     * 1. 如果数组按照从大到小排序后，可以保证顺序遍历取值是最大的
     * 2. 如果标签数量 >= numWanted 则取numWanted个数是最大的，否则取便签的类别数
     */
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {

        List<Item> itemList = new ArrayList<>();
        for (int i=0; i<values.length; i++) {
            Item item = new Item(values[i], labels[i]);
            itemList.add(item);
        }
        itemList = itemList.stream()
                .sorted(Comparator.comparingInt(o -> -o.value)).collect(Collectors.toList());
        print(itemList);
        Map<Integer, Integer> map = new HashMap<>();
        int maxSumValue = 0;
        int countNum = 0;

        for (Item item : itemList) {
            if (countNum == numWanted) {
                break;
            }
            if (map.containsKey(item.label)) {
                int count = map.get(item.label);
                if (count < useLimit && countNum < numWanted) {
                    maxSumValue += item.value;
                    map.put(item.label, count+1);
                    ++countNum;
                }
            } else {
                if (countNum < numWanted) {
                    maxSumValue += item.value;
                    map.put(item.label, 1);
                    ++countNum;
                }
            }
        }

        return maxSumValue;
    }

    public static void main(String[] args) {
        int[] values = new int[] {5,4,3,2,1};
        int[] labels = new int[] {1,1,2,2,3};
        LeetCodeNum1090 lc = new LeetCodeNum1090();
        int res = lc.largestValsFromLabels(values, labels, 3, 1);
        System.out.println(res);
    }

    public static void print(List<Item> itemList) {
        for (Item item : itemList) {
            System.out.print(item.value + " , ");
        }
        System.out.println();
    }

    class Item {
        public int value;
        public int label;

        public Item(int value, int label) {
            this.value = value;
            this.label = label;
        }
    }
}
