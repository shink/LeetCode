package com.yuanhaoji.leetcode.weekly_contest.weekly_234;

import java.util.*;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/3/28
 * @desp: 第 234 场周赛
 */

public class Solution {

    public int numDifferentIntegers(String word) {
        Set<Long> set = new HashSet<>();
        char[] charArray = word.toCharArray();
        int n = charArray.length;
        int i = 0;
        while (i < n) {
            char ch = charArray[i];
            if (ch >= 'a' && ch <= 'z') {
                ++i;
                continue;
            }

            long num = 0;
            while (i < n && charArray[i] >= '0' && charArray[i] <= '9') {
                num = num * 10 + (charArray[i] - '0');
                ++i;
            }
            set.add(num);
        }

        System.out.println(set.toString());

        return set.size();
    }

    public int reinitializePermutation(int n) {
        int res = 1;
        int[] perm = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
        }
        int[] flag = perm;

        perm = get(perm);
        while (!Arrays.equals(perm, flag)) {
            perm = get(perm);
            ++res;
        }
        return res;
    }

    private int[] get(int[] perm) {
        int n = perm.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                arr[i] = perm[i / 2];
            } else {
                arr[i] = perm[n / 2 + (i - 1) / 2];
            }
        }
        return arr;
    }

    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }

        StringBuilder res = new StringBuilder();
        int i = 0, n = s.length();
        int left, right;
        while (i < n) {
            if (s.charAt(i) == '(') {
                left = i;
                right = i + 1;
                while (right < n && s.charAt(right) != ')') {
                    ++right;
                }
                i = right + 1;

                String key = s.substring(left + 1, right);
                res.append(map.getOrDefault(key, "?"));
            } else {
                res.append(s.charAt(i++));
            }
        }

        return res.toString();
    }

}
