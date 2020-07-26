package SingleNumber;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/5/14
 * @desp: 136题——只出现一次的数字, https://leetcode-cn.com/problems/single-number/
 */

public class Solution {

    /**
     * 异或：相同为 0，不同为 1
     * 0 与一个数的异或还是那个数
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
