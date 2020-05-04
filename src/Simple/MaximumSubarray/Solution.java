package MaximumSubarray;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/5/3
 * @desp: 53题——最大子序和, https://leetcode-cn.com/problems/maximum-subarray/
 */

public class Solution {

    /**
     * 暴力法
     */
    //    public int maxSubArray(int[] nums) {
    //        int res = Integer.MIN_VALUE;
    //        for (int i = 0; i < nums.length; i++) {
    //            int sum = 0;
    //            for (int j = i; j < nums.length; j++) {
    //                sum += nums[j];
    //                res = Math.max(res, sum);
    //            }
    //        }
    //        return res;
    //    }

    /**
     * 动态规划
     * dp[i]表示以nums[i]结尾的连续子数组的最大值
     * dp[i + 1] = max(dp[i] + nums[i + 1], nums[i + 1])
     * res = max(dp)
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int dp = 0, res = nums[0];
        for (int num : nums) {
            dp = Math.max(dp + num, num);
            res = Math.max(dp, res);
        }
        return res;
    }
}
