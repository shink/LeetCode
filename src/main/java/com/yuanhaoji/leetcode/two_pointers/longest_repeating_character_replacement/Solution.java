package com.yuanhaoji.leetcode.two_pointers.longest_repeating_character_replacement;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/2/2
 * @desp: 424中等题——替换后的最长重复字符，https://leetcode-cn.com/problems/longest-repeating-character-replacement/
 */
public class Solution {

    public int characterReplacement(String s, int k) {
        int left = 0, right = 0;
        int maxCount = 0;
        int[] countArray = new int[26];
        char[] array = s.toCharArray();

        int index;
        while (right < array.length) {
            index = array[right] - 'A';
            if (++countArray[index] > maxCount) {
                maxCount = countArray[index];
            }

            if (right - left - maxCount + 1 > k) {
                --countArray[array[left] - 'A'];
                ++left;
            }
            ++right;
        }

        return right - left;
    }

}
