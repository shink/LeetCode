package TheLastNumberLeftInTheCircle;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/3/30
 * @desp: 面试题62——圆圈中最后剩下的数字, https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 */

public class Solution {
    /**
     * 官方题解，迭代法（用递归需要额外空间）
     * 约瑟夫环问题
     */
    public int lastRemaining(int n, int m) {
        int res = 0;
        for (int i = 2; i != n + 1; ++i)
            res = (m + res) % i;
        return res;
    }
}
