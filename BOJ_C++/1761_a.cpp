#include <bits/stdc++.h>
using namespace std;
#define fastio cin.tie(0)->sync_with_stdio(0)
using ll = long long;
using pii = pair<int, int>;
using pll = pair<ll, ll>;
void solve() {
    int n, a, b;
    cin >> n >> a >> b;
    if(n - a - b >= 2 || (n == a && n == b)) {
        cout << "Yes" << '\n';
    } else {
        cout << "No" << '\n';
    }
}
int main() {
    fastio;
    int tc; cin >> tc;
    while(tc--) {
        solve();
    }
    return 0;
}