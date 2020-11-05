package com.shenke.leetcode.stack.MiniParser;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/7/28
 * @desp:
 */

public class NestedInteger {

    public Integer integer;
    public List<NestedInteger> list;

    public NestedInteger() {
        list = new ArrayList<>();
    }

    public NestedInteger(int value) {
        integer = value;
    }

    public boolean isInteger() {
        return integer != null;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(int value) {
        integer = value;
    }

    public void add(NestedInteger ni) {
        list.add(ni);
    }

    public List<NestedInteger> getList() {
        return list;
    }
}
