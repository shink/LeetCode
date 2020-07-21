package ReformatTheString;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/4/19
 * @desp: 周赛185场5388题——重新格式化字符串, https://leetcode-cn.com/contest/weekly-contest-185/problems/reformat-the-string/
 */

public class Solution {
    //  5388
    public String reformat(String s) {
        String res = "";

        Pattern p1 = Pattern.compile("[a-z]");
        Matcher m1 = p1.matcher(s);
        String letter = m1.replaceAll("").trim();

        Pattern p2 = Pattern.compile("[0-9]");
        Matcher m2 = p2.matcher(s);
        String character = m2.replaceAll("").trim();

        if (letter.length() - character.length() == 1) {
            res = getRes(letter, character, false);
        } else if (letter.length() - character.length() == -1) {
            res = getRes(character, letter, false);
        } else if (letter.length() == character.length()) {
            res = getRes(letter, character, true);
        }
        return res;
    }

    private String getRes(String s1, String s2, boolean equal) {
        char[] array = new char[s1.length() + s2.length()];
        int i;

        for (i = 0; i < s2.length(); i++) {
            array[i * 2] = s1.charAt(i);
            array[i * 2 + 1] = s2.charAt(i);
        }
        if (!equal)
            array[i * 2] = s1.charAt(i);
        return String.valueOf(array);
    }
}
