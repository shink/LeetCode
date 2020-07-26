package TheSmallestKNumbers;

import java.util.Arrays;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/3/20
 * @desp: 面试题 40——最小的k个数, https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */

public class Solution {

    /**
     * 我的方法
     */
    //    public int[] getLeastNumbers(int[] arr, int k) {
    //        if (arr.length == 0)
    //            return arr;
    //        if (k == 0)
    //            return new int[0];
    //
    //        int[] res = new int[k];
    //        int num = 0;
    //        for (int i = 0; i < arr.length - 1; i++) {
    //            for (int j = i + 1; j < arr.length; j++) {
    //                if (arr[j] < arr[i]) {
    //                    int temp = arr[j];
    //                    arr[j] = arr[i];
    //                    arr[i] = temp;
    //                }
    //            }
    //        }
    //
    //        for (int i = 0; i < k; i++) {
    //            res[i] = arr[i];
    //        }
    //        return res;
    //    }

    /**
     * 快排
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 最后一个参数表示我们要找的是下标为k-1的数
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch(int[] nums, int lo, int hi, int k) {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
        int j = partition(nums, lo, hi);
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
        return j > k ? quickSearch(nums, lo, j - 1, k) : quickSearch(nums, j + 1, hi, k);
    }

    // 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
    private int partition(int[] nums, int lo, int hi) {
        int v = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (++i <= hi && nums[i] < v)
                ;
            while (--j >= lo && nums[j] > v)
                ;
            if (i >= j) {
                break;
            }
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[lo] = nums[j];
        nums[j] = v;
        return j;
    }

}
