package com.yuanhaoji.leetcode.dp.maximum_subarray;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/5/31
 * @desp: 53简单题——最大子序和，https://leetcode-cn.com/problems/maximum-subarray/
 */
public class Solution {

    /**
     * dp
     */
    public int maxSubArray(int[] nums) {
        int res = nums[0], pre = 0;
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            res = Math.max(res, pre);
        }
        return res;
    }

}
