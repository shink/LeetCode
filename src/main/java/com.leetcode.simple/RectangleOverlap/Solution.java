package RectangleOverlap;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/3/18
 * @desp: 836题——矩阵重叠, https://leetcode-cn.com/problems/rectangle-overlap/
 */

public class Solution {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[2] <= rec2[0] || rec2[2] <= rec1[0] || rec1[3] <= rec2[1] || rec2[3] <= rec1[1]);
    }
}
