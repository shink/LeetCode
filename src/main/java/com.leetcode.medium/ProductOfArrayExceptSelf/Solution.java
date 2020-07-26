package ProductOfArrayExceptSelf;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/6/4
 * @desp: 238——Product of Array Except Self, https://leetcode-cn.com/problems/product-of-array-except-self/
 */

public class Solution {
    /**
     * 一次循环中同时操作
     */
    //    public int[] productExceptSelf(int[] nums) {
    //        int length = nums.length;
    //        int[] res = new int[length];
    //
    //        /**
    //         * left表示当前元素左边所有元素的乘积
    //         * right表示当前元素右边所有元素的乘积
    //         */
    //        int left = 1, right = 1;
    //        for (int i = 0; i < length; i++) {
    //            res[i] = 1;
    //        }
    //
    //        for (int i = 0; i < length; i++) {
    //            res[i] *= left;
    //            left *= nums[i];
    //            res[length - 1 - i] *= right;
    //            right *= nums[length - 1 - i];
    //        }
    //
    //        return res;
    //    }


    /**
     * 官方题解，方法二
     * 分两次循环
     */
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];

        // res[i] 表示索引 i 左侧所有元素的乘积
        // 因为索引为 '0' 的元素左侧没有元素， 所以 answer[0] = 1
        res[0] = 1;
        for (int i = 1; i < length; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }

        // R 为右侧所有元素的乘积
        // 刚开始右边没有元素，所以 R = 1
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            // 对于索引 i，左边的乘积为 answer[i]，右边的乘积为 R
            res[i] = res[i] * R;
            // R 需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到 R 上
            R *= nums[i];
        }
        return res;
    }

}
