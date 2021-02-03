package com.yuanhaoji.leetcode.stack.decoded_string_at_index;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/1/28
 * @desp: 880中等题——索引处的解码字符串，https://leetcode-cn.com/problems/decoded-string-at-index/
 */
public class Solution {

    /**
     * 官方题解
     * 逆向解题：从后向前扫描，若 array[i] 为数字，则说明前面 0 ~ i 个字符解码后字符串重复了 array[i] 次
     * 此时，原问题的解就等于 K = K % size, S = S.subString(0, i) 的解
     * 因此，size 就变为 size /= array[i]
     * 若 array[i] 为字母，说明无需复制，此时，原问题的解就等于 K = K % size, S = S.subString(0, i) 的解，--size
     */
    public String decodeAtIndex(String S, int K) {
        int length = S.length();
        char[] array = S.toCharArray();

        long size = 0;
        for (char c : array) {
            if (c >= 'a' && c <= 'z') {
                ++size;
            } else {
                size *= (c - '0');
            }
        }

        for (int i = length - 1; i >= 0; i--) {
            K %= size;
            if (array[i] >= 'a' && array[i] <= 'z') {
                if (K == 0) {
                    return Character.toString(array[i]);
                }

                --size;
            } else {
                size /= (array[i] - '0');
            }
        }

        return "";
    }

}
