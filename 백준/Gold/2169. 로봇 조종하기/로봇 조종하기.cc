#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n, m;
    cin >> n >> m;
    vector<vector<int>> v(n, vector<int>(m));
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++)
            cin >> v[i][j];
    }
    
    vector<vector<int>> dp(n, vector<int>(m));
    dp[0][0] = v[0][0];
    for(int j = 1; j < m; j++)
        dp[0][j] = dp[0][j - 1] + v[0][j];
    
    for(int i = 1; i < n; i++){
        vector<int> right(m), left(m);
        
        right[0] = dp[i - 1][0] + v[i][0];
        for(int j = 1; j < m; j++)
            right[j] = max(dp[i - 1][j], right[j - 1]) + v[i][j];

        left[m - 1] = dp[i - 1][m - 1] + v[i][m - 1];
        for(int j = m - 2; j >= 0; j--)
            left[j] = max(dp[i - 1][j], left[j + 1]) + v[i][j];
        
        for(int j = 0; j < m; j++)
            dp[i][j] = max(right[j], left[j]);
    }
    
    cout << dp[n - 1][m - 1];
    return 0;
}