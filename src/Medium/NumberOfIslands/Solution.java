package NumberOfIslands;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/4/20
 * @desp: 200题——岛屿数量, https://leetcode-cn.com/problems/number-of-islands/
 */

public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    recur(grid, i, j);
                    ++res;
                }
            }
        }

        return res;
    }

    private void recur(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0')
            return;

        //  沉岛
        grid[i][j] = '0';
        recur(grid, i - 1, j);
        recur(grid, i + 1, j);
        recur(grid, i, j - 1);
        recur(grid, i, j + 1);
    }
}
