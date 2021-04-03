package com.yuanhaoji.leetcode.biweekly_contest.biweekly_49;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/4/3
 * @desp: 第 49 场双周赛
 */
public class Solution {

    public boolean squareIsWhite(String coordinates) {
        int i = coordinates.charAt(0) - 'a';
        int j = coordinates.charAt(1) - '1';
        return (i % 2 + j % 2) % 2 != 0;
    }

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] array1 = sentence1.split("\\s");
        String[] array2 = sentence2.split("\\s");
        int m = array1.length, n = array2.length;
        int i = 0, j = 1;
        while (i < m && i < n && array1[i].equals(array2[i])) {
            ++i;
        }
        while (m - j >= 0 && n - j >= 0 && array1[m - j].equals(array2[n - j])) {
            ++j;
        }
        return i > Math.min(m - j, n - j);
    }

    public int countNicePairs(int[] nums) {
        long res = 0;


        return (int) (res % (10e9 + 7));
    }

}
