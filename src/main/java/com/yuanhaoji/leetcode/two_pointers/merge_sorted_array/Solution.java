package com.yuanhaoji.leetcode.two_pointers.merge_sorted_array;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/4/5
 * @desp: 88简单题——合并两个有序数组，https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m + n - 1;
        int p1 = m - 1, p2 = n - 1;
        while (p >= 0 && p1 >= 0 && p2 >= 0) {
            nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        while (p >= 0 && p1 >= 0) {
            nums1[p--] = nums1[p1--];
        }
        while (p >= 0 && p2 >= 0) {
            nums1[p--] = nums2[p2--];
        }
    }

}
