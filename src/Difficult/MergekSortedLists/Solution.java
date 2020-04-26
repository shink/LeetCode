package MergekSortedLists;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/4/26
 * @desp: 23题——合并K个排序链表, https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        int length = lists.length;
        while (length > 1) {
            for (int i = 0; i < length / 2; i++) {
                lists[i] = mergeTwoList(lists[i], lists[length - i - 1]);
            }
            length = (length + 1) / 2;
        }
        return lists[0];
    }

    private ListNode mergeTwoList(ListNode a, ListNode b) {
        ListNode p = a, q = b;
        ListNode res = new ListNode(-1), r = res;

        while (p != null && q != null) {
            if (p.val < q.val) {
                r.next = p;
                p = p.next;
            } else {
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }
        r.next = p != null ? p : q;
        return res.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
