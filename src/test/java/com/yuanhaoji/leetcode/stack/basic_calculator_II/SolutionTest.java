package com.yuanhaoji.leetcode.stack.basic_calculator_II;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/3/11
 */

public class SolutionTest {

    @Test
    public void calculate() {
        String s = " 3+5 / 2 ";
        int res = new Solution().calculate(s);
        System.out.println(res);
    }
}