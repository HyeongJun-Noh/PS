#include <bits/stdc++.h>
using namespace std;
#define fastio cin.tie(0)->sync_with_stdio(0)
using ll = long long;
using pii = pair<int, int>;
using pll = pair<ll, ll>;
int n, m;
int a[10];
int main() {
    fastio;
    cin >> n;
    for(int i = 0; i < n; i++) {
        cin >> a[i];
    }
    cin >> m;   
    int maxsz = -1;
    for(int i = 0; i < n; i++) {
        maxsz = max(maxsz, m / a[i]);
    }

    

    return 0;
}