package com.yuanhaoji.leetcode.stack.asteroid_collision;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void asteroidCollision() {
        int[] a = new int[]{-2, -1, 1, 2};
        System.out.println(Arrays.toString(new Solution().asteroidCollision(a)));
    }
}