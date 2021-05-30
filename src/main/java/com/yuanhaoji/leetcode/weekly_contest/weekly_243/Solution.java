package com.yuanhaoji.leetcode.weekly_contest.weekly_243;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/5/30
 * @desp: 第 243 场周赛
 */
public class Solution {

    // public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
    //     return getNum(firstWord) + getNum(secondWord) == getNum(targetWord);
    // }
    //
    // private int getNum(String str) {
    //     int length = str.length();
    //     int i = 0, num = 0;
    //     while (i < length && str.charAt(i) == 'a') {
    //         ++i;
    //     }
    //     while (i < length) {
    //         num = num * 10 + (str.charAt(i++) - 'a');
    //     }
    //     return num;
    // }

    // public String maxValue(String n, int x) {
    //     int length = n.length();
    //     boolean isNegative = n.charAt(0) == '-';
    //     boolean flag = false;
    //     StringBuilder builder = new StringBuilder();
    //     int i;
    //
    //     if (!isNegative) {
    //         for (i = 0; i < length; i++) {
    //             char ch = n.charAt(i);
    //             if ((ch - '0') >= x) {
    //                 builder.append(ch);
    //             } else {
    //                 builder.append(x);
    //                 flag = true;
    //                 break;
    //             }
    //         }
    //     } else {
    //         builder.append('-');
    //         for (i = 1; i < length; i++) {
    //             char ch = n.charAt(i);
    //             if ((ch - '0') <= x) {
    //                 builder.append(ch);
    //             } else {
    //                 builder.append(x);
    //                 flag = true;
    //                 break;
    //             }
    //         }
    //     }
    //
    //     if (!flag) {
    //         builder.append(x);
    //     } else {
    //         while (i < length) {
    //             builder.append(n.charAt(i++));
    //         }
    //     }
    //
    //     return builder.toString();
    // }

}
