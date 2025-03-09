#include <iostream>
#include <vector>
#include <map>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    int n, m, count = 0, dupli = 0;
    cin >> n >> m;
    
    vector<string> v(n);
    vector<vector<int>> visit(n, vector<int>(m));
    map<char, pair<int, int>> d = {{'U', {-1, 0}}, {'D', {1, 0}}, {'L', {0, -1}}, {'R', {0, 1}}};
    
    for(int i = 0; i < n; i++)
        cin >> v[i];
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            if(visit[i][j] != 0)
                continue;
            
            count++;
            int r = i;
            int c = j;
            while(visit[r][c] == 0){
                visit[r][c] = count;
                
                char nd = v[r][c];
                r += d[nd].first;
                c += d[nd].second;

                if(visit[r][c] < count && visit[r][c] > 0)
                    dupli++;
            }
        }
    }
    
    cout << count - dupli;
    return 0;
}