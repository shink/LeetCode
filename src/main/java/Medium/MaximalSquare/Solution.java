package MaximalSquare;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/5/8
 * @desp: 221题——最大正方形, https://leetcode-cn.com/problems/maximal-square/
 */

public class Solution {
    /**
     * 动态规划
     * dp[i][j]表示以(i, j)为右下角的最大正方形的边长
     * dp[i][j] = 1 + min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1])
     * 即：边长为左上、上、左的最大正方形边长中的最小值，加上该条边
     */
    public int maximalSquare(char[][] matrix) {
        int res = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return res;

        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]);
                    res = Math.max(res, dp[i][j]);
                }
            }
        }

        return res * res;
    }
}
