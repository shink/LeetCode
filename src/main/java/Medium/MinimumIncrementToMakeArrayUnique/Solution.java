package MinimumIncrementToMakeArrayUnique;

import java.util.Arrays;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/3/22
 * @desp: 945题——使数组唯一的最小增量, https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/
 */

public class Solution {

    public int minIncrementForUnique(int[] A) {

        //        quickSort(A);
        Arrays.sort(A);

        int res = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i - 1]) {
                ++res;
                ++A[i];
            } else if (A[i] < A[i - 1]) {
                int delta = A[i - 1] - A[i] + 1;
                res += delta;
                A[i] += delta;
            }
        }

        return res;
    }

    /**
     * 快排
     */
    private void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int left, int right) {
        if (left < right) {
            // 枢轴
            int pivot = partition(array, left, right);
            quickSort(array, left, pivot - 1);
            quickSort(array, pivot + 1, right);
        }
    }

    private int partition(int[] array, int left, int right) {
        int i = left;
        int j = right;

        while (i < j) {
            while (i < j && array[i] <= array[j]) {
                j--;
            }
            if (i < j) {
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
                i++;
            }

            while (i < j && array[i] <= array[j]) {
                i++;
            }
            if (i < j) {
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        return i;
    }
}
