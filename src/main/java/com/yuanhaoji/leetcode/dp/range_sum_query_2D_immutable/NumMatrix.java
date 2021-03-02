package com.yuanhaoji.leetcode.dp.range_sum_query_2D_immutable;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/3/2
 * @desp: 304中等题——二维区域和检索 - 矩阵不可变，https://leetcode-cn.com/problems/range-sum-query-2d-immutable/
 */

public class NumMatrix {

    private int[][] numMatrix;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int row = matrix.length, col = matrix[0].length;
        numMatrix = new int[row + 1][col + 1];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                numMatrix[i + 1][j + 1] = numMatrix[i + 1][j] + numMatrix[i][j + 1] - numMatrix[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return numMatrix[row2 + 1][col2 + 1] - numMatrix[row2 + 1][col1] - numMatrix[row1][col2 + 1] + numMatrix[row1][col1];
    }

}
