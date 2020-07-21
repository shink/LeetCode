package ShortEncodingOfWords;

import java.util.*;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/3/28
 * @desp: 820题——单词的压缩编码, https://leetcode-cn.com/problems/short-encoding-of-words/
 */

public class Solution {
    /**
     * 保留所有不是其他单词后缀的单词
     */

    /**
     * 官方题解——1.存储后缀，32ms
     */
    //    public int minimumLengthEncoding(String[] words) {
    //        // 去重
    //        Set<String> set = new HashSet(Arrays.asList(words));
    //        // 删除每个单词的子序列
    //        for (String word : words) {
    //            for (int k = 1; k < word.length(); ++k)
    //                set.remove(word.substring(k));
    //        }
    //
    //        int res = 0;
    //        for (String str : set)
    //            res += str.length() + 1;
    //        return res;
    //    }

    /**
     * 官方题解，2.字典树（前缀树，Trie树），28ms
     */
    public int minimumLengthEncoding(String[] words) {
        TrieNode trie = new TrieNode();
        Map<TrieNode, Integer> nodes = new HashMap();

        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            TrieNode cur = trie;
            for (int j = word.length() - 1; j >= 0; --j)
                cur = cur.get(word.charAt(j));
            nodes.put(cur, i);
        }

        int res = 0;
        for (TrieNode node : nodes.keySet()) {
            // 叶结点
            if (node.count == 0)
                res += words[nodes.get(node)].length() + 1;
        }
        return res;
    }
}


class TrieNode {
    TrieNode[] children;
    int count;

    TrieNode() {
        children = new TrieNode[26];
        count = 0;
    }

    public TrieNode get(char c) {
        if (children[c - 'a'] == null) {
            children[c - 'a'] = new TrieNode();
            count++;
        }
        return children[c - 'a'];
    }
}