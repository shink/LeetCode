package MinimumSubsequenceInNonIncreasingOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/4/5
 * @desp: 周赛183场5376题——非递增顺序的最小子序列, https://leetcode-cn.com/contest/weekly-contest-183/problems/minimum-subsequence-in-non-increasing-order/
 */

public class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        int num = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            num += nums[i];
            if (num > sum - num) {
                res.add(nums[i]);
                break;
            } else
                res.add(nums[i]);
        }

        return res;
    }

    /**
     * 我的方法，太蠢了
     */
    //    public List<Integer> minSubsequence(int[] nums) {
    //        List<Integer> res = new ArrayList<>();
    //        if(nums.length == 1){
    //            res.add(nums[0]);
    //            return res;
    //        } else if(nums.length == 2 && nums[0] == nums[1]){
    //            res.add(nums[0]);
    //            res.add(nums[1]);
    //            return res;
    //        }
    //
    //        int[] array = sortArray(nums);
    //
    //        for (int i = 0; i < array.length - 1; i++) {
    //            if (getSum(array, 0, i) > getSum(array, i + 1, array.length - 1)) {
    //                for (int j = 0; j <= i; j++) {
    //                    res.add(array[j]);
    //                }
    //                return res;
    //            }
    //        }
    //        return res;
    //    }
    //
    //    private int getSum(int[] nums, int start, int end) {
    //        int sum = 0;
    //        for (int i = start; i <= end; i++) {
    //            sum += nums[i];
    //        }
    //        return sum;
    //    }
    //
    //    private int[] sortArray(int[] nums) {
    //        quickSort(nums, 0, nums.length - 1);
    //        return nums;
    //    }
    //
    //    private void quickSort(int[] nums, int left, int right) {
    //        if (left < right) {
    //            //  枢轴
    //            int pivot = partition(nums, left, right);
    //            quickSort(nums, left, pivot - 1);
    //            quickSort(nums, pivot + 1, right);
    //        }
    //    }
    //
    //    private int partition(int[] nums, int left, int right) {
    //        int i = left, j = right;
    //
    //        while (i < j) {
    //            while (i < j && nums[i] >= nums[j]) {
    //                j--;
    //            }
    //            if (i < j) {
    //                int temp = nums[j];
    //                nums[j] = nums[i];
    //                nums[i] = temp;
    //                i++;
    //            }
    //
    //            while (i < j && nums[i] >= nums[j]) {
    //                i++;
    //            }
    //            if (i < j) {
    //                int temp = nums[j];
    //                nums[j] = nums[i];
    //                nums[i] = temp;
    //            }
    //        }
    //
    //        return i;
    //    }
}
