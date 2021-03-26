package com.yuanhaoji.leetcode.linked_list.remove_duplicates_from_sorted_list;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/3/26
 * @desp: 83简单题——删除排序链表中的重复元素，https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head, q;

        while (p != null) {
            q = p.next;
            while (q != null && q.val == p.val) {
                q = q.next;
            }
            p.next = q;
            p = q;
        }
        return head;
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
