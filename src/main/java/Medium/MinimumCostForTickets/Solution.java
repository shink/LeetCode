package MinimumCostForTickets;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/5/6
 * @desp: 983题——最低票价, https://leetcode-cn.com/problems/minimum-cost-for-tickets/
 */

public class Solution {
    /**
     * 考虑 dp[i] 代表一年之内从 1 到 i 天旅行需要的最小花费
     * <p>
     * 如果第i天不需要出去旅行，既然不旅行，那么最优解就是尽量不花钱，所以 dp[i]=dp[i-1]
     * <p>
     * 如果第i天需要出去旅行，那么有三种情况：
     * <p>
     * 买第i天当天的票，花费costs[0]元，即 dp[i]=dp[i-1]+costs[0]
     * 7天前买的票正好延续到今天，花费即为：dp[i]=dp[i-7]+costs[1]
     * 30天前买的票正好延续到今天，花费为：dp[i]=dp[i-30]+costs[2]
     * 那么既然是最小值，我们肯定要求出这三种情况里面最小的那个了
     * 则：dp[i]=min(dp[i-1]+costs[0],dp[i-7]+costs[1],dp[i]=dp[i-30]+costs[2])
     * 注意如果i减去的值小于0，则答案为0
     */
    public int mincostTickets(int[] days, int[] costs) {
        int length = days.length;
        int[] dp = new int[days[length - 1] + 1];
        int[] occ = new int[366];

        for (int day : days) {
            occ[day]++;
        }

        for (int i = 1; i <= days[length - 1]; i++) {
            if (occ[i] == 0) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = Math.min(Math.min(dp[Math.max(0, i - 1)] + costs[0], dp[Math.max(0, i - 7)] + costs[1]), dp[Math.max(0, i - 30)] + costs[2]);
            }
        }

        return dp[days[length - 1]];
    }
}
