package com.yuanhaoji.leetcode.backtracking.subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/3/31
 * @desp: 78中等题——子集，https://leetcode-cn.com/problems/subsets/
 */

public class Solution {

    /**
     * 从前往后遍历，遇到一个数就把所有子集加上该数组成新的子集，遍历完毕即是所有子集
     */
    // public List<List<Integer>> subsets(int[] nums) {
    //     List<List<Integer>> res = new ArrayList<>();
    //     res.add(new ArrayList<>());
    //
    //     for (int num : nums) {
    //         int n = res.size();
    //         for (int i = 0; i < n; i++) {
    //             List<Integer> list = new ArrayList<>(res.get(i));
    //             list.add(num);
    //             res.add(list);
    //         }
    //     }
    //
    //     return res;
    // }


    /**
     * DFS：0 表示不选该数字，1 表示选择该数字
     *
     *          0
     *        0   1      1
     *       0 1 0 1     2
     *     01 01 01 01   3
     */

    List<Integer> list = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return res;
    }

    private void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[cur]);
        dfs(cur + 1, nums);
        list.remove(list.size() - 1);
        dfs(cur + 1, nums);
    }

}
