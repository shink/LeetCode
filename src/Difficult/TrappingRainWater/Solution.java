package TrappingRainWater;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/4/4
 * @desp: 42题——接雨水, https://leetcode-cn.com/problems/trapping-rain-water/
 */

public class Solution {

    /**
     * 暴力法，找到当前位置两遍最高的方块，并以其中较小的方块为基准
     * 造成重复搜索
     */
    //    public int trap(int[] height) {
    //        int res = 0;
    //        int length = height.length;
    //        for (int i = 1; i < length - 1; i++) {
    //            int left = 0, right = 0;
    //            for (int j = i; j >= 0; j--) {
    //                left = Math.max(left, height[j]);
    //            }
    //            for (int j = i; j < length; j++) {
    //                right = Math.max(right, height[j]);
    //            }
    //
    //            res += Math.min(left, right) - height[i];
    //        }
    //        return res;
    //    }

    /**
     * DP：
     */
    //    public int trap(int[] height) {
    //        if (height.length == 0)
    //            return 0;
    //
    //        int res = 0;
    //        int length = height.length;
    //        int[] left = new int[length];   // left[i]表示第i个方块的左边最高的方块高度
    //        int[] right = new int[length];  // right[i]表示第i个方块的右边最高的方块高度
    //
    //        left[0] = height[0];
    //        for (int i = 1; i < length; i++) {
    //            left[i] = Math.max(height[i], left[i - 1]);
    //        }
    //
    //        right[length - 1] = height[length - 1];
    //        for (int i = length - 2; i >= 0; i--) {
    //            right[i] = Math.max(height[i], right[i + 1]);
    //        }
    //
    //        for (int i = 1; i < length - 1; i++) {
    //            res += Math.min(left[i], right[i]) - height[i];
    //        }
    //        return res;
    //    }

    /**
     * 双指针法
     */
    public int trap(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > leftMax)
                    leftMax = height[left];
                else {
                    res += leftMax - height[left];
                    ++left;
                }
            } else {
                if (height[right] > rightMax)
                    rightMax = height[right];
                else {
                    res += rightMax - height[right];
                    --right;
                }
            }
        }
        return res;
    }


}
