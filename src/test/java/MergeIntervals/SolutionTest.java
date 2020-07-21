package MergeIntervals;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/7/21
 */

public class SolutionTest {

    @Test
    public void merge() {
        Solution solution = new Solution();
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        solution.merge(intervals);
    }
}