#include <bits/stdc++.h>
using namespace std;

// Power of Two

class Solution {
public:
    bool isPowerOfTwo(int n) {
        if(n <= 0) return false;
        int cnt = 0;
        while(n) {
            cnt += n & 1;
            n >>= 1;
        }
        return cnt == 1;
    }
};