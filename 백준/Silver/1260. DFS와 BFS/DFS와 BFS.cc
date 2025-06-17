#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

void dfs(vector<vector<int>> &g, vector<bool> &visit, int now){
    visit[now] = true;
    cout << now << ' ';

    sort(g[now].begin(), g[now].end());
    for(int i = 0; i < g[now].size(); i++){
        if(visit[g[now][i]] == false){
            dfs(g, visit, g[now][i]);
        }
    }
}

void bfs(vector<vector<int>> &g, vector<bool> &visit, int v){
    visit[v] = true;
    queue<int> q;
    q.push(v);

    while(!q.empty()){
        int f = q.front();
        cout << f << ' ';

        sort(g[f].begin(), g[f].end());
        for(int i = 0; i < g[f].size(); i++){
            if(visit[g[f][i]] == false){
                visit[g[f][i]] = true;
                q.push(g[f][i]);
            }
        }
        q.pop();
    }
}

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m, v, v1, v2;
    cin >> n >> m >> v;
    
    vector<vector<int>> g(n + 1);
    vector<bool> visit(n + 1, false);
    while(m--){
        cin >> v1 >> v2;
        g[v1].push_back(v2);
        g[v2].push_back(v1);
    }
    dfs(g, visit, v);
    cout << '\n';
    visit = vector<bool>(n + 1, false);
    bfs(g, visit, v);
    
    return 0;
}