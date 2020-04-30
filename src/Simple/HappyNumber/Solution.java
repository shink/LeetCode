package HappyNumber;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/4/30
 * @desp: 202题——快乐数, https://leetcode-cn.com/problems/happy-number/
 */

public class Solution {
    /**
     * 快慢指针法，慢指针一次挪动一步，快指针一次挪动两步
     * 如果进入死循环，他们必定会相遇，否则快指针必定先变为 1
     */
    public boolean isHappy(int n) {
        int slow = n;
        int fast = sumOfSquares(n);
        while (fast != 1 && slow != fast) {
            slow = sumOfSquares(slow);
            fast = sumOfSquares(sumOfSquares(fast));
        }
        return fast == 1;
    }

    private int sumOfSquares(int num) {
        int sum = 0;
        while (num > 0) {
            int remainder = num % 10;
            sum += Math.pow(remainder, 2);
            num /= 10;
        }
        return sum;
    }
}
