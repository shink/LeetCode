package com.yuanhaoji.leetcode.bit_manipulation.count_triplets_that_can_form_two_arrays_of_equal_XOR;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/4/25
 * @desp: 1442中等题——形成两个异或相等数组的三元组数目，https://leetcode-cn.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/
 */
public class Solution {

    public int countTriplets(int[] arr) {
        int length = arr.length;
        int res = 0;

        for (int i = 0; i < length - 1; i++) {
            int sum = 0;
            for (int k = i; k < length; k++) {
                sum ^= arr[k];
                if (sum == 0 && k > i) {
                    res += (k - i);
                }
            }
        }
        return res;
    }

}
