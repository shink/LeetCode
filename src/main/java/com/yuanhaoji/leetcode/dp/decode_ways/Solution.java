package com.yuanhaoji.leetcode.dp.decode_ways;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/4/21
 * @desp: 91中等题——解码方法，https://leetcode-cn.com/problems/decode-ways/
 */
public class Solution {

    public int numDecodings(String s) {
        int n = s.length();
        // a = arr[i-2], b = arr[i-1], c = arr[i]
        char[] arr = s.toCharArray();
        int a = 0, b = 1, c = 0;
        for (int i = 1; i <= n; ++i) {
            c = 0;
            if (arr[i - 1] != '0') {
                c += b;
            }
            if (i > 1 && arr[i - 2] != '0' && ((arr[i - 2] - '0') * 10 + (arr[i - 1] - '0') <= 26)) {
                c += a;
            }
            a = b;
            b = c;
        }
        return c;
    }

}
