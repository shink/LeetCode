package com.yuanhaoji.leetcode.tree.cousins_in_binary_tree;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/5/17
 * @desp: 993简单题——二叉树的堂兄弟节点，https://leetcode-cn.com/problems/cousins-in-binary-tree/
 */
public class Solution {

    private int x, y;
    private int xDepth, yDepth, xFatherVal, yFatherVal;

    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        dfs(root, 1, -1);
        return xDepth == yDepth && xFatherVal != yFatherVal;
    }

    private void dfs(TreeNode node, int depth, int fatherVal) {
        if (node == null) {
            return;
        }

        if (node.val == x) {
            xDepth = depth;
            xFatherVal = fatherVal;
        } else if (node.val == y) {
            yDepth = depth;
            yFatherVal = fatherVal;
        } else {
            dfs(node.left, depth + 1, node.val);
            dfs(node.right, depth + 1, node.val);
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

}
