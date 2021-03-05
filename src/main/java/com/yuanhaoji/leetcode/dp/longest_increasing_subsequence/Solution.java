package com.yuanhaoji.leetcode.dp.longest_increasing_subsequence;

import java.util.Arrays;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/3/4
 * @desp: 330中等题——最长递增子序列，https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */

public class Solution {

    /**
     * dp
     * <p>
     * dp[i]表示前 i 个元素中最长子序列的最大值
     * dp[i] = max(dp[j]) + 1，0 <= j < i 且 nums[i] > nums[j]
     * <p>
     * 注意：
     * 答案并非就是 dp[n - 1]
     * 在更新 dp[i] 时，只关注了小于 nums[i] 的数，因此可能存在 nums[k] > nums[i]，dp[k] > dp[i]
     */
//    public int lengthOfLIS(int[] nums) {
//        int n = nums.length;
//        int[] dp = new int[n];
//        int max, res = 1;
//        dp[0] = 1;
//
//        for (int i = 1; i < n; i++) {
//            max = 0;
//            for (int j = 0; j < i; j++) {
//                if (nums[i] > nums[j]) {
//                    max = Math.max(max, dp[j]);
//                }
//            }
//            dp[i] = max + 1;
//            res = Math.max(res, dp[i]);
//        }
//
//        return res;
//    }

    /**
     * greedy + dp
     *
     * 贪心：使得 最长子序列中最后一个数尽可能小
     * dp[len]表示长度为 len 的最长子序列中最后一个数的最小值
     * len 表示当前最长子序列的长度，开始时 len 为 1
     * 遍历 nums，若 nums[i] > dp[len]，则 dp[len + 1] = nums[i]
     * 若 nums[i] <= dp[len]，此时最长子序列已不能扩张，但可能存在
     * 二分查找 dp，找到比 nums[i] 小的数中最小的那个数，以该数为最长子序列尾数最小值的序列的长度为 pos，则 dp[pos + 1] = nums[i]
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        int len = 1;
        dp[1] = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] > dp[len]) {
                dp[++len] = nums[i];
            } else {
                int left = 1, right = len, pos = 0;
                int mid;
                while (left <= right) {
                    mid = (left + right) >> 1;
                    if (dp[mid] < nums[i]) {
                        left = mid + 1;
                        pos = mid;
                    } else {
                        right = mid - 1;
                    }
                }
                dp[pos + 1] = nums[i];
            }
        }

        return len;
    }

}
