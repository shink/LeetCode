package SearchInRotatedSortedArray;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/4/27
 * @desp: 33题——搜索旋转排序数组, https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */

public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        return recur(nums, 0, nums.length - 1, target);
    }

    private int recur(int[] nums, int left, int right, int target) {
        if (left == right) {
            return nums[left] == target ? left : -1;
        }
        int mid = (left + right) / 2;
        int lres = recur(nums, left, mid, target);
        return lres != -1 ? lres : recur(nums, mid + 1, right, target);
    }
}
