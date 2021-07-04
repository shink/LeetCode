package com.yuanhaoji.leetcode.weekly_contest.weekly_248;

import java.util.Arrays;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/7/4
 * @desp:
 */
public class Solution {

    public int[] buildArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }

    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        for (int i = 0; i < n; i++) {
            int time;
            if (dist[i] % speed[i] == 0) time = dist[i] / speed[i];
            else time = dist[i] / speed[i] + 1;
            dist[i] = time;
        }

        Arrays.sort(dist);
        int cur = 0, res = 0;
        for (int i = 0; i < n; i++) {
            if (dist[i] >= cur) {
                ++res;
            }
            ++cur;
        }
        return res;
    }

    public int countGoodNumbers(long n) {
        long x = n >> 1;
        long y = n - x;
        int mod = (int) (1e9 + 7);
        return (int) (pow(4, x, mod) * pow(5, y, mod) % mod);
    }

    private long pow(long x, long n, int mod) {
        if (n == 0) {
            return 1;
        }

        long res = pow(x, n >> 1, mod);
        res = res * res % mod;
        if ((n & 1) == 1) {
            res = res * x % mod;
        }
        return res;
    }

}
