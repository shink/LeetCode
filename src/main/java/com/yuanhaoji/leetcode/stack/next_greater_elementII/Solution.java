package com.yuanhaoji.leetcode.stack.next_greater_elementII;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/3/6
 * @desp: 503中等题——下一个更大元素，https://leetcode-cn.com/problems/next-greater-element-ii/
 */

public class Solution {

    /**
     * 暴力法
     */
    // public int[] nextGreaterElements(int[] nums) {
    //     if (nums == null) {
    //         return null;
    //     }
    //
    //     int n = nums.length;
    //     int[] res = new int[n];
    //     for (int i = 0; i < n; i++) {
    //         int max = -1;
    //         boolean found = false;
    //         for (int j = i + 1; j < n; j++) {
    //             if (nums[j] > nums[i]) {
    //                 max = nums[j];
    //                 found = true;
    //                 break;
    //             }
    //         }
    //
    //         if(!found){
    //             for (int j = 0; j < i; j++) {
    //                 if (nums[j] > nums[i]) {
    //                     max = nums[j];
    //                     break;
    //                 }
    //             }
    //         }
    //         res[i] = max;
    //     }
    //
    //     return res;
    // }

    /**
     * 单调栈 + 循环数组
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                res[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }

        return res;
    }

}
