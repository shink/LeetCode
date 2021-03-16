package com.yuanhaoji.leetcode.array.spiral_matrix_II;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/3/16
 * @desp: 59中等题——螺旋矩阵 II，https://leetcode-cn.com/problems/spiral-matrix-ii/
 */

public class Solution {

    public int[][] generateMatrix(int n) {
        int n2 = n * n;
        int[][] res = new int[n][n];
        int left = 0, right = n - 1;
        int top = 0, bottom = n - 1;

        int i = 1;
        while (i <= n2) {
            for (int j = left; j <= right && i <= n2; j++) {
                res[top][j] = i++;
            }
            ++top;

            for (int j = top; j <= bottom && i <= n2; j++) {
                res[j][right] = i++;
            }
            --right;

            for (int j = right; j >= left && i <= n2; j--) {
                res[bottom][j] = i++;
            }
            --bottom;

            for (int j = bottom; j >= top && i <= n2; j--) {
                res[j][left] = i++;
            }
            ++left;
        }

        return res;
    }

}
