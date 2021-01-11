package com.yuanhaoji.leetcode.stack.decode_string;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/7/27
 * @desp: 394中等题——字符串解码，https://leetcode-cn.com/problems/decode-string/
 */

public class Solution {

    //  1. 栈
//    public String decodeString(String s) {
//        int num = 0, length = s.length();
//        char c;
//        String res = "";
//        Stack<Integer> numStack = new Stack<>(); //  记录"["前面的数字
//        Stack<String> strStack = new Stack<>(); //   记录"["前数字前面的字符串
//
//        for (int i = 0; i < length; ++i) {
//            c = s.charAt(i);
//            if (c >= 48 && c < 58) {
//                num = num * 10 + (c - 48);
//            } else if (c == '[') {
//                //  入栈
//                numStack.push(num);
//                strStack.push(res);
//                num = 0;
//                res = "";
//            } else if (c == ']') {
//                //  出栈
//                int n = numStack.pop();
//                String str = strStack.pop();
//                for (int j = 0; j < n; ++j) {
//                    str += res;
//                }
//                res = str;
//            } else {
//                res += String.valueOf(c);
//            }
//        }
//        return res;
//    }

    //  2. 递归
//    String str;
//    int index;
//
//    public String decodeString(String s) {
//        str = s;
//        index = 0;
//        return recursion();
//    }
//
//    public String recursion() {
//        if (index == str.length() || str.charAt(index) == ']') {
//            return "";
//        }
//
//        char c = str.charAt(index);
//        int num = 0;
//        String res = "";
//
//        if (Character.isDigit(c)) {
//            while (Character.isDigit(str.charAt(index))) {
//                num = num * 10 + str.charAt(index++) - 48;
//            }
//            ++index;
//            String str = recursion();
//            ++index;
//            while (num-- > 0) {
//                res += str;
//            }
//        } else if (Character.isLetter(c)) {
//            res = String.valueOf(str.charAt(index++));
//        }
//
//        return res + recursion();
//    }

    //  3. 递归
    String str;
    int index, length;

    public String decodeString(String s) {
        str = s;
        index = 0;
        length = s.length();
        return recursion();
    }

    private String recursion() {
        String res = "";
        int num = 0;
        char c;

        while (index < length) {
            c = str.charAt(index);
            if (c >= 48 && c < 58) {
                num = num * 10 + c - 48;
            } else if (c == '[') {
                ++index;
                String tmp = recursion();
                while (num > 0) {
                    res += tmp;
                    --num;
                }
            } else if (c == ']') {
                break;
            } else {
                res += String.valueOf(c);
            }
            ++index;
        }
        return res;
    }

}
