package TwoSum;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2019/10/01
 * @desp: 1题——两数之和, https://leetcode-cn.com/problems/two-sum/
 */

import java.util.HashMap;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int length = nums.length;
        int result[] = null;

        for (int i = 0; i < length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                result = new int[]{i, map.get(key)};
                break;
            }
            map.put(nums[i], i);
        }

        return result;
    }

    // o(n) 4ms
    //	public int[] twoSum(int[] nums, int target) {
    //		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    //		int length = nums.length;
    //		int i, j;
    //		int result[] = null;
    //
    //		for (i = 0; i < length; i++) {
    //			map.put(nums[i], i);
    //		}
    //
    //		for (j = 0; j < length; j++) {
    //			int key = target - nums[j];
    //			if (map.containsKey(key) && map.get(key) != j) {
    //				result = new int[] { j, map.get(key) };
    //				result[0] = j;
    //				result[1] = map.get(key);
    //				break;
    //			}
    //		}
    //
    //		return result;
    //	}

    // o(n^2) 45ms 63ms
    //	public int[] twoSum(int[] nums, int target) {
    //		int i, j;
    //		int length = nums.length;
    //		int result[] = null;
    //		for (i = 0; i < length - 1; i++) {
    //			for (j = i + 1; j < length; j++) {
    //				if (nums[i] + nums[j] == target) {
    //					result = new int[] { i, j };
    //					return result;
    //				}
    //			}
    //		}
    //		return result;
    //	}
}
