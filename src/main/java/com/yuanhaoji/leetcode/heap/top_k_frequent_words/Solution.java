package com.yuanhaoji.leetcode.heap.top_k_frequent_words;

import java.util.*;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/5/20
 * @desp: 692中等题——前K个高频单词，https://leetcode-cn.com/problems/top-k-frequent-words/
 */
public class Solution {

    /**
     * 暴力法
     */
    // public List<String> topKFrequent(String[] words, int k) {
    //     Map<String, Integer> frequent = new HashMap<>();
    //     for (String word : words) {
    //         frequent.put(word, frequent.getOrDefault(word, 0) + 1);
    //     }
    //     List<String> list = new ArrayList<>(frequent.keySet());
    //     list.sort((s1, s2) -> {
    //         int freq1 = frequent.get(s1), freq2 = frequent.get(s2);
    //         return freq1 == freq2 ? s1.compareTo(s2) : freq2 - freq1;
    //     });
    //
    //     return list.subList(0, k);
    // }

    /**
     * 优先级队列
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>(new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                return entry1.getValue().equals(entry2.getValue()) ? entry2.getKey().compareTo(entry1.getKey()) : entry1.getValue() - entry2.getValue();
            }
        });
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<String> ret = new ArrayList<>();
        while (!pq.isEmpty()) {
            ret.add(pq.poll().getKey());
        }
        Collections.reverse(ret);
        return ret;
    }

}
