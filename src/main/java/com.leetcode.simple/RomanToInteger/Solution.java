package RomanToInteger;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2019/10/01
 * @desp: 13题——罗马数字转整数, https://leetcode-cn.com/problems/roman-to-integer/
 */

import java.util.HashMap;

public class Solution {

    public static int romanToInt(String s) {

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int length = s.length();
        int result = 0;

        for (int i = 0; i < length; i++) {
            int num = map.get(s.charAt(i));
            if (i < length - 1 && num < map.get(s.charAt(i + 1))) {
                result -= num;
            } else {
                result += num;
            }

        }

        //		int i = 0;
        //
        //		while (i < length) {
        //			if (i + 1 >= length) {
        //				return result + map.get(s.charAt(i));
        //			} else {
        //				int num1 = map.get(s.charAt(i));
        //				int num2 = map.get(s.charAt(i + 1));
        //
        //				if (num1 >= num2) {
        //					result += num1;
        //					++i;
        //
        //				} else {
        //					result += num2 - num1;
        //					i += 2;
        //				}
        //
        //			}
        //		}

        return result;
    }

}
