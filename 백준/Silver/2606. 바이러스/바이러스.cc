#include <iostream>
#include <vector>
using namespace std;

vector<vector<int>> g(101);
vector<bool> visit(101);
int result = 0;

void dfs(int now){
    visit[now] = true;
    
    for(int i = 0; i < g[now].size(); i++){
        if(visit[g[now][i]])
            continue;
        result++;
        dfs(g[now][i]);
    }
}

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m, v1, v2;
    cin >> n >> m;
    
    while(m--){
        cin >> v1 >> v2;
        g[v1].push_back(v2);
        g[v2].push_back(v1);
    }
    
    dfs(1);
    cout << result;
    
    return 0;
}