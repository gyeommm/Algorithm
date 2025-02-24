#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    int n, m, r, rr;
    cin >> n >> m >> r;
    
    vector<vector<int>> v(n, vector<int>(m));
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++)
            cin >> v[i][j];
    }
    
    while(r--){
        cin >> rr;

        if(rr == 1){
            vector<vector<int>> vv(n, vector<int>(m));
            for(int i = 0; i < n; i++)
                vv[i] = v[n - 1 - i];
            v = vv;
        }
        else if(rr == 2){
            for(int i = 0; i < n; i++)
                reverse(v[i].begin(), v[i].end());
        }
        else if(rr == 3){
            vector<vector<int>> vv(m, vector<int>(n));
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++)
                    vv[i][j] = v[n - 1 - j][i];
            }
            v = vv;
        }
        else if(rr == 4){
            vector<vector<int>> vv(m, vector<int>(n));
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++)
                    vv[i][j] = v[j][m - 1 - i];
            }
            v = vv;
        }
        else if(rr == 5){
            int nn = n / 2, mm = m / 2;
            for(int i = 0; i < nn; i++){
                for(int j = 0; j < mm; j++){
                    swap(v[i][j], v[i][j + mm]);
                    swap(v[i][j], v[i + nn][j]);
                }
            }
            
            for(int i = nn; i < n; i++){
                for(int j = 0; j < mm; j++)
                    swap(v[i][j], v[i][j + mm]);
            }
        }
        else if(rr == 6){
            int nn = n / 2, mm = m / 2;
            for(int i = 0; i < nn; i++){
                for(int j = 0; j < mm; j++){
                    swap(v[i][j], v[i + nn][j]);
                    swap(v[i][j], v[i][j + mm]);
                }
            }
            
            for(int i = 0; i < nn; i++){
                for(int j = mm; j < m; j++)
                    swap(v[i][j], v[i + nn][j]);
            }
        }
        
        n = v.size();
        m = v[0].size();
    }
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++)
            cout << v[i][j] << ' ';
        cout << '\n';
    }
    return 0;
}