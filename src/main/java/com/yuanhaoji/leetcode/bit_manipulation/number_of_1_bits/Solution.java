package com.yuanhaoji.leetcode.bit_manipulation.number_of_1_bits;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/3/22
 * @desp: 191简单题——位1的个数，https://leetcode-cn.com/problems/number-of-1-bits/
 */

public class Solution {

    /**
     * TLE
     */
    // public int hammingWeight(int n) {
    //     int res = 0;
    //     while (n != 0) {
    //         if (n % 2 != 0) {
    //             ++res;
    //         }
    //         n = n >> 1;
    //     }
    //
    //     return res;
    // }


    // public int hammingWeight(int n) {
    //     int res = 0;
    //     for (int i = 0; i < 32; i++) {
    //         if ((n & (1 << i)) != 0) {
    //             ++res;
    //         }
    //     }
    //     return res;
    // }
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n &= (n - 1);
            ++res;
        }
        return res;
    }
}
