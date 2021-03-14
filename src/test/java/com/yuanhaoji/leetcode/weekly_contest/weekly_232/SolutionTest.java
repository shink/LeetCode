package com.yuanhaoji.leetcode.weekly_contest.weekly_232;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void maximumScore() {
        int[] nums = new int[]{6569, 9667, 3148, 7698, 1622, 2194, 793, 9041, 1670, 1872};
        int k = 5;

        int res = new Solution().maximumScore(nums, k);
        System.out.println(res);
    }
}
