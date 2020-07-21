package SortAnArray;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/3/31
 * @desp: 912题——排序数组, https://leetcode-cn.com/problems/sort-an-array/
 */

public class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            //  枢轴
            int pivot = partition(nums, left, right);
            quickSort(nums, left, pivot - 1);
            quickSort(nums, pivot + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int i = left, j = right;

        while (i < j) {
            while (i < j && nums[i] <= nums[j]) {
                j--;
            }
            if (i < j) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }

            while (i < j && nums[i] <= nums[j]) {
                i++;
            }
            if (i < j) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }

        return i;
    }
}
