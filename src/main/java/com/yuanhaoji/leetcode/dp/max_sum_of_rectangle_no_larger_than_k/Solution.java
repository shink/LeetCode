package com.yuanhaoji.leetcode.dp.max_sum_of_rectangle_no_larger_than_k;

import java.util.TreeSet;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/4/22
 * @desp: 363困难题——矩形区域不超过 K 的最大数值和，https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/
 */
public class Solution {

    // public int maxSumSubmatrix(int[][] matrix, int k) {
    //     int m = matrix.length, n = matrix[0].length;
    //     int[][] dp = new int[m + 1][n + 1];
    //     for (int i = 0; i < m; i++) {
    //         for (int j = 0; j < n; j++) {
    //             dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j] - dp[i][j] + matrix[i][j];
    //         }
    //     }
    //
    //     int res = Integer.MIN_VALUE;
    //     int sum;
    //     for (int i = 1; i <= m; i++) {
    //         for (int j = 1; j <= n; j++) {
    //             for (int ii = 0; ii < i; ii++) {
    //                 for (int jj = 0; jj < j; jj++) {
    //                     sum = dp[i][j] - dp[ii][j] - dp[i][jj] + dp[ii][jj];
    //                     if (sum <= k) {
    //                         res = Math.max(res, sum);
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //
    //     return res;
    // }

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int ans = Integer.MIN_VALUE;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; ++i) { // 枚举上边界
            int[] sum = new int[n];
            for (int j = i; j < m; ++j) { // 枚举下边界
                for (int c = 0; c < n; ++c) {
                    sum[c] += matrix[j][c]; // 更新每列的元素和
                }
                TreeSet<Integer> sumSet = new TreeSet<>();
                sumSet.add(0);
                int s = 0;
                for (int v : sum) {
                    s += v;
                    Integer ceil = sumSet.ceiling(s - k);
                    if (ceil != null) {
                        ans = Math.max(ans, s - ceil);
                    }
                    sumSet.add(s);
                }
            }
        }
        return ans;
    }

}
