package com.yuanhaoji.leetcode.coding_interviews.rebuild_binary_tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/6/5
 * @desp: 《剑指 Offer》第 7 题——重建二叉树，https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 */
public class Solution {

    /**
     * 递归
     */
    // private int[] preorder;
    // private int[] inorder;
    //
    // public TreeNode buildTree(int[] preorder, int[] inorder) {
    //     if (preorder == null || inorder == null) {
    //         return null;
    //     }
    //
    //     this.preorder = preorder;
    //     this.inorder = inorder;
    //     return recur(0, preorder.length, 0, inorder.length);
    // }
    //
    // private TreeNode recur(int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
    //     if (preorderLeft >= preorderRight) {
    //         return null;
    //     }
    //
    //     int rootVal = preorder[preorderLeft];
    //     TreeNode root = new TreeNode(rootVal);
    //
    //     // 在 inorder 中找 rootVal
    //     int midIdx = -1;
    //     for (int i = inorderLeft; i < inorderRight; i++) {
    //         if (inorder[i] == rootVal) {
    //             midIdx = i;
    //             break;
    //         }
    //     }
    //
    //     int leftSubTreeSize = midIdx - inorderLeft;
    //     root.left = recur(preorderLeft + 1, preorderLeft + leftSubTreeSize + 1, inorderLeft, midIdx);
    //     root.right = recur(preorderLeft + leftSubTreeSize + 1, preorderRight, midIdx + 1, inorderRight);
    //     return root;
    // }


    /**
     * 官方题解 1
     * 递归
     */
    // private Map<Integer, Integer> indexMap;
    //
    // public TreeNode buildTree(int[] preorder, int[] inorder) {
    //     int n = preorder.length;
    //     // 构造哈希映射，帮助我们快速定位根节点
    //     indexMap = new HashMap<>();
    //     for (int i = 0; i < n; i++) {
    //         indexMap.put(inorder[i], i);
    //     }
    //     return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    // }
    //
    // public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
    //     if (preorder_left > preorder_right) {
    //         return null;
    //     }
    //
    //     // 前序遍历中的第一个节点就是根节点
    //     int preorder_root = preorder_left;
    //     // 在中序遍历中定位根节点
    //     int inorder_root = indexMap.get(preorder[preorder_root]);
    //
    //     // 先把根节点建立出来
    //     TreeNode root = new TreeNode(preorder[preorder_root]);
    //     // 得到左子树中的节点数目
    //     int size_left_subtree = inorder_root - inorder_left;
    //     // 递归地构造左子树，并连接到根节点
    //     // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
    //     root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
    //     // 递归地构造右子树，并连接到根节点
    //     // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
    //     root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
    //     return root;
    // }


    /**
     * 官方题解 2
     * 迭代
     * <p>
     * 前序遍历，从根节点root开始，只要有左子节点，就一直会往左下方走，直到最左下角。
     * 而中序遍历，是从最左下角往上，如果碰到节点有右子节点，则会转向。
     * <p>
     * 因此，代码中的if块是用前序数组一直构建左子树，如果碰到了inorder[inorderIndex]，表示到了左下角，这时就需要往上走并处理右子树，也就是while代码块
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
