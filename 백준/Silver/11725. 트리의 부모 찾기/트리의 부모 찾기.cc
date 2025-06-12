#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, a, b, front, next;
    cin >> n;
    vector<vector<int>> g(n + 1);
    for(int i = 0; i < n - 1; i++){
        cin >> a >> b;
        g[a].push_back(b);
        g[b].push_back(a);
    }

    queue<int> q;
    q.push(1);
    vector<int> parent(n + 1);
    while(!q.empty()){
        front = q.front();
        q.pop();

        for(int i = 0; i < g[front].size(); i++){
            next = g[front][i];

            if(parent[next] == 0){
                parent[next] = front;
                q.push(next);
            }
        }
    }
    for(int i = 2; i <= n; i++)
        cout << parent[i] << '\n';

	return 0;
}