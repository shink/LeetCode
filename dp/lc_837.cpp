#if defined(__APPLE__) && defined(__MACH__)
#include <algorithm>
#include <bitset>
#include <cmath>
#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <deque>
#include <fstream>
#include <iostream>
#include <list>
#include <map>
#include <queue>
#include <set>
#include <stack>
#include <string>
#include <vector>
#else
#include <bits/stdc++.h>
#endif

using namespace std;

// #define LOCAL
// #define ONLINE_JUDGE

#ifdef ONLINE_JUDGE
#undef LOCAL
#endif

#ifdef LOCAL
#include "algo/debug.h"
#else
#define debug(...) 42
#define assert(...) 42
#endif

#define FORN(i, n) for (int i = 0; i < n; ++i)
#define ROFN(i, n) for (int i = n - 1; i >= 0; --i)
#define FOR(i, a, b) for (int i = a; i < b; ++i)
#define ROF(i, a, b) for (int i = a; i > b; --i)
#define LC(i) ((i) << 1)
#define RC(i) ((i) << 1 | 1)
#define MAX(a, b) ((a) < (b) ? (b) : (a))
#define MIN(a, b) ((a) < (b) ? (a) : (b))
#define MAX3(a, b, c) max(max(a, b), c)
#define MIN3(a, b, c) min(min(a, b), c)
#define SIZE(x) int((x).size())
#define ALL(x) begin(x), end(x)
#define SORT(x) sort(ALL(x))

using str = string;
using ll = long long;
using ld = long double;
using ull = unsigned long long;

using pii = pair<int, int>;
using pll = pair<ll, ll>;
using pd = pair<double, double>;

using vi = vector<int>;
using vb = vector<bool>;
using vd = vector<double>;
using vs = vector<str>;
using vll = vector<ll>;

const int inf = 0x7fffffff; // 2147483647
const int mod = 1e9 + 7;    // 1000000007
const int maxn = 100;
const double eps = 1e-8;
const double pi = acos(-1.0);

class Solution {
public:
    double new21Game(int n, int k, int maxPts) {
        int min = k;
        int max = k + maxPts - 1;

        // 从 x 分数开始，获胜的概率
        vd dp(max + 1, 0.0);
        for (int i = min; i <= n && i <= max; ++i) {
            dp[i] = 1.0;
        }
        ROFN(i, min) {
            FOR(j, 1, maxPts + 1) {
                dp[i] += dp[i + j] / maxPts;
            }
        }
        return dp[0];
    }
};
