package com.leetcode.stack.MiniParser;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/7/28
 */

public class SolutionTest {

    @Test
    public void deserialize() {
        Solution solution = new Solution();
        solution.deserialize("[123,[456,[789]]]");
    }
}