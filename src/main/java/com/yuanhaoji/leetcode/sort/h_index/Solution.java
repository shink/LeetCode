package com.yuanhaoji.leetcode.sort.h_index;

import java.util.Arrays;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/7/11
 * @desp: 274中等题——H 指数，https://leetcode-cn.com/problems/h-index/
 */
public class Solution {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (citations[i] >= n - i) {
                ++res;
            } else {
                break;
            }
        }
        return res;
    }

}
