package ReversePairInTheArray;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/4/24
 * @desp: 面试题51——数组中的逆序对, https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 */

public class Solution {

    /**
     * 在归并之前，找右侧有多少个数比左侧的数小；统计好当前左右两区间的逆序对数目，然后在归并
     */
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left == right) {
            return 0;
        }

        int mid = left + ((right - left) >> 1);

        return mergeSort(nums, left, mid) +
                mergeSort(nums, mid + 1, right) +
                merge(nums, left, mid, right);
    }

    private int merge(int[] nums, int left, int mid, int right) {
        int p1 = left, lEnd = mid, p2 = mid + 1, rEnd = right;
        int ans = 0, i = 0;
        int[] mergeArray = new int[right - left + 1];

        while (p1 <= lEnd && p2 <= rEnd) {
            ans += nums[p1] > nums[p2] ? rEnd - p2 + 1 : 0;
            mergeArray[i++] = nums[p1] > nums[p2] ? nums[p1++] : nums[p2++];
        }
        while (p1 <= lEnd) {
            mergeArray[i++] = nums[p1++];
        }
        while (p2 <= rEnd) {
            mergeArray[i++] = nums[p2++];
        }

        for (int j = 0; j < mergeArray.length; j++) {
            nums[left + j] = mergeArray[j];
        }

        return ans;
    }
}
