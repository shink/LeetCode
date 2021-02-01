package com.yuanhaoji.leetcode.array.fair_candy_swap;

import java.util.Arrays;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/2/1
 * @desp: 888简单题——公平的糖果棒交换，https://leetcode-cn.com/problems/fair-candy-swap/
 */
public class Solution {

    /**
     * 1. 暴力法，O(n2)
     */
    // public int[] fairCandySwap(int[] A, int[] B) {
    //     int[] res = new int[2];
    //     int aliceSum = Arrays.stream(A).sum();
    //     int bobSum = Arrays.stream(B).sum();
    //     int delta = aliceSum - bobSum;
    //
    //     for (int a : A) {
    //         for (int b : B) {
    //             if ((2 * (a - b)) == delta) {
    //                 res[0] = a;
    //                 res[1] = b;
    //                 return res;
    //             }
    //         }
    //     }
    //
    //     return res;
    // }

    /**
     * 2. 排序之后二分查找
     */
    public int[] fairCandySwap(int[] A, int[] B) {
        int aliceSum = Arrays.stream(A).sum();
        int bobSum = Arrays.stream(B).sum();
        int average = (aliceSum - bobSum) / 2;

        Arrays.sort(A);
        Arrays.sort(B);

        int i = 0, j = 0;
        int delta;
        int aliceLength = A.length;
        int bobLength = B.length;
        int[] res = new int[2];
        while (i < aliceLength && j < bobLength) {
            delta = A[i] - B[j];
            if (delta == average) {
                res[0] = A[i];
                res[1] = B[j];
                return res;
            }

            if (delta < average) {
                ++i;
            }else {
                ++j;
            }
        }

        return res;
    }

}
