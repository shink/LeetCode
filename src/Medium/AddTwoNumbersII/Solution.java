package AddTwoNumbersII;

import java.util.ArrayList;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/4/14
 * @desp: 445题——两数相加II, https://leetcode-cn.com/problems/add-two-numbers-ii/
 */

public class Solution {

    /**
     * 官方题解，使用栈存储数字
     */
    //    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    //        Stack<Integer> s1 = new Stack<>();
    //        Stack<Integer> s2 = new Stack<>();
    //
    //        while (l1 != null) {
    //            s1.push(l1.val);
    //            l1 = l1.next;
    //        }
    //        while (l2 != null) {
    //            s2.push(l2.val);
    //            l2 = l2.next;
    //        }
    //
    //        ListNode res = null;
    //        int c = 0;
    //        while (!s1.isEmpty() || !s2.isEmpty() || c > 0) {
    //            int sum = (s1.isEmpty() ? 0 : s1.pop()) +
    //                    (s2.isEmpty() ? 0 : s2.pop()) + c;
    //            ListNode n = new ListNode(sum % 10);
    //            c = sum / 10;
    //            n.next = res;
    //            res = n;
    //        }
    //        return res;
    //    }

    /**
     * 我的方法，使用list存储数字，超出内存限制
     */
    //        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    //            int divisor = 0, i, j;
    //            ListNode p = l1, q = l2, ans;
    //            ArrayList<Integer> a1 = new ArrayList<>(), a2 = new ArrayList<>(), res = new ArrayList<>();
    //            while (p != null) {
    //                a1.add(p.val);
    //                p = p.next;
    //            }
    //            while (q != null) {
    //                a2.add(q.val);
    //                q = q.next;
    //            }
    //
    //            for (i = a1.size() - 1, j = a2.size() - 1; i >= 0 && j >= 0; i--, j--) {
    //                int num = divisor + a1.get(i) + a2.get(j);
    //                divisor = num / 10;
    //                res.add(num % 10);
    //            }
    //
    //            if (i == j) {
    //                res.add(divisor);
    //            } else if (i > j) {
    //                while (i >= 0) {
    //                    int num = divisor + a1.get(i);
    //                    divisor = num / 10;
    //                    res.add(num % 10);
    //                }
    //            } else {
    //                while (j >= 0) {
    //                    int num = divisor + a2.get(j);
    //                    divisor = num / 10;
    //                    res.add(num % 10);
    //                }
    //            }
    //
    //            ans = new ListNode(res.get(res.size() - 1));
    //            p = ans;
    //            for (int k = res.size() - 2; k >= 0; k--) {
    //                ListNode node = new ListNode(res.get(k));
    //                p.next = node;
    //                p = p.next;
    //            }
    //
    //            return ans;
    //        }

    /**
     * 我的方法，修改版
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1, q = l2, res = null;
        ArrayList<Integer> a1 = new ArrayList<>(), a2 = new ArrayList<>();
        while (p != null) {
            a1.add(p.val);
            p = p.next;
        }
        while (q != null) {
            a2.add(q.val);
            q = q.next;
        }

        for (int divisor = 0, i = a1.size() - 1, j = a2.size() - 1; i >= 0 || j >= 0 || divisor > 0; i--, j--) {
            int sum = (i < 0 ? 0 : a1.get(i)) + (j < 0 ? 0 : a2.get(j)) + divisor;
            ListNode node = new ListNode(sum % 10);
            divisor = sum / 10;
            node.next = res;
            res = node;
        }
        return res;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}