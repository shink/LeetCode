package ReverseWordsInAString;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/4/10
 */

public class SolutionTest {

    @Test
    public void reverseWords() {
        Solution solution = new Solution();
        String s = "  hello world!  aaa sssssaf efeqf efeg  ";
        solution.reverseWords(s);
    }
}