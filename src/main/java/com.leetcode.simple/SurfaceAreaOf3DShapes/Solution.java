package SurfaceAreaOf3DShapes;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/3/25
 * @desp: 892题——三维形体的表面积, https://leetcode-cn.com/problems/surface-area-of-3d-shapes/
 */

public class Solution {

    /**
     * 我的方法
     */
    //    public int surfaceArea(int[][] grid) {
    //        int N = grid.length;
    //        int res = 0;
    //
    //        for (int i = 0; i < N; i++) {
    //            for (int j = 0; j < N; j++) {
    //                if (grid[i][j] != 0)
    //                    res += 4 * grid[i][j] + 2;
    //
    //                res -= Math.min(grid[i][j], borderArea(grid, i - 1, j));
    //                res -= Math.min(grid[i][j], borderArea(grid, i + 1, j));
    //                res -= Math.min(grid[i][j], borderArea(grid, i, j - 1));
    //                res -= Math.min(grid[i][j], borderArea(grid, i, j + 1));
    //            }
    //        }
    //
    //        return res;
    //    }
    //
    //    private int borderArea(int[][] grid, int i, int j) {
    //        int res = 0;
    //
    //        if (i >= 0 && j >= 0 && i < grid.length && j < grid.length) {
    //            return grid[i][j];
    //        }
    //
    //        return res;
    //    }

    /**
     * 评论中的方法，差距在于：两个物体相靠的时候，需减去相靠面积的两倍，故无需重复考虑
     */
    public int surfaceArea(int[][] grid) {
        int N = grid.length;
        int res = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int num = grid[i][j];
                if (num != 0)
                    res += 4 * num + 2;

                if (i > 0)
                    res -= Math.min(num, grid[i - 1][j]) * 2;
                if (j > 0)
                    res -= Math.min(num, grid[i][j - 1]) * 2;
            }
        }

        return res;
    }
}
