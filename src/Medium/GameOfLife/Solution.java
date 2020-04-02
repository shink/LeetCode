package GameOfLife;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/4/2
 * @desp: 289题——生命游戏, https://leetcode-cn.com/problems/game-of-life/
 */

public class Solution {
    public void gameOfLife(int[][] board) {
        if (board.length == 0)
            return;

        int m = board.length;
        int n = board[0].length;
        int[][] raw = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                raw[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = compute(raw, i, j);
            }
        }
    }

    private int compute(int[][] raw, int i, int j) {
        int status = raw[i][j];
        int sum = 0;
        sum += count(raw, i, j, -1, -1);    // 左上
        sum += count(raw, i, j, -1, 0);     // 上
        sum += count(raw, i, j, -1, 1);     // 右上
        sum += count(raw, i, j, 0, -1);     // 左
        sum += count(raw, i, j, 0, 1);     // 右
        sum += count(raw, i, j, 1, -1);     // 左下
        sum += count(raw, i, j, 1, 0);     // 下
        sum += count(raw, i, j, 1, 1);     // 右下

        if (status == 1) {
            if (sum == 2 || sum == 3)
                return 1;
            else
                return 0;
        } else {
            if (sum == 3)
                return 1;
            else
                return 0;
        }
    }

    private int count(int[][] raw, int i, int j, int dx, int dy) {
        i = i + dx;
        j = j + dy;

        if (i >= 0 && j >= 0 && i < raw.length && j < raw[i].length && raw[i][j] == 1) {
            return 1;
        }
        return 0;
    }

}
