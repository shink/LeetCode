package XOfAKindInADeckOfCards;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/3/27
 * @desp: 914题——卡牌分组, https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards/
 */

public class Solution {

    // return 所有数字出现次数的公约数 >= 2

    /**
     * 我的方法
     */
    //    public boolean hasGroupsSizeX(int[] deck) {
    //        int[] array = new int[10000];
    //        int min = Integer.MAX_VALUE;
    //        int i, j;
    //
    //        for (int num : deck) {
    //            ++array[num];
    //        }
    //
    //        for (i = 0; i < 10000; i++) {
    //            if (array[i] > 0 && array[i] < min)
    //                min = array[i];
    //            if (min == 1)
    //                return false;
    //        }
    //
    //        // 求最小值的所有约数
    //        for (i = 2; i <= min; i++) {
    //            boolean flag = true;
    //            if (min % i == 0) {
    //                for (j = 0; j < 10000; j++) {
    //                    if (array[j] > 0 && array[j] % i != 0) {
    //                        flag = false;
    //                        break;
    //                    }
    //                }
    //                if (flag)
    //                    return true;
    //            }
    //        }
    //
    //        return false;
    //    }

    /**
     * 官方结题
     */
    public boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[10000];
        for (int c : deck)
            count[c]++;

        int g = -1;
        for (int i = 0; i < 10000; ++i)
            if (count[i] > 0) {
                if (g == -1)
                    g = count[i];
                else
                    g = gcd(g, count[i]);
            }

        return g >= 2;
    }

    // 辗转相除法求最大公约数
    private int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }

}
