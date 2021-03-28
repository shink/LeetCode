package com.yuanhaoji.leetcode.tree.binary_search_tree_iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/3/28
 * @desp: 173中等题——二叉搜索树迭代器，https://leetcode-cn.com/problems/binary-search-tree-iterator/
 */

public class BSTIterator {

    private int idx;
    private final List<Integer> list;

    public BSTIterator(TreeNode root) {
        idx = 0;
        list = new ArrayList<>();
        inorderTravelsal(root);
    }

    public int next() {
        return list.get(idx++);
    }

    public boolean hasNext() {
        return idx < list.size();
    }

    private void inorderTravelsal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTravelsal(root.left);
        list.add(root.val);
        inorderTravelsal(root.right);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
