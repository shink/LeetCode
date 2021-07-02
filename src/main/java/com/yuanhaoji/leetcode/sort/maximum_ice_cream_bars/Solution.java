package com.yuanhaoji.leetcode.sort.maximum_ice_cream_bars;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/7/2
 * @desp: 1833中等题——雪糕的最大数量，https://leetcode-cn.com/problems/maximum-ice-cream-bars/
 */
public class Solution {

    // public int maxIceCream(int[] costs, int coins) {
    //     Arrays.sort(costs);
    //     int res = 0, sum = 0;
    //     for (int cost : costs) {
    //         if (sum + cost <= coins) {
    //             sum += cost;
    //             ++res;
    //         }
    //     }
    //     return res;
    // }

    public int maxIceCream(int[] costs, int coins) {
        int[] counts = new int[100001];
        for (int cost : costs) {
            ++counts[cost];
        }
        int res = 0, sum = 0;
        for (int cost = 1; cost < counts.length && coins >= cost; cost++) {
            int count = Math.min(counts[cost], coins / cost);
            coins -= count * cost;
            res += count;
        }
        return res;
    }

}
