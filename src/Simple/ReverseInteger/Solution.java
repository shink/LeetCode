package ReverseInteger;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2019/10/01
 * @desp: 7题——整数反转, https://leetcode-cn.com/problems/reverse-integer/
 */

public class Solution {

	public int reverse(int x) {
		long result = 0;

		while (x != 0) {
			int reminder = x % 10;
			result = result * 10 + reminder;
			x /= 10;
		}

		return (int) ((result >= Integer.MIN_VALUE && result <= Integer.MAX_VALUE) ? result : 0);
	}

}
