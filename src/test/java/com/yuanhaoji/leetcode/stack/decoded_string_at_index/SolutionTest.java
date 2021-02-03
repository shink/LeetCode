package com.yuanhaoji.leetcode.stack.decoded_string_at_index;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/2/3
 * @desp:
 */
public class SolutionTest {

    @Test
    public void decodeAtIndex() {
        String S = "a2b2";
        System.out.println(new Solution().decodeAtIndex(S, 5));
    }
}