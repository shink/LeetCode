package LongestPalindrome;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/3/19
 */

public class SolutionTest {

    @Test
    public void longestPalindrome() {
        Solution solution = new Solution();
        String s = "aaabb";
        System.out.println(solution.longestPalindrome(s));
    }
}