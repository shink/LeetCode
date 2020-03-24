package CreateTargetArrayInTheGivenOrder;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/3/24
 */

public class SolutionTest {

    @Test
    public void createTargetArray() {
        Solution solution = new Solution();
        int[] nums = new int[]{0,1,2,3,4};
        int[] index = new int[]{0,1,2,2,2};
        System.out.println(Arrays.toString(solution.createTargetArray(nums, index)));
    }
}