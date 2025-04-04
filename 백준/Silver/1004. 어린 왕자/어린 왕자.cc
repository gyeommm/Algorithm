#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	vector<pair<int, int>> point(3);
	vector<bool> check(2);
	int t, n, r;
	cin >> t;
	while (t--) {
		int ans = 0;

		cin >> point[0].first >> point[0].second >> point[1].first >> point[1].second >> n;

		while (n--) {
			check = vector<bool>(2, false);

			cin >> point[2].first >> point[2].second >> r;

			float distance;
			for (int i = 0; i < 2; i++) {
				distance = sqrt(pow(point[2].first - point[i].first, 2) + pow(point[2].second - point[i].second, 2));
				if (distance < r)
					check[i] = true;
			}
			
			if (check[0] != check[1])
				ans++;
		}

		cout << ans << '\n';
	}

	return 0;
}