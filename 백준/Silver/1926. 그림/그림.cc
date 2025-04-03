#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m, result = 0, count = 0, area, d[4][2] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    cin >> n >> m;
    vector<vector<int>> v(n + 2, vector<int>(m + 2));
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= m; j++)
            cin >> v[i][j];
    }

    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= m; j++){
            if(v[i][j] != 1)
                continue;

            queue<pair<int, int>> q;
            q.push({i, j});
            v[i][j] = 2;
            area = 1;
            count++;

            while(!q.empty()){
                int r = q.front().first;
                int c = q.front().second;
                q.pop();

                for(int k = 0; k < 4; k++){
                    int nr = r + d[k][0];
                    int nc = c + d[k][1];

                    if(v[nr][nc] != 1)
                        continue;
                    
                    q.push({nr, nc});
                    v[nr][nc] = 2;
                    area++;
                }
            }
            result = max(result, area);
        }
    }
    cout << count << '\n' << result;

    return 0;
}