package MaxAreaOfIsland;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/3/15
 * @desp: 695题——岛屿的最大面积, https://leetcode-cn.com/problems/max-area-of-island/
 */

public class Solution {

    /**
     * 深度优先遍历 DFS
     *
     * @return: 从当前节点出发延伸到最远的一个岛屿的面积
     */
    //    private int dfs(int i, int j, int[][] grid) {
    //
    //        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
    //            return 0;
    //        }
    //
    //        // 沉岛，发现岛屿就把它和周围的 1 沉没
    //        grid[i][j] = 0;
    //        int num = 1;
    //        num += dfs(i + 1, j, grid);
    //        num += dfs(i - 1, j, grid);
    //        num += dfs(i, j + 1, grid);
    //        num += dfs(i, j - 1, grid);
    //
    //        return num;
    //    }

    //    public int maxAreaOfIsland(int[][] grid) {
    //
    //        int i, j;
    //        int res = 0;
    //
    //        for (i = 0; i < grid.length; i++) {
    //            for (j = 0; j < grid[i].length; j++) {
    //                if (grid[i][j] == 1) {
    //                    res = Math.max(res, dfs(i, j, grid));
    //                }
    //            }
    //        }
    //
    //        return res;
    //    }


    /**
     * 我的方法
     */
    private int dfs(int i, int j, int[][] grid, boolean[][] hasVisited) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0 || hasVisited[i][j]) {
            return 0;
        }

        hasVisited[i][j] = true;
        int num = 1;
        num += dfs(i + 1, j, grid, hasVisited);
        num += dfs(i - 1, j, grid, hasVisited);
        num += dfs(i, j + 1, grid, hasVisited);
        num += dfs(i, j - 1, grid, hasVisited);

        return num;
    }


    public int maxAreaOfIsland(int[][] grid) {

        if (grid.length == 0) {
            return 0;
        }

        int i, j;
        int res = 0;
        int row = grid.length;
        int column = grid[0].length;
        boolean[][] hasVisited = new boolean[row][column];

        for (i = 0; i < row; i++) {
            for (j = 0; j < column; j++) {
                if (!hasVisited[i][j] && grid[i][j] == 1) {
                    res = Math.max(res, dfs(i, j, grid, hasVisited));
                }
            }
        }

        return res;
    }

}
