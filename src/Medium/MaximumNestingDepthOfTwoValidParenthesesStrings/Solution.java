package MaximumNestingDepthOfTwoValidParenthesesStrings;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/4/1
 * @desp: 1111题——有效括号的嵌套深度, https://leetcode-cn.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/
 */

public class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        char[] array = seq.toCharArray();
        int length = array.length;
        int[] res = new int[length];
        int depth = 0;

        for (int i = 0; i < length; i++) {
            if (array[i] == '(') {
                ++depth;
                res[i] = depth % 2;
            } else if (array[i] == ')'){
                res[i] = depth % 2;
                --depth;
            }
        }
        return res;
    }
}
