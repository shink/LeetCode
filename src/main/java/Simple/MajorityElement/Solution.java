package MajorityElement;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/3/13
 * @desp: 169题——多数元素, https://leetcode-cn.com/problems/majority-element/
 */

public class Solution {

    /**
     * 哈希表法
     */
    //    public int majorityElement(int[] nums) {
    //        int length = nums.length;
    //        int target = length / 2;
    //        Map<Integer, Integer> map = new HashMap<>();
    //
    //        for (int num : nums) {
    //            if (map.containsKey(num)) {
    //                int value = map.get(num);
    //                map.put(num, ++value);
    //            } else {
    //                map.put(num, 1);
    //            }
    //
    //            if (map.get(num) > target) {
    //                return num;
    //            }
    //        }
    //        return 0;
    //    }


    /**
     * Boyer-Moore 投票算法
     */
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (candidate == num) ? 1 : -1;
        }

        return candidate;
    }
}
