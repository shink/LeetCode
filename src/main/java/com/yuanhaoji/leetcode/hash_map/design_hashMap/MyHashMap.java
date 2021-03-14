package com.yuanhaoji.leetcode.hash_map.design_hashMap;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/3/14
 * @desp: 706简单题——设计哈希映射，https://leetcode-cn.com/problems/design-hashmap/
 */

public class MyHashMap {

    public static final int MOD_NUM = 769;
    private LinkedList<Data>[] data;

    public MyHashMap() {
        data = new LinkedList[MOD_NUM];
        for (int i = 0; i < MOD_NUM; i++) {
            data[i] = new LinkedList<>();
        }
    }

    public void put(int key, int value) {
        int hash = hash(key);
        Data element;
        Iterator<Data> iterator = data[hash].iterator();
        while (iterator.hasNext()) {
            element = iterator.next();
            if (element.getKey() == key) {
                element.setValue(value);
                return;
            }
        }
        data[hash].offerLast(new Data(key, value));
    }

    public int get(int key) {
        int hash = hash(key);
        Data element;
        Iterator<Data> iterator = data[hash].iterator();
        while (iterator.hasNext()) {
            element = iterator.next();
            if (element.getKey() == key) {
                return element.getValue();
            }
        }
        return -1;
    }

    public void remove(int key) {
        int hash = hash(key);
        Data element;
        Iterator<Data> iterator = data[hash].iterator();
        while (iterator.hasNext()) {
            element = iterator.next();
            if (element.getKey() == key) {
                data[hash].remove(element);
                return;
            }
        }
    }

    private static int hash(int key) {
        return key % MOD_NUM;
    }

    class Data {
        private int key;
        private int value;

        public Data(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

}
