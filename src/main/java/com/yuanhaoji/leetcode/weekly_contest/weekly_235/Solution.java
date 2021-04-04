package com.yuanhaoji.leetcode.weekly_contest.weekly_235;

import sun.nio.cs.ext.MacHebrew;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/4/4
 * @desp: 第 235 场周赛
 */

public class Solution {

    public String truncateSentence(String s, int k) {
        String[] array = s.split("\\s");
        StringBuilder res = new StringBuilder();
        res.append(array[0]);
        for (int i = 1; i < k; i++) {
            res.append(" ").append(array[i]);
        }

        return res.toString();
    }

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] res = new int[k];
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] log : logs) {
            int key = log[0];
            if (map.containsKey(key)) {
                map.get(key).add(log[1]);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(log[1]);
                map.put(key, set);
            }
        }

        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            ++res[entry.getValue().size() - 1];
        }

        return res;
    }

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Math.abs(nums1[i] - nums2[i]);
        }

        int max = 0, idx2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
                idx2 = i;
            }
        }

        int min = Integer.MAX_VALUE, idx1 = 0;
        for (int i = 0; i < n; i++) {
            if (Math.abs(nums1[i] - nums2[idx2]) < min) {
                min = Math.abs(nums1[i] - nums2[idx2]);
                idx1 = i;
            }
        }
        nums[idx2] = Math.abs(nums1[idx1] - nums2[idx2]);

        long res = 0L;
        for (int i = 0; i < n; i++) {
            res += nums[i];
        }
        return (int) (res % 1000000007);
    }

    public int countDifferentSubsequenceGCDs(int[] nums) {
        Set<Integer> set = new HashSet<>();

        return set.size();
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
