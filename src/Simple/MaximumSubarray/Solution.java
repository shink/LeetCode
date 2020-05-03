package MaximumSubarray;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/5/3
 * @desp: 53题——最大子序和, https://leetcode-cn.com/problems/maximum-subarray/
 */

public class Solution {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                res = Math.max(res, sum);
            }
        }
        return res;
    }
}
