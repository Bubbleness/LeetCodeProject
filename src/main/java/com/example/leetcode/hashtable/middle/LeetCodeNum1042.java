package com.example.leetcode.hashtable.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shuiyu
 */
public class LeetCodeNum1042 {

    public int[] gardenNoAdj(int n, int[][] paths) {

        if (paths.length == 0 || paths[0].length == 0) {
            return new int[n];
        }

        if (n <= 4) {
            int[] nums = new int[n];
            for (int i=1; i<=n; i++) {
                nums[i-1] = i;
            }
            return nums;
        }

        // n大于4
        int[] nums = new int[n];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        nums[3] = 4;
        Map<Integer, List<Integer>> graph = getGraph(n, paths);

        List<Integer> flowers;
        List<Integer> vertice;
        for (int i=5; i<=n; i++) {
            flowers = new ArrayList<Integer>();
            flowers.add(1);
            flowers.add(2);
            flowers.add(3);
            flowers.add(4);
            vertice = graph.get(i);
            int k = 0;
            while (k < vertice.size()) {
                if (nums[vertice.get(k)] != 0 && flowers.contains(vertice.get(k))) {
                    flowers.remove(vertice.get(k));
                }
            }
            nums[i] = flowers.get(0);
        }

        return nums;
    }

    public static Map<Integer, List<Integer>> getGraph(int n, int[][] paths) {
        if (paths.length == 0 || paths[0].length == 0) {
            return new HashMap<>(n);
        }
        Map<Integer, List<Integer>> map = initMap(n);
        for (int i=0; i<paths.length; i++) {
            int from = paths[i][0];
            int to = paths[i][1];
            List<Integer> temp = map.get(from);
            temp.add(to);
            map.put(from, temp);

            temp = map.get(to);
            temp.add(from);
            map.put(to, temp);
        }
        return map;
    }

    public static Map<Integer, List<Integer>> initMap(int n) {

        Map<Integer, List<Integer>> map = new HashMap<>(n);
        for (int i=1; i<=n; i++) {
            map.put(i, new ArrayList<Integer>());
        }
        return map;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] paths = new int[][]{{1,2},{1,4},{1,6},{2,3},{3,5},{4,5},{5,6}};
        LeetCodeNum1042 lc = new LeetCodeNum1042();
        int[] res = lc.gardenNoAdj(n, paths);
        for (int i=0;i<n;i++) {
            System.out.print(res[i] + " ");
        }
    }
}
