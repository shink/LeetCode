package MergeIntervals;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/4/16
 * @desp: 56题——合并区间, https://leetcode-cn.com/problems/merge-intervals/
 */

public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1)
            return intervals;

        int count = 0;  //  合并次数
        int length = intervals.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (intervals[i][0] <= intervals[j][1] && intervals[i][1] >= intervals[j][0]) {
                    intervals[j][0] = Math.min(intervals[i][0], intervals[j][0]);
                    intervals[j][1] = Math.max(intervals[i][1], intervals[j][1]);
                    intervals[i] = null;    //  清空前者（只能这样，清空后者i++后下次循环时会空指针）
                    count++;
                    break;
                }
            }
        }

        int[][] res = new int[length - count][2];
        int i = 0;
        for (int[] point : intervals) {
            if (point != null)
                res[i++] = point;
        }

        return res;
    }
}
