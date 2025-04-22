#include <iostream>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int n, k = 1666;
	cin >> n;
	for (int i = 0; 5 * i <= n; i++) {
		for (int j = 0; 5 * i + 3 * j <= n; j++) {
			if (5 * i + 3 * j == n && i + j < k)
				k = i + j;
		}
	}
	if (k == 1666)
		cout << -1 << endl;
	else
		cout << k << endl;

	return 0;
}