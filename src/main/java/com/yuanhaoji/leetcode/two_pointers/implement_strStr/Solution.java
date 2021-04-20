package com.yuanhaoji.leetcode.two_pointers.implement_strStr;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/4/20
 * @desp: 28简单题——实现 strStr()，https://leetcode-cn.com/problems/implement-strstr/
 */
public class Solution {

    /**
     * 暴力法
     */
    // public int strStr(String haystack, String needle) {
    //     int m = haystack.length(), n = needle.length();
    //     for (int i = 0; i <= m - n; i++) {
    //         boolean found = true;
    //         for (int j = 0; j < n; j++) {
    //             if (haystack.charAt(i + j) != needle.charAt(j)) {
    //                 found = false;
    //                 break;
    //             }
    //         }
    //         if (found) {
    //             return i;
    //         }
    //     }
    //
    //     return -1;
    // }

    /**
     * KMP
     */
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

}
