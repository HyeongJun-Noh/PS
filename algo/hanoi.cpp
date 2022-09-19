#include <iostream>
using namespace std;
void hanoi(int n, int a, int b, int c) {
    if(n > 0) {
        hanoi(n - 1, a, c, b);
        cout << a << " -> " << c << '\n';
        hanoi(n - 1, b, a, c);
    }
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    hanoi(4, 1, 2, 3);
    return 0;
}