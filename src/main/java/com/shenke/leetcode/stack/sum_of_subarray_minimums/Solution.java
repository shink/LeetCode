package com.shenke.leetcode.stack.sum_of_subarray_minimums;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/11/5
 * @desp: 907中等题——子数组的最小值之和，https://leetcode-cn.com/problems/sum-of-subarray-minimums/
 */

public class Solution {

    /**
     * res = 每个数在子数组中作为最小值时的次数之和 * 该数值
     * 等号在左在右都可以，因为当出现一个与当前值相等的值时，该值依然算是该子数组的最小值
     */
    //    public int sumSubarrayMins(int[] A) {
    //        long res = 0, mod = 1000000007;
    //        int l, r;
    //
    //        for (int i = 0; i < A.length; ++i) {
    //
    //            l = i - 1;
    //            while (l >= 0 && A[i] <= A[l])
    //                --l;
    //
    //            r = i + 1;
    //            while (r < A.length && A[i] < A[r])
    //                ++r;
    //
    //            res += ((i - l) * (r - i) * A[i]);
    //        }
    //
    //        return (int) (res % mod);
    //    }


    /**
     * 单调栈
     * 维护单增栈用来求各段最小值出现的位置(栈顶两个数相减表示这个值连续出现的个数或者说距离),
     * curSum 表示以A[i]结尾的所有子数组要求的和(类似dp[i])
     * curSum += (A[i] - A[top]) * (top - new_top)
     * 这句就是算出来的递推增量关系(类似dp[i]与dp[i-1]的关系)
     * 然后我们最终要求的 ans 就是所有 curSum 之和(类似于sum(dp[i]))
     * 又由于这里只要一个变量存就够了, 就不要 dp 数组了
     */
    //    public int sumSubarrayMins(int[] A) {
    //        long mod = 1000000007;
    //        Stack<Integer> stack = new Stack<>();
    //
    //        long curSum = 0, res = 0;
    //        for (int i = 0; i < A.length; ++i) {
    //            while (!stack.empty() && A[stack.peek()] >= A[i]) {
    //                int top = stack.pop();
    //                int newTop = stack.empty() ? -1 : stack.peek();
    //                curSum += (A[i] - A[top]) * (top - newTop);
    //            }
    //            curSum += A[i];
    //            stack.push(i);
    //            res += curSum;
    //        }
    //        return (int) (res % mod);
    //    }


    /**
     * 执行时间 6ms 范例
     */
    public int sumSubarrayMins(int[] A) {
        long res = 0, sum = 0;
        int N = A.length;
        int[] stack = new int[N + 1];
        int idx = 0;
        stack[idx++] = -1;
        for (int i = 0; i < N; i++) {
            if (A[i] <= A[stack[1]]) {
                idx = 1;
                sum = A[i] * (i + 1);
            } else {
                while (idx > 1 && A[stack[idx - 1]] >= A[i]) {
                    sum -= A[stack[idx - 1]] * (stack[idx - 1] - stack[idx - 2]);
                    idx--;
                }
                sum += A[i] * (i - stack[idx - 1]);
            }
            res += sum;
            stack[idx++] = i;
            //            System.out.println(Arrays.toString(stack));
        }
        return (int) (res % 1_000_000_007);
    }

}
