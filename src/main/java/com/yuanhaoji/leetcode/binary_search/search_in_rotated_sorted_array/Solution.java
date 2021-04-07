package com.yuanhaoji.leetcode.binary_search.search_in_rotated_sorted_array;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/4/7
 * @desp: 33中等题——搜索旋转排序数组，https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */

public class Solution {

    /**
     * 二分查找
     */
    // public int search(int[] nums, int target) {
    //     if (nums == null || nums.length == 0) {
    //         return -1;
    //     }
    //     if (nums.length == 1) {
    //         return nums[0] == target ? 0 : -1;
    //     }
    //     return recur(nums, 0, nums.length - 1, target);
    // }
    //
    // private int recur(int[] nums, int left, int right, int target) {
    //     if (left == right) {
    //         return nums[left] == target ? left : -1;
    //     }
    //
    //     int mid = (left + right) / 2;
    //     int leftRes = recur(nums, left, mid, target);
    //     return leftRes != -1 ? leftRes : recur(nums, mid + 1, right, target);
    // }

    /**
     * 如果 [l, mid - 1] 是有序数组，且 target 的大小满足 [nums[l],nums[mid])
     * 则我们应该将搜索范围缩小至 [l, mid - 1]，否则在 [mid + 1, r] 中寻找
     * 如果 [mid, r] 是有序数组，且 target 的大小满足 nums[mid+1],nums[r]]
     * 则我们应该将搜索范围缩小至 [mid + 1, r]，否则在 [l, mid - 1] 中寻找
     */
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] < nums[high]) {
            if (nums[mid] < target && target <= nums[high]) {
                return search(nums, mid + 1, high, target);
            } else {
                return search(nums, low, mid - 1, target);
            }
        } else {
            if (nums[low] <= target && target < nums[mid]) {
                return search(nums, low, mid - 1, target);
            } else {
                return search(nums, mid + 1, high, target);
            }
        }
    }

}
