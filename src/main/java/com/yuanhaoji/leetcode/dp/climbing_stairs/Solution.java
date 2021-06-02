package com.yuanhaoji.leetcode.dp.climbing_stairs;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/6/2
 * @desp: 70简单题——爬楼梯，https://leetcode-cn.com/problems/climbing-stairs/
 */
public class Solution {

    /**
     * dp
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int num1 = 1, num2 = 2;
        for (int i = 3; i <= n; i++) {
            int temp = num1 + num2;
            num1 = num2;
            num2 = temp;
        }

        return num2;

        // if (n <= 2) {
        //     return n;
        // }
        // return climbStairs(n - 1) + climbStairs(n - 2);
    }

}
