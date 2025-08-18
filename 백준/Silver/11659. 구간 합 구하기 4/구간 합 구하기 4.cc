#include <iostream>
#include <vector>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int n, m;
	cin >> n >> m;
	vector<int> v(n + 1);
	vector<int> sum(n + 1);
	for (int i = 1; i <= n; i++) {
		cin >> v[i];
		sum[i] = sum[i - 1] + v[i];
	}

	int a, b;
	for (int i = 0; i < m; i++) {
		cin >> a >> b;
		cout << sum[b] - sum[a - 1] << '\n';
	}

	return 0;
}