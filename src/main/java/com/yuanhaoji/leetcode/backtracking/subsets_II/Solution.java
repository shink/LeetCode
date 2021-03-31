package com.yuanhaoji.leetcode.backtracking.subsets_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/3/31
 * @desp: 90中等题——子集 II，https://leetcode-cn.com/problems/subsets-ii/
 */

public class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        Arrays.sort(nums);
        int n = nums.length;
        int left, right, len = 0;
        for (int i = 0; i < n; i++) {
            left = (i != 0 && (nums[i] == nums[i - 1])) ? res.size() - len : 0;
            right = res.size();
            len = right - left;
            for (int j = left; j < right; ++j) {
                List<Integer> list = new ArrayList<>(res.get(j));
                list.add(nums[i]);
                res.add(list);
            }
        }

        return res;
    }

}
