package com.yuanhaoji.leetcode.weekly_contest.weekly_231;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/3/7
 * @desp: 第 231 场周赛
 */

public class Solution {

    public boolean checkOnesSegment(String s) {
        int n = s.length();
        int i = 1;

        while (i < n && s.charAt(i) == '1') {
            ++i;
        }

        while (i < n && s.charAt(i) == '0') {
            ++i;
        }

        return i == n;
    }

    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }

        long delta = sum - goal;
        if (delta < 0) {
            delta *= -1;
        }

        long res = delta / limit;
        if (delta % limit != 0) {
            ++res;
        }

        return (int) res;
    }

}
