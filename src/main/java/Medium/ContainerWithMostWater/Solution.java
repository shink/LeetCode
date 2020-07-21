package ContainerWithMostWater;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/4/18
 * @desp: 11题——盛最多水的容器, https://leetcode-cn.com/problems/container-with-most-water/
 */

public class Solution {
    /**
     * 暴力法，O(n2)
     */
    //    public int maxArea(int[] height) {
    //        int length = height.length;
    //        int res = 0;
    //
    //        for (int i = 0; i < length - 1; i++) {
    //            for (int j = i + 1; j < length; j++) {
    //                res = Math.max(res, (j - i) * Math.min(height[i], height[j]));
    //            }
    //        }
    //
    //        return res;
    //    }

    /**
     * 双指针，O(n)
     */
    public int maxArea(int[] height) {
        int length = height.length;
        int i = 0, j = length - 1;
        int res = 0;

        while (i < j) {
            int h = Math.min(height[i], height[j]);
            res = Math.max(res, h * (j - i));
            if (height[i] < height[j])
                ++i;
            else
                --j;
        }

        return res;
    }
}
