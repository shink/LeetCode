package com.yuanhaoji.leetcode.binary_search.find_minimum_in_rotated_sorted_array;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/4/7
 * @desp: 153中等题——寻找旋转排序数组中的最小值，https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class Solution {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

}
