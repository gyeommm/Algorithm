#include <iostream>
#include <vector>
using namespace std;

int main(){
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	int n, m, s, e;
	cin >> n;
	vector<int> v(n + 1);
	for(int i = 1; i <= n; i++)
		cin >> v[i];
	cin >> m;

	vector<vector<bool>> dp(n + 1, vector<bool>(n + 1, false));
	for(int d = 0; d < n; d++){
		for(int i = 1; i + d <= n; i++){
			if(v[i] == v[i + d]){
				if(d <= 2)
					dp[i][i + d] = true;
				else if(dp[i + 1][i + d - 1])
					dp[i][i + d] = true;
			}
		}
	}

	while(m--){
		cin >> s >> e;
		cout << dp[s][e] << '\n';
	}

	return 0;
}