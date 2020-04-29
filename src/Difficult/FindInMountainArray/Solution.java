package FindInMountainArray;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/4/29
 * @desp: 1095题——山脉数组中查找目标值, https://leetcode-cn.com/problems/find-in-mountain-array/
 */

public class Solution {
    /**
     * 数组length<=10000，而log_2(10000)约等于13，故可推算出要求的算法时间复杂度为O(logn)，首先可想到二分查找
     * 以峰顶为中心的两个数组一定是有序数组，于是可以通过分别在两个数组中二分查找来找到目标值
     * BTW，二分查找不一定只能应用在有序数组的查找中！
     */
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();

        //  1.查找山顶元素
        int peakIndex = findMountainTop(mountainArr, 0, length - 1);
        if (target == mountainArr.get(peakIndex))
            return peakIndex;

        //  2.二分查找左边区域（因为题目返回最小下标）
        int res = findSortedArray(mountainArr, 0, peakIndex - 1, target);

        //  3.二分查找右边区域
        return res != -1 ? res : findReverseArray(mountainArr, peakIndex + 1, length - 1, target);
    }

    private int findMountainTop(MountainArray mountainArr, int left, int right) {
        while (left < right) {
            //  防止 (left + right) 溢出，下面是下取整
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1))
                //  下一轮搜索区间 [mid + 1, right]
                //  因为是下取整，所以当只有两个元素时，mid==left，如果取区间[mid, right]，会发生死循环
                left = mid + 1;
            else
                //  下一轮搜索区间 [left, mid]
                right = mid;
        }
        //  退出时必然有Left==right，即为山顶
        return left;
    }

    private int findSortedArray(MountainArray mountainArr, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < target)
                left = mid + 1;
            else
                right = mid;
        }
        return mountainArr.get(left) == target ? left : -1;
    }

    private int findReverseArray(MountainArray mountainArr, int left, int right, int target) {
        while (left < right) {
            //  这里是用上取整
            int mid = left + (right - left + 1) / 2;
            if (mountainArr.get(mid) < target)
                //  下一轮搜索区间 [left, mid - 1]
                right = mid - 1;
            else
                //  下一轮搜索区间 [mid, right]
                //  如果用下取整，则只有两个元素的时候，left==mid，区间不会缩小，发生死循环，所以需要上取整
                left = mid;
        }
        return mountainArr.get(left) == target ? left : -1;
    }
}
