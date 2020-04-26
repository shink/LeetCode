package MaximumScoreAfterSplittingAString;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/4/26
 * @desp: 周赛186场5392题——分割字符串的最大得分, https://leetcode-cn.com/contest/weekly-contest-186/problems/maximum-score-after-splitting-a-string/
 */

public class Solution {
    public int maxScore(String s) {
        int res = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            res = Math.max(res, score(s, i));
        }
        return res;
    }

    private int score(String s, int cur) {
        int res1 = 0, res2 = 0;
        char[] array = s.toCharArray();

        for (int i = 0; i <= cur; i++) {
            if (array[i] == '0')
                res1++;
        }

        for (int i = cur + 1; i < array.length; i++) {
            if (array[i] == '1')
                res2++;
        }

        return res1 + res2;
    }
}
