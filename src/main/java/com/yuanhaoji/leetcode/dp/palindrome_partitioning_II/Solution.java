package com.yuanhaoji.leetcode.dp.palindrome_partitioning_II;

import java.util.Arrays;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/3/8
 * @desp: 132困难题——分割回文串 II，https://leetcode-cn.com/problems/palindrome-partitioning-ii/
 */

public class Solution {

    /**
     * dp：
     * <p>
     * dp[i] 表示字符串前缀 s[0..i] 的最少分割次数
     * <p>
     * 枚举最后一个回文串的起始位置 j + 1，保证 s[j + 1..i] 是一个回文串
     * 那么 dp[i] 就可以从 dp[j] 转移而来，并再加一次分割次数
     * <p>
     * dp[i] = min{ dp[j] } + 1,        0 < j < i 且 s[j + 1..i] 是一个回文串
     */
    public int minCut(String s) {
        int n = s.length();
        boolean[][] flag = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (i >= j) {
                    flag[i][j] = true;
                } else {
                    flag[i][j] = s.charAt(i) == s.charAt(j) && flag[i - 1][j + 1];
                }
            }
        }

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < n; ++i) {
            if (flag[0][i]) {
                dp[i] = 0;
            } else {
                for (int j = 0; j < i; ++j) {
                    if (flag[j + 1][i]) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }

        return dp[n - 1];
    }

}
