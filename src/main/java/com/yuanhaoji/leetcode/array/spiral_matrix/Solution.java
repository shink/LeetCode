package com.yuanhaoji.leetcode.array.spiral_matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/3/15
 * @desp: 54中等题——螺旋矩阵，https://leetcode-cn.com/problems/spiral-matrix/
 */

public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int elementNum = m * n;

        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right && elementNum > 0; i++) {
                res.add(matrix[top][i]);
                --elementNum;
            }
            ++top;

            for (int i = top; i <= bottom && elementNum > 0; i++) {
                res.add(matrix[i][right]);
                --elementNum;
            }
            --right;

            for (int i = right; i >= left && elementNum > 0; i--) {
                res.add(matrix[bottom][i]);
                --elementNum;
            }
            --bottom;

            for (int i = bottom; i >= top && elementNum > 0; i--) {
                res.add(matrix[i][left]);
                --elementNum;
            }
            ++left;
        }

        return res;
    }

}
