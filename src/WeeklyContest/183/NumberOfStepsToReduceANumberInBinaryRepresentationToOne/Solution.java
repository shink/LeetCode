package NumberOfStepsToReduceANumberInBinaryRepresentationToOne;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/4/5
 * @desp: 周赛183场5377题——将二进制表示减到1的步骤数, https://leetcode-cn.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/
 */

public class Solution {

    public int numSteps(String s) {
        char[] array = s.toCharArray();
        int r = array.length - 1;
        int res = 0;

        while (r >= 1) {
            if (array[r] == '0') {
                ++res;
                if (--r == 0)
                    return res;
            } else {
                ++res;
                while (r >= 0 && array[r] == '1') {
                    ++res;
                    --r;
                }
                if (r < 0)
                    return res;
                array[r] = '1';
            }
        }
        return res;
    }

}
