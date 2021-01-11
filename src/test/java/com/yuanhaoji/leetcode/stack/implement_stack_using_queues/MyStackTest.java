package com.yuanhaoji.leetcode.stack.implement_stack_using_queues;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/11/9
 */

public class MyStackTest {

    @Test
    public void push() {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    @Test
    public void pop() {
    }

    @Test
    public void top() {
    }

    @Test
    public void empty() {
    }
}