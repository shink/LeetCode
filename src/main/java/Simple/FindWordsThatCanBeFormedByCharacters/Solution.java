package FindWordsThatCanBeFormedByCharacters;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/3/17
 * @desp: 1160题——拼写单词, https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters/
 */

public class Solution {

    /**
     * 我的方法，暴力，o(n3)
     */
    //    private boolean match(String word, String chars) {
    //
    //        if (chars.length() < word.length()) {
    //            return false;
    //        }
    //
    //        char[] word_array = word.toCharArray();
    //        char[] chars_array = chars.toCharArray();
    //        boolean[] hasUsed = new boolean[chars.length()];
    //        int sum = 0;
    //
    //        for (int i = 0; i < word_array.length; i++) {
    //            for (int j = 0; j < chars_array.length; j++) {
    //                if (!hasUsed[j] && word_array[i] == chars_array[j]) {
    //                    hasUsed[j] = true;
    //                    ++sum;
    //                    break;
    //                }
    //            }
    //        }
    //
    //        return (sum == word.length()) ? true : false;
    //    }
    //
    //    public int countCharacters(String[] words, String chars) {
    //
    //        int res = 0;
    //
    //        for (int i = 0; i < words.length; i++) {
    //            if (match(words[i], chars)) {
    //                res += words[i].length();
    //            }
    //        }
    //
    //        return res;
    //    }


    /**
     * 计数法，couter
     */
    public int countCharacters(String[] words, String chars) {

        int res = 0;
        Map<Character, Integer> charsMap = getCountMap(chars);

        for (String word : words) {
            boolean flag = true;
            Map<Character, Integer> wordMap = getCountMap(word);
            char[] wordArray = word.toCharArray();
            for (char c : wordArray) {
                if (!charsMap.containsKey(c) || wordMap.get(c) > charsMap.get(c)) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                res += word.length();
        }

        return res;
    }

    private Map<Character, Integer> getCountMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        char[] charArray = str.toCharArray();

        for (char c : charArray) {
            if (map.containsKey(c)) {
                int sum = map.get(c);
                map.put(c, ++sum);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }

}
