package StringToInteger;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/4/3
 * @desp: 8题——字符串转换整数（atoi）, https://leetcode-cn.com/problems/string-to-integer-atoi/
 */

public class Solution {
    public int myAtoi(String str) {
        char[] array = str.toCharArray();
        int length = array.length;
        int i = 0, res = 0;
        boolean negative = false;

        while (i < array.length && array[i] == ' ')
            ++i;
        if (i == length)
            return 0;

        if (array[i] == '-') {
            negative = true;
            ++i;
        } else if (array[i] == '+')
            ++i;
        else if (!Character.isDigit(array[i]))
            return 0;

        while (i < length && Character.isDigit(array[i])) {
            int digit = array[i] - '0';
            /**
             * 本来应该是 ans * 10 + digit > Integer.MAX_VALUE
             * 但是 *10 和 + digit 都有可能越界，所有都移动到右边去就可以了
             */
            if (res > (Integer.MAX_VALUE - digit) / 10)
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            res = 10 * res + digit;
            ++i;
        }
        return negative ? -res : res;
    }
}
