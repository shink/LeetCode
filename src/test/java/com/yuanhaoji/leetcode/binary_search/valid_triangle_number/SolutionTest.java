package com.yuanhaoji.leetcode.binary_search.valid_triangle_number;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/8/4
 * @desp:
 */
public class SolutionTest {

    @Test
    public void triangleNumber() {
        int[] a = new int[]{2, 2, 3, 5};
        System.out.println(new Solution().triangleNumber(a));
    }
}