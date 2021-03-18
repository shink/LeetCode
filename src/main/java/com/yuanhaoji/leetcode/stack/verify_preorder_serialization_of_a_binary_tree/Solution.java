package com.yuanhaoji.leetcode.stack.verify_preorder_serialization_of_a_binary_tree;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/3/15
 * @desp: 331中等题——验证二叉树的前序序列化，https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/
 */

public class Solution {

    // public boolean isValidSerialization(String preorder) {
    //     if (preorder == null) {
    //         return false;
    //     }
    //
    //     Deque<Integer> stack = new LinkedList<>();
    //     stack.push(1);
    //     char[] charArray = preorder.toCharArray();
    //     int i = 0, n = charArray.length;
    //
    //     while (i < n) {
    //         if (stack.isEmpty()) {
    //             return false;
    //         }
    //
    //         if (charArray[i] == '#') {
    //             int top = stack.pop() - 1;
    //             if (top > 0) {
    //                 stack.push(top);
    //             }
    //             i += 2;
    //         } else {
    //             while (i < n && charArray[i] != ',') {
    //                 ++i;
    //             }
    //             int top = stack.pop() - 1;
    //             if (top > 0) {
    //                 stack.push(top);
    //             }
    //             stack.push(2);
    //
    //             ++i;
    //         }
    //     }
    //
    //     return stack.isEmpty();
    // }


    public boolean isValidSerialization(String preorder) {
        if (preorder == null) {
            return false;
        }

        char[] charArray = preorder.toCharArray();
        int i = 0, n = charArray.length;
        int slots = 1;

        while (i < n) {
            if (slots == 0) {
                return false;
            }

            if (charArray[i] == '#') {
                --slots;
                i += 2;
            } else {
                while (i < n && charArray[i] != ',') {
                    ++i;
                }
                ++slots;
                ++i;
            }
        }

        return slots == 0;
    }

}
