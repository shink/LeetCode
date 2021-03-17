package com.yuanhaoji.leetcode.dp.distinct_subsequences;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/3/17
 * @desp: 115困难题——不同的子序列，https://leetcode-cn.com/problems/distinct-subsequences/
 */

public class Solution {

    /**
     * 1、为啥状态方程这样对？
     * <p>
     * 我个人习惯 dp[i][j] 表示为 s[0-i] 和 t[0-j] 均闭区间的子序列个数，但这样不能表示s和t空串的情况
     * <p>
     * 所以声明 int[][] dp = new int[m + 1][n + 1]; 这样 dp[0][x] 可以表示 s 为空串，dp[x][0] 同理
     * <p>
     * 先不扣初始化的细节，假设 dp[i][j] 就是s[i] 和 t[j] 索引的元素子序列数量
     * <p>
     * 1：为啥状态方程是： s[i] == t[j] 时 dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
     * <p>
     * s[i] != t[j] 时 dp[i][j] = dp[i-1][j]
     * <p>
     * 先看s[i] == t[j] 时，以 s = "rara"，t = "ra" 为例，当 i = 3, j = 1 时，s[i] == t[j]
     * <p>
     * 此时分为 2 种情况，s 串用最后一位的 a 或者 不用最后一位的 a
     * <p>
     * 如果用 s 串最后一位的 a,那么 t 串最后一位的 a 也被消耗掉，此时的子序列其实等于 dp[i-1][j-1]
     * <p>
     * 如果不用 s 串最后一位的 a，那就得看 "rar" 里面是否有 "ra" 子序列的了，就是 dp[i-1][j]
     * <p>
     * 所以 dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
     * <p>
     * 再看s[i] != t[j] 比如 s = "rarb"，t = "ra" 还是当 i = 3, j = 1 时，s[i] != t[j]
     * <p>
     * 此时显然最后的 b 想用也用不上啊。所以只能指望前面的 "rar" 里面是否有能匹配 "ra" 的
     * <p>
     * 所以此时dp[i][j] = dp[i-1][j]
     * <p>
     * 2：怎么想到这样的状态方程？
     * <p>
     * 一点个人经验，见过的很多 2 个串的题，大部分都是 dp[i][j] 分别表示 s 串[0...i] 和 t 串[0...j] 怎么怎么样
     * <p>
     * 然后都是观察 s[i] 和 t[j] 分等或者不等的情况，而且方程通常就是 dp[i-1][j-1] 要么 + 要么 || dp[i-1][j] 类似的
     * <p>
     * 类似的题比如有
     * 10：正则表达式匹配
     * 44：通配符匹配 编辑距离
     * 1143：最长公共子序列
     */

    /**
     * dp[i][j] 表示 s[0-i) 的子序列中 t[0-j) 的数量，因此答案就是 dp[m][n]
     *
     * 考虑状态方程
     *
     * 要想得出状态 dp[i][j]，就需要考虑什么情况下可以从之前的状态转移而来
     * 之前的状态相当于是 s[0-i) 的子串的子序列中 t[0-j) 的子串的数量
     * 包括 dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]
     *
     * 因此与当前 s[0-i) 和 t[0-j) 的最后一个字符是否相等有关
     * 若相等，则可以考虑从之前的状态转移过来
     *
     * 若 s[i - 1] == t[j - 1]，则 dp[i][j] = dp[i - 1][j - 1]
     * 但是，上式只考虑了 dp[i - 1][j - 1]，未考虑 dp[i - 1][j] 和 dp[i][j - 1]
     *
     * 以示例中的 s = "rabbbit"，t = "rabbit" 为例
     * 当 s = "rabb", t = "rab" 时
     * 既可以从 s = "rab" 中搜索 t = "ra" ，也可以从 s = "rab" 中搜索 t = "rab"
     *
     * 而对于子状态 dp[i][j - 1]
     * 尽管两子串最后一个字符已经相等，但是消耗掉 t[j] 的同时也必须消耗掉 s[j]
     * 这样才能保证
     *
     * 若 s[i - 1] ！= t[j - 1]
     * 显然，dp[i][j] = dp[i - 1][j]
     */
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= i && j < n; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + dp[i][j + 1];
                } else {
                    dp[i + 1][j + 1] = dp[i][j + 1];
                }
            }
        }

        return dp[m][n];
    }

}
