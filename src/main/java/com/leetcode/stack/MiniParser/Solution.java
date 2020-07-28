package com.leetcode.stack.MiniParser;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/7/28
 * @desp: 385中等题——迷你语法分析器，https://leetcode-cn.com/problems/mini-parser/
 */

public class Solution {

    private int index;
    private int length;
    private char[] charArr;

    /**
     * 民间题解
     */
    public NestedInteger deserialize(String s) {
        index = 0;
        length = s.length();
        charArr = s.toCharArray();

        return s.charAt(0) != '[' ? new NestedInteger(Integer.parseInt(s)) : recursion();
    }

    private NestedInteger recursion() {
        NestedInteger res = new NestedInteger();
        int num = 0;
        int sign = 1;
        char c;

        while (index < length - 1) {
            c = charArr[++index];

            if (c == ',') {
                continue;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '[') {
                res.add(recursion());
            } else if (c == ']') {
                return res;
            } else {
                num = num * 10 + c - 48;
                if (charArr[index + 1] == ',' || charArr[index + 1] == ']') {
                    res.add(new NestedInteger(sign * num));
                    num = 0;
                    sign = 1;
                }
            }
        }

        return null;
    }

}
