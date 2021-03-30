package com.yuanhaoji.leetcode.array.search_a_2D_matrix;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/3/30
 * @desp: 74中等题——搜索二维矩阵，https://leetcode-cn.com/problems/search-a-2d-matrix/
 */

public class Solution {

    // public boolean searchMatrix(int[][] matrix, int target) {
    //     int m = matrix.length, n = matrix[0].length;
    //     int i = 0, j = n - 1;
    //
    //     while (i < m && j >= 0) {
    //         int num = matrix[i][j];
    //         if (num == target) {
    //             return true;
    //         }
    //
    //         if (num < target) {
    //             ++i;
    //         } else {
    //             --j;
    //         }
    //     }
    //
    //     return false;
    // }


    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int x = matrix[mid / n][mid % n];
            if (x < target) {
                low = mid + 1;
            } else if (x > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
