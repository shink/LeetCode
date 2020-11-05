package com.shenke.leetcode.stack.remove_k_digits;

import java.util.LinkedList;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/9/28
 * @desp: 402中等题——移掉K位数字，https://leetcode-cn.com/problems/remove-k-digits/
 */

public class Solution {

    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";

        LinkedList<Character> stack = new LinkedList<>();
        char[] array = num.toCharArray();

        for (char c : array) {
            while (stack.size() > 0 && k > 0 && stack.peekLast() > c) {
                stack.removeLast();
                --k;
            }
            stack.addLast(c);
        }

        for (int i = 0; i < k; ++i) {
            stack.removeLast();
        }

        StringBuilder res = new StringBuilder();
        boolean leadingZero = true;
        for (char digit : stack) {
            if (leadingZero && digit == '0') continue;
            leadingZero = false;
            res.append(digit);
        }

        return res.length() == 0 ? "0" : res.toString();
    }

}
