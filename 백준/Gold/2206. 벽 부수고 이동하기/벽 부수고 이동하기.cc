#include <iostream>
#include <vector>
#include <queue>
#include <tuple>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m;
    cin >> n >> m;

    vector<vector<int>> v(n, vector<int>(m));
    for (int i = 0; i < n; ++i) {
        string temp;
        cin >> temp;
        for (int j = 0; j < m; ++j) {
            v[i][j] = temp[j] - '0';
        }
    }

    vector<vector<int>> visited(n, vector<int>(m, -1));
    queue<tuple<int, int, int, int>> q;     // r, c, k, count
    q.push({0, 0, 1, 1});
    visited[0][0] = 1;

    int result = 1000000;
    int d[4][2] = {{-1,0}, {1,0}, {0,-1}, {0,1}};

    while (!q.empty()) {
        auto [r, c, k, count] = q.front();
        q.pop();

        if (r == n - 1 && c == m - 1) {
            result = min(result, count);
            break;
        }

        for (int i = 0; i < 4; ++i) {
            int nr = r + d[i][0];
            int nc = c + d[i][1];
            int nk = k;

            if (nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc] >= nk)
                continue;

            if (v[nr][nc] == 1) {
                if (nk - 1 <= visited[nr][nc])
                    continue;

                nk--;
            }

            q.push({nr, nc, nk, count + 1});
            visited[nr][nc] = nk;
        }
    }

    if (result == 1000000)
        result = -1;
    cout << result;
    return 0;
}