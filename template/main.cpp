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

#define LOCAL

#ifdef LOCAL
#define DEBUG(x)                                                                                                       \
    std::cerr << "[" << __FILE__ << ":" << __LINE__ << "][" << __func__ << "] " << #x << " = " << (x) << std::endl;
#define ASSERT(cond)                                                                                                   \
    do {                                                                                                               \
        if (!(cond)) {                                                                                                 \
            DEBUG(cond);                                                                                               \
            exit(0);                                                                                                   \
        }                                                                                                              \
    } while (0)
#else
#define DEBUG(...) 42
#define ASSERT(...) 42
#endif

#define FORN(i, n) for (int i = 0; i < n; ++i)
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
#define LOWER(x, i) lower_bound(ALL(x), i)
#define UPPER(x, i) upper_bound(ALL(x), i)
#define EXIST(x, i) (x).find(i) != (x).end()

using str = string;
using ll = long long;
using ld = long double;
using ull = unsigned long long;

using pii = pair<int, int>;
using pll = pair<ll, ll>;
using pdd = pair<double, double>;

using vi = vector<int>;
using vb = vector<bool>;
using vs = vector<str>;
using vll = vector<ll>;

using vvi = vector<vector<int>>;
using vvb = vector<vector<bool>>;
using vvs = vector<vector<str>>;
using vvll = vector<vector<ll>>;

const int inf = 0x7fffffff; // 2147483647
const int mod = 1e9 + 7;    // 1000000007
const int maxn = 100;
const double eps = 1e-8;
const double pi = acos(-1.0);

class Solution {
public:
    // TODO
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

#ifdef LOCAL
    freopen("main.in", "r", stdin);
    freopen("main.out", "w", stdout);
#endif

    int t = 1;
    // int t;
    // cin >> t;
    DEBUG(t);
    while (t--) {
        Solution solution = Solution();
        // solution.solve();
    }

    return 0;
}
