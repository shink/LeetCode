package AvailableCapturesForRook;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/3/26
 * @desp: 999题——车的可用捕获量, https://leetcode-cn.com/problems/available-captures-for-rook/
 */

public class Solution {

    public int numRookCaptures(char[][] board) {
        int res = 0;
        int length = board.length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (board[i][j] == 'R') {
                    res += compute(board, i, j, -1, 0);  //   上
                    res += compute(board, i, j, 0, 1);  //   右
                    res += compute(board, i, j, 1, 0);  //   下
                    res += compute(board, i, j, 0, -1);  //   左
                    return res;
                }
            }
        }
        return 0;
    }

    private int compute(char[][] board, int x, int y, int dx, int dy) {
        while (x >= 0 && y >= 0 && x < board.length && y < board[x].length && board[x][y] != 'B') {
            if (board[x][y] == 'p') {
                return 1;
            }
            x += dx;
            y += dy;
        }
        return 0;
    }

}
