package com.yuanhaoji.leetcode.dp.longest_common_subsequence;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/4/3
 * @desp: 1143中等题——最长公共子序列，https://leetcode-cn.com/problems/longest-common-subsequence/
 */
public class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        char ch1, ch2;
        for (int i = 1; i <= m; i++) {
            ch1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                ch2 = text2.charAt(j - 1);
                dp[i][j] = ch1 == ch2 ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m][n];
    }

}
