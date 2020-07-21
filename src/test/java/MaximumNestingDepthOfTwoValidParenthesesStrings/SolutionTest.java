package MaximumNestingDepthOfTwoValidParenthesesStrings;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/7/21
 */

public class SolutionTest {

    @Test
    public void maxDepthAfterSplit() {
        Solution solution = new Solution();
        solution.maxDepthAfterSplit("()(())()");
    }
}