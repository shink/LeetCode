package LongestPalindrome;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/3/19
 * @desp: 409题——最长回文串, https://leetcode-cn.com/problems/longest-palindrome/
 */

public class Solution {

    public int longestPalindrome(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] array = s.toCharArray();
        for (char c : array) {
            if (map.containsKey(c)) {
                int value = map.get(c);
                map.put(c, ++value);
            } else {
                map.put(c, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (value > 1) {
                res += value / 2 * 2;
                value = value % 2;
                map.put(entry.getKey(), value);
            }
        }

        return map.containsValue(1) ? ++res : res;
    }

}
