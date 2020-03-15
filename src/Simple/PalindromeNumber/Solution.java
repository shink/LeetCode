package PalindromeNumber;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2019/10/01
 * @desp: 9题——回文数, https://leetcode-cn.com/problems/palindrome-number/
 */

public class Solution {

	public boolean isPalindrome(int x) {

		if (x < 0 || (x > 0 && x % 10 == 0)) {
			return false;
		}

		long result = 0;
		int input = x;

		while (x != 0) {
			result = result * 10 + x % 10;
			x /= 10;
		}

		return ((int) result) == input;

	}

	// ��
//	public boolean IsPalindrome(int x) {
//		if (x < 0 || (x % 10 == 0 && x != 0)) {
//			return false;
//		}
//
//		int revertedNumber = 0;
//		while (x > revertedNumber) {
//			revertedNumber = revertedNumber * 10 + x % 10;
//			x /= 10;
//		}
//
//		return x == revertedNumber || x == revertedNumber / 10;
//	}

}
