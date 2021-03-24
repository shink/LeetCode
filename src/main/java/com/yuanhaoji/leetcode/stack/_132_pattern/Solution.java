package com.yuanhaoji.leetcode.stack._132_pattern;

import java.util.Stack;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/9/29
 * @desp: 456中等题——132模式，https://leetcode-cn.com/problems/132-pattern/
 */

public class Solution {

    /**
     * 暴力法
     * O(n2)
     */
    // public boolean find132pattern(int[] nums) {
    //     if (nums.length < 3) {
    //         return false;
    //     }
    //
    //     int n = nums.length;
    //     int i = 0;
    //     for (int j = i + 1; j < n - 1; j++) {
    //         if (nums[j] <= nums[i]) {
    //             i = j;
    //             continue;
    //         }
    //
    //         for (int k = j + 1; k < n; k++) {
    //             if (nums[k] < nums[j] && nums[k] > nums[i]) {
    //                 return true;
    //             }
    //         }
    //     }
    //
    //     return false;
    // }

    /**
     * a[i] < a[k] < a[j], i < j < k
     */
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] min = new int[n];

        //  1. dp：min[j] = min(a[0 .. j])
        min[0] = nums[0];
        for (int i = 1; i < n; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }

        /**
         * 使用递减栈，栈中存储 a[k]，即栈中元素都是 j 后面的元素
         * min[j] = a[i]
         * 后往前扫描 a[j]
         */
        for (int j = n - 1; j >= 0; j--) {
            if (nums[j] > min[j]) {
                while (!stack.isEmpty() && stack.peek() <= min[j]) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() < nums[j]) {
                    return true;
                }
                stack.push(nums[j]);
            }
        }
        return false;
    }

}
