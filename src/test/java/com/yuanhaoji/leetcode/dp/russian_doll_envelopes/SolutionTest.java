package com.yuanhaoji.leetcode.dp.russian_doll_envelopes;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/3/5
 * @desp:
 */

public class SolutionTest {

    @Test
    public void maxEnvelopes() {
        int[][] envelopes = new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        System.out.println(new Solution().maxEnvelopes(envelopes));
    }
}