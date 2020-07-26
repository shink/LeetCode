package StringMatchingInAnArray;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/4/12
 * @desp: 周赛184场5380题——数组中的字符串匹配, https://leetcode-cn.com/contest/weekly-contest-184/problems/string-matching-in-an-array/
 */

public class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        int length = words.length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (j == i)
                    continue;
                if (words[i].indexOf(words[j]) != -1 && !res.contains(words[j]))
                    res.add(words[j]);
            }
        }
        return res;
    }
}
