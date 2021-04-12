package com.yuanhaoji.leetcode.sort.largest_number;

import java.util.Arrays;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/4/12
 * @desp: 179中等题——最大数，https://leetcode-cn.com/problems/largest-number/
 */
public class Solution {

    public String largestNumber(int[] nums) {
        // 转换为包装类型
        int n = nums.length;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }

        Arrays.sort(arr, (x, y) -> {
            long sx = 10, sy = 10;
            while (sx <= x) {
                sx *= 10;
            }
            while (sy <= y) {
                sy *= 10;
            }
            return (int) (-sy * x - y + sx * y + x);
        });

        if (arr[0] == 0) {
            return "0";
        }

        StringBuilder builder = new StringBuilder();
        for (int num : arr) {
            builder.append(num);
        }
        return builder.toString();
    }

}
