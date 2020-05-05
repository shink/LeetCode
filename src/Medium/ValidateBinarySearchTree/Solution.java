package ValidateBinarySearchTree;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/5/5
 * @desp: 98题——验证二叉搜索树, https://leetcode-cn.com/problems/validate-binary-search-tree/
 */

public class Solution {
    /**
     * 中序遍历：左——>根——>右
     */

    /**
     * 中序递归
     */
    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        if (isValidBST(root.left) && root.val > pre) {
            pre = root.val;
            return isValidBST(root.right);
        }

        return false;
    }


    /**
     * 中序迭代
     */
    //    public boolean isValidBST(TreeNode root) {
    //        Stack<TreeNode> stack = new Stack<>();
    //        long pre = Long.MIN_VALUE;
    //
    //        while (!stack.empty() || root != null) {
    //            while (root != null) {
    //                stack.push(root);
    //                root = root.left;
    //            }
    //
    //            root = stack.pop();
    //            if (root.val <= pre)
    //                return false;
    //            pre = root.val;
    //            root = root.right;
    //        }
    //        return true;
    //    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}


