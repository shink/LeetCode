package MergeTwoSortedLists;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/5/1
 * @desp: 21题——合并两个有序链表, https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */

public class Solution {
    /**
     * 迭代
     */
    //    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    //        ListNode res = new ListNode(-1);
    //        ListNode r = res;
    //
    //        while (l1 != null && l2 != null) {
    //            if (l1.val < l2.val) {
    //                r.next = l1;
    //                l1 = l1.next;
    //            } else {
    //                r.next = l2;
    //                l2 = l2.next;
    //            }
    //            r = r.next;
    //        }
    //
    //        r.next = (l1 != null) ? l1 : l2;
    //
    //        return res.next;
    //    }

    /**
     * 递归
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
