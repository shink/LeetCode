package com.yuanhaoji.leetcode.stack.evaluate_reverse_polish_notation;

import java.util.Stack;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/3/20
 * @desp: 150中等题——逆波兰表达式求值，https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 */

public class Solution {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int a, b;
        for (String s : tokens) {
            switch (s) {
                case "+":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a + b);
                    break;
                case "-":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a - b);
                    break;
                case "*":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a * b);
                    break;
                case "/":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a / b);
                    break;
                default:
                    stack.push(Integer.valueOf(s));
                    break;
            }
        }

        return stack.pop();
    }

}
