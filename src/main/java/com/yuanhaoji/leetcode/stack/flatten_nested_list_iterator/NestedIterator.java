package com.yuanhaoji.leetcode.stack.flatten_nested_list_iterator;

import java.util.*;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/3/23
 * @desp: 341中等题——扁平化嵌套列表迭代器，https://leetcode-cn.com/problems/flatten-nested-list-iterator/
 */

public class NestedIterator implements Iterator<Integer> {

    /**
     * DFS
     */
    // private final List<Integer> res;
    // private int index;
    //
    // public NestedIterator(List<NestedInteger> nestedList) {
    //     res = new ArrayList<>();
    //     dfs(nestedList);
    // }
    //
    // @Override
    // public Integer next() {
    //     return hasNext() ? res.get(index++) : null;
    // }
    //
    // @Override
    // public boolean hasNext() {
    //     return index < res.size();
    // }
    //
    // private void dfs(List<NestedInteger> nestedList) {
    //     for (NestedInteger nestedInteger : nestedList) {
    //         if (nestedInteger.isInteger()) {
    //             res.add(nestedInteger.getInteger());
    //         } else {
    //             dfs(nestedInteger.getList());
    //         }
    //     }
    // }

    /**
     * Stack
     */

    // 存储列表的当前遍历位置
    private Deque<Iterator<NestedInteger>> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new LinkedList<>();
        stack.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        // 由于保证调用 next 之前会调用 hasNext，直接返回栈顶列表的当前元素
        return stack.peek().next().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            Iterator<NestedInteger> it = stack.peek();
            if (!it.hasNext()) { // 遍历到当前列表末尾，出栈
                stack.pop();
                continue;
            }
            // 若取出的元素是整数，则通过创建一个额外的列表将其重新放入栈中
            NestedInteger nest = it.next();
            if (nest.isInteger()) {
                List<NestedInteger> list = new ArrayList<NestedInteger>();
                list.add(nest);
                stack.push(list.iterator());
                return true;
            }
            stack.push(nest.getList().iterator());
        }
        return false;
    }

}
