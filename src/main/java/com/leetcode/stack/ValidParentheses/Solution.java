package com.leetcode.stack.ValidParentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/7/30
 * @desp: 20简单题——有效的括号，https://leetcode-cn.com/problems/valid-parentheses/
 */

public class Solution {

    /**
     * 1. 官方题解
     * () {} []
     */
//    private Map<Character, Character> map;
//
//    public Solution() {
//        map = new HashMap<>();
//        map.put(')', '(');
//        map.put('}', '{');
//        map.put(']', '[');
//    }
//
//    public boolean isValid(String s) {
//        int length = s.length();
//        if (length % 2 == 1)
//            return false;
//
//        Stack<Character> stack = new Stack<>();
//        char c, top;
//
//        for (int i = 0; i < length; ++i) {
//            c = s.charAt(i);
//
//            if (map.containsKey(c)) {
//                //  是右括号，判断是否与栈顶元素相符
//                top = stack.isEmpty() ? '#' : stack.pop();
//                if (map.get(c) != top)
//                    return false;
//            } else {
//                //  是左括号，直接入栈
//                stack.push(c);
//            }
//        }
//
//        return stack.isEmpty();
//    }

    /**
     * 2. 字符串替换
     * 如果括号有效，则最内层必定有左右括号相连
     */
//    public boolean isValid(String s) {
//        if (s.length() % 2 != 0) {
//            return false;
//        }
//
//        int t = s.length() / 2;
//        while (t > 0) {
//            s = s.replace("()", "").replace("[]", "").replace("{}", "");
//            --t;
//        }
//
//        return s.isEmpty();
//    }


    /**
     * 3. 官方题解的另外一种实现
     */
    public boolean isValid(String s) {
        int length = s.length();
        if (length % 2 == 1)
            return false;

        Stack<Character> stack = new Stack<>();
        char c;

        for (int i = 0; i < length; ++i) {
            c = s.charAt(i);

            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }

        return stack.isEmpty();
    }

}
