package com.yuanhaoji.leetcode.weekly_contest.weekly_246;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/6/20
 * @desp:
 */
public class Solution {

    public String largestOddNumber(String num) {
        int right = num.length() - 1;
        while (right >= 0 && ((num.charAt(right) - '0') & 1) == 0) --right;
        return right >= 0 ? num.substring(0, right + 1) : "";
    }

    // public int numberOfRounds(String startTime, String finishTime) {
    //     int startHour = (startTime.charAt(0) - '0') * 10 + (startTime.charAt(1) - '0');
    //     int startMinute = (startTime.charAt(3) - '0') * 10 + (startTime.charAt(4) - '0');
    //     int finishHour = (finishTime.charAt(0) - '0') * 10 + (finishTime.charAt(1) - '0');
    //     int finishMinute = (finishTime.charAt(3) - '0') * 10 + (finishTime.charAt(4) - '0');
    //
    //     if (finishHour < startHour || (finishHour == startHour && finishMinute < startMinute)) finishHour += 24;
    //     if (startMinute > 0 && startMinute <= 15) {
    //         startMinute = 15;
    //     } else if (startMinute > 15 && startMinute <= 30) {
    //         startMinute = 30;
    //     } else if (startMinute > 30 && startMinute <= 45) {
    //         startMinute = 45;
    //     } else if (startMinute > 45 && startMinute <= 59) {
    //         startMinute = 0;
    //         ++startHour;
    //     }
    //
    //     if (finishMinute < 15) {
    //         finishMinute = 0;
    //     } else if (finishMinute < 30) {
    //         finishMinute = 15;
    //     } else if (finishMinute < 45) {
    //         finishMinute = 30;
    //     } else if (finishMinute <= 59) {
    //         finishMinute = 45;
    //     }
    //
    //     return (finishHour - startHour) * 4 + (finishMinute - startMinute) / 15;
    // }

    /**
     * 第二题，优化版
     */
    public int numberOfRounds(String startTime, String finishTime) {
        int startHour = (startTime.charAt(0) - '0') * 10 + (startTime.charAt(1) - '0');
        int startMinute = (startTime.charAt(3) - '0') * 10 + (startTime.charAt(4) - '0');
        int finishHour = (finishTime.charAt(0) - '0') * 10 + (finishTime.charAt(1) - '0');
        int finishMinute = (finishTime.charAt(3) - '0') * 10 + (finishTime.charAt(4) - '0');

        int start = startHour * 60 + startMinute;
        int finish = finishHour * 60 + finishMinute;
        if (finish < start) finish += 24 * 60;

        finish -= finish % 15;  // 取当前值与左边相邻区间值的较小值
        start = (start + 14) / 15 * 15;    // 取当前值与右边相邻区间值的最大值
        return (finish - start) / 15;
    }


    // private int[][] grid1;
    // private int[][] grid2;
    // private int m;
    // private int n;
    // private int res = 0;
    //
    // public int countSubIslands(int[][] grid1, int[][] grid2) {
    //     m = grid1.length;
    //     n = grid1[0].length;
    //     this.grid1 = grid1;
    //     this.grid2 = grid2;
    //
    //     for (int i = 0; i < m; i++) {
    //         for (int j = 0; j < n; j++) {
    //             if (this.grid2[i][j] == 1 && this.grid1[i][j] == 1 && dfs(i, j)) {
    //                 ++res;
    //             }
    //         }
    //     }
    //
    //     return res;
    // }
    //
    // public boolean dfs(int i, int j) {
    //     if (i < 0 || i >= m || j < 0 || j >= n) return false;
    //
    //     if (grid2[i][j] == 1 && grid1[i][j] == 1) {
    //         grid2[i][j] = 0;
    //         grid1[i][j] = 0;
    //         boolean up = dfs(i - 1, j);
    //         boolean left = dfs(i, j - 1);
    //         boolean down = dfs(i + 1, j);
    //         boolean right = dfs(i, j + 1);
    //         return up && left && down && right;
    //     }
    //
    //     return true;
    // }

}
