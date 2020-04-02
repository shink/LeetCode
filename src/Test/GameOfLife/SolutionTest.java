package GameOfLife;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/4/2
 */

public class SolutionTest {

    @Test
    public void gameOfLife() {
        Solution solution = new Solution();
        int[][] board = new int[][]{{1, 2, 3}, {4, 5, 6}};
        solution.gameOfLife(board);
    }
}