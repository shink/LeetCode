package com.yuanhaoji.leetcode.stack.baseball_game;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/5/26
 * @desp: 682简单题——棒球比赛，https://leetcode-cn.com/problems/baseball-game/
 */
public class Solution {

    /**
     * 栈
     */
    public int calPoints(String[] ops) {
        Deque<Integer> stack = new LinkedList<>();

        for (String op : ops) {
            if ("+".equals(op)) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2);
                stack.push(num1);
                stack.push(num1 + num2);
            } else if ("D".equals(op)) {
                stack.push(2 * stack.peek());
            } else if ("C".equals(op)) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(op));
            }
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

}
