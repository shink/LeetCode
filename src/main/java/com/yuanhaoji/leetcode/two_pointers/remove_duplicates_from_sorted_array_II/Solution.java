package com.yuanhaoji.leetcode.two_pointers.remove_duplicates_from_sorted_array_II;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/4/6
 * @desp: 80中等题——删除有序数组中的重复项 II，https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 */

public class Solution {

    public int removeDuplicates(int[] nums) {
        int pos = 0;
        for (int num : nums) {
            if (pos < 2 || num > nums[pos - 2]) {
                nums[pos++] = num;
            }
        }
        return pos;
    }

}
