package LargestRectangleInHistogram;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/5/30
 * @desp: 84题——柱状图中最大的矩形, https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 */

public class Solution {
    /**
     * 暴力法
     */
    //    public int largestRectangleArea(int[] heights) {
    //        int length = heights.length;
    //        int res = 0;
    //
    //        for (int i = 0; i < length; i++) {
    //            int h = heights[i];
    //            int left = i - 1, right = i + 1;
    //
    //            while (left >= 0 && heights[left] >= h)
    //                --left;
    //
    //            while (right < length && heights[right] >= h)
    //                ++right;
    //
    //            res = Math.max(res, (right - left - 1) * h);
    //        }
    //        return res;
    //    }

    /**
     * 单调栈 + 常数优化
     */
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        Stack<Integer> mono_stack = new Stack<Integer>();
        for (int i = 0; i < n; ++i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                right[mono_stack.peek()] = i;
                mono_stack.pop();
            }
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }

}
