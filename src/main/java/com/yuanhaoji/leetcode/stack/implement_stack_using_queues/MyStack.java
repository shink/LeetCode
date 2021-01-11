package com.yuanhaoji.leetcode.stack.implement_stack_using_queues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/11/9
 * @desp: 225简单题——用队列实现栈，https://leetcode-cn.com/problems/implement-stack-using-queues/
 */

public class MyStack {

    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */

    /**
     * 通过两个队列实现
     * b 队列借助 a 队列保存逆序数据
     */
    //    private Queue<Integer> a;
    //    private Queue<Integer> b;
    //
    //    /**
    //     * Initialize your data structure here.
    //     */
    //    public MyStack() {
    //        a = new LinkedList<>();
    //        b = new LinkedList<>();
    //    }
    //
    //    /**
    //     * Push element x onto stack.
    //     */
    //    public void push(int x) {
    //        a.offer(x);
    //        // 将 b 队列中元素全部转给 a 队列
    //        while(!b.isEmpty())
    //            a.offer(b.poll());
    //        // 交换 a和 b,使得 a 队列没有在 push() 的时候始终为空队列
    //        Queue<Integer> temp = a;
    //        a = b;
    //        b = temp;
    //    }
    //
    //    /**
    //     * Removes the element on top of the stack and returns that element.
    //     */
    //    public int pop() {
    //        return b.poll();
    //    }
    //
    //    /**
    //     * Get the top element.
    //     */
    //    public int top() {
    //        return b.peek();
    //    }
    //
    //    /**
    //     * Returns whether the stack is empty.
    //     */
    //    public boolean empty() {
    //        return b.isEmpty();
    //    }

    /**
     * 通过一个队列实现
     * 入队后，将前面的所有元素依次出队并入队
     */
    private Queue<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.offer(x);
        int length = queue.size();
        for (int i = 0; i < length - 1; i++) {
            queue.offer(queue.poll());
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }

}
