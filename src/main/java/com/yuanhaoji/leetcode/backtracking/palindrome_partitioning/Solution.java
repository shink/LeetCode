package com.yuanhaoji.leetcode.backtracking.palindrome_partitioning;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/3/7
 * @desp: 131中等题——分割回文串，https://leetcode-cn.com/problems/palindrome-partitioning/
 */

public class Solution {

    int n;
    private boolean[][] dp;
    private List<String> list;
    private List<List<String>> res;

    /**
     * 回溯 + dp 预处理
     * <p>
     * dp 预处理：提前算好任意子串是否是回文串
     * <p>
     * true,                                       i >= j
     * dp[i][j] =   dp[i + 1][j - 1] && str[i] == str[j],       otherwise
     *
     * 回溯：dfs
     *
     * 由于需要求出字符串 s 的所有分割方案
     * 因此我们考虑使用搜索 + 回溯的方法枚举所有可能的分割方法并进行判断
     *
     * 假设我们当前搜索到字符串的第 i 个字符，且 s[0..i-1]s[0..i−1] 位置的所有字符已经被分割成若干个回文串，并且分割结果被放入了答案数组 res 中
     * 那么我们就需要枚举下一个回文串的右边界 j，使得 s[i..j]s[i..j] 是一个回文串
     *
     * 因此，我们可以从 i 开始，从小到大依次枚举 j
     * 对于当前枚举的 j 值，我们使用双指针的方法判断 s[i..j]s[i..j] 是否为回文串
     * 如果 s[i..j]s[i..j] 是回文串，那么就将其加入答案数组 list 中，并以 j+1 作为新的 i 进行下一层搜索，并在未来的回溯时将 s[i..j]s[i..j] 从 list 中移除
     *
     * 如果我们已经搜索完了字符串的最后一个字符，那么就找到了一种满足要求的分割方法
     */
    public List<List<String>> partition(String s) {
        if (s == null) {
            return null;
        }

        n = s.length();
        dp = new boolean[n][n];
        list = new ArrayList<>();
        res = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (i >= j) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }
            }
        }

        dfs(s, 0);
        return res;
    }

    private void dfs(String s, int i) {
        if (i == n) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int j = i; j < n; j++) {
            if (dp[i][j]) {
                list.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                list.remove(list.size() - 1);
            }
        }
    }

}
