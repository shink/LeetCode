package CountTheRepetitions;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/4/19
 * @desp: 466题——统计重复个数, https://leetcode-cn.com/problems/count-the-repetitions/
 */

public class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (n1 == 0)
            return 0;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int l1 = s1.length();
        int l2 = s2.length();
        int counts1 = 0; //  经历多少s1
        int counts2 = 0; //  经历多少s2
        int p = 0;  //  当前在s2的位置
        Map<Integer, int[]> mp = new HashMap<>();   //  记录每一次s1扫描结束后当前的状态，寻找循环
        while (counts1 < n1) {
            for (int i = 0; i < l1; i++) {
                if (c1[i] == c2[p]) {   //  往前
                    p++;
                    if (p == l2) {  //  s2扫描结束从头开始循环
                        p = 0;
                        counts2++;
                    }
                }
            }
            counts1++;
            if (!mp.containsKey(p)) {
                mp.put(p, new int[]{counts1, counts2});   //  记录当前状态

            } else {    //  出现了循环 这次结束后p的位置和以前某一次一样，就是循环
                int[] last = mp.get(p);
                int circle1 = counts1 - last[0];
                int circle2 = counts2 - last[1];
                counts2 += circle2 * ((n1 - counts1) / circle1);
                counts1 = counts1 + ((n1 - counts1) / circle1) * circle1;  //  更新新他们
            }
        }
        return counts2 / n2;
    }
}
