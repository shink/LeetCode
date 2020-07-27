package com.leetcode.stack.TrappingRainWater;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/7/27
 */

public class SolutionTest {

    @Test
    public void trap() {
        Solution solution = new Solution();
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution.trap(height));
    }
}