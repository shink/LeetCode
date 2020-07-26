package MiddleOfTheLinkedList;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/3/23
 * @desp: 876题——链表的中间结点, https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    /**
     * 我的方法
     */
    //    public ListNode middleNode(ListNode head) {
    //        ListNode p = head;
    //        ListNode res = head;
    //        int num = 0;
    //
    //        while (p != null) {
    //            if (num % 2 != 0) {
    //                res = res.next;
    //            }
    //            ++num;
    //            p = p.next;
    //        }
    //        return res;
    //    }

    /**
     * 快慢指针法
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
