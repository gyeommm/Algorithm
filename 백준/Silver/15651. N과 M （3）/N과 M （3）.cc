#include <iostream>
#include <vector>
using namespace std;

int n, m;

void f(int cur, vector<int> &v) {
    if (cur > m) {
        for (int i = 1; i <= m; i++)
            cout << v[i] << ' ';
        cout << '\n';
        return;
    }

    for (int i = 1; i <= n; i++) {
        v[cur] = i;
        f(cur + 1, v);
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m;
    vector<int> v(n + 1);
    f(1, v);

    return 0;
}