package com.yuanhaoji.leetcode.weekly_contest.weekly_232;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/3/14
 * @desp: 第 232 场周赛
 */

public class Solution {

    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        int n = s1.length();
        int num = 0, charIdx1 = -1, charIdx2 = n;
        for (int i = 0; i < n; i++) {
            if (s2.charAt(i) != s1.charAt(i)) {
                ++num;
                if (num == 1) {
                    charIdx1 = i;
                } else {
                    charIdx2 = i;
                }
            }
        }

        return num == 2 && s2.charAt(charIdx1) == s1.charAt(charIdx2) && s2.charAt(charIdx2) == s1.charAt(charIdx1);
    }

    public int findCenter(int[][] edges) {
        int length = edges.length;
        int num11 = edges[0][0];
        int num12 = edges[0][1];
        int num21 = edges[1][0];
        int num22 = edges[1][1];

        if (num11 == num21 || num11 == num22) {
            return num11;
        }

        if (num12 == num21 || num12 == num22) {
            return num12;
        }

        return 0;
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        double res = 0;
        int n = classes.length;


        return 0.0;
    }

    // public int maximumScore(int[] nums, int k) {
    //     int n = nums.length;
    //     int i = k, j = k;
    //     int minLeft = Integer.MAX_VALUE, minRight = Integer.MAX_VALUE;
    //     int res = Integer.MIN_VALUE;
    //     while (i >= 0 && j < n) {
    //         if (nums[i] < minLeft) {
    //             minLeft = nums[i];
    //         }
    //         if (nums[j] < minRight) {
    //             minRight = nums[j];
    //         }
    //
    //         if (minLeft < minRight) {
    //             res = Math.max(res, minLeft * (j - i + 1));
    //             --i;
    //         } else {
    //             res = Math.max(res, minRight * (j - i + 1));
    //             ++j;
    //         }
    //     }
    //
    //     if (i < 0) {
    //         while (j < n) {
    //             minRight = Math.min(minRight, nums[j]);
    //             res = Math.max(res, minRight * (j - i + 1));
    //             ++j;
    //         }
    //     }
    //
    //     if (j == n) {
    //         while (i >= 0) {
    //             minLeft = Math.min(minLeft, nums[i]);
    //             res = Math.max(res, minLeft * (j - i + 1));
    //             --i;
    //         }
    //     }
    //
    //     System.out.println(i);
    //     System.out.println(j);
    //     return res;
    // }

    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int minLeft = Integer.MAX_VALUE, minRight = Integer.MAX_VALUE;
        int res = Integer.MIN_VALUE;

        for (int i = k; i >= 0; i--) {
            minLeft = Math.min(minLeft, nums[i]);
            minRight = Integer.MAX_VALUE;
            for (int j = k; j < n; j++) {
                minRight = Math.min(minRight, nums[j]);
                res = Math.max(res, Math.min(minLeft, minRight) * (j - i + 1));
            }
        }

        return res;
    }

}
