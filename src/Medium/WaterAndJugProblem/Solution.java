package WaterAndJugProblem;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/3/21
 * @desp: 365题——水壶问题, https://leetcode-cn.com/problems/water-and-jug-problem/
 */

public class Solution {

    public boolean canMeasureWater(int x, int y, int z) {
        if (x == 0 && y == 0)
            return z == 0;
        return z == 0 || (z % gcd(x, y) == 0 && x + y >= z);
    }

    private int gcd(int x, int y) {
        if (y == 0)
            return x;
        int r = x % y;
        return gcd(y, r);
    }
}
