package com.yuanhaoji.leetcode.dp.transform_information;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/7/1
 * @desp: LCP 07 简单题——传递信息，https://leetcode-cn.com/problems/chuan-di-xin-xi/
 */
public class Solution {

    /**
     * dfs
     */

    // private int res = 0;
    //
    // public int numWays(int n, int[][] relation, int k) {
    //     boolean[][] graph = new boolean[n][n];
    //
    //     for (int[] arr : relation) {
    //         graph[arr[0]][arr[1]] = true;
    //     }
    //
    //     dfs(graph, n, k, 0, 0);
    //     return res;
    // }
    //
    // private void dfs(boolean[][] graph, int n, int k, int cur, int depth) {
    //     if (depth == k) {
    //         if (cur == n - 1) ++res;
    //         return;
    //     }
    //
    //     for (int i = 0; i < n; i++) {
    //         if (!graph[cur][i]) continue;
    //
    //         dfs(graph, n, k, i, depth + 1);
    //     }
    // }

    /**
     * dp
     */
    public int numWays(int n, int[][] relation, int k) {
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        for (int i = 0; i < k; i++) {
            for (int[] arr : relation) {
                int src = arr[0], dest = arr[1];
                dp[i + 1][dest] += dp[i][src];
            }
        }

        return dp[k][n - 1];
    }

}
