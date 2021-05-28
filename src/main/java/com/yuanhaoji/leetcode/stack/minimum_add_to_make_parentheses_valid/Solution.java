package com.yuanhaoji.leetcode.stack.minimum_add_to_make_parentheses_valid;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/5/28
 * @desp: 921中等题——使括号有效的最少添加，https://leetcode-cn.com/problems/minimum-add-to-make-parentheses-valid/
 */
public class Solution {

    /**
     * 栈
     */
    // public int minAddToMakeValid(String s) {
    //     Deque<Character> stack = new LinkedList<>();
    //     int res = 0;
    //     for (int i = 0; i < s.length(); i++) {
    //         char c = s.charAt(i);
    //         if (c == '(') {
    //             stack.push(c);
    //         } else {
    //             if (stack.isEmpty()) {
    //                 ++res;
    //             } else {
    //                 stack.pop();
    //             }
    //         }
    //     }
    //     res += stack.size();
    //     return res;
    // }

    /**
     * 栈的优化版
     */
    // public int minAddToMakeValid(String s) {
    //     int num = 0, res = 0;
    //     for (int i = 0; i < s.length(); i++) {
    //         char ch = s.charAt(i);
    //         if (ch == '(') {
    //             ++num;
    //         } else {
    //             if (num == 0) {
    //                 ++res;
    //             } else {
    //                 --num;
    //             }
    //         }
    //     }
    //     res += num;
    //     return res;
    // }

    /**
     * 官方题解
     */
    public int minAddToMakeValid(String s) {
        int num = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            num += (s.charAt(i) == '(' ? 1 : -1);
            if (num == -1) {
                ++num;
                ++res;
            }
        }
        return res + num;
    }

}
