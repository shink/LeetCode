package com.yuanhaoji.leetcode.stack.online_stock_span;

import javafx.util.Pair;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/5/25
 * @desp: 901中等题——股票价格跨度，https://leetcode-cn.com/problems/online-stock-span/
 */
public class StockSpanner {

    /**
     * Your StockSpanner object will be instantiated and called as such:
     * StockSpanner obj = new StockSpanner();
     * int param_1 = obj.next(price);
     */

    /**
     * 数组+暴力
     */

    // private int today;
    // private final int[] prices;
    //
    // public StockSpanner() {
    //     today = 0;
    //     prices = new int[10000];
    // }
    //
    // public int next(int price) {
    //     int res = 1;
    //     for (int i = today - 1; i >= 0; i--) {
    //         if (prices[i] > price) {
    //             break;
    //         }
    //         ++res;
    //     }
    //     prices[today++] = price;
    //     return res;
    // }

    /**
     * 单调栈
     */

    private final Deque<Pair<Integer, Integer>> stack;

    public StockSpanner() {
        stack = new LinkedList<>();
    }

    public int next(int price) {
        int res = 1;
        while (!stack.isEmpty() && stack.peek().getKey() <= price) {
            res += stack.pop().getValue();
        }
        stack.push(new Pair<>(price, res));
        return res;
    }

}
