package com.yuanhaoji.leetcode.stack.flatten_nested_list_iterator;

import java.util.List;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/3/23
 * @desp:
 */

public interface NestedInteger {

    public boolean isInteger();

    public Integer getInteger();

    public List<NestedInteger> getList();

}
