package BuildAnArrayWithStackOperations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/5/10
 * @desp: 周赛188场5404题——用栈操作构建数组, https://leetcode-cn.com/contest/weekly-contest-188/problems/build-an-array-with-stack-operations/
 */

public class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int i = 0, j = 1;

        while (i < target.length) {
            res.add("Push");
            if (target[i] != j)
                res.add("Pop");
            else
                i++;
            j++;
        }

        return res;
    }
}
