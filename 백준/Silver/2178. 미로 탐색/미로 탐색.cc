#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    int d[4][2] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int n, m;
    cin >> n >> m;
    
    vector<vector<int>> g(n + 2, vector<int>(m + 2));
    char temp;
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= m; j++){
            cin >> temp;
            g[i][j] = temp - '0';
        }
    }

    queue<pair<int, int>> q;
    q.push({1, 1});

    while(!q.empty()){
        int r = q.front().first;
        int c = q.front().second;
        q.pop();
        
        if(r == n && c == m){
            cout << g[r][c];
            break;
        }

        for(int i = 0; i < 4; i++){
            int nr = r + d[i][0];
            int nc = c + d[i][1];
            
            if(g[nr][nc] != 1)
                continue;
            
            q.push({nr, nc});
            g[nr][nc] = g[r][c] + 1;
        }
    }
    
    return 0;
}