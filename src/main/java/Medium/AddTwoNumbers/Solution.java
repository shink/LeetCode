package AddTwoNumbers;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/3/14
 * @desp: 2题——两数相加, https://leetcode-cn.com/problems/add-two-numbers/
 */

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode r = result;

        int integer = 0, reminder;

        while (p != null || q != null) {
            int val1 = (p != null) ? p.val : 0;
            int val2 = (q != null) ? q.val : 0;

            int sum = integer + val1 + val2;
            integer = sum / 10;
            reminder = sum % 10;
            r.next = new ListNode(reminder);

            r = r.next;

            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }

        if (integer > 0) {
            r.next = new ListNode(integer);
        }

        return result.next;
    }

    class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

}
