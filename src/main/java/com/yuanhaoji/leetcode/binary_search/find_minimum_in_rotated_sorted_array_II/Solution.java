package com.yuanhaoji.leetcode.binary_search.find_minimum_in_rotated_sorted_array_II;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/4/9
 * @desp: 154困难题——寻找旋转排序数组中的最小值 II，https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class Solution {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                --right;
            }
        }
        return nums[left];
    }

}
