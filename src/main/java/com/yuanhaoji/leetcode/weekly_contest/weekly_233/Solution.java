package com.yuanhaoji.leetcode.weekly_contest.weekly_233;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/3/21
 * @desp: 第 233 场周赛
 */

public class Solution {

    public int maxAscendingSum(int[] nums) {
        int res = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int num = nums[i], sum = nums[i];

            for (int j = i + 1; j < n; j++) {
                if (nums[j] > num) {
                    num = nums[j];
                    sum += nums[j];
                    continue;
                }
                break;
            }

            res = Math.max(res, sum);
        }

        return res;
    }

    public int getNumberOfBacklogOrders(int[][] orders) {
        long res = 0;
        int m = orders.length;
        List<Order> buyOrders = new ArrayList<>();
        List<Order> sellOrders = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            if (orders[i][2] == 0) {

            } else {

            }
            // search();
            // 插入

        }

        return (int) (res % 10e9 + 7);
    }

    private boolean compare(Order order1, Order order2) {
        return order1.price > order2.price;
    }

    private int search(List<Order> orders, int low, int high, int price) {
        if (orders == null || low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (orders.get(mid).price == price) {
            return mid;
        } else if (orders.get(mid).price < price) {
            return search(orders, mid + 1, high, price);
        } else {
            return search(orders, low, mid - 1, price);
        }
    }

    class Order {
        private int amount;
        private int price;

        public Order(int amount, int price) {
            this.amount = amount;
            this.price = price;
        }
    }

    public int maxValue(int n, int index, int maxSum) {
        if (index == 0 && n == 1) {
            return maxSum;
        }

        maxSum -= n;
        int res = 1;
        if (maxSum >= 1) {
            ++res;
            --maxSum;
        }

        int left = Math.max(0, index - 1), right = Math.min(n - 1, index + 1);
        while (maxSum >= (right - left + 1)) {
            maxSum -= (right - left + 1);
            ++res;

            if (left == 0 && right == n - 1) {
                res += maxSum / n;
                break;
            }
            left = Math.max(0, left - 1);
            right = Math.min(n - 1, right + 1);
        }
        return res;
    }

}
