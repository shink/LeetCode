package com.yuanhaoji.leetcode.math.rabbits_in_forest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/4/4
 * @desp: 781中等题——森林中的兔子，https://leetcode-cn.com/problems/rabbits-in-forest/
 */
public class Solution {

    public int numRabbits(int[] answers) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int y : answers) {
            count.put(y, count.getOrDefault(y, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int y = entry.getKey(), x = entry.getValue();
            res += (x + y) / (y + 1) * (y + 1);
        }
        return res;
    }

}
