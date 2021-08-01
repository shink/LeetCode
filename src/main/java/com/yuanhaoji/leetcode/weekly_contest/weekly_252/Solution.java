package com.yuanhaoji.leetcode.weekly_contest.weekly_252;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/8/1
 * @desp: 第 252 场周赛
 */
public class Solution {

    public boolean isThree(int n) {
        int count = 2;
        for (int k = 2; k < n; k++) {
            if (count > 3) return false;
            double m = (double) n / (double) k;
            if ((int) m == m) {
                if ((int) m == k) count++;
                else return false;
            }
        }
        return count == 3;
    }

    /**
     * 可以完成所有工作的充要条件是：max ≤ rest + 1
     */
    public long numberOfWeeks(int[] milestones) {
        long sum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < milestones.length; i++) {
            sum += milestones[i];
            if (milestones[i] > max) max = milestones[i];
        }

        long rest = sum - max;
        if (max > rest + 1) return (rest << 1) + 1;
        else return sum;
    }

}
