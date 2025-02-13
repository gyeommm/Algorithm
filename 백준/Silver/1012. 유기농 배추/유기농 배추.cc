#include <iostream>
#include <vector>
#include <queue>
using namespace std;

void bfs(vector<vector<int>> &g, pair<int, int> start){
    queue<pair<int, int>> q;
    q.push(start);

    while(!q.empty()){
        int row = q.front().first;
        int col = q.front().second;
        g[row][col] = 0;

        if(g[row - 1][col] == 1){
            q.push({row - 1, col});
            g[row - 1][col] = 0;
        }
        if(g[row + 1][col] == 1){
            q.push({row + 1, col});
            g[row + 1][col] = 0;
        }
        if(g[row][col - 1] == 1){
            q.push({row, col - 1});
            g[row][col - 1] = 0;
        }
        if(g[row][col + 1] == 1){
            q.push({row, col + 1});
            g[row][col + 1] = 0;
        }
        q.pop();
    }
}

int main(){
    ios_base ::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int t;
    cin >> t;
    while(t--){
        int m, n, k, x, y, result = 0;
        cin >> m >> n >> k;
        vector<vector<int>> g(n + 2, vector<int>(m + 2, 0));
        for(int i = 0; i < k; i++){
            cin >> x >> y;
            g[y + 1][x + 1] = 1;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(g[i][j] == 1){
                    bfs(g, {i, j});
                    result++;
                }
            }
        }

        cout << result << '\n';
    }

    return 0;
}