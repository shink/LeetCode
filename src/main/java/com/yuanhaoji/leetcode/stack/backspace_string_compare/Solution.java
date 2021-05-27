package com.yuanhaoji.leetcode.stack.backspace_string_compare;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/5/27
 * @desp: 844简单题——比较含退格的字符串，https://leetcode-cn.com/problems/backspace-string-compare/
 */
public class Solution {

    /**
     * 栈
     */
    // public boolean backspaceCompare(String s, String t) {
    //     return getString(s).equals(getString(t));
    // }
    //
    // private String getString(String s) {
    //     Deque<Character> stack = new LinkedList<>();
    //     for (int i = 0; i < s.length(); i++) {
    //         char ch = s.charAt(i);
    //         if (ch == '#') {
    //             if (!stack.isEmpty()) {
    //                 stack.pop();
    //             }
    //         } else {
    //             stack.push(ch);
    //         }
    //     }
    //
    //     char[] chars = new char[stack.size()];
    //     for (int i = stack.size() - 1; i >= 0; i--) {
    //         chars[i] = stack.pop();
    //     }
    //     return new String(chars);
    // }

    /**
     * 双指针
     */
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }

}
