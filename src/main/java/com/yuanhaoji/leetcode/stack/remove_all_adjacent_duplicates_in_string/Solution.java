package com.yuanhaoji.leetcode.stack.remove_all_adjacent_duplicates_in_string;

import java.util.Stack;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/3/9
 * @desp: 1047简单题——删除字符串中的所有相邻重复项，https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
 */

public class Solution {

    // public String removeDuplicates(String S) {
    //     Stack<Character> stack = new Stack<>();
    //     char[] charArray = S.toCharArray();
    //
    //     for (char c : charArray) {
    //         if (!stack.empty() && c == stack.peek()) {
    //             stack.pop();
    //         } else {
    //             stack.push(c);
    //         }
    //     }
    //
    //     int size = stack.size();
    //     char[] chars = new char[size];
    //     for (int i = size - 1; i >= 0; i--) {
    //         chars[i] = stack.pop();
    //     }
    //
    //     return new String(chars);
    // }

    /**
     * 官方题解
     */
    public String removeDuplicates(String S) {
        StringBuilder stack = new StringBuilder();
        char[] charArray = S.toCharArray();
        int top = -1;
        for (char ch : charArray) {
            if (top >= 0 && stack.charAt(top) == ch) {
                stack.deleteCharAt(top);
                --top;
            } else {
                stack.append(ch);
                ++top;
            }
        }
        return stack.toString();
    }

}
