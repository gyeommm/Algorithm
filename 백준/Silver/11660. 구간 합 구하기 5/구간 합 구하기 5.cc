#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int n, m;
	cin >> n >> m;
	vector<vector<int>> v(n + 1, vector<int>(n + 1));
	vector<vector<int>> dp(n + 1, vector<int>(n + 1));

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			cin >> v[i][j];
			dp[i][j] = v[i][j] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
		}
	}

	int a, b, c, d;
	for (int i = 0; i < m; i++) {
		cin >> a >> b >> c >> d;

		cout << dp[c][d] - dp[c][b - 1] - dp[a - 1][d] + dp[a - 1][b - 1] << '\n';
	}

	return 0;
}