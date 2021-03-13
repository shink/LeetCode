package com.yuanhaoji.leetcode.hash_table.design_hashSet;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/3/13
 * @desp: 705简单题——设计哈希集合，https://leetcode-cn.com/problems/design-hashset/
 */

public class MyHashSet {

    public static final int MOD_NUM = 769;
    private LinkedList<Integer>[] data;

    public MyHashSet() {
        data = new LinkedList[MOD_NUM];
        for (int i = 0; i < MOD_NUM; i++) {
            data[i] = new LinkedList<>();
        }
    }

    public void add(int key) {
        int hash = hash(key);
        Integer element;
        Iterator<Integer> iterator = data[hash].iterator();
        while (iterator.hasNext()) {
            element = iterator.next();
            if (element == key) {
                return;
            }
        }
        data[hash].offerLast(key);
    }

    public void remove(int key) {
        int hash = hash(key);
        Integer element;
        Iterator<Integer> iterator = data[hash].iterator();
        while (iterator.hasNext()) {
            element = iterator.next();
            if (element == key) {
                data[hash].remove(element);
                return;
            }
        }
    }

    public boolean contains(int key) {
        int hash = hash(key);
        Integer element;
        Iterator<Integer> iterator = data[hash].iterator();
        while (iterator.hasNext()) {
            element = iterator.next();
            if (element == key) {
                return true;
            }
        }
        return false;
    }

    private static int hash(int key) {
        return key % MOD_NUM;
    }

}
