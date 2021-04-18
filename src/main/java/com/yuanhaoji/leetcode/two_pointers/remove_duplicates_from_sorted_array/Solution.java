package com.yuanhaoji.leetcode.two_pointers.remove_duplicates_from_sorted_array;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/4/18
 * @desp: 26简单题——删除有序数组中的重复项，https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int n = nums.length;
        int j = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }

        return ++j;
    }

}
