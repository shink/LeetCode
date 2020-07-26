package TheMasseuseLCCI;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/3/24
 * @desp: 面试题17.16——按摩师, https://leetcode-cn.com/problems/the-masseuse-lcci/
 */

public class Solution {
    public int massage(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int length = nums.length;
        int dp0 = 0, dp1 = nums[0];

        for (int i = 1; i < length; i++) {
            int tmp0 = Math.max(dp0, dp1);
            int tmp1 = dp0 + nums[i];

            dp0 = tmp0;
            dp1 = tmp1;
        }

        return Math.max(dp0, dp1);
    }
}
