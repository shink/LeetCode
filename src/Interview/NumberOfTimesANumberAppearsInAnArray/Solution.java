package NumberOfTimesANumberAppearsInAnArray;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/4/28
 * @desp: 面试题56-I.数组中数字出现的次数, https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 */

public class Solution {
    public int[] singleNumbers(int[] nums) {
        int a = 0, b = 0;

        /**
         * 先求所有数的异或值（0和任何数的异或等于那个数）
         * 最终结果等于a与b的异或值
         */
        int res = 0;
        for (int num : nums)
            res ^= num;

        //  求出a与b异或值的二进制数中不同的位置（xi=1），以此进行分组
        int div = 1;
        while ((div & res) == 0)
            div <<= 1;

        /**
         * 基于div进行分组，a与b必然分别存在于两个组中，并且相等的数必然存在于同一组中
         * 于是，一组所有数的异或值即为a，二组所有数异或值即为b
         */
        for (int num : nums) {
            if ((div & num) == 0)
                a ^= num;
            else
                b ^= num;
        }

        return new int[]{a, b};
    }
}
