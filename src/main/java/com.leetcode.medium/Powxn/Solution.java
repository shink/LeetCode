package Powxn;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/5/11
 * @desp: 50题——Pow(x, n), https://leetcode-cn.com/problems/powx-n/
 */

public class Solution {
    /**
     * 快速幂+递归
     */
    //    private double recur(double x, int n) {
    //        if (n == 0)
    //            return 1.0;
    //
    //        double res = recur(x, n / 2);
    //        return n % 2 == 0 ? res * res : res * res * x;
    //    }
    //
    //    public double myPow(double x, int n) {
    //        return n >= 0 ? recur(x, n) : 1.0 / recur(x, -n);
    //    }

    /**
     * 迭代
     */
    public double myPow(double x, int n) {
        double res = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0)
                res *= x;

            x *= x;
        }
        return n >= 0 ? res : 1.0 / res;
    }


    /**
     * 直接调用pow，非法
     */
    //    public double myPow(double x, int n) {
    //        return Math.pow(x, n);
    //    }
}
