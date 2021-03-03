package com.yuanhaoji.leetcode.dp.counting_bits;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/3/3
 * @desp: 338中等题——比特位计数，https://leetcode-cn.com/problems/counting-bits/
 */

public class Solution {

    /**
     * 奇偶性判断
     * <p>
     * 奇数：最低位一定是一个 1，因此 res[i] = res[i - 1] + 1
     * 偶数：最低位一定是一个 0，i 的比特数与将 i 右移一位的数的比特数相等，即 res[i] = res[i >> 1]
     */
    // public int[] countBits(int num) {
    //     int[] res = new int[num + 1];
    //     for (int i = 1; i <= num; i++) {
    //         res[i] = i % 2 == 1 ? res[i - 1] + 1 : res[i >> 1];
    //     }
    //
    //     return res;
    // }

    /**
     * 最低有效位
     * <p>
     * i 的比特数为：i 右移一位的比特数 + i 最低位的值
     */
    // public int[] countBits(int num) {
    //     int[] res = new int[num + 1];
    //     for (int i = 0; i <= num; i++) {
    //         res[i] = res[i >> 1] + (i & 1);
    //     }
    //     return res;
    // }

    /**
     * 最低设置位
     * <p>
     * i & (i - 1) 可以去掉 i 最右边的 1，因此 i 的比特数即为该值的比特数 + 1
     */
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }

}
