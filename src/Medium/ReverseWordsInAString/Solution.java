package ReverseWordsInAString;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/4/10
 * @desp: 151题——翻转字符串里的单词, https://leetcode-cn.com/problems/reverse-words-in-a-string/
 */

public class Solution {
    public String reverseWords(String s) {
//        String res = "";
//        s = s.replaceAll("\\s{2,}", " ").trim();
//        String[] array = s.split("\\s+");
//
//        for (int i = array.length - 1; i >= 0; i--) {
//            res += array[i] + " ";
//        }
//
//        return res.trim();

        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}
