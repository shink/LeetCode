package For1ToN;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/6/2
 * @desp: 面试题64题——求1+2+…+n, https://leetcode-cn.com/problems/qiu-12n-lcof/
 */

public class Solution {
    //    public int sumNums(int n) {
    //        return (n * (n + 1)) / 2;
    //    }

    /**
     * 递归
     * <p>
     * 这里利用了 && 的短路性质代替if判断，当 n<=1 时，不会执行后面语句，从而终止递归
     */
    public int sumNums(int n) {
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
