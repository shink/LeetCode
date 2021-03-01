package com.yuanhaoji.leetcode.dp.range_sum_query_immutable;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/3/1
 * @desp: 303简单题——区域和检索 - 数组不可变，https://leetcode-cn.com/problems/range-sum-query-immutable/
 */

public class NumArray {

    /**
     * numArray 保存前缀和
     * numArray[i] = numArray[i - 1] + nums[i - 1]
     * res = numArray[j + 1] - numArray[i]
     */
    private final int[] numArray;

    public NumArray(int[] nums) {
        int length = nums.length;
        numArray = new int[length + 1];

        for (int i = 1; i <= length; ++i) {
            numArray[i] = numArray[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return numArray[j + 1] - numArray[i];
    }

}
