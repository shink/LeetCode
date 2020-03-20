package TheSmallestKNumbers;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/3/20
 */

public class SolutionTest {

    @Test
    public void getLeastNumbers() {
        Solution solution = new Solution();
        int[] arr = new int[]{1, 3, 4, 3, 1, 2, 8};
        solution.getLeastNumbers(arr, 2);
    }
}