package KidsWithTheGreatestNumberOfCandies;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/6/1
 * @desp: 1431题——拥有最多糖果的孩子, https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies/
 */

public class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int max = 0;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }

        int flag = max - extraCandies;
        for (int candy : candies) {
            res.add(candy >= flag);
        }

        return res;
    }
}
