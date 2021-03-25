package com.yuanhaoji.leetcode.linked_list.remove_duplicates_from_sorted_list_II;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/3/25
 * @desp: 82中等题——删除排序链表中的重复元素 II，https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 */

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
