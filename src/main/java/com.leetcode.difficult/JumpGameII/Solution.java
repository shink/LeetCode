package JumpGameII;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/5/4
 * @desp: 45题——跳跃游戏 II, https://leetcode-cn.com/problems/jump-game-ii/
 */

public class Solution {
    /**
     * 贪心
     */

    /**
     * 反向查找出发位置
     * O(n2)
     */
    //    public int jump(int[] nums) {
    //        int position = nums.length - 1;
    //        int steps = 0;
    //        while (position > 0) {
    //            for (int i = 0; i < position; i++) {
    //                if (i + nums[i] >= position) {
    //                    position = i;
    //                    steps++;
    //                    break;
    //                }
    //            }
    //        }
    //        return steps;
    //    }

    /**
     * 正向查找可到达的最大位置
     */
    public int jump(int[] nums) {
        /**
         * end表示一次跳跃的最远边界
         * maxPosition表示从当前位置可以到达的最远位置
         */
        int i = 0, end = 0, maxPosition = 0;
        int res = 0;
        int length = nums.length;

        while (end < length - 1) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                ++res;
            }
            ++i;
        }
        return res;
    }

}
