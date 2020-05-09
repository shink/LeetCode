package Sqrtx;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/5/9
 * @desp: 69题——x的平方根, https://leetcode-cn.com/problems/sqrtx/
 */

public class Solution {

    /**
     * 袖珍计算器算法：是一种用指数函数 exp 和对数函数 ln 代替平方根函数的方法
     */
    //    public int mySqrt(int x) {
    //        if (x == 0)
    //            return 0;
    //        int res = (int) Math.exp(0.5 * Math.log(x));
    //        return (long) (res + 1) * (res + 1) <= x ? res + 1 : res;
    //    }


    /**
     * 二分查找： x 平方根的整数部分是满足 k^2 <= x的最大k值
     */
    public int mySqrt(int x) {
        int left = 0, right = x, res = -1;
        while (left <= right) {
            //  防止 (left + right) 溢出，下面是下取整
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                res = mid;
                left = mid + 1;
            } else
                right = mid - 1;
        }
        return res;
    }

    /**
     * 直接调用sqrt，非法
     */
    //    public int mySqrt(int x) {
    //        return (int) Math.sqrt(x);
    //    }
}
