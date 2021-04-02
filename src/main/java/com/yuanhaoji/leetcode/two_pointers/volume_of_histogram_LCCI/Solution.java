package com.yuanhaoji.leetcode.two_pointers.volume_of_histogram_LCCI;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/4/2
 * @desp:  面试题 17.21 困难题——直方图的水量，https://leetcode-cn.com/problems/volume-of-histogram-lcci/
 */
public class Solution {

    /**
     * DP
     */
    // public int trap(int[] height) {
    //     if (height == null || height.length <= 1) {
    //         return 0;
    //     }
    //
    //     int n = height.length;
    //     int[] left = new int[n];
    //     int[] right = new int[n];
    //     left[0] = height[0];
    //     right[n - 1] = height[n - 1];
    //     for (int i = 1; i < n; i++) {
    //         left[i] = Math.max(left[i - 1], height[i]);
    //         right[n - i - 1] = Math.max(right[n - i], height[n - i - 1]);
    //     }
    //
    //     int res = 0;
    //     for (int i = 0; i < n; i++) {
    //         res += Math.min(left[i], right[i]) - height[i];
    //     }
    //
    //     return res;
    // }


    /**
     * 单调栈
     */
    // public int trap(int[] height) {
    //     int n = height.length;
    //     int res = 0;
    //     Deque<Integer> stack = new LinkedList<>();
    //
    //     for (int i = 0; i < n; i++) {
    //         while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
    //             int top = stack.pop();
    //             if (stack.isEmpty()) {
    //                 break;
    //             }
    //             int left = stack.peek();
    //             int w = i - left - 1;
    //             int h = Math.min(height[left], height[i]) - height[top];
    //             res += w * h;
    //         }
    //         stack.push(i);
    //     }
    //
    //     return res;
    // }


    /**
     * 双指针
     */
    public int trap(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                res += leftMax - height[left];
                ++left;
            } else {
                res += rightMax - height[right];
                --right;
            }
        }

        return res;
    }


}
