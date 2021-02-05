package com.yuanhaoji.leetcode.stack.score_of_parentheses;

import java.util.Stack;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/2/5
 * @desp: 856中等题——括号的分数，https://leetcode-cn.com/problems/score-of-parentheses/
 */

public class Solution {

    /**
     * 分治：左括号 +1，右括号 -1，当值为 0 时，左边必然构成一个最小的 平衡括号
     * 可以递归进入左边字符，若左边只有一对括号，则 +1，否则 += 2 * (左边字符分数)
     */
    // public int scoreOfParentheses(String S) {
    //     return recursion(S, 0, S.length());
    // }
    //
    // private int recursion(String S, int left, int right) {
    //     int res = 0, val = 0;
    //     for (int i = left; i < right; i++) {
    //         val += (S.charAt(i) == '(' ? 1 : -1);
    //         if (val == 0) {
    //             if (i == left + 1) {
    //                 ++res;
    //             } else {
    //                 res += 2 * recursion(S, left + 1, i);
    //             }
    //             left = i + 1;
    //         }
    //     }
    //     return res;
    // }

    /**
     * 栈
     */
    // public int scoreOfParentheses(String S) {
    //     Stack<Integer> stack = new Stack();
    //     stack.push(0);
    //
    //     for (char c: S.toCharArray()) {
    //         if (c == '(')
    //             stack.push(0);
    //         else {
    //             int v = stack.pop();
    //             int w = stack.pop();
    //             stack.push(w + Math.max(2 * v, 1));
    //         }
    //     }
    //
    //     return stack.pop();
    // }


    /**
     * 统计核心的数目
     */
    public int scoreOfParentheses(String S) {
        int res = 0, depth = 0;
        int length = S.length();
        boolean isLeft = false;

        for (int i = 0; i < length; i++) {
            if (S.charAt(i) == '(') {
                ++depth;
                isLeft = true;
            } else {
                --depth;
                if (isLeft) {
                    res += 1 << depth;
                    isLeft = false;
                }
            }
        }

        return res;
    }

}
