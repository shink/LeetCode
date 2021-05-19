package com.yuanhaoji.leetcode.bit_manipulation.find_kth_largest_XOR_coordinate_value;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/5/19
 * @desp: 1738中等题——找出第 K 大的异或坐标值，https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value/
 */
public class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                dp[i][j] = dp[i - 1][j] ^ dp[i][j - 1] ^ dp[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                nums.add(dp[i][j]);
            }
        }

        nums.sort((num1, num2) -> num2 - num1);
        return nums.get(k - 1);
    }
}
