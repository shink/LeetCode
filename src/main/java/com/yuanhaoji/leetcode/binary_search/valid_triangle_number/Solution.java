package com.yuanhaoji.leetcode.binary_search.valid_triangle_number;

import java.util.Arrays;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/8/4
 * @desp: 611 中等题——有效三角形的个数，https://leetcode-cn.com/problems/valid-triangle-number/
 */
public class Solution {

    /**
     * 排序 + 二分查找
     * 排序后，固定 a 和 b，寻找第一个大于或等于 a + b 的值
     */
    // public int triangleNumber(int[] nums) {
    //     Arrays.sort(nums);
    //     int res = 0, n = nums.length;
    //     for (int i = 0; i < n - 2; i++) {
    //         for (int j = i + 1; j < n - 1; j++) {
    //             int left = j + 1, right = n - 1;
    //             while (left <= right) {
    //                 int mid = left + ((right - left) >> 1);
    //                 if (nums[i] + nums[j] > nums[mid]) left = mid + 1;
    //                 else right = mid - 1;
    //             }
    //             res += left - j - 1;
    //         }
    //     }
    //     return res;
    // }

    /**
     * 排序 + 双指针
     * 排序后，固定 a，把 b 和 c 看成两个双指针，一起向后移动
     * 可以看成找 c 的时候复用了上一次的结果
     */
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int k = i + 1;
            for (int j = i + 1; j < n - 1; j++) {
                while (k < n && nums[k] < nums[i] + nums[j]) ++k;
                res += Math.max(k - j - 1, 0);
            }
        }
        return res;
    }

}
