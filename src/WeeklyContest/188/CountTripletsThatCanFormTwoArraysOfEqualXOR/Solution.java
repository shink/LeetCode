package CountTripletsThatCanFormTwoArraysOfEqualXOR;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/5/10
 * @desp: 周赛188场5405题——形成两个异或相等数组的三元组数目, https://leetcode-cn.com/contest/weekly-contest-188/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/
 */

public class Solution {
    public int countTriplets(int[] arr) {
        int res = 0;
        int i = 0, k = arr.length - 1;
        for (int j = 0; j < k; j++) {

        }
        return res;
    }

    private int recur(int[] arr, int i, int j, int k) {
        int a = 0, b = 0;
        for (int l = i; l < j; l++) {
            a ^= arr[l];
        }
        for (int l = j; l <= k; l++) {
            b ^= arr[l];
        }
        return a == b ? 1 : 0;
    }

}
