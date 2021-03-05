package com.yuanhaoji.leetcode.dp.russian_doll_envelopes;

import java.util.Arrays;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/3/5
 * @desp: 354困难题——俄罗斯套娃信封问题，https://leetcode-cn.com/problems/russian-doll-envelopes/
 */

public class Solution {

    /**
     * 解题思路类似 300 题——最长递增子序列（LIS），不同的是该题是两个维度
     * <p>
     * 根据宽度升序排列，若宽度各不相同，则答案就是高度集合中最长递增子序列的长度
     * 但宽度可能相同，因此，再按照高度进行降序排列，这样对于所有相同宽度的信封，其高度的最长子序列中只可能有一个
     * <p>
     * 如：
     * 2 1      2 1
     * 6 2  ->  6 4
     * 6 3      6 3
     * 6 4      6 2
     * <p>
     * 若按高度升序，则最长子序列 1 2 3 4，若降序，则最长子序列 1 2
     */
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }

        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o2[1] - o1[1];
            }
        });

        int n = envelopes.length;
        int[] dp = new int[n + 1];
        int len = 1;
        dp[1] = envelopes[0][1];

        for (int i = 1; i < n; i++) {
            if (envelopes[i][1] > dp[len]) {
                dp[++len] = envelopes[i][1];
            } else {
                int l = 1, r = len, pos = 0;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (dp[mid] < envelopes[i][1]) {
                        l = mid + 1;
                        pos = mid;
                    } else {
                        r = mid - 1;
                    }
                }
                dp[pos + 1] = envelopes[i][1];
            }
        }

        return len;
    }

}
