package LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/5/4
 * @desp: 3题——无重复字符的最长子串, https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */

public class Solution {
    /**
     * 滑动窗口
     * [i, right]表示一个无重复字符的子串，则知[i + 1, right]无重复字符
     * 故对于下一个以i + 1开头的子串，只需从 right + 1开始判别
     * 得到每一个无重复字符的子串，最长子串的长度即为答案
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> occ = new HashSet<>();
        int length = s.length();
        int right = 0, res = 0;
        for (int i = 0; i < length; ++i) {
            if (i != 0)
                occ.remove(s.charAt(i - 1));
            while (right < length && !occ.contains(s.charAt(right))) {
                occ.add(s.charAt(right));
                ++right;
            }
            res = Math.max(res, right - i);
        }
        return res;
    }

}
