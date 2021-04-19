package com.yuanhaoji.leetcode.two_pointers.remove_element;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/4/19
 * @desp: 27简单题——移除元素，https://leetcode-cn.com/problems/remove-element/
 */
public class Solution {

    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }

        return j;
    }

}
