package CountNumberOfNiceSubarrays;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/4/21
 * @desp: 1248题——统计优美子数组, https://leetcode-cn.com/problems/count-number-of-nice-subarrays/
 */

public class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int res = 0, count = 0;
        int length = nums.length;
        int odd[] = new int[length + 2];

        for (int i = 0; i < length; i++) {
            if (nums[i] % 2 == 1)
                odd[++count] = i;
        }

        odd[0] = -1;
        odd[++count] = length;
        for (int i = 1; i + k <= count; i++) {
            res += (odd[i] - odd[i - 1]) * (odd[i + k] - odd[i + k - 1]);
        }

        return res;
    }
}
