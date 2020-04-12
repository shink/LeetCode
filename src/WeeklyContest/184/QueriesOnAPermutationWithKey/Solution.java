package QueriesOnAPermutationWithKey;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/4/12
 * @desp: 周赛184场5381题——查询带键的排列, https://leetcode-cn.com/contest/weekly-contest-184/problems/queries-on-a-permutation-with-key/
 */

public class Solution {
    public int[] processQueries(int[] queries, int m) {
        int length = queries.length;
        int[] res = new int[length];
        List<Integer> p = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            p.add(i, i + 1);
        }

        for (int i = 0; i < length; i++) {
            int loc = p.indexOf(queries[i]);
            res[i] = loc;

            for (int j = loc; j > 0; j--) {
                p.set(j, p.get(j - 1));
            }
            p.set(0, queries[i]);
        }
        return res;
    }

}
