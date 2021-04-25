package com.yuanhaoji.leetcode.tree.increasing_order_search_tree;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/4/25
 * @desp: 897简单题——递增顺序搜索树，https://leetcode-cn.com/problems/increasing-order-search-tree/
 */
public class Solution {

    private TreeNode p;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode head = new TreeNode(-1);
        p = head;
        dfs(root);
        return head.right;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        dfs(node.left);

        p.right = node;
        node.left = null;
        p = node;

        dfs(node.right);
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
