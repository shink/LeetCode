package com.yuanhaoji.leetcode.linked_list.reverse_linked_list_II;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/3/18
 * @desp: 92中等题——反转链表 II，https://leetcode-cn.com/problems/reverse-linked-list-ii/
 */

public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode preHead = new ListNode(-1, head);
        ListNode pre = preHead;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        ListNode next;
        for (int i = left; i < right; i++) {
            next = cur.next;
            cur.next = next.next;
            // 注意：这里不能是 next.next = cur，因为 cur 永远是 next 的前一个，而 pre 永远是 left 的前一个
            // 我们每次交换的目的是将 next 放至区间最左端，而 next.next = cur 只有在第一次循环时才符合
            next.next = pre.next;
            pre.next = next;
        }

        return preHead.next;
    }

}
