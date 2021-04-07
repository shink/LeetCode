package com.yuanhaoji.leetcode.binary_search.search_in_rotated_sorted_array_II;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/4/7
 * @desp: 81中等题——搜索旋转排序数组 II，https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
 */

public class Solution {

    // public boolean search(int[] nums, int target) {
    //     return search(nums, 0, nums.length - 1, target);
    // }
    //
    // public boolean search(int[] nums, int left, int right, int target) {
    //     if (left > right) {
    //         return false;
    //     }
    //     int mid = (left + right) / 2;
    //     if (nums[mid] == target) {
    //         return true;
    //     }
    //
    //     if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
    //         return search(nums, left + 1, right - 1, target);
    //     }
    //
    //     if (nums[left] <= nums[mid]) {
    //         if (nums[left] <= target && target < nums[mid]) {
    //             return search(nums, left, mid - 1, target);
    //         } else {
    //             return search(nums, mid + 1, right, target);
    //         }
    //     } else {
    //         if (nums[mid] < target && target <= nums[right]) {
    //             return search(nums, mid + 1, right, target);
    //         } else {
    //             return search(nums, left, mid - 1, target);
    //         }
    //     }
    // }

    /**
     * 官方题解
     */
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return nums[0] == target;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
                ++l;
                --r;
            } else if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }

}
