package com.yuanhaoji.leetcode.zte.byte_2021;

import java.util.*;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/4/24
 * @desp:
 */
public class Main {

    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int h = sc.nextInt();
    //     int u = sc.nextInt();
    //
    //     int[] a = new int[n];
    //     for (int i = 0; i < n; i++) {
    //         a[i] = sc.nextInt();
    //     }
    //
    //     Arrays.sort(a);
    //     int res = 0;
    //     int idx = n - 1;
    //     while (h < u) {
    //         h += a[idx--];
    //         ++res;
    //     }
    //     System.out.println(res);
    // }

    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int T = sc.nextInt();
    //     for (int i = 0; i < T; i++) {
    //         long n = sc.nextLong();
    //         if (n == 1) {
    //             System.out.println(1);
    //         } else if (n == 2) {
    //             System.out.println(2);
    //         } else {
    //             System.out.println(1 + (long) Math.ceil(Math.log(n) / Math.log(2)));
    //         }
    //     }
    // }

    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     List<Stack<Integer>> stacks = new ArrayList<>();
    //     for (int i = 0; i < 5; i++) {
    //         stacks.add(new Stack<>());
    //     }
    //
    //     for (int i = 0; i < n; i++) {
    //         int num = sc.nextInt();
    //         stacks.get(num - 1).push(i + 1);
    //         if (!stacks.get(0).empty() && !stacks.get(1).empty() && !stacks.get(2).empty() && !stacks.get(3).empty() && !stacks.get(4).empty()) {
    //             System.out.print(stacks.get(0).pop() + " ");
    //             System.out.print(stacks.get(1).pop() + " ");
    //             System.out.print(stacks.get(2).pop() + " ");
    //             System.out.print(stacks.get(3).pop() + " ");
    //             System.out.println(stacks.get(4).pop() + " ");
    //         } else {
    //             System.out.println(-1);
    //         }
    //     }
    // }

    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int n1 = sc.nextInt();
    //     int n2 = sc.nextInt();
    //     int q = sc.nextInt();
    //     int[] a1 = new int[q << 1 + 1];
    //     int[] a2 = new int[q << 1 + 1];
    //     boolean[] loc = new boolean[q << 1 + 1];
    //     int[] loc1 = new int[q << 1 + 1];
    //     int[] loc2 = new int[q << 1 + 1];
    //     int m1 = n1, m2 = n2;
    //
    //     for (int i = 1; i <= n1; i++) {
    //         a1[i] = i;
    //         loc1[i] = i;
    //         loc[i] = true;
    //     }
    //     for (int i = 1; i <= n2; i++) {
    //         a2[i] = n1 + i;
    //         loc2[n1 + i] = i;
    //         loc[n1 + i] = false;
    //     }
    //
    //     for (int i = 0; i < q; i++) {
    //         int num = sc.nextInt();
    //         if (loc[num]) {
    //             a1[loc1[num]] = -1;
    //             a2[++m2] = num;
    //             loc[num] = false;
    //             loc2[num] = m2;
    //         } else {
    //             a2[loc2[num]] = -1;
    //             a1[++m1] = num;
    //             loc[num] = true;
    //             loc1[num] = m1;
    //         }
    //     }
    //
    //     for (int i = 1; i <= m1; i++) {
    //         if (a1[i] == -1) {
    //             continue;
    //         }
    //         System.out.print(a1[i] + " ");
    //     }
    //     System.out.println();
    //
    //     for (int i = 1; i <= m2; i++) {
    //         if (a2[i] == -1) {
    //             continue;
    //         }
    //         System.out.print(a2[i] + " ");
    //     }
    //     System.out.println();
    //
    // }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int t = sc.nextInt();
        if (s == t) {
            System.out.println(1);
            return;
        }

        System.out.println(recur(s, t, 1, 1));
    }

    public static int recur(int s, int t, int op, int step) {
        if (s == t) {
            return 1;
        }

        if (t < s) {
            t = s + s - t;
            op *= -1;
        }

        if (step > t - s) {
            return Integer.MAX_VALUE;
        }

        int res = 0;
        int right = s;
        while (right < t) {
            right += op * step;
            op *= -1;
            step *= 2;
            ++res;
        }
        int left = right + op * (step / 2) - op * (step / 4);
        int leftRes1 = (t - left) * 2;
        int leftRes2 = recur(left, t, op, step / 4);
        int rightRes1 = (right - t) * 2 - 1;
        int rightRes2 = recur(right, t, op, step);
        return res + Math.min(Math.min(leftRes1, leftRes2) - 2, Math.min(rightRes1, rightRes2));
    }

}
