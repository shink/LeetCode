package RangeOfMotionOfTheRobot;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/4/8
 * @desp: 面试题13——机器人的运动范围, https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 */

public class Solution {
    public int movingCount(int m, int n, int k) {
        int[][] visit = new int[m][n];
        return recursion(visit, 0, 0, m, n, k);
    }

    private int recursion(int[][] visit, int i, int j, int m, int n, int k) {
        int res = 0;

        if (i < m && j < n && visit[i][j] != 1 && getSum(i) + getSum(j) <= k) {
            ++res;
            visit[i][j] = 1;
            res += recursion(visit, i, j + 1, m, n, k) + recursion(visit, i + 1, j, m, n, k);
        }
        return res;
    }

    private int getSum(int num) {
        return num / 10 + num % 10;
    }
}
