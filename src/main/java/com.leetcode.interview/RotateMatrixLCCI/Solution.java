package RotateMatrixLCCI;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/4/7
 * @desp: 面试题01.07——旋转矩阵, https://leetcode-cn.com/problems/rotate-matrix-lcci/
 */

public class Solution {
    /**
     * 我的方法，与方法一相同
     */
    //    public void rotate(int[][] matrix) {
    //        int n = matrix.length;
    //        int[][] temp = new int[n][n];
    //
    //        for (int i = 0; i < n; i++) {
    //            for (int j = 0; j < n; j++) {
    //                temp[i][j] = matrix[i][j];
    //
    //            }
    //        }
    //
    //        for (int i = 0; i < n; i++) {
    //            for (int j = 0; j < n; j++) {
    //                matrix[j][n - 1 - i] = temp[i][j];
    //            }
    //        }
    //    }

    /**
     * 方法三，先水平翻转，再主对角线翻转
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        //  水平翻转
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
            }
        }

        //  主对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
