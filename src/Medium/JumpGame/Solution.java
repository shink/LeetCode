package JumpGame;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/4/17
 * @desp: 55题——跳跃游戏， https://leetcode-cn.com/problems/jump-game/
 */

public class Solution {

    /**
     * 官方题解，贪心
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        int length = nums.length;
        int maxPosition = 0;
        for (int i = 0; i < length; i++) {
            if (i <= maxPosition) {
                maxPosition = Math.max(maxPosition, i + nums[i]);
                if (maxPosition >= length - 1)
                    return true;
            } else
                return false;
        }
        return false;
    }


    /**
     * 我的方法，dp，复杂度较高
     */
    //    public boolean canJump(int[] nums) {
    //        if (nums == null || nums.length == 0)
    //            return false;
    //        int length = nums.length;
    //        boolean[] dp = new boolean[length];
    //        dp[0] = true;
    //        for (int i = 1; i < length; i++) {
    //            for (int j = 0; j < i; j++) {
    //                if (dp[i])
    //                    break;
    //                else
    //                    dp[i] = dp[j] ? nums[j] >= (i - j) : false;
    //            }
    //        }
    //        return dp[length - 1];
    //    }
}
