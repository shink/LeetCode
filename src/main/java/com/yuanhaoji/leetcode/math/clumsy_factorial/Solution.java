package com.yuanhaoji.leetcode.math.clumsy_factorial;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/4/1
 * @desp: 1006中等题——笨阶乘，https://leetcode-cn.com/problems/clumsy-factorial/
 */

public class Solution {

    /**
     * https://leetcode-cn.com/problems/clumsy-factorial/solution/ben-jie-cheng-by-leetcode-solution-deh2/
     */
    public int clumsy(int N) {
        if (N == 1) {
            return 1;
        } else if (N == 2) {
            return 2;
        } else if (N == 3) {
            return 6;
        } else if (N == 4) {
            return 7;
        }

        if (N % 4 == 0) {
            return N + 1;
        } else if (N % 4 <= 2) {
            return N + 2;
        } else {
            return N - 1;
        }
    }

}
