package com.yuanhaoji.leetcode.stack.basic_calculator;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/3/10
 * @desp: 224题——基本计算器，https://leetcode-cn.com/problems/basic-calculator/
 */

public class Solution {

    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);

        char[] charArray = s.toCharArray();
        int sign = 1, res = 0, n = s.length();
        int i = 0;
        while (i < n) {
            if (charArray[i] == ' ') {
                i++;
            } else if (charArray[i] == '+') {
                sign = stack.peek();
                i++;
            } else if (charArray[i] == '-') {
                sign = -stack.peek();
                i++;
            } else if (charArray[i] == '(') {
                stack.push(sign);
                i++;
            } else if (charArray[i] == ')') {
                stack.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(charArray[i])) {
                    num = num * 10 + charArray[i] - '0';
                    i++;
                }
                res += sign * num;
            }
        }
        return res;
    }

}
