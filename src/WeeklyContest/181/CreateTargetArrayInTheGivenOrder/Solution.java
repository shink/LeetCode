package CreateTargetArrayInTheGivenOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/3/24
 * @desp: 周赛181场1389题——按既定顺序创建目标数组, https://leetcode-cn.com/contest/weekly-contest-181/problems/create-target-array-in-the-given-order/
 */

public class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int length = nums.length;
        List<Integer> res = new ArrayList<>();
        int[] target = new int[length];

        for (int i = 0; i < length; i++) {
            res.add(index[i], nums[i]);
        }

        for (int j = 0; j < length; j++) {
            target[j] = res.get(j);
        }

        return target;
    }

}
