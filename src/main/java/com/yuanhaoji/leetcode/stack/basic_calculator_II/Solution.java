package com.yuanhaoji.leetcode.stack.basic_calculator_II;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/3/11
 * @desp: 227中等题——基本计算器 II，https://leetcode-cn.com/problems/basic-calculator-ii/
 */

public class Solution {

    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();

        char[] charArray = s.toCharArray();
        char lastSign = '+';
        int n = s.length(), num = 0;
        int i = 0;
        while (i < n) {
            if (Character.isDigit(charArray[i])) {
                num = charArray[i++] - '0';
                while (i < n && Character.isDigit(charArray[i])) {
                    num = num * 10 + (charArray[i++] - '0');
                }
            }

            if (i == n || i == n - 1 || (i < n && charArray[i] != ' ')) {
                switch (lastSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                    default:
                        break;
                }

                if (i < n) {
                    lastSign = charArray[i];
                }
            }
            ++i;
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}

