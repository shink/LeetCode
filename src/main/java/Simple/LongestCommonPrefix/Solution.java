package LongestCommonPrefix;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/6/7
 * @desp: 14——最长公共前缀, https://leetcode-cn.com/problems/longest-common-prefix/
 */

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        String res = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(res) != 0) {
                res = res.substring(0, res.length() - 1);
                if (res.isEmpty())
                    return "";
            }
        }

        return res;
    }
}
