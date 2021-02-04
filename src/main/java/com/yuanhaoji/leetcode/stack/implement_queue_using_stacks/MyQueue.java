package com.yuanhaoji.leetcode.stack.implement_queue_using_stacks;

import java.util.Stack;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/2/4
 * @desp: 232简单题——用栈实现队列，https://leetcode-cn.com/problems/implement-queue-using-stacks/
 */

public class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }

}
