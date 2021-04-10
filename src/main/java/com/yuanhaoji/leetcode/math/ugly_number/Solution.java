package com.yuanhaoji.leetcode.math.ugly_number;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/4/10
 * @desp: 263简单题——丑数，https://leetcode-cn.com/problems/ugly-number/
 */
public class Solution {

    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }

        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        return n == 1;
    }

}
