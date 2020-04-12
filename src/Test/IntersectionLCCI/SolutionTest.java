package IntersectionLCCI;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/4/12
 */

public class SolutionTest {

    @Test
    public void intersection() {
        Solution solution = new Solution();
        int[] start1 = new int[]{0, 0};
        int[] end1 = new int[]{3, 4};
        int[] start2 = new int[]{1, 1};
        int[] end2 = new int[]{0, -1};

        solution.intersection(start1, end1, start2, end2);
    }
}