package SubtreeOfAnotherTree;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/5/7
 * @desp: 572题——另一个树的子树, https://leetcode-cn.com/problems/subtree-of-another-tree/
 */

public class Solution {
    /**
     * 一个树是另一个树的子树，则
     * <p>
     * 要么这两个树相等
     * 要么这个树是左树的子树
     * 要么这个树是右树的子树
     */
    public boolean isSametree(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;

        return s != null && t != null && s.val == t.val && isSametree(s.left, t.left) && isSametree(s.right, t.right);
    }

    //    public boolean isSubtree(TreeNode s, TreeNode t) {
    //        if (s == null)
    //            return t == null;
    //
    //        return isSametree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    //    }


    /**
     * 我的方法，错误在于当两棵树val相等时，递归进行搜索，若遇到val不等时，本应直接返回false
     * 但是进入 isSubtree(s.left, t) || isSubtree(s.right, t) 后，可能返回true
     * 因此，判断两棵树相等和判断一棵树是否是另一颗的子树，应分开进行
     */
    //    public boolean isSubtree(TreeNode s, TreeNode t) {
    //        if (s == null && t == null)
    //            return true;
    //
    //        if (s != null && t != null) {
    //            if (s.val != t.val)
    //                return isSubtree(s.left, t) || isSubtree(s.right, t);
    //            else
    //                return isSubtree(s.left, t.left) || isSubtree(s.right, t.right);
    //        }
    //
    //        return false;
    //    }

    /**
     * 修改版
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;

        if (s != null && t != null) {
            if (s.val != t.val)
                return isSubtree(s.left, t) || isSubtree(s.right, t);
            else
                return isSametree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        }

        return false;
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

