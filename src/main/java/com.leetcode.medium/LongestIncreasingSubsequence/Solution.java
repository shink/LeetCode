package LongestIncreasingSubsequence;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/3/14
 * @desp: 300题——最长上升子序列, https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */

public class Solution {

    /**
     * 动态规划
     */
    //    public int lengthOfLIS(int[] nums) {
    //
    //        if (nums.length == 0) {
    //            return 0;
    //        }
    //
    //        int i, j;
    //        int res = 1;
    //        int length = nums.length;
    //        // dp[i] 表示前i个元素中，以nums[i]结尾的最长子序列的长度
    //        int[] dp = new int[length];
    //        dp[0] = 1;
    //
    //        for (i = 1; i < length; i++) {
    //            int tmp = 0;
    //            for (j = 0; j < i; j++) {
    //                if (nums[j] < nums[i]) {
    //                    tmp = Math.max(tmp, dp[j]);
    //                }
    //            }
    //            dp[i] = tmp + 1;
    //            res = Math.max(res, dp[i]);
    //        }
    //
    //        return res;
    //    }

    /**
     * 贪心+二分查找
     */
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int i = 0, j = res;
            while (i < j) {
                int m = (i + j) / 2;
                if (tails[m] < num)
                    i = m + 1;
                else
                    j = m;

            }
            tails[i] = num;
            if (res == j)
                res++;
        }
        return res;
    }

}
