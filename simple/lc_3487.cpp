#include <vector>

using namespace std;

class Solution {
public:
  int maxSum(vector<int> &nums) {
    uint16_t counts[101] = {0};
    int maxNeg = -100;
    bool hasZero = false;
    for (auto num : nums) {
      if (num >= 0 && num <= 100) {
        counts[num]++;
      }
      if (num < 0 && num > maxNeg) {
        maxNeg = num;
      }
      if (num == 0) {
        hasZero = true;
      }
    }

    int ret = 0;
    for (int i = 0; i <= 100; i++) {
      if (counts[i] > 0) {
        ret += i;
      }
    }

    // 只包含负数
    if (ret == 0 && !hasZero) {
      ret = maxNeg;
    }
    return ret;
  }
};
