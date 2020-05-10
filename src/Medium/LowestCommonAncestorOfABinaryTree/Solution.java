package LowestCommonAncestorOfABinaryTree;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/5/10
 * @desp: 236题——二叉树的最近公共祖先, https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */

public class Solution {
    /**
     * DFS
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //  都不为空说明一个在左，一个在右，此时返回root
        if (left != null && right != null)
            return root;
        return left == null ? right : left;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
