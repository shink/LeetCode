package NumberOfWaysToPaintNx3Grid;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/4/12
 * @desp: 周赛184场5383题——给 N x 3 网格图涂色的方案数, https://leetcode-cn.com/contest/weekly-contest-184/problems/number-of-ways-to-paint-n-x-3-grid/
 */

public class Solution {
    public int numOfWays(int n) {
        /**
         * 每一行分为 ABA(使用AB两种颜色) 和 ABC(使用三种颜色) 这样的两种情况， 且仅有这两种情况
         * 在ABA的情况下下一行有 三色情况：CAB,ABC 双色情况：BAB,CAC,CBC这样总共5种情况
         * 在ABC的情况下下一样有 三色情况：CAB,BCA 双色情况：BAB,BCB这样总共4种情况，
         * dp数组中dp[i][0]存当前行双色数量 dp[i][1]存当前行三色数量 因此有如下公式：
         */
        long[][] dp = new long[n][2];
        dp[0][0] = 6;
        dp[0][1] = 6;
        for (int i = 1; i < n; i++) {
            dp[i][0] = (dp[i - 1][0] * 3 + dp[i - 1][1] * 2) % (1000000007);
            dp[i][1] = (dp[i - 1][0] * 2 + dp[i - 1][1] * 2) % (1000000007);
        }
        return (int) ((dp[n - 1][0] + dp[n - 1][1]) % (1000000007));
    }
}
