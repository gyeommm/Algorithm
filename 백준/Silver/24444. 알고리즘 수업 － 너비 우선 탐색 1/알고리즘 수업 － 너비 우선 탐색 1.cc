#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m, r, v1, v2, order = 1;
    cin >> n >> m >> r;
    vector<vector<int>> g(n + 1);
    vector<int> visit(n + 1);

    for(int i = 0; i < m; i++){
        cin >> v1 >> v2;
        g[v1].push_back(v2);
        g[v2].push_back(v1);
    }
    
    queue<int> q;
    q.push(r);
    visit[r] = order++;
    while(!q.empty()){
        int now = q.front();
        q.pop();
        
        sort(g[now].begin(), g[now].end());
        
        for(int i = 0; i < g[now].size(); i++){
            int next = g[now][i];
            
            if(visit[next] != 0)
                continue;
            
            q.push(next);
            visit[next] = order++;
        }
    }
    
    for(int i = 1; i <= n; i++)
        cout << visit[i] << '\n';

    return 0;
}