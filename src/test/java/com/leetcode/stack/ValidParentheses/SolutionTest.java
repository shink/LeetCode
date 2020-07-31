package com.leetcode.stack.ValidParentheses;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/7/30
 */

public class SolutionTest {

    @Test
    public void isValid() {
        Solution solution = new Solution();
        System.out.println(solution.isValid("([)]"));
    }
}