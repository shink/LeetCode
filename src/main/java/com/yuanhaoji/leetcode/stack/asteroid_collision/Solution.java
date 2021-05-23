package com.yuanhaoji.leetcode.stack.asteroid_collision;

import java.util.*;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/5/23
 * @desp: 735中等题——行星碰撞，https://leetcode-cn.com/problems/asteroid-collision/
 */
public class Solution {

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();
        for (int size : asteroids) {
            if (size < 0) {
                int num = Math.abs(size);
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < num) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() > 0 && stack.peek() == num) {
                    stack.pop();
                } else if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(size);
                }
            } else {
                stack.push(size);
            }
        }

        int length = stack.size();
        int[] res = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }

    /**
     * 官方题解
     */
    // public int[] asteroidCollision(int[] asteroids) {
    //     Deque<Integer> stack = new LinkedList<>();
    //     for (int ast : asteroids) {
    //         collision:
    //         {
    //             while (!stack.isEmpty() && ast < 0 && 0 < stack.peek()) {
    //                 if (stack.peek() < -ast) {
    //                     stack.pop();
    //                     continue;
    //                 } else if (stack.peek() == -ast) {
    //                     stack.pop();
    //                 }
    //                 break collision;
    //             }
    //             stack.push(ast);
    //         }
    //     }
    //
    //     int[] ans = new int[stack.size()];
    //     for (int t = ans.length - 1; t >= 0; --t) {
    //         ans[t] = stack.pop();
    //     }
    //     return ans;
    // }

}
