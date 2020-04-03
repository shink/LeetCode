package StringToInteger;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/4/3
 */

public class SolutionTest {

    @Test
    public void myAtoi() {
        Solution solution = new Solution();
        String str = "    -151515aaaaa";
        solution.myAtoi(str);
    }
}