package DisplayTableOfFoodOrdersInARestaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/4/19
 * @desp: 周赛185场5389题——点菜展示表, https://leetcode-cn.com/contest/weekly-contest-185/problems/display-table-of-food-orders-in-a-restaurant/
 */

public class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> res = new ArrayList<>();
        Map<String, Integer> food = new HashMap<>();
        Map<String, Integer> table = new HashMap<>();
        Map<String, String> order = new HashMap<>();

        for (List<String> item : orders) {
            table.put(item.get(1), 1);
            food.put(item.get(2), 1);
            order.put(item.get(1), item.get(2));
        }

        List<String> head = new ArrayList<>();
        head.add("Table");
        for (String s : food.keySet()) {
            head.add(s);
        }
        res.add(head);

        for (String s : table.keySet()) {
            List<String> list = new ArrayList<>();
            list.add(s);


            res.add(list);
        }


        return res;
    }
}
