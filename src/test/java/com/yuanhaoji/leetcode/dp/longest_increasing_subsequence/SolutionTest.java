package com.yuanhaoji.leetcode.dp.longest_increasing_subsequence;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void lengthOfLIS() {
        int[] nums = new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6};
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLIS(nums));
    }
}