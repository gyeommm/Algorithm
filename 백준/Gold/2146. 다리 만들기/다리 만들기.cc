#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    int d[4][2] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int n, ans = 10000;
    cin >> n;
    
    vector<vector<int>> v(n, vector<int>(n, -1));
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++)
            cin >> v[i][j];
    }
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            if(v[i][j] != 1)
                continue;
            
            vector<vector<int>> visit(n, vector<int>(n));
            queue<pair<int, int>> q;
            queue<pair<int, int>> qq;
           
            q.push({i, j});
            v[i][j] = -1;
            visit[i][j] = 1;
            
            while(!q.empty()){
                int r = q.front().first;
                int c = q.front().second;
                q.pop();

                for(int i = 0; i < 4; i++){
                    int nr = r + d[i][0];
                    int nc = c + d[i][1];
                    if(nr < 0 || nc < 0 || nr >= n || nr >= n || visit[nr][nc] > 0)
                        continue;
                    
                    visit[nr][nc] = 1;
                    if(v[nr][nc] == 0){
                        qq.push({nr, nc});
                        continue;
                    }
                    
                    q.push({nr, nc});
                    v[nr][nc] = -1;
                }
            }
            
            vector<vector<int>> vv = v;
            while(!qq.empty()){
                int r = qq.front().first;
                int c = qq.front().second;
                qq.pop();
                
                for(int i = 0; i < 4; i++){
                    int nr = r + d[i][0];
                    int nc = c + d[i][1];
                    if(nr < 0 || nc < 0 || nr >= n || nr >= n || visit[nr][nc] > 0 || vv[nr][nc] == -1)
                        continue;
                    
                    if(vv[nr][nc] == 1){
                        ans = min(ans, visit[r][c]);
                        queue<pair<int, int>>().swap(qq);
                        break;
                    }
                    
                    visit[nr][nc] = visit[r][c] + 1;
                    qq.push({nr, nc});
                }
            }
        }
    }
    
    cout << ans;
    return 0;
}